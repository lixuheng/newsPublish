
	function postaddnewsform(){
		//取出富文本框的内容
		var content  = editor.$txt.html();
		//处理日期时间
		var date =$("#ariseTime").val();
		//alert(date);
		/*
		riqi = date.substr(0,10);
		time = date.substr(11);
		date = riqi+" "+time;
		*/
		//alert(date);
		var data = $("#addNewsForm").serialize();
		data+="&news.content="+content+"&news.arise_date="+date;
		//alert(data);
		
		$.ajax({
			async:false,
			cache:false,
			url:"addnews",
			type:"post",
			data:data,
			dataType:"text",
			error:function(e){
				alert("后台错误");
				console.log(e);
			},
			success:function(s){
				if(s!="error"){
					alert("添加成功");
					quxiao();
				}else{
					alert("添加失败");
				}
				
			}
		})
		
		return false;
	}
	function quxiao(){
		$("#addNewsForm").get(0).reset();
		$("#editor-trigger").empty();
	}
