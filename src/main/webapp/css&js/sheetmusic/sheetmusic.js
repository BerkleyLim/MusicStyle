// 여기는 바로 페이지 이동없이 바로 악보로 이동 시킨다
function moveSheetmusic() {
	$(document).ready( () => {
		$(".move-sheetmusic").click(e => {
			$.get(serverRoot + "/sheetmusic/sheetmusic.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}
