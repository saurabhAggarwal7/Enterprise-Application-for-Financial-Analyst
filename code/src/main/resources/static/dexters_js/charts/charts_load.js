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
    plot_charts(data);
}

function plot_charts(data){
	/**
     * Flot charts data and options
     */

    var data1 = [ [0, 26], [1, 24], [2, 29], [3, 26], [4, 33], [5, 26], [6, 36], [7, 28] ];

    var chartUsersOptions = {
        series: {
            splines: {
                show: true,
                tension: 0.4,
                lineWidth: 1,
                fill: 0.5
            },
        },
        grid: {
            tickColor: "#e4e5e7",
            borderWidth: 1,
            borderColor: '#e4e5e7',
            color: '#6a6c6f'
        },
        colors: [ "#62cb31", "#efefef"],
    };

    $.plot($("#flot-line-chart"), [data1], chartUsersOptions);

    /**
     * Flot charts data and options
     */

    var data2 = [
        {
            label: "bar",
            data: [ [1, 12], [2, 14], [3, 18], [4, 24], [5, 32], [6, 22] ]
        }
    ];

    var chartUsersOptions2 = {
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
            tickDecimals: 0
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

    //$.plot($("#flot-bar-chart"), data2, chartUsersOptions2);
    
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
    $.plot($("#flot-bar-chart"), [ajax_data], chartUsersOptions2_ajax );
    
    /*var data_01 = [];
    var tzOffset = 8*60*60*1000;
    data_01.push([(new Date("2012/02/20").getTime()-tzOffset), 1]);
    data_01.push([(new Date("2012/02/19").getTime()-tzOffset), 0]);
    data_01.push([(new Date("2012/02/18").getTime()-tzOffset), 3]);*/
    
    /*$.plot($("#flot-bar-chart"), [ajax_data], {
        bars: { 
            show: true, 
            barWidth: 18*60*60*1000 ,
            align: 'center'    },
        xaxis: {
            mode: "time",
            minTickSize: [1, "day"]    },
        yaxis: {
            min: 0
        }
    });*/
    

    var data3 = [
        { label: "Data 1", data: 16, color: "#84c465", },
        { label: "Data 2", data: 6, color: "#8dd76a", },
        { label: "Data 3", data: 22, color: "#a2c98f", },
        { label: "Data 4", data: 32, color: "#c7eeb4", }
    ];

    var chartUsersOptions3 = {
        series: {
            pie: {
                show: true
            }
        },
        grid: {
            hoverable: true
        },
        tooltip: true,
        tooltipOpts: {
            content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
            shifts: {
                x: 20,
                y: 0
            },
            defaultTheme: false
        }
    };

    //$.plot($("#flot-pie-chart"), data3, chartUsersOptions3);

    
    
    //working chart
    var data4 = [
        {
            label: "line",
            data: [ [1, 24], [2, 15], [3, 29], [4, 34], [5, 30], [6, 40], [7, 23], [8, 27], [9, 40] ]
        }
    ];
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

    $.plot($("#flot-area-chart"), data4, chartUsersOptions4);


    var sin = [],
            cos = [];
    for (var i = 0; i < 14; i += 0.5) {
        sin.push([i, Math.sin(i)]);
        cos.push([i, Math.cos(i)]);
    }

    var data5 = [
        { data: sin, label: "sin(x)"},
        { data: cos, label: "cos(x)"}
    ];
    
    var data5 = [
        { data: get_ajax_data_adj_low(data), label: "adj_low"},
        { data: get_ajax_data_adj_high(data), label: "adj_high"}
    ];

    var chartUsersOptions5 = {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                grid: {
                    tickColor: "#e4e5e7",
                    borderWidth: 1,
                    borderColor: '#e4e5e7',
                    color: '#6a6c6f'
                },
                xaxis: {
                	mode: "time",
                    minTickSize: [1, "day"]    },
                yaxis: {
                    min: 0
                },
                colors: [ "#62cb31", "#efefef"],
            }
            ;

    $.plot($("#flot-sin-chart"), data5, chartUsersOptions5);
    
    
    
    
}

function get_ajax_data(){
	var ajax_data =[];
    var tzOffset = 8*60*60*1000;
    var data_loop = data;
    for(var i=0; i< data_loop.data.length; i++){
    	var data_index = data.data[i];
    	var data_date = data_index.date;
    	var data_close = data_index.close;
    	ajax_data.push([(new Date(data_date).getTime()-tzOffset), data_close]);
    }
    return ajax_data;
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

function get_ajax_data_adj_low(data){
	var ajax_data =[];
    var tzOffset = 8*60*60*1000;
    var data_loop = data;
    for(var i=0; i< data_loop.data.length; i++){
    	var data_index = data.data[i];
    	var data_date = data_index.date;
    	var data_close = data_index.adj_low;
    	ajax_data.push([(new Date(data_date).getTime()-tzOffset), data_close]);
    }
    return ajax_data;
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

