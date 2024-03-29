$(window).on("scroll touchmove", function () {
    $('#header_bg').toggleClass('tiny', $(document).scrollTop() > 0);
});

$.get(serverRoot + "header.html", (data) => {
	$("#header").html(data);
	eventDropdown();
	//outputDesplay();
	//loadLoginUser();
	// 차후 로그인 될 경우 loadLoginUser()에 함수 넣을 예정 (마이페이지 이동처리)
	// 헤더의 프로필 창 클릭시 (여기는 임시용으로 사용) => 나중에 moveMypage()로 이용하여 처리할 것이다
	$(document).ready( () => {
		$(".header_mymenu button").click(e => {
			//loginDesplay();
//			$.get(serverRoot + "json/user/", (data) => {
//				$(".container").html(data);
//			})
        movePage("/user");

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


// 여기는 바로 페이지 이동없이 바로 마이페이지, 소개페이지, 곡정보
// 음원, 악보, 레스너찾기, 연습실정보, 커뮤니티로 이동 시킨다
function movePage(page){
    
    // 1번 => 현재폼의 정보를 다음 페이지로 전송
    //document.id.action="/json/" + page + "/";
    //document.id.submit();
    
    // 2번(값을 정해야 하는 프로퍼티) => 순서대로 이동
    //location.href="/json/" + page + "/";
    
    // 3번(파라미터로 동작하는 메소드) => 페이지 자체 변경
    location.replace("/json/" + page + "/");
    
//    var state = { 'page_id': 1, 'user_id': 5 };
//    var title = "뮤직스타일";
//    var url = '/' + page;
//     
//    //history.pushState(state, title, url);
//    history.pushState(null, null, url);
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



