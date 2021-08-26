

function loginDesplay() {
	$.get(serverRoot + "/user/login.html", (data) => {
		
		$('.login-popup-container').html(data);
		$('.login-popup-container').css("display","flex");
		
		// 여기서 로그인 팝업 종료
		$(document).ready( () => {
			$(".bgdim").click(e => {
				// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
				$.get(serverRoot + "/null.html", (data) => {
					$('.login-popup-container').removeAttr('style');
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



// 페이스북 로그인 구현
 window.fbAsyncInit = function() {
    FB.init({
      appId            : 'your-app-id',
      autoLogAppEvents : true,
      xfbml            : true,
      version          : 'v11.0'
    });
  };
  
  
FB.ui({
  method: 'share',
  href: 'https://developers.facebook.com/docs/'
}, function(response){});

FB.login(function(response) {
    if (response.authResponse) {
     console.log('Welcome!  Fetching your information.... ');
     FB.api('/me', function(response) {
       console.log('Good to see you, ' + response.name + '.');
     });
    } else {
     console.log('User cancelled login or did not fully authorize.');
    }
});

