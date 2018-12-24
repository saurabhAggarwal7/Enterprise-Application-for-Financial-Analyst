var notes_lst;


$(document).ready(function() {

	load_notes();

	
	
	
	$(".l1").click(function(e){
		$("#values").html($(".l1").attr("notes"));
	});
	
	$(".l2").click(function(e){
		$("#values").html($(".l2").attr("notes"));
	});
	$(".l3").click(function(e){
		$("#values").html($(".l3").attr("notes"));
	});
	$(".l4").click(function(e){
		$("#values").html($(".l4").attr("notes"));
	});
	$(".l5").click(function(e){
		$("#values").html($(".l5").attr("notes"));
	});
	
});

function load_notes(){
	
	   $.ajax({
	        type: "GET",
	        contentType: "application/json",
	        url: "/v1/Getnotes",
	        dataType: 'json',
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
	        	 console.log(data);
	        	 success_notes(data);
	        	 notes_lst = data;
	        },
	        error: function (e) {

	            

	        }
	    });
		
	}

function success_notes(data){
	
	/*for(var i=0; i< data.length-1; i++){*/
		
	$("#n1").html(data[data.length-5].notes);
	$("#n2").html(data[data.length-4].notes);
	$("#n3").html(data[data.length-3].notes);
	$("#n4").html(data[data.length-2].notes);
	$("#n5").html(data[data.length-1].notes);
	
	$(".l1").attr("notes", data[data.length-5].notes)
	$(".l2").attr("notes", data[data.length-4].notes)
	$(".l3").attr("notes", data[data.length-3].notes)
	$(".l4").attr("notes", data[data.length-2].notes)
	$(".l5").attr("notes", data[data.length-1].notes)

	$("#values").html($(".l1").attr("notes"));
	
}


