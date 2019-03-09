$.get(serverRoot + "/information/list-test.html", (data) => {
	$(".information-on").html(data);
});
