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


//function clickInformationDetail() {
// 여기서 상세정보 클리하고, informationNumber값을 먼저 지정
	var informationNumber = 00001;

	$(document).ready( () => {
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
	})
//}

