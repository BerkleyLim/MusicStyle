








$.getJSON(serverRoot + "json/practiceRoom/list", {"pageNo":1, "pageSize":20}, (data) => {
    // 핸들바 템플릿 가져오기
    var source = $("#practiceRoom-template").html();

    // 핸들바 템플릿 컴파일
    var template = Handlebars.compile(source);
    var html = template({practiceRoom:data});
    $('.practiceRoom-feed').append(html);

}) 

// 곡 정보 상세히 보기, 이벤트 리스너
//$(document).ready(()=> {
    function practiceRoomDetail(pno) {
        //console.log(pno);
        //console.log(serverRoot + "json/practiceRoom/" + pno);
        
        $.getJSON(serverRoot + "json/practiceRoom/" + pno, (dataNo) => {
            //var source = $("#practiceRoom-detail-template").html();  
            //var source = data;
            var source = $("#practiceRoom-detail-template").html();  
            var template = Handlebars.compile(source);
            
            //console.log('compile.error');
            
            var html = template({practiceRoomDetail:dataNo});
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