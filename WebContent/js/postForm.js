
var canDo1 ;
var canDo2 ;
var canDo3 ;
var urlvar ;

function chlogin(){
	canDo1 = false;
	canDo2 = false;
	canDo3 = false;
	//alert("tologinbtn");
	$("#myModalLabel").html("用户登录");
	//$("#postform").attr("action","login");
	urlvar = "login";
	$("button#ok").text("登录");
	$("#postform span").empty();
	$("#postform div").removeClass("has-error");
	$("#phonebox").hide();
	$("#birthbox").hide();
}

function chreg (){
	canDo1 = false;
	canDo2 = false;
	canDo3 = false;
	$("#myModalLabel").html("用户注册");
	//$("#postform").attr("action","reg");
	urlvar = "reg";
	$("button#ok").text("注册");
	$("#postform span").empty();
	$("#postform div").removeClass("has-error");
	$("#phonebox").show();
	$("#birthbox").show();
}


//校验用户名
$("#namebox").focusin(
		function(envent) {
			$("#nameinput").empty();
			$("#nameinput").focusout(
					function() {
						if ($("#nameinput").val().length < 3
								|| $("#nameinput").val().length >= 40) {
							$("#namebox").addClass("has-error");
							$("#namebox>div>span").empty();
							$("#namebox>div>span").html("用户名长度不在[3,40]范围内");
						} else {
							$("#userbox").removeClass("has-error");
							$("#userbox>div>span").empty();
							//alert($("#nameinput").val());
							if (!(/^[a-zA-Z]{1}[0-9a-zA-Z_]{1,}$/.test($(
									"#nameinput").val()))) {
								$("#namebox").addClass("has-error");
								$("#namebox>div>span").empty();
								$("#namebox>div>span").html("用户名只能使用字母数字和下划线,并以字母开头");
							} else {
								//alert("name true ");
								//如果是注册，多一个重复性判断
								if($("#myModalLabel").html()=="用户注册"){
									$.ajax({
										cache : false,
										type : "post",
										url : "isHadOneName",
										data: $('#postform').serialize(),
										async : false,
										error : function(request) {
											alert("后台错误");
											console.log(request);
										},
										dataType : "text",
										success : function(data) {
											//alert("ok");
											console.log("data=  "+data);
											if(data=="true"){
												canDo1 = false;
												//alert("该用户名已被注册");
												$("#namebox span").html("该用户名已被注册");
											}else{
												canDo1 = true;
												$("#namebox").removeClass("has-error");
												$("#namebox>div>span").empty();
											}
										}
									})
								}else{//是登录
									canDo1=true;
									$("#namebox").removeClass("has-error");
									$("#namebox>div>span").empty();
								}
							}
						}
					});
		});

//校验密码长度
$("#pwdbox").focusin(
		function(envent) {
			$("#pwdinput").empty();
			$("#pwdinput").focusout(
					function() {
						if ($("#pwdinput").val().length < 2
								|| $("#pwdinput").val().length >= 40) {
							$("#pwdbox").addClass("has-error");
							$("#pwdbox>div>span").empty();
							$("#pwdbox>div>span").html("密码长度不在[6,40]之间");
						} else {
							//alert("pwd true ");
							canDo2=true;
							$("#pwdbox").removeClass("has-error");
							$("#pwdbox>div>span").empty();
							
						}
					});
		});


//校验验证码
$("#verimgbox").focusin(
		function(envent) {
			$("#yzm").empty();
			$("#yzm").mouseleave(
					function() {
						if ($("#yzm").val().length <6) {
							$("#verimgbox").addClass("has-error");
							$("#verimgbox>div>span").empty();
							$("#verimgbox>div>span").html("验证码没有填写");
						} else {
							//alert("vercode true ");
							canDo3=true;
							$("#verimgbox").removeClass("has-error");
							$("#verimgbox>div>span").empty();
							
						}
					});
		});
//校验手机号
$("#phonebox").focusin(
		function(envent) {
			//alert("phonebox1");
			$("#phoneinput").empty();
			$("#phoneinput").focusout(
					function() {
						//alert("phonebox2");|| !/^dd$/.test($("phoneinput").val()
						//alert($("#phoneinput").val().length);
						if ( $("#phoneinput").val().length <7 ) {
							$("#phonebox").addClass("has-error");
						} else {
							//alert("vercode true ");
							$("#phoneinput").removeClass("has-error");
						}
					});
		});



//提交表单
$("#ok").click(function(event) {
	if (canDo1&&canDo2&&canDo3) {
		$.ajax({
			cache : false,
			type : "post",
			url : urlvar,
			data : $('#postform').serialize(),
			async : false,
			error : function(request) {
				alert("后台错误");
				console.log(request);
				//alert("Connection error");
			},
			dataType : "text",
			success : function(data) {
				//alert("ok");
				alert(data);
				$('#postform').modal('hide');
				window.location.reload();
			}
		})
	} else {
		alert("表单不正确");
	}
})
//取消
$("#cancel").click(function(event) {
	$('#login').modal('hide');
});