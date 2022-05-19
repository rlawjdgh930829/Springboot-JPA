let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{
			 this.save();
		});
		$("#btn-update").on("click", ()=>{
			 this.update();
		});
	},
	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		// ajax호출 시 default가 비동기 호출
		// ajax를 이용해서 데이터를 json으로 변경하여 insert요청
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // 서버로 요청하는 body 데이터가 어떤 타입인지
			dataType: "json" // 서버로부터 어떤 타입의 데이터를 받을 지 -> 받은 josn 데이터를 javascript object로 변환
		}).done(function(response) {
			if(response.status === 500) {
				console.log(response);
				alert("회원가입에 실패하였습니다.");
			} else {
				console.log(response);
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			}
		}).fail(function(error) {
			console.log(error);
			alert(JSON.stringify(error));
		}); 
	},
	
	update: function() {
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(response) {
			if(response.status === 500) {
				console.log(response);
				alert("회원수정에 실패하였습니다.");
			} else {
				console.log(response);
				alert("회원수정이 완료되었습니다.");
				location.href = "/";
			}
		}).fail(function(error) {
			console.log(error);
			alert(JSON.stringify(error));
		}); 
	},
}

index.init();