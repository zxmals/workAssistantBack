
let computermodelinfo = null;
$(function (){

})

/*设备信息页*/
let locator = new ActiveXObject ("WbemScripting.SWbemLocator");
let service = locator.ConnectServer(".");
let macAddress = "";
let ipAddress = "";


/*CPU 信息*/
function cpuInfo() {
    let properties = service.ExecQuery("SELECT * FROM Win32_Processor");
    let e = new Enumerator (properties);
    let info = "";
    for (;!e.atEnd();e.moveNext ()) {
        let p = e.item ();
        info+='<li class="list-group-item">CPU型号：' + p.Name + '</li>';
        info+='<li class="list-group-item">主机名称：' + p.SystemName + '</li>';
    }
    return info;
}

/*操作系统*/
function osInfo(){
    let properties = service.ExecQuery("SELECT * FROM Win32_OperatingSystem");
    let e = new Enumerator (properties);
    let info="";
    for (;!e.atEnd();e.moveNext ()){
        let p = e.item ();
        info+='<li class="list-group-item">操作系统：' + p.Caption + '</li>';
    }
    return info;
}

/*主板信息*/
function mainBoard() {
    let properties = service.ExecQuery("SELECT * FROM Win32_BaseBoard");
    let e = new Enumerator (properties);
    let info="";
    for (;!e.atEnd();e.moveNext ()) {
        let p = e.item ();
        info+='<li class="list-group-item">制造商：' + p.Manufacturer + '</li>';
        info+='<li class="list-group-item">型号：' + p.Product + '</li>';
    }
    return info;
}

//获取网络连接信息
function ipInfo(){
    let properties = service.ExecQuery("SELECT * FROM Win32_NetworkAdapterConfiguration Where IPEnabled=TRUE");
    let e = new Enumerator (properties);
    let info="";
    for (;!e.atEnd();e.moveNext ()){
        let p = e.item ();
        info+='<li class="list-group-item">MAC地址：' + p.MACAddress + '</li>';
        macAddress = p.MACAddress;
        info+='<li class="list-group-item">IP地址：' + p.IPAddress(0) + '</li>';
        ipAddress = p.IPAddress(0);
    }
    return info;
}

function getDeviceInfo(){
    /*let info = '<img src="../img/dl-pc.jpg" class="img-thumbnail" alt="Responsive image">';*/
    let info = '';
    info += osInfo();
    info += cpuInfo();
    info += mainBoard();
    info += ipInfo();

    return info;

}

function generateSoftInfo(title,data){
    let imgsrc = "";
    imgsrc = "操作系统"==title?"os.png":("办公软件"==title?"office.png":("浏览器"==title?"browser.png":("安全软件"==title?"safe.png":"other_.png")))
    let info = '<tr class="active">\n' +
        '                        <td class="row-vertical-center"><strong><h3 class="text-primary">\n' +
        '                            <img src="img/'+imgsrc+'" alt="" class="img-rounded" style="width: 70px;height: 70px">\n' +
        title+'</h3></strong></td>\n' +
        '                        <td class="text-center">\n' +
        '                            <table class="table table-bordered">'
    for(let i in data){
        info += '<tr>' +
            '<td>' + data[i].softwear_name1 + '</td>'
        info += '<td><p class="text-primary" style="width: auto!important;"><a id="'+data[i].softwear_id+'" class="download" href=workassist/download?softwear_id='+parseInt(data[i].softwear_id)+'><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span> 点击下载</a></p></td>' +
            '</tr>';
    }
    info += '</table></td></tr>';
    return info;
}

$(function() {
    let info = getDeviceInfo();
    $('#deviceuse ul').html(info);
    /*
    根据用户设备信息（mac/ip)获取用户以及资产信息
    首先根据MAC地址查询*/
    $.get("workassist/getuserpropbymac?macAddress="+macAddress,
        function(data,status){
            if(data.userprop != null){
                let datas = data.userprop
                let userinfo = "";
                userinfo += '<li class="list-group-item">资产责任人：' + datas.user_name + '</li>';
                userinfo += '<li class="list-group-item">员工编号：'+datas.user_id+'</li>';
                userinfo += '<li class="list-group-item">归属部门：'+datas.department+'</li>';
                userinfo += '<li class="list-group-item">联系方式：'+datas.product_no+'</li>';
                userinfo += '<li class="list-group-item">资产编号：'+datas.property_id+'</li>';
                userinfo += '<li class="list-group-item">资产申领日期：'+datas.prop_startdate+'</li>';
                userinfo += '<li class="list-group-item">资产到期日期：'+datas.prop_enddate+'</li>';
                $('#deviceuser ul').html(userinfo);
            }else{
                /*MAC地址查不到就用IP地址查询*/
                $.get("workassist/getuserpropbyip?ipAddress="+ipAddress,
                    function (data,status){
                        if(data.userprop!=null){
                            let datas = data.userprop
                            let userinfo = "";
                            userinfo += '<li class="list-group-item">资产责任人：' + datas.user_name + '</li>';
                            userinfo += '<li class="list-group-item">员工编号：'+datas.user_id+'</li>';
                            userinfo += '<li class="list-group-item">归属部门：'+datas.department+'</li>';
                            userinfo += '<li class="list-group-item">联系方式：'+datas.product_no+'</li>';
                            userinfo += '<li class="list-group-item">资产编号：'+datas.property_id+'</li>';
                            userinfo += '<li class="list-group-item">资产申领日期：'+datas.prop_startdate+'</li>';
                            userinfo += '<li class="list-group-item">资产到期日期：'+datas.prop_enddate+'</li>';
                            $('#deviceuser ul').html(userinfo);
                        }else{
                            let userinfo = "未查询到当前设备资产对应用户信息！";
                            $('#deviceuser ul').html(userinfo);
                        }
                });
            }
        });

    /*获取所有系统可供下载的软件*/
    $.get("workassist/getsoftwear",
        function (data,status){
            let data1 = data.softwear.filter(function (item){
                return item.category_name == "操作系统";
            });
            let data2 = data.softwear.filter(function (item){
                return item.category_name == "办公软件";
            });
            let data3 = data.softwear.filter(function (item){
                return item.category_name == "浏览器";
            });
            let data4 = data.softwear.filter(function (item){
                return item.category_name == "安全软件";
            });
            let data5 = data.softwear.filter(function (item){
                return item.category_name == "其他软件";
            });

            let softinfo = '<table class="table table-bordered">'
            softinfo += generateSoftInfo("操作系统",data1);
            softinfo += generateSoftInfo("办公软件",data2);
            softinfo += generateSoftInfo("浏览器",data3);
            softinfo += generateSoftInfo("安全软件",data4);
            softinfo += generateSoftInfo("其他软件",data5);
            softinfo += '</table>'
            $('#software div').html(softinfo);
    });

    /*页面切换*/
    $("li[role='presentation']").click(function (){
        $(this).addClass('active').siblings().removeClass('active');
        $('#'+$(this).attr("title")).removeClass("hidden").siblings().addClass('hidden');
    });

    /*软件下载触发事件处理*/
/*    $('#software div').ready(function(){
        $('.download').click(function (){
            $.get("workassist/download?softwear_id="+this.id
            		,function(data,status){
                    alert(status,data)
                });
        });
    });*/

    $.get("/workassist/getcomputerbrand"
        ,function (data,status){
            let info = "";
            brandinfo = data.brand
            for(let e in brandinfo){
                info += '<option id="'+brandinfo[e].pc_brand_id+'">'+brandinfo[e].pc_brand_name+'</option>'
            }
            $('#hardware .col-md-3 select').eq(0).find('option').remove();
            $('#hardware .col-md-3 select').eq(0).append(info);
            $('#hardware .col-md-3 select').selectpicker('refresh');
        });

    $.get("/workassist/getosinfo"
        ,function (data,status){
            let info = "";
            osinform = data.osinfo
            for(let e in osinform){
                info += '<option customs="'+osinform[e].operation_system_id+'">'+osinform[e].operation_system_name+'</option>'
            }
            $('#hardware .col-md-3 select').eq(1).find('option').remove();
            $('#hardware .col-md-3 select').eq(1).append(info);
            $('#hardware .col-md-3 select').selectpicker('refresh');
        });

    $.get("/workassist/getcomputerinfo"
        ,function (data,status){
            let info = "";
            compinfo = data.computerinfo
            for(let e in compinfo){
                info += '<option compid="'+compinfo[e].computer_id+'" customs="'+compinfo[e].computerbrand.pc_brand_id+'">'+compinfo[e].computermodel.pc_model_name+'</option>'
            }
            $('#hardware .col-md-4 select').eq(0).find('option').remove();
            $('#hardware .col-md-4 select').eq(0).append(info);
            $('#hardware .col-md-4 select').selectpicker('refresh');
        });

    /*驱动下载界面，下拉框级联查询*/
    $('#hardware select').ready(function (){
        computermodelinfo = p = $('#hardware .col-md-4 select').find('option').clone();
        $('#hardware .col-md-3 select').eq(0).change(function (){
            let i =$('#hardware .col-md-3 select').eq(0).find('option:selected').attr('id');
            $('#hardware .col-md-4 select').find('option').remove();
            $('#hardware .col-md-4 select').append(computermodelinfo);
            $('#hardware .col-md-4 select').find('option[customs!='+i+']').remove();
            $('#hardware .col-md-4 select').selectpicker('refresh');
        });
    });

});



