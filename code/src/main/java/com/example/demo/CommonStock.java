package com.example.demo;

import java.util.Date;

public class CommonStock {
	private String symbol;
	private double open;
	private double last;
	private double close;
	private long volume;
	private double pe;
	private String name;
	private String ticker;
	private String securityName;
	private String marketSector;
	private String type;
	private String exchange;
	private String shortDesc;
	private String business;
	private String ceo;
	private String url;
	private String address;
	private String phone;
	private long employees;
	private String sector;
	private String industryCategory;
	private String industryGroup;
	private Date priceDate;
	private long revenue;
	private double change;
	private double marketCap;
	private double dividend;
	private double eps;
	private double roe;

	public String toString() { 
		return "\nCommonStock - \nSymbol : '" + this.symbol +
			"', \nQuote : " + this.last + ", \nP/E : " + this.pe + "" +
			"', \nVolume : " + this.volume + "" +
			"', \nMarket Sector : '" + this.marketSector + "'" +
			"', \nType : '" + this.type + "'" +
			"', \nExchange : '" + this.exchange + "'" +
			"', \nBusiness : '" + this.business + "'" +
			"', \nCeo : '" + this.ceo + "'" +
			"', \nUrl : '" + this.url + "'" +
			"', \nAddress : '" + this.address + "'" +
			"', \nPhone : " + this.phone + "" +
			"', \nEmployees # : " + this.employees + "" +
			"', \nSector : '" + this.sector + "'" +
			"', \nIndustry Category : '" + this.industryCategory + "'" +
			"', \nIndustry Group : '" + this.industryGroup + "'" +
			"', \nQuote Date : " + this.priceDate + "" +
			"', \nChange : " + this.change + "" +
			", \nMarket Cap : " + this.marketCap + "" +
			", \nDividend : " + this.dividend + "" +
			", \nEPS : " + this.eps + "" +
			", \nROE : " + this.roe + "";
	} 

	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { 	this.symbol = symbol; }

	public double getOpen() { return open; }
	public void setOpen(double open) { this.open = open; }

	public double getLast() { return last; }
	public void setLast(double last) { this.last = last; }

	public double getClose() { return close; }
	public void setClose(double close) { this.close = close; }

	public long getVolume() { return volume; }
	public void setVolume(long volume) { this.volume = volume; }

	public double getPe() { return pe; }
	public void setPe(double pe) { this.pe = pe; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getTicker() { return ticker; }
	public void setTicker(String ticker) { this.ticker = ticker; }

	public String getSecurityName() { return securityName; }
	public void setSecurityName(String securityName) { this.securityName = securityName; }

	public String getMarketSector() { return marketSector; }
	public void setMarketSector(String marketSector) { this.marketSector = marketSector; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	public String getExchange() { return exchange; }
	public void setExchange(String exchange) { this.exchange = exchange; }

	public String getShortDesc() { return shortDesc; }
	public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

	public String getBusiness() { return business; }
	public void setBusiness(String business) { this.business = business; }

	public String getCeo() { return ceo; }
	public void setCeo(String ceo) { this.ceo = ceo; }

	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public long getEmployees() { return employees; }
	public void setEmployees(long employees) { this.employees = employees; }

	public String getSector() { return sector; }
	public void setSector(String sector) { this.sector = sector; }

	public String getIndustryCategory() { return industryCategory; }
	public void setIndustryCategory(String industryCategory) { this.industryCategory = industryCategory; }

	public String getIndustryGroup() { return industryGroup; }
	public void setIndustryGroup(String industryGroup) { this.industryGroup = industryGroup; }

	public Date getPriceDate() { return priceDate; }
	public void setPriceDate(Date priceDate) { this.priceDate = priceDate; }

	public long getRevenue() { return revenue; }
	public void setRevenue(long revenue) { this.revenue = revenue; }

	public double getChange() { return change; }
	public void setChange(double change) { this.change = change; }

	public double getMarketCap() { return marketCap; }
	public void setMarketCap(double marketCap) { this.marketCap = marketCap; }

	public double getDividend() { return dividend; }
	public void setDividend(double dividend) { this.dividend = dividend; }

	public double getEps() { return eps; }
	public void setEps(double eps) { this.eps = eps; }

	public double getRoe() { return roe; }
	public void setRoe(double roe) { this.roe = roe; }
}


