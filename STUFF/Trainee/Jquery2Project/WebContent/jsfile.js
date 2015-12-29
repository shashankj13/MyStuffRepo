var count=0;
/**
 * 
 */

$(document).ready(function() {
	$('#add').click(function() {		
		$("#dialog").dialog({

			height : 300,
			width : 600,
			show:{
				effect:"blind",
				duration:500,
			},
			hide:{
				effect:"explode",
				duration:500,
		}
			
		});
	});
	
});

function read(input) {

	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#image').attr('src', e.target.result).width(100).height(100);
		};

		reader.readAsDataURL(input.files[0]);
	}
	
}



function display(){
	var f = new Object();
	f = document.getElementById('formid');
	var image = document.getElementById('image').src;
	var name = f.name.value.toString();
	var contact = f.contact.value.toString();
	var email = f.email.value.toString();
	$('#leftlower').append("<div id='"+(++count)+"'> <table border='1' class=show> " +
			"<tr > <td> <image src ="+image +" height=30px width=30px class=getimg> </td> " +
					" <td> <div class=getdiv> remove </div>  </td></tr>" +
			"<tr> <td> Name : </td>   <td> "+ name + "</td> </tr>" +
			"<tr> <td> Contact : </td>   <td> "+ contact + "</td> </tr>" +
			"<tr> <td> Email : </td>   <td> "+ email + "</td> </tr>" +
			
			"</table> " +
			"</div>");
		
	 $( "#dialog" ).dialog("close"); 
	 
	$(document).on('click', '.getdiv', function() {
		$(this).closest('table').remove();
			
		});
	

	$(document).on('click','.getimg',function(){
		var id=$(this).closest('div').attr('id');
		$('#rightupper').empty();
		$('#'+id).clone().appendTo('#rightupper');
	});

	
	

	
}