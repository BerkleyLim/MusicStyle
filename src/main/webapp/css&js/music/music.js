// 여기는 바로 페이지 이동없이 바로 음원으로 이동 시킨다
function moveMusic() {
	$(document).ready( () => {
		$(".move-music").click(e => {
			$.get(serverRoot + "/music/music.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}
