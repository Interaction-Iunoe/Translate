$(document).ready(function() {
	$("#tranlate-submit").click(function() {
		var content=$("#tranlate-content").val();
		var source=$("#tranlate-source").val();
		var target=$("#tranlate-target").val();
		TranslateManager.translate(content, source, target, function(result) {
			$("#translate-result").text(result);
		});
	});
});