

$(document).ready(function () {
	fire_ajax_graph("AAPL");
	
	$("#stock_drop").change(function(){
	     var stock_code = this.value;
		 
		 //
	     fire_ajax_graph(stock_code);
		 
		 //be default in document ready ajax call will fire with apple stock
	  });
});


function fire_ajax_graph(stock_code) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/v1/intrinio/" + stock_code,
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
    
    
    
    
    var close = data.data[0].close;
	$("#dash_val01").html(close);
    
	var date = data.data[0].date;
	$("#dash_val02").html(date);
	
	var volume = data.data[0].volume;
	$("#dash_val03").html(volume);
	
	var low = data.data[0].low;
	$("#dash_val04").html(low);
	
	var high = data.data[0].high;
	$("#dash_val05").html(high);
	
	var adj_high = data.data[0].adj_high;
	$("#dash_val051").html(adj_high);
	
	
	var ex_dividend = data.data[0].ex_dividend;
	$("#dash_val06").html(ex_dividend);
	
	var split_ratio = data.data[0].split_ratio;
	$("#dash_val07").html(split_ratio);
	
	var adj_low = data.data[0].adj_low;
	$("#dash_val071").html(adj_low);
	
	
	var data4 = get_ajax_data_cap(data);
	var chartUsersOptions4 = {
	        series: {
	            lines: {
	                show: true,
	                lineWidth: 1,
	                fill: true,
	                fillColor: {
	                    colors: [ { opacity: 0.5 }, { opacity: 0.5 }
	                    ]
	                }
	            }
	        },
	        xaxis: {
	        	mode: "time",
	            minTickSize: [1, "day"]    },
	        yaxis: {
	            min: 0
	        },
	        colors: ["#62cb31"],
	        grid: {
	            tickColor: "#e4e5e7",
	            borderWidth: 1,
	            borderColor: '#e4e5e7',
	            color: '#6a6c6f'
	        },
	        legend: {
	            show: false
	        },
	        tooltip: true,
	        tooltipOpts: {
	            content: "x: %x, y: %y"
	        }
	    };

	    $.plot($("#flot-area-chart-dash"), data4, chartUsersOptions4);
	    
	    var data41 = get_ajax_data_cap_41(data);
		var chartUsersOptions41 = {
		        series: {
		            lines: {
		                show: true,
		                lineWidth: 1,
		                fill: true,
		                fillColor: {
		                    colors: [ { opacity: 0.5 }, { opacity: 0.5 }
		                    ]
		                }
		            }
		        },
		        xaxis: {
		        	mode: "time",
		            minTickSize: [1, "day"]    },
		        yaxis: {
		            min: 0
		        },
		        colors: ["#62cb31"],
		        grid: {
		            tickColor: "#e4e5e7",
		            borderWidth: 1,
		            borderColor: '#e4e5e7',
		            color: '#6a6c6f'
		        },
		        legend: {
		            show: false
		        },
		        tooltip: true,
		        tooltipOpts: {
		            content: "x: %x, y: %y"
		        }
		    };

		    $.plot($("#flot-income-chart-01"), data41, chartUsersOptions41);
		    
		    
		    
		    var ajax_data =[];
		    var tzOffset = 8*60*60*1000;
		    var data_loop = data;
		    for(var i=0; i< data_loop.data.length; i++){
		    	var data_index = data.data[i];
		    	var data_date = data_index.date;
		    	var data_close = data_index.close;
		    	ajax_data.push([(new Date(data_date).getTime()-tzOffset), data_close]);
		    }
		    var chartUsersOptions2_ajax = {
		            series: {
		                bars: {
		                    show: true,
		                    barWidth: 0.8,
		                    fill: true,
		                    fillColor: {
		                        colors: [ { opacity: 0.6 }, { opacity: 0.6 } ]
		                    },
		                    lineWidth: 1
		                }
		            },
		            xaxis: {
		            	mode: "time",
		                minTickSize: [1, "day"]    },
		            yaxis: {
		                min: 0
		            },
		            colors: ["#62cb31"],
		            grid: {
		                color: "#e4e5e7",
		                hoverable: true,
		                clickable: true,
		                tickColor: "#D4D4D4",
		                borderWidth: 0,
		                borderColor: 'e4e5e7',
		            },
		            legend: {
		                show: false
		            },
		            tooltip: true,
		            tooltipOpts: {
		                content: "x: %x, y: %y"
		            }
		        };
		    $.plot($("#flot-bar-chart-91"), [ajax_data], chartUsersOptions2_ajax );
	    
	
}

function get_ajax_data_cap(data){
	var ajax_data =[];
    var tzOffset = 8*60*60*1000;
    var data_loop = data;
    for(var i=0; i< data_loop.data.length; i++){
    	var data_index = data.data[i];
    	var data_date = data_index.date;
    	var data_close = data_index.volume;
    	ajax_data.push([(new Date(data_date).getTime()-tzOffset), data_close]);
    }
    return [ajax_data];
}

function get_ajax_data_cap_41(data){
	var ajax_data =[];
    var tzOffset = 8*60*60*1000;
    var data_loop = data;
    for(var i=0; i< data_loop.data.length; i++){
    	var data_index = data.data[i];
    	var data_date = data_index.date;
    	var data_close = data_index.high;
    	ajax_data.push([(new Date(data_date).getTime()-tzOffset), data_close]);
    }
    return [ajax_data];
}

function tables_01(data){
	
}

function tables_02(data){
	
}

function tables_03(data){
	
}


