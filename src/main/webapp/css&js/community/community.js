//$('.dropdown-toggle').dropdown();

// 여기는 바로 페이지 이동없이 바로 커뮤니티로 이동 시킨다
function moveCommunity() {
	$(document).ready( () => {
		$(".move-community").click(e => {
			$.get(serverRoot + "/community/community.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}



$("#board-10").click(e => {
	$("#desplay-board-menu").text($("#board-10").text());
});