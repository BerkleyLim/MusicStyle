//// 여기는 바로 페이지 이동없이 바로 곡정보로 이동 시킨다
//function moveInformation() {
//	$(document).ready( () => {
//		$(".move-information").click(e => {
//			$.get(serverRoot + "/information/information.html", (data) => {
//				$(".container").html(data);
//			});
//		});
//	})
//}


// 여기는 어차피 곡정보 불려오는 것 
// handlebars.js로 이용하여 리스트 출력할 것이다!
//$.getJSON(serverRoot + "json/information/list", (data) => {
//	desplayInformation();
//})


// 여기서 상세정보 클릭하고, informationNumber값을 먼저 지정
//function desplayInformation() {
//	var informationNumber = 00001;
//	
//	$("#information-detail-00001").click(e => {
//		$.get(serverRoot + "information/information-detail.html", (data) => {
//			$('.popup-board-detail-container').html(data);
//			$('.popup-board-detail-container').css("display","flex");
//			
//			// 여기서 곡정보 종료
//			$(document).ready( () => {
//				$(".bgdim").click(e => {
//					// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
//					$('.popup-board-detail-container').removeAttr("style");
//					
//					$.get(serverRoot + "/null.html", (data) => {
//						$('.popup-board-detail-container').html(data);
//					});
//				})
//			});
//			
//		});
//	});
//}

// 곡 정보의 대한 내용의 관련 드롭박스
// 여기는 header.js에 이미 정의 되어 있으므로 굳이 
// $('.dropdown-toggle').dropdown(); 넣을 필요가 읍습니다.
//$('.dropdown-toggle').dropdown();

$(document).ready(()=> {
	
	$("#information-select-all").click(e => {
		$("#selected-genre").text($("#information-select-all").text());
	});
	
	$("#information-select-classic").click(e => {
		$("#selected-genre").text($("#information-select-classic").text());
	});
	
	$("#information-select-newage").click(e => {
		$("#selected-genre").text($("#information-select-newage").text());
	});
	
	$("#information-select-jazz").click(e => {
		$("#selected-genre").text($("#information-select-jazz").text());
	});
	
	$("#information-select-pop").click(e => {
		$("#selected-genre").text($("#information-select-pop").text());
	});
	
	$("#information-select-koreanpop").click(e => {
		$("#selected-genre").text($("#information-select-koreanpop").text());
	});
	
	$("#information-select-ost").click(e => {
		$("#selected-genre").text($("#information-select-ost").text());
	});
	
	$("#information-select-etc").click(e => {
		$("#selected-genre").text($("#information-select-etc").text());
	});
});



// 정적인 페이지일 때만 잠시 임시로 수행
$(document).ready(()=> {
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
	
});
