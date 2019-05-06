// 여기는 바로 페이지 이동없이 바로 연습실정보로 이동 시킨다
function movePracticeRoom() {
	$(document).ready( () => {
		$(".move-practiceRoom").click(e => {
			$.get(serverRoot + "/practiceRoom/practiceRoom.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}
