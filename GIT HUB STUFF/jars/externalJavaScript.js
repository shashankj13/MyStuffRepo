/**
 * 
 */

$(document).ready(function(){
	$('#add').click(function(){
		 $( "#dialog" ).dialog({
			 
			 height:380,
			 width:700
		 });
	});
});

function read(input){
	
	 if (input.files && input.files[0]) {
         var reader = new FileReader();

         reader.onload = function (e) {
             $('#image')
                 .attr('src', e.target.result)
                 .width(100)
                 .height(100);
         };

         reader.readAsDataURL(input.files[0]);
     }
	
}