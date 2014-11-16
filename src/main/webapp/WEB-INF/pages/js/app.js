(function($) {
	$(".next_page").click(function() {
		page = document.getElementById('page').value;
		total = document.getElementById('total').value;
		size = document.getElementById('size').value;
		page=page+1;
		if (total % size == 0) {
			maxpage = total / size;
		} else {
			maxpage = total / size + 1;
		}
		if (page > maxpage) {
			page = maxpage;
		}
		$("#page").val(page);
		$("#main-form").submit();
	});
	$(".previous_page").click(function() {
		page = document.getElementById('page').value;
		page=page-1;
		if (page <= 0) {
			page = 1;
		}
		$("#page").val(page);
		$("#main-form").submit();
	});
})(window.jQuery);