
	function postaddnewsform(){
		//取出富文本框的内容
		var content  = editor.$txt.html();
		//处理日期时间
		var date =$("#ariseTime").val();
		var data = $("#editNewsForm").serialize();
		data+="&news.content="+content+"&news.arise_date="+date;

		$.ajax({
			async:false,
			cache:false,
			url:"alterNews",
			type:"post",
			data:data,
			dataType:"text",
			error:function(e){
				alert("后台错误");
				console.log(e);
			},
			success:function(s){
				if(s!="error"){
					alert("已修改");
					quxiao();
				}else{
					alert("添加失败");
				}
			}
		})
		
		return false;
	}
	function quxiao(){
		$("#editNewsForm").get(0).reset();
		$("#editor-trigger").empty();
	}
