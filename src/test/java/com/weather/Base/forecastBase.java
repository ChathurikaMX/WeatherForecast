package com.weather.Base;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class forecastBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("Weather Rest API");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	

}
