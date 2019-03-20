// 헤더의 프로필 창 클릭시!
$(document).ready( () => {
	$(".header_mymenu button").click(e => {
		$.get(serverRoot + "/user/login.html", (data) => {
			
			$('.login-popup-container').html(data);
			$('.login-popup-container').css("display","flex");
			
			// 여기서 로그인 팝업 종료
			$(document).ready( () => {
				$(".bgdim").click(e => {
					// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
					$('.login-popup-container').removeAttr("style");
				})
			});
		})
	})
})

