$(function information(menu){
	$.get(serverRoot + menu , (data) => {
		location.href = data;
	});
})

