// 메인 화면 출력
$.get(serverRoot + "main.html", (data) => {
    $(".container").html(data);
});