$(document).ready(function() {
	$('#submitButton').on('click', function(e) {
		e.preventDefault();
		$('#result').html('');

		var file = $("#file").val();
											
		if (file == '') {
			$("#result").addClass("alert-warning");
			$("#result").html("Por favor seleccione un archivo primero.");
			e.preventDefault();
		} else {
			// Check file extension
			var ext = file.split('.').pop().toLowerCase(); 
																														
			if ($.inArray(ext, [ 'xml' ]) == -1) {
				$("#result").addClass("alert-warning");
				$("#result").html("Seleccione un archivo valido, solo se permite archivos de extension XML.");
				e.preventDefault();
			} else {
				$("#result").removeClass("alert-warning");
				
				$("#uploadForm").ajaxForm({
					success : function(data) {
						$('#result').html(data);
						$("#result").addClass("alert-info");
					},
					dataType : "text"
				}).submit();
			}
		}		
	});
});