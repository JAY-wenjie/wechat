// JavaScript Document
$(function(){
    var arr = location.href.split("&")[0].split("=");
    if (arr.length > 1) {
    	var strName = arr[0].split("?")[1];
        var code = arr[1];
        //alert("strName:"+strName);
		if(strName=="code"){
            //alert("服务器返回code值:"+code);
            $.ajax({
                type: "post",
                url: "http://5k9if5r.hn3.mofasuidao.cn/web-admin/code.do",
                data: {"code": code},
                async: false,
                dataType: "json",
                success: function (data) {
                }
            })
		}

    }
	//计算内容上下padding
	reContPadding({main:"#main",header:"#header",footer:"#footer"});
	function reContPadding(o){
		var main = o.main || "#main",
			header = o.header || null,
			footer = o.footer || null;
		var cont_pt = $(header).outerHeight(true),
			cont_pb = $(footer).outerHeight(true);
		$(main).css({paddingTop:cont_pt,paddingBottom:cont_pb});
	}
});


//折叠展开列表内容
$(document).ready(function(){
  mui('#slider').on('tap', '.open-btn', function (e) {
	  $(".nav-con").fadeToggle("fast");
	  $(".open-btn span").toggleClass('rotate'); 	
	  if($(".open-btn span").hasClass('rotate')){
		 $("#slider").on("touchmove.ddd",function(e){
			// console.log(e)
			  e.stopPropagation();
		});
	  }else{
		  console.log(1)
		 $("#slider").off("touchmove.ddd");  
	  }
  });
});