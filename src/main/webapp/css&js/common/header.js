$(window).on("scroll touchmove", function () {
    $('#header_bg').toggleClass('tiny', $(document).scrollTop() > 0);
});

$.get(serverRoot + "header.html", (data) => {
	$("#header").html(data);
	eventDropdown();
	outputDesplay();
	loadLoginUser();
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
	
	$("#hd-search-practiceInformation").click(e => {
		$("#hd-search-menu").text($("#hd-search-practiceInformation").text());
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

// 여기는 main.html을 직접 불려와서 container에 저장한다.
function outputDesplay() {
	//$(".header").css("height", "80px");
	//$(".container").css("padding-top", "100px");
	//$(".hd-content2").css("display", "none"); // 마이페이지 할때 기능 넣기
	$.get(serverRoot + "/main.html", (data) => {
		$(".container").html(data);
	});
	
	// 여기는 바로 페이지 이동없이 바로 곡정보를 이동 시킨다
	$(document).ready( () => {
		$("#hd-information").click(e => {
			$.get(serverRoot + "/information/list.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}

function loadLoginUser() {
//	$.getJSON(serverRoot + "/json/auth/loginUser", (data) => {
//		
//		$("#nav-link-1").text("글쓰기");
//		$("#nav-link-2").text("장바구니");
//		$("#nav-link-3").text("알림");
//		$("#nav-link-4").text("로그아웃");
//		$(".dropdown").css("display","flex"); // 드롭다운의 관한 css 변경
//		$("#nav-link-5").text(data.nickname);
//
//		// 글쓰기 관련 이벤트 구현
//		$("#nav-link-1").click(e => {
//			e.preventDefault();
//			location.href= serverRoot + "/interia/html/mypage/mp_post.html";
//		});
//		
//		// 장바구니 관련 이벤트 구현
//		$("#nav-link-2").click(e => {
//			e.preventDefault();
//			location.href = serverRoot + "/interia/html/works/sp_bascket.html";
//		});
//		
//		// 알림 관련 기능 구현
//		$("#nav-link-3").click(e => {
//			e.preventDefault();
//		});
//		
//		// 로그아웃 관련 기능 구현
//		$("#nav-link-4").click((e) => { // 로그아웃 버튼
//			e.preventDefault(); // 클릭했을 때 원래 하던 일이 있는데 그것을 하지 말라!
//			$.get(serverRoot + "/json/auth/logout", () => {
//				location.href = serverRoot + "/interia/html/auth/login.html";
//			});
//		});
//		
//		// 마이페이지 관련 기능 구현
//		$("#nav-link-5").click(e => {
//			e.preventDefault();
//			location.href = serverRoot + "/interia/html/mypage/mp_post.html";
//		});
//
//		
//		
//		// 마이페이지 관련 기능에서의 드롭다운의 대한 내용들 수정!
//		$("#mypageName").text(data.nickname + "(마이페이지)");
//		
//		// 마이페이지 연결
//		$("#mypageName").click(e => {
//			e.preventDefault();
//			location.href = serverRoot + "/interia/html/mypage/mp_post.html";
//		});
//		
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
//		
//		// 마이페이지 드롭바 공방신청 or 관리자 기능
//		$("#state-apply-works").click(e => {
//			e.preventDefault();
//			$.getJSON(serverRoot + "/json/workshop/isExist/" + data.no, (result) => {
//				if (result) {  // 판매자 회원 신청 완료시
//					location.href = "../admin/store_admin_index.html";
//				} else { // 판매자 회원이 아닐 경우
//					location.href = "../workshop/workshop_sellerRequest.html";
//				}
//			});
//		});
//		
//		// 마이페이지 드롭바 설정 및 개인정보 기능
//		$("#setting-myprofile").click(e => {
//			e.preventDefault();
//			location.href = serverRoot + "/interia/html/mypage/mp-myinfo.html";
//		});
//		
//		// 마이페이지 드롭바 로그아웃 기능
//		$("#logout").click(e => {
//			e.preventDefault();
//			$.get(serverRoot + "/json/auth/logout", () => {
//				location.href = serverRoot + "/interia/html/auth/login.html";
//			});
//		});
//
//	})
	// 이부분의 대해서는 조금 더 연구를 해 볼것이다. 여기서는 로그인 필요한 부분일 경우 수행하는 것인데 아직은 생각할 필요 있음
	/*.fail(() => {
		location.href = serverRoot + "/interia/html/auth/login.html";
	});*/ 
}



