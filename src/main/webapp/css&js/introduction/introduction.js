// 여기는 바로 페이지 이동없이 바로 소개페이지로 이동 시킨다
function moveIntroduction() {
	$(document).ready( () => {
		$(".move-introduction").click(e => {
			$.get(serverRoot + "/introduction/introduction.html", (data) => {
				$(".container").html(data);
			});
		});
	});
}
