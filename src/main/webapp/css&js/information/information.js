// 여기서 상세정보 클릭하고, informationNumber값을 먼저 지정
//function desplayInformation() {
//	var informationNumber = 00001;
//	
//	$("#information-detail-00001").click(e => {
//		$.get(serverRoot + "information/information-detail.html", (data) => {
//			$('.popup-board-detail-container').html(data);
//			$('.popup-board-detail-container').css("display","flex");
//			
//			// 여기서 곡정보 종료
//			$(document).ready( () => {
//				$(".bgdim").click(e => {
//					// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
//					$('.popup-board-detail-container').removeAttr("style");
//					
//					$.get(serverRoot + "/null.html", (data) => {
//						$('.popup-board-detail-container').html(data);
//					});
//				})
//			});
//			
//		});
//	});
//}

// 곡 정보의 대한 내용의 관련 드롭박스
// 여기는 header.js에 이미 정의 되어 있으므로 굳이 
// $('.dropdown-toggle').dropdown(); 넣을 필요가 읍습니다.
//$('.dropdown-toggle').dropdown();

$(document).ready(()=> {
	
	$("#information-select-all").click(e => {
		$("#selected-genre").text($("#information-select-all").text());
	});
	
	$("#information-select-classic").click(e => {
		$("#selected-genre").text($("#information-select-classic").text());
	});
	
	$("#information-select-newage").click(e => {
		$("#selected-genre").text($("#information-select-newage").text());
	});
	
	$("#information-select-jazz").click(e => {
		$("#selected-genre").text($("#information-select-jazz").text());
	});
	
	$("#information-select-pop").click(e => {
		$("#selected-genre").text($("#information-select-pop").text());
	});
	
	$("#information-select-koreanpop").click(e => {
		$("#selected-genre").text($("#information-select-koreanpop").text());
	});
	
	$("#information-select-ost").click(e => {
		$("#selected-genre").text($("#information-select-ost").text());
	});
	
	$("#information-select-etc").click(e => {
		$("#selected-genre").text($("#information-select-etc").text());
	});
});



// 핸들바 템플릿 가져오기
var source = $("#information-template").html();

// 핸들바 템플릿 컴파일
var template = Handlebars.compile(source);


$.getJSON(serverRoot + "json/information/list", {"pageNo":1, "pageSize":20}, (data) => {
    var html = template({information:data});
    $('.information-feed').append(html);

    // 정적인 페이지일 때만 잠시 임시로 수행
    $(document).ready(()=> {
        $('.information-detail').click(e => {
            console.log($('.information-detail').val());
            $.get(serverRoot + "information/information-detail.html", (data) => {
                $('.popup-board-detail-container').html(data);
                $('.popup-board-detail-container').css("display","flex");
                
                // 여기서 곡정보 종료
                $(document).ready( () => {
                    $(".bgdim").click(e => {
                        // 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
                        $('.popup-board-detail-container').removeAttr("style");
                        
                        $.get(serverRoot + "/null.html", (data) => {
                            $('.popup-board-detail-container').html(data);
                        });
                    })
                });
                
            });
        });
    });
}) 

       //  {no:1, /*username:"berkley", */ view:3000000, artist:"이루마", title:"Yellow moon", 
       //    img:"/image/sample-yiruma-chaconne.png", genre:"뉴에이지", releaseDate:1998, 
       //    albumName:"Yellow moon", /*musicLink:"", */ content:"이 곡은 클래식을 기반해서.....", uploadDate:"2020-05-31"}

// 핸들바 템플릿에 바인딩할 데이터
//var data = {
//   information : array
  
   
   //[
        
       // {no:1, /*username:"berkley", */ view:3000000, artist:"이루마", title:"Yellow moon", 
       //     img:"/image/sample-yiruma-chaconne.png", genre:"뉴에이지", releaseDate:1998, 
       //     albumName:"Yellow moon", /*musicLink:"", */ content:"이 곡은 클래식을 기반해서.....", uploadDate:"2020-05-31"},
       // {no:1, /*username:"berkley", */ view:3000000, artist:"이루마", title:"Yellow moon", 
       // img:"/image/sample-yiruma-chaconne.png", genre:"뉴에이지", releaseDate:1998, 
       // albumName:"Yellow moon", /*musicLink:"", */ content:"이 곡은 클래식을 기반해서.....", uploadDate:"2020-05-31"}
        
      
    //]
    
//}

// 핸들바 템플릿에 데이터를 바인딩해서 HTML 설정
//var html = template(data);

// 생성된 HTML을 DOM에 주입
//$('.information-feed').append(html);






// 정적인 페이지일 때만 잠시 임시로 수행
//$(document).ready(()=> {
//	$('.information-detail').click(e => {
//       console.log("작동성공");
//		$.get(serverRoot + "information/information-detail.html", (data) => {
//			$('.popup-board-detail-container').html(data);
//			$('.popup-board-detail-container').css("display","flex");
//			
//			// 여기서 곡정보 종료
//			$(document).ready( () => {
//				$(".bgdim").click(e => {
//					// 여기서 이벤트는 style이라는 속성으로 css로 사용 (display:none)
//					$('.popup-board-detail-container').removeAttr("style");
//					
//					$.get(serverRoot + "/null.html", (data) => {
//						$('.popup-board-detail-container').html(data);
//					});
//				})
//			});
//			
//		});
//	});
//});
