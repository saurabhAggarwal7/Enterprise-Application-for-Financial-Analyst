package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v2")
public class IntrinioAPI_multiple {
	private static final String USERNAME = "xxxxxxxxxxxxx"; 
	private static final String PASSWORD = "xxxxxxxxxxxx"; 
	private static final Date TODAY = new Date();
	private static final SimpleDateFormat DT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@RequestMapping(value = "/intrinio/{value}", method = RequestMethod.GET)
    private  String doGet(@PathVariable String value) throws Exception {

		String startDt = DT_FORMAT.format(TODAY);
		System.out.println("TODAY is " + startDt);
		String basicUrl = "https://api.intrinio.com/";
		//String symbol = "AAPL";
		String symbol = value;
		String responseText=null;
		String singleDayUrl = basicUrl + "prices?identifier="+symbol+"&start_date=2017-10-15";
		String dataPointUrl = basicUrl + "data_point?ticker="+symbol+"&item=open_price,last_price,close_price" +
			",volume,pricetoearnings,name,ticker,security_name,market_sector" +
			",security_type,stock_exchange,short_description,long_description" +
			",ceo,company_url,business_address,mailing_address,business_phone_no" +
			",employees,sector,industry_category,industry_group,price_date,totalrevenue,percent_change" +
			",marketcap,dividend,basiceps,roe";
		String dataPointUrl_01 = basicUrl + "prices?identifier="+symbol+"&item=open_price,last_price,close_price" +
				",volume,pricetoearnings,name,ticker,security_name,market_sector" +
				",security_type,stock_exchange,short_description,long_description" +
				",ceo,company_url,business_address,mailing_address,business_phone_no" +
				",employees,sector,industry_category,industry_group,price_date,totalrevenue,percent_change" +
				",marketcap,dividend,basiceps,roe";
		HttpGet httpGet = new HttpGet(dataPointUrl_01);
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
		provider.setCredentials(AuthScope.ANY, credentials);
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		HttpResponse response = client.execute(httpGet);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("\nstatusCode is "+statusCode+"\n");
		HttpEntity httpEntity = response.getEntity();
		if (statusCode == HttpStatus.SC_OK) {
			 responseText = EntityUtils.toString(httpEntity);
			System.out.println(responseText+"\n\n");
			parseDataPointJson(responseText);
		} else System.out.println("\nOOPS! statusCode is "+statusCode+"\n");
		return responseText;
	} 

	private static void parseDataPointJson(String responseText) throws Exception {
		JSONObject jo = (JSONObject) new JSONParser().parse(responseText);
        JSONArray ja = (JSONArray) jo.get("data");
        Iterator itr2 = ja.iterator();
		JSONObject jsonObject;
		CommonStock stock = new CommonStock();
		while (itr2.hasNext()) {
			while(itr2.hasNext()){
				jsonObject = (JSONObject)itr2.next();
				//extractDataPointData(jsonObject,stock);
				
			}
        }
		
	}

	private static void extractDataPointData(JSONObject jsonObject, CommonStock stock) throws java.text.ParseException {
		String item = (String) jsonObject.get("item");
		
		Object value = jsonObject.get("value");
	 double val;
		switch (item) {
			case "ticker" :	stock.setSymbol((String)value);
			break;
			case "last_price" :	stock.setLast((Double)value);
			break;
			case "pricetoearnings" : stock.setPe((Double)value); 
			break;
			case "market_sector" : stock.setMarketSector((String)value); 
			break;
			case "security_type" : stock.setType((String)value); 
			break;
			case "stock_exchange" : stock.setExchange((String)value); 
			break;
			case "long_description" : stock.setBusiness((String)value);
			break;
			case "ceo" : stock.setCeo((String)value); 
			break;
			case "company_url" : stock.setUrl((String)value);
			break;
			case "business_address" : stock.setAddress((String)value); 
			break;
			case "business_phone_no" : stock.setPhone((String)value);
			break;
			case "employees" : stock.setEmployees((Long)value);
			break;
			case "sector" : stock.setSector((String)value); 
			break;
			case "industry_category" : stock.setIndustryCategory((String)value);
			break;
			case "industry_group" : stock.setIndustryGroup((String)value);
			break;
			case "price_date" : stock.setPriceDate(DT_FORMAT.parse((String)value)); 
			break;
			case "percent_change" : stock.setChange((Double)value); 
			break;
			case "marketcap" : stock.setMarketCap((Double)value);
			break;
			case "dividend" : stock.setDividend((Double)value); 
			break;
			case "basiceps" : stock.setEps((Double)value);
			break;
			case "roe" : stock.setRoe((Double)value); 
			break;
		}
	}

	private static void extractSingleDayData(JSONObject jsonObject) {
		Object date = jsonObject.get("date");
		System.out.println("Date : "+date+" "+date.getClass().getName());
		Object open = jsonObject.get("open");
		System.out.println("Open : "+open+" "+open.getClass().getName());
		Object high = jsonObject.get("high");
		System.out.println("High : "+high+" "+high.getClass().getName());
		Object low = jsonObject.get("low");
		System.out.println("Low : "+low+" "+low.getClass().getName());
		Object close = jsonObject.get("close");
		System.out.println("Close : "+close+" "+close.getClass().getName());
		Object volume = jsonObject.get("volume");
		System.out.println("Volume : "+volume+" "+volume.getClass().getName());
		
	}

   
}
