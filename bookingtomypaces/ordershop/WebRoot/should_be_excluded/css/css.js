$(function(){
	$('div.dclass_container_collapsible > div.dclass_container_header').click(function(){
			var content = $(this).siblings('.dclass_container_content');
			content.toggle();
			content.is(':hidden')?$(this).parent().addClass('dclass_container_collapse'): $(this).parent().removeClass('dclass_container_collapse');
		}	
	);
	$('table.dclass_data>tbody>tr:nth-child(even)').addClass("dclass_data_even");
	$('table.dclass_data>tbody>tr:nth-child(odd)').addClass("dclass_data_odd");
	$('table.dclass_data>tbody>tr').hover(
		function(){
			$(this).addClass("dclass_data_hover");
		},
		function(){
			$(this).removeClass("dclass_data_hover");
		});
});