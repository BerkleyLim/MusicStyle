


$.getJSON(serverRoot + "json/sheetMusic/list", {"pageNo":1, "pageSize":20}, (data) => {
    // 핸들바 템플릿 가져오기
    var source = $("#sheetMusic-template").html();

    // 핸들바 템플릿 컴파일
    var template = Handlebars.compile(source);
    var html = template({sheetMusic:data});
    $('.sheetMusic-feed').append(html);

}) 

// 곡 정보 상세히 보기, 이벤트 리스너
//$(document).ready(()=> {
    function sheetMusicDetail(sno) {
        //console.log(sno);
        //console.log(serverRoot + "json/sheetmusic/" + sno);
        
        $.getJSON(serverRoot + "json/sheetmusic/" + sno, (dataNo) => {
            //var source = $("#sheetMusic-detail-template").html();  
            //var source = data;
            var source = $("#sheetMusic-detail-template").html();  
            var template = Handlebars.compile(source);
            
            //console.log('compile.error');
            
            var html = template({sheetMusicDetail:dataNo});
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