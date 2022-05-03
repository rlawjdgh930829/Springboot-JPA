let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{
			 this.save();
		});
	},
	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(response) {
			if(response.status === 500) {
				console.log(response);
				alert("글쓰기에 실패하였습니다.");
			} else {
				console.log(response);
				alert("글쓰기가 완료되었습니다.");
				location.href = "/";
			}
		}).fail(function(error) {
			console.log(error);
			alert(JSON.stringify(error));
		}); 
	},
}

index.init();