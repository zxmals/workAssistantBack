
/*缓存驱动下拉框数据-电脑型号*/
let computermodelinfo = null;

/*缓存单个移动APP信息*/
let appinfo = null;

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

function generateSoftInfo(title,img_src,data){

    let info = '<tr class="active">\n' +
        '                        <td class="row-vertical-center"><strong><h3 class="text-primary">\n' +
        '                            <img src="'+img_src+'" alt="" class="img-rounded" style="width: 70px;height: 70px">\n' +
        title+'</h3></strong></td>\n' +
        '                        <td class="text-center">\n' +
        '                            <table class="table table-bordered">'
    for(let i in data){
        info += '<tr>' +
            '<td>' + data[i].softwear_name1 + '</td>'
        info += '<td><p class="text-primary" style="width: auto!important;"><a id="'+data[i].softwear_id+'" class="download" href=workassist/download?softwear_id='+parseInt(data[i].softwear_id)+'><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>&nbsp;点击下载</a></p></td>' +
            '</tr>';
    }
    info += '</table></td></tr>';
    return info;
}

/*字符串转码成UTF8*/
function toUtf8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for (i = 0; i < len; i++) {
        c = str.charCodeAt(i);
        if ((c >= 0x0001) && (c <= 0x007F)) {
            out += str.charAt(i);
        } else if (c > 0x07FF) {
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
            out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        } else {
            out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        }
    }
    return out;
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

    /*获取软件分类信息*/
    let softwear_type = null;
    $.get("workassist/getsoftweartype",function (data,status){softwear_type = data.softweartype});

    /*获取所有系统可供下载的软件*/
    $.get("workassist/getsoftwear",
        function (data,status){
            let softinfo = '                    <div class="input-group">\n' +
                '                        <input type="text" class="form-control" placeholder="输入软件名称……">\n' +
                '                        <span class="input-group-btn">\n' +
                '                                <button class="btn btn-default" type="button">\n' +
                '                                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>\n' +
                '                                </button>\n' +
                '                        </span>\n' +
                '                    </div>'
                softinfo += '<table class="table table-bordered">'
            for(let e in softwear_type){
                let dats = data.softwear.filter(function (item){return item.softWearTypeInfo.softwear_type_id==softwear_type[e].softwear_type_id})
                softinfo += generateSoftInfo(softwear_type[e].softwear_type_name,softwear_type[e].img_store_path,dats)
            }
            softinfo += '</table>'
            $('#software div').html(softinfo);

            /*软件服务界面-触动二次查询事件*/
            $('#software .input-group button').click(function (){
                searchinfo = $('#software .input-group input').val().toLowerCase();

                let k=0;
                for(let i=0;i<$('#software table:first-child').length;i++){
                    k=0;
                    for(let j=0;j<$('#software table:first-child').eq(i).find('tr').length;j++){
                        if($('#software table:first-child').eq(i).find('tr').eq(j).find('td').eq(0).get(0).innerText.toLowerCase().indexOf(searchinfo)<0){
                            $('#software table:first-child').eq(i).find('tr').eq(j).addClass('hidden');
                            k += 1;
                        }else{
                            $('#software table:first-child').eq(i).find('tr').eq(j).removeClass('hidden');
                        }
                    }
                    if(k==$('#software table:first-child').eq(i).find('tr').length){
                        $('#software table:first-child').eq(i).parent().parent().eq(0).addClass('hidden')
                    }else{
                        $('#software table:first-child').eq(i).parent().parent().eq(0).removeClass('hidden')
                    }
                }
            });
    });

    /*页面切换*/
    $("li[role='presentation']").click(function (){
        $(this).addClass('active').siblings().removeClass('active');
        $('#'+$(this).attr("title")).removeClass("hidden").siblings().addClass('hidden');
    });

/*初始化驱动下拉框数据-电脑品牌*/
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
    /*初始化驱动下拉框数据-操作系统*/
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
    /*初始化驱动下拉框数据-电脑型号*/
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
            computermodelinfo = info;
        });

    /*驱动下载界面，下拉框级联查询*/
    $('#hardware select').ready(function (){
        $('#hardware .col-md-3 select').eq(0).change(function (){
            let i =$('#hardware .col-md-3 select').eq(0).find('option:selected').attr('id');
            $('#hardware .col-md-4 select').find('option').remove();
            $('#hardware .col-md-4 select').append(computermodelinfo);
            $('#hardware .col-md-4 select').find('option[customs!='+i+']').remove();
            $('#hardware .col-md-4 select').selectpicker('refresh');
        });
    });

    /*驱动界面触发查询事件*/
    $('#hardware .col-md-2 button').click(function (){
        if($('#hardware .col-md-4 select').selectpicker('val')!=""&&$('#hardware .col-md-3 select').eq(0).selectpicker('val')!=""&&$('#hardware .col-md-3 select').eq(1).selectpicker('val')!=""){
            computer_id = $('#hardware .col-md-4 select').eq(0).find('option:selected').attr("compid");
            os_id = $('#hardware .col-md-3 select').eq(1).find('option:selected').attr("customs");
            $.get("workassist/getdriverinfobycmandos?computer_id="+computer_id+"&os_id="+os_id
                ,function (data,status){
                    $('#hardware .panel-body table tbody').find('tr').remove();
                    driverinfoli = data.dirverinfo;
                    let infodriver = "";
                    let i = 1
                    for(let e in driverinfoli){
                        infodriver += '<tr><td style="text-align: center">'+i+'</td>';
                        infodriver += '<td style="text-align: center">'+driverinfoli[e].driver_name1+'</td>'
                        infodriver += '<td style="text-align: center">';
                        infodriver += '<p class="text-primary" style="width: auto !important;">';
                        infodriver += '<a class="download" id="'+driverinfoli[e].driver_id+'" href="workassist/driverdownload?driver_id='+driverinfoli[e].driver_id+'" ><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span> 点击下载</a></p>';
                        infodriver += '</td></tr>';
                        i += 1;
                    }
                    $('#hardware .panel-body table tbody').append(infodriver);
            })
        }else{
            let a = $('#hardware .col-md-3 select').eq(0).selectpicker('val')==''?"电脑品牌":'';
            let b = $('#hardware .col-md-4 select').eq(0).selectpicker('val')==''?"电脑型号":'';
            let c = $('#hardware .col-md-3 select').eq(1).selectpicker('val')==''?"操作系统":'';
            let info = "请选择："+a+(a==""?"":"、");
            info += b+(b==""?"":"、");
            info = c==""?info.substring(0,info.length-1):info;
            info += c+"信息！";
            swal("",info,"warning")
        }
    });

    let apptypeinfo = ""
    $.get("workassist/getapptype",function (data,status){apptypeinfo=data.apptype});

    /*获取APP信息*/
    $.get("workassist/getappinfo"
        ,function (data,status){
        appinfos = data.appinfo
            let info = ""
            for(let i in apptypeinfo){
                info += '<div class="panel panel-default"><div class="panel-heading"><h3 class="panel-title">'+apptypeinfo[i].app_type_name+'</h3></div>'
                info += '<div class="container" style="padding-top: 15px"><div class="row">'
                data2 = appinfos.filter(function (item){return item.apptypeInfo.app_type_id==apptypeinfo[i].app_type_id})
                for(let j=0;j<data2.length;j++){
                    info += '<div class="col-md-3"><table class="table table-bordered" style="height: 165px"><tbody><tr><td class="row-vertical-center"><div>'
                    info += '<img src="'+data2[j].img_store_path+'" height="80px"><br>'
                    info += '<h5 class="text-primary"><a href="'+data2[j].app_href+'">'+data2[j].app_name+'</a></h5>'
                    info += '</div></td></tr></tbody></table></div>'
                }
                info += '</div></div>'
            }
            $('#cmccapp .panel div').remove()
            $('#cmccapp .panel').append(info);

            /*生成链接对应二维码*/
            appinfo2 = $('#cmccapp .panel .container .row .col-md-3 table');
            for(let i=0;i<appinfo2.length;i++){
                appinfo2.eq(i).find('td').qrcode({width: 130,height: 130,text: toUtf8(appinfo2.eq(i).find('td a').attr('href')+"")});
                appinfo2.eq(i).find('td canvas').addClass('hidden')
            }


            /*app界面鼠标移入移出*/
            $("#cmccapp .col-md-3 table").bind("mouseenter",function (){
                $(this).find('tr td div').addClass('hidden');
                $(this).find('tr td canvas').removeClass('hidden');
                $(this).addClass("cmcc-app-background");
            })

            $("#cmccapp .col-md-3 table").bind('mouseleave',function (){
                $(this).removeClass("cmcc-app-background");
                $(this).find('tr td div').removeClass('hidden');
                $(this).find('tr td canvas').addClass('hidden');
            });

            /*移动APP界面-触发二次筛选查询事件*/
            $('#cmccapp .input-group button').click(function (){
                searchinfo = $('#cmccapp .input-group input').val().toLowerCase();
                for(let i=0;i<$('#cmccapp .panel .container .row .col-md-3').length;i++){
                    if($('#cmccapp .panel .container .row .col-md-3').eq(i).find('td a').eq(0).get(0).innerText.toLowerCase().indexOf(searchinfo)<0){
                        $('#cmccapp .panel .container .row .col-md-3').eq(i).addClass('hidden')
                    }else{
                        $('#cmccapp .panel .container .row .col-md-3').eq(i).removeClass('hidden')
                    }
                }
            });
    });

    /*驱动查询-二次筛选服务*/
    $('#hardware .input-group button').click(function (){
        searchinfo = $('#hardware .input-group input').val().toLowerCase();
        for(let i=0;i<$('#hardware table tbody tr').length;i++){
            if($('#hardware table tbody tr').eq(i).find('td').eq(1).get(0).innerText.toLowerCase().indexOf(searchinfo)<0){
                $('#hardware table tbody tr').eq(i).addClass('hidden');
            }else{
                $('#hardware table tbody tr').eq(i).removeClass('hidden');
            }
        }
    });

});



