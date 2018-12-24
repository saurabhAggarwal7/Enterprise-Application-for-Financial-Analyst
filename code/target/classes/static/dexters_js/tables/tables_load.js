$(document).ready(function () {
	fire_ajax_graph("AAPL");
	
	$("#stock_drop").change(function(){
	     var stock_code = this.value;
		 
		 //
	     fire_ajax_graph(stock_code);
		 
		 //be default in document ready ajax call will fire with apple stock
	  });
});


function fire_ajax_graph(stock) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/v1/intrinio/" + stock,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	on_success_chart(data);
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}

function on_success_chart(data){
    var json = "<h4>Ajax Response</h4><pre>"
        + JSON.stringify(data, null, 4) + "</pre>";
    $('#feedback').html(json);
    console.log("SUCCESS : ", data);
    //plot_charts(data);
    tables_01(data);
    tables_02(data);
    tables_03(data);
}

function tables_01(data){
	/*for(var i=0; i< data.data.length; i++){
	var newItem = "<tr><td>" + i + "</td></tr>"; 
	$("#table_01 tr:last").after(newItem);
	}*/
	for(var i=0; i< 6; i++){
	var newItem = "<tr><td>" + i + "</td></tr>"; 
	$('#table_01').append('<tr><td>' + data.data[i].date + '</td><td>' + data.data[i].high + '</td><td>' + data.data[i].low + '</td><td>' + data.data[i].open + '</td><td>' + data.data[i].close + '</td></tr>');
	}
}

function tables_02(data){
	/*for(var i=0; i< data.data.length; i++){
	var newItem = "<tr><td>" + i + "</td></tr>"; 
	$("#table_01 tr:last").after(newItem);
	}*/
	for(var i=0; i< 7; i++){
	var newItem = "<tr><td>" + i + "</td></tr>"; 
	$('#table_02').append('<tr><td>' + data.data[i].date + '</td><td>' + data.data[i].adj_low + '</td><td>' + data.data[i].adj_high + '</td><td>');
	}
}

function tables_03(data){
	/*for(var i=0; i< data.data.length; i++){
	var newItem = "<tr><td>" + i + "</td></tr>"; 
	$("#table_01 tr:last").after(newItem);
	}*/
	for(var i=0; i< 30; i++){
	var newItem = "<tr><td>" + i + "</td></tr>"; 
	$('#table_03').append('<tr><td>' + data.data[i].date + '</td><td>' + data.data[i].volume + '</td><td>' + data.data[i].open + '</td><td>' + data.data[i].close + '</td><td>'+ data.data[i].ex_dividend + '</td><td>'+ data.data[i].split_ratio + '</td><td>'+ data.data[i].adj_factor + '</td><td>'+ data.data[i].high + '</td>');
	}
}

function get_ajax_data_adj_high(data){
	var ajax_data =[];
    var tzOffset = 8*60*60*1000;
    var data_loop = data;
    for(var i=0; i< data_loop.data.length; i++){
    	var data_index = data.data[i];
    	var data_date = data_index.date;
    	var data_close = data_index.adj_high;
    	ajax_data.push([(new Date(data_date).getTime()-tzOffset), data_close]);
    }
    return ajax_data;
}

