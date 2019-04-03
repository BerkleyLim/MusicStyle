

function loginDesplay() {
	$.get(serverRoot + "/user/login.html", (data) => {
		
		$('.login-popup-container').html(data);
		$('.login-popup-container').css("display","flex");
		
		// 여기서 로그인 팝업 종료
		$(document).ready( () => {
			$(".bgdim").click(e => {
				// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
				//$('.login-popup-container').removeAttr("style");
				$.get(serverRoot + "/null.html", (data) => {
					$('.login-popup-container').html(data);
				});
			})
		});
		
		// 로그인 클릭시
		$(document).ready( () => {
			$(".log-in").click(e => {
				login();
			})
		})
		
		// 회원가입 클릭시
		$(document).ready( () => {
			$(".popup-sign-up").click(e => {
				signUp();
			})
		})
		
	})
}

// 로그인 이벤트
function login() {
	// 여기서는 세션을 이용한 백엔드 기법 사용
//	$.getJSON()
//	.fall({
//		window.alert("회원정보가 일치하지 않습니다");
//	})
}

// 회원가입 이벤트
function signUp() {
	$.get(serverRoot + "/user/sign-up.html", (data) => {
		$('.login-popup-container').html(data);
		$('.login-popup-container').css("display","flex");
		
		// 여기서 로그인 팝업 종료
		$(document).ready( () => {
			$(".bgdim").click(e => {
				// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
				$.get(serverRoot + "/null.html", (data) => {
					$('.login-popup-container').html(data);
				});
			})
		});
		
		// 이전으로 클릭시
		$(document).ready( () => {
			$(".back-login").click(e => {
				loginDesplay();
			})
		})
	})
}

