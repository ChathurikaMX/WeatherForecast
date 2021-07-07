package com.weather.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.weather.Base.forecastBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class getForecast extends forecastBase{
	
	@BeforeClass
	void getTwoForecast() throws InterruptedException {
		
		logger.info("***********RestAPI Testing Started**********");
		
		RestAssured.baseURI = "https://api.weatherbit.io/v2.0/forecast/daily";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/postal_code=6148,2108&key=c08a234190f14c3ca4e5b80f6d27bd65");
		
		Thread.sleep(3);
	}
	
	@Test
	void checkResponsBody() {
		
		logger.info("*********Checking The Response Body**********");
		
		//This will verify if there is a response present
		String responseBody= response.getBody().asString();
		logger.info("Response Body---->"+ responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	void checkStatusCode() {
		

		logger.info("*********Checking The Status Code**********");
		
		//This method will verify the status code of the response
		int statusCode = response.getStatusCode();
		logger.info("The Status Code is--->"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	void verifyContentType() {
		

		logger.info("*********Checking The Content Type**********");
		
		//This method will verify the content type of the response
		String contentType = response.header("Content-Type");
		logger.info("The Content Type is---->"+contentType);
		Assert.assertEquals(contentType,"application/json");
		
	}
     
	
	
}
