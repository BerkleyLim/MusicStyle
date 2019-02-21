$.get(serverRoot + "/information/all_information.html", (data) => {
    $("#information").html(data);
});
