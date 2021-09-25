// 여기는 바로 페이지 이동없이 바로 마이페이지로 이동 시킨다
function moveMypage() {
	$(document).ready( () => {
		$(".move-mypage").click(e => {
			// 차후, 이부분의 대해서 따로 연구해보겠음
			//$(".header").css("height", "80px");
			//$(".container").css("padding-top", "100px");
			//$(".hd-content2").css("display", "none"); // 마이페이지 할때 기능 넣기
			
			$.get(serverRoot + "/mypage/mypage.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}


function moveMyInformation() {
    $.getJSON(serverRoot + "/mypage/myInformation.html", (data) => {
        $(".mypage-target-container").html(data);
    })
}