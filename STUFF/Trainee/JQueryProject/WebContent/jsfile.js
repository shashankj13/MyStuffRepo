/**
 * 
 */

$(document).ready(function() {
	
	$('#add').click(function() {
		var title = prompt("Enter Title For New Field");		
		var type = prompt("Enter Type Of Field","");
		if (title != null && type != null) {
		$('tr.field').after('<tr  id="'+ type.concat(title)+ '"><td >'
		+ title+ ':</td><td><input type="'+type+ '" id="'+ type.concat(title)
		+  '" ></td><td><input type="button" id="'+ type.concat(title)
		+ '" value="-" class="remove"></td></div></tr>');

		} else {
			alert("No Value Found ");
		}

		});

		$(document).on('click', '.remove', function() {
			var id=$(this).closest('tr').attr('id');
			$('#'+id).remove();

		});
});



