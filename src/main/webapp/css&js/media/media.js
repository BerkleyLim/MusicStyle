$(document).ready(()=> {
	
	$("#media-select-all").click(e => {
		$("#selected-genre").text($("#media-select-all").text());
	});
	
	$("#media-select-classic").click(e => {
		$("#selected-genre").text($("#media-select-classic").text());
	});
	
	$("#media-select-newage").click(e => {
		$("#selected-genre").text($("#media-select-newage").text());
	});
	
	$("#media-select-jazz").click(e => {
		$("#selected-genre").text($("#media-select-jazz").text());
	});
	
	$("#media-select-pop").click(e => {
		$("#selected-genre").text($("#media-select-pop").text());
	});
	
	$("#media-select-koreanpop").click(e => {
		$("#selected-genre").text($("#media-select-koreanpop").text());
	});
	
	$("#media-select-ost").click(e => {
		$("#selected-genre").text($("#media-select-ost").text());
	});
	
	$("#media-select-etc").click(e => {
		$("#selected-genre").text($("#media-select-etc").text());
	});
});



$.getJSON(serverRoot + "json/media/list", {"pageNo":1, "pageSize":20}, (data) => {
    // 핸들바 템플릿 가져오기
    var source = $("#media-template").html();

    // 핸들바 템플릿 컴파일
    var template = Handlebars.compile(source);
    var html = template({media:data});
    $('.media-feed').append(html);

}) 

// 곡 정보 상세히 보기, 이벤트 리스너
//$(document).ready(()=> {
    function mediaDetail(mno) {
        //console.log(mno);
        //console.log(serverRoot + "json/media/" + mno);
        
        $.getJSON(serverRoot + "json/media/" + mno, (dataNo) => {
            //var source = $("#media-detail-template").html();  
            //var source = data;
            var source = $("#media-detail-template").html();  
            var template = Handlebars.compile(source);
            
            //console.log('compile.error');
            
            var html = template({mediaDetail:dataNo});
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
