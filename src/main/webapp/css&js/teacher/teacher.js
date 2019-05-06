// 여기는 바로 페이지 이동없이 바로 레스너찾기로 이동 시킨다
function moveTeacher() {
	$(document).ready( () => {
		$(".move-teacher").click(e => {
			$.get(serverRoot + "/teacher/teacher.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}
