/**
 * 
 */

$(document).ready(function() {
	$(function() {
		$("#tabs").tabs();
	});

	$(function() {
		$("#simpleTabs").tabs();
	});

	$(function() {

		// Better to construct options first and then pass it as a parameter
		var options = {
			exportEnabled : true,
			animationEnabled : true,
			title : {
				text : "Exporting Chart as Image"
			},
			data : [ {
				type : "splineArea", // change it to line, area, bar, pie,
				// etc
				dataPoints : [ {
					y : 10
				}, {
					y : 6
				}, {
					y : 14
				}, {
					y : 12
				}, {
					y : 19
				}, {
					y : 14
				}, {
					y : 26
				}, {
					y : 10
				}, {
					y : 22
				} ]
			} ]
		};

		$("#chartContainer").CanvasJSChart(options);

	});

	/*
	 * $( "input" ) .change(function() { var $input = $( this ); var value = [];
	 * value[value.length]=$input.attr( "class" ); alert(value); });
	 */

		

});
