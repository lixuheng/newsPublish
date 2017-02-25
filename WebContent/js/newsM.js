$("button").click(function() {
	// console.log($(this).val());
	// console.log($(this).html())
	id = $(this).val();
	console.log(id);
	if ("编辑" == $(this).html()) {
		// alert("编辑，id="+$(this).val());
		window.location.href = "editNews?news_id=" + id;
	} else if("删除" == $(this).html()) {
		// alert("删除，id="+$(this).val());
		if (confirm("确定删除？")) {
			$.ajax({
				url : "delnews",
				type : "get",
				async : false,
				cache : false,
				data : "news.news_id=" + id,
				error : function(event) {
					console.log("后台错误");
					console.log(event);
				},
				dateType : "text",
				success : function(event) {
					// alert(event);
					$("table tr").each(function() {
						console.log($(this).attr("id"));
						if ($(this).attr("id") == id) {
							// alert("del");
							$(this).remove();
						}
					});
				}
			});
		}
	}
});
