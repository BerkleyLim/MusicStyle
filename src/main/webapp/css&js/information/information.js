//// 여기는 바로 페이지 이동없이 바로 곡정보로 이동 시킨다
//function moveInformation() {
//	$(document).ready( () => {
//		$(".move-information").click(e => {
//			$.get(serverRoot + "/information/information.html", (data) => {
//				$(".container").html(data);
//			});
//			clickInformationDetail();
//		});
//	})
//}


// 여기는 어차피 곡정보 불려오는 것 
// handlebars.js로 이용하여 리스트 출력할 것이다!
$.getJSON(serverRoot + "json/information/list", (data) => {
	desplayInformation();
})

// 여기서 상세정보 클릭하고, informationNumber값을 먼저 지정
function desplayInformation() {
	var informationNumber = 00001;
	
	$("#information-detail-00001").click(e => {
		$.get(serverRoot + "information/information-detail.html", (data) => {
			$('.popup-board-detail-container').html(data);
			$('.popup-board-detail-container').css("display","flex");
			
			// 여기서 곡정보 종료
			$(document).ready( () => {
				$(".bgdim").click(e => {
					// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
					$('.popup-board-detail-container').removeAttr("style");
					
					$.get(serverRoot + "/null.html", (data) => {
						$('.popup-board-detail-container').html(data);
					});
				})
			});
			
		});
	});
}

