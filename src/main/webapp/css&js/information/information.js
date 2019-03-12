// 여기는 바로 페이지 이동없이 바로 곡정보를 추가 시킨다
$(document).ready( () => {
	$("#hd-information").click(e => {
		$.get(serverRoot + "/information/list.html", (data) => {
			$(".container").html(data);
		});
	});
})

