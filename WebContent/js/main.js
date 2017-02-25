
$("#newcol>a").click(function (){
	$("#newcol").addClass("active");
	$("#professional").removeClass("active");
	$("#deep").removeClass("active");
	$("#module1").css("display","block");
	$("#module2").css("display","none");
	$("#module3").css("display","none");
});
$("#professional>a").click(function (){
	$("#newcol").removeClass("active");
	$("#professional").addClass("active");
	$("#deep").removeClass("active");
	$("#module1").css("display","none");
	$("#module2").css("display","block");
	$("#module3").css("display","none");
});
$("#deep>a").click(function (){
	$("#newcol").removeClass("active");
	$("#professional").removeClass("active");
	$("#deep").addClass("active");
	$("#module1").css("display","none");
	$("#module2").css("display","none");
	$("#module3").css("display","block");
});