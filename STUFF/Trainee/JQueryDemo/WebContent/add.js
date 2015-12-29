/**
 * 
 */



$(document).ready(function() {
	$('#add').click(function() {
		var field = prompt("Enter Field Name", "Default");
		var type = prompt("Enter Field Type ", "text/password/number");
		if (field!= null && type!= null) {		
			   
			    $('#inside').click(function(){ 
		            $('.main').append('<div><input type="text" name="mytext[]"/><a href="#" class="remove_field">Remove</a></div>');
			    });
		   
			    $('.main').on("click",".remove_field", function(){ 
		         $(this).parent('div').remove();
		    });
			
		}
	});
});
