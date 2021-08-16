// 여기는 바로 페이지 이동없이 바로 레스너찾기로 이동 시킨다
function moveTeacher() {
	$(document).ready( () => {
		$(".move-teacher").click(e => {
			$.get(serverRoot + "/teacher/teacher.html", (data) => {
				$(".container").html(data);
			});
		});
	})
}

$.getJSON(serverRoot + "json/teacher/list", {"pageNo":1, "pageSize":20}, (data) => {
    // 핸들바 템플릿 가져오기
    var source = $("#information-template").html();

    // 핸들바 템플릿 컴파일
    var template = Handlebars.compile(source);
    var html = template({information:data});
    $('.information-feed').append(html);

}) 

function informationDetail(tno) {
    //console.log(tno);
    //console.log(serverRoot + "json/teacher/" + tno);
    
    $.getJSON(serverRoot + "json/teacher/" + ino, (dataNo) => {
        //var source = $("#information-detail-template").html();  
        //var source = data;
        var source = $("#information-detail-template").html();  
        var template = Handlebars.compile(source);
        
        //console.log('compile.error');
        
        var html = template({teacherDetail:dataNo});
        $('.popup-board-detail-container').html(html);  
        $('.popup-board-detail-container').css("display","flex");
    
        // 여기서 곡정보 종료
        $(document).ready( () => {
            $(".bgdim").click(e => {
                // 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
                $('.popup-board-detail-container').removeAttr("style");
                
                $.get(serverRoot + "/null.html", (deleteData) => {
                    $('.popup-board-detail-container').html(deleteData);
                });
            })
        });
    })
    
}