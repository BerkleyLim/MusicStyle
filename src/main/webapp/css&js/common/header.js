$(window).on("scroll touchmove", function () {
    $('#header_bg').toggleClass('tiny', $(document).scrollTop() > 0);
});

$.get(serverRoot + "header.html", (data) => {
	$("#header").html(data);
	eventDropdown();
	outputDesplay();
	//loadLoginUser();
	// 차후 로그인 될 경우 loadLoginUser()에 함수 넣을 예정 (마이페이지 이동처리)
	// 헤더의 프로필 창 클릭시
	$(document).ready( () => {
		$(".header_mymenu button").click(e => {
			loginDesplay();
//			$.get(serverRoot + "/mypage/mypage.html", (data) => {
//				$(".container").html(data);
//			})
		})
	})
});

// header의 드롭박스 이벤트
function eventDropdown() {
	$('.dropdown-toggle').dropdown();

	$("#hd-search-all").click(e => {
		$("#hd-search-menu").text($("#hd-search-all").text());
	});
	
	$("#hd-search-information").click(e => {
		$("#hd-search-menu").text($("#hd-search-information").text());
	});
	
	$("#hd-search-sheetmusic").click(e => {
		$("#hd-search-menu").text($("#hd-search-sheetmusic").text());
	});
	
	$("#hd-search-music").click(e => {
		$("#hd-search-menu").text($("#hd-search-music").text());
	});
	
	$("#hd-search-community").click(e => {
		$("#hd-search-menu").text($("#hd-search-community").text());
	});
	
	$("#hd-search-teacher").click(e => {
		$("#hd-search-menu").text($("#hd-search-teacher").text());
	});
	
	$("#hd-search-practiceRoom").click(e => {
		$("#hd-search-menu").text($("#hd-search-practiceRoom").text());
	});
	
	// 여기는 다국어 드롭박스이다
	$("#select-korean").click(e => {
		$("#select-language").text($("#select-korean").text());
		// 여기서부터 해당 언어를 이벤트 처리
	});
	
	$("#select-japanese").click(e => {
		$("#select-language").text($("#select-japanese").text());
		// 여기서부터 해당 언어를 이벤트 처리
	});
	
	$("#select-English").click(e => {
		$("#select-language").text($("#select-English").text());
		// 여기서부터 해당 언어를 이벤트 처리
	});
}

// 여기는 Container를 이동할 경로 설정
function outputDesplay() {

	// 메인 화면 출력
	$.get(serverRoot + "main.html", (data) => {
		$(".container").html(data);
	});
	
	// 여기는 바로 페이지 이동없이 바로 마이페이지로 이동 시킨다
	$(document).ready( () => {
		$("#hd-mypage").click(e => {
			// 차후, 이부분의 대해서 따로 연구해보겠음
			//$(".header").css("height", "80px");
			//$(".container").css("padding-top", "100px");
			//$(".hd-content2").css("display", "none"); // 마이페이지 할때 기능 넣기
			
			$.get(serverRoot + "/mypage/list.html", (data) => {
				$(".container").html(data);
			});
		});
	})
	
	
	// 여기는 바로 페이지 이동없이 바로 소개페이지로 이동 시킨다
	$(document).ready( () => {
		$("#hd-introduction").click(e => {
			$.get(serverRoot + "/introduction/introduction.html", (data) => {
				$(".container").html(data);
			});
		});
	})
	
	// 여기는 바로 페이지 이동없이 바로 곡정보로 이동 시킨다
	$(document).ready( () => {
		$("#hd-information").click(e => {
			$.get(serverRoot + "/information/information.html", (data) => {
				$(".container").html(data);
				
			});
			clickInformationDetail();
		});
	})
	
	// 여기는 바로 페이지 이동없이 바로 음원으로 이동 시킨다
	$(document).ready( () => {
		$("#hd-music").click(e => {
			$.get(serverRoot + "/music/music.html", (data) => {
				$(".container").html(data);
			});
		});
	})
	
	// 여기는 바로 페이지 이동없이 바로 악보로 이동 시킨다
	$(document).ready( () => {
		$("#hd-sheetmusic").click(e => {
			$.get(serverRoot + "/sheetmusic/sheetmusic.html", (data) => {
				$(".container").html(data);
			});
		});
	})
	
	// 여기는 바로 페이지 이동없이 바로 레스너찾기로 이동 시킨다
	$(document).ready( () => {
		$("#hd-teacher").click(e => {
			$.get(serverRoot + "/teacher/teacher.html", (data) => {
				$(".container").html(data);
			});
		});
	})
	
	// 여기는 바로 페이지 이동없이 바로 연습실정보로 이동 시킨다
	$(document).ready( () => {
		$("#hd-practiceRoom").click(e => {
			$.get(serverRoot + "/practiceRoom/practiceRoom.html", (data) => {
				$(".container").html(data);
			});
		});
	})
	
	// 여기는 바로 페이지 이동없이 바로 커뮤니티로 이동 시킨다
	$(document).ready( () => {
		$("#hd-community").click(e => {
			$.get(serverRoot + "/community/community.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}

//function loadLoginUser() {
//	$.getJSON(serverRoot + "/json/auth/loginUser", (data) => {
//		/*// 마이페이지 드롭바 글쓰기 기능
//		$("#write").click(e => {
//			e.preventDefault();
//		});
//		
//		// 마이페이지 드롭바 주문제작 글쓰기 기능
//		$("#write-order").click(e => {
//			e.preventDefault();
//		});
//		
//		// 마이페이지 드롭바 주문 제작상태 기능
//		$("#state-order").click(e => {
//			e.preventDefault();
//		});*/
//	})
//	// 이부분의 대해서는 조금 더 연구를 해 볼것이다. 여기서는 로그인 필요한 부분일 경우 수행하는 것인데 아직은 생각할 필요 있음
//	/*.fail(() => {
//		location.href = serverRoot + "/interia/html/auth/login.html";
//	});*/ 
//}



