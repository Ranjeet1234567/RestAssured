package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapXMLRequest {
	@Test
	public void validateSoapXML() throws IOException {
		File file=new File("./SoapRequest/Add.xml");
		if(file.exists())
		{
			System.out.println("......=>File exists");
		FileInputStream fileInputStream=new FileInputStream(file);
		String requestBody=IOUtils.toString(fileInputStream,"UTF-8");
		baseURI="http://dneonline.com";
		given()
		.contentType("text/xml").accept(ContentType.XML)
		.body(requestBody)
		.when().
		post("/calculator.asmx").
		then().statusCode(200).log().all()
		.and().
		body("//*:AddResult.text()",equalTo("7"));	
	}
	}
	public void validateCalcultor() throws IOException {
		File file=new File("./SoapRequest/Add.xml");
		if(file.exists())
		{
			System.out.println("......=>File exists");
		FileInputStream fileInputStream=new FileInputStream(file);
		String requestBody=IOUtils.toString(fileInputStream,"UTF-8");
		baseURI="http://dneonline.com";
		given()
		.contentType("text/xml").accept(ContentType.XML)
		.body(requestBody)
		.when().
		post("/calculator.asmx").
		then().statusCode(200).log().all()
		.and().
		body("//*:AddResult.text()",equalTo("7"));	
	}
	}

}
