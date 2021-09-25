

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


// 카카오


// 페이스북 로그인 구현
window.fbAsyncInit = function() {
    FB.init({
      appId      : '{your-app-id}',
      cookie     : true,
      xfbml      : true,
      version    : '{api-version}'
    });
      
    FB.AppEvents.logPageView();   
      
};

(function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
  
  

FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
});

/*
{
    status: 'connected',
    authResponse: {
        accessToken: '...',
        expiresIn:'...',
        signedRequest:'...',
        userID:'...'
    }
}
*/

/*
<fb:login-button 
  scope="public_profile,email"
  onlogin="checkLoginState();">
</fb:login-button>
*/
function checkLoginState() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}


