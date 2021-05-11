package Restassured;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class payload {

	//@Test()
	public void first() throws IOException 
	{
		
		FileInputStream fis = new FileInputStream(".\\Json\\postpayload.json"); //from postpayload local drive
		RestAssured.baseURI="http://localhost:3000";
		given()
		.contentType(ContentType.JSON)
		.body(IOUtils.toString(fis,"UTF8"))
		.post("/students")
		.then().statusCode(201)
		.log().all();
	}
	
	
	
	
	@Test()
	public void second() throws IOException 
	{
		
		FileInputStream fis = new FileInputStream(".\\Json\\calc.xml"); //from  local drive
		RestAssured.baseURI="http://www.dneonline.com";
        Response resp =
		given()
		.headers("content-type","text/xml") 
		.body(IOUtils.toString(fis,"UTF8"))
		.post("/calculator.asmx")
		.then().statusCode(200)
		.log().all().extract().response();
        
        
        XmlPath obj=new XmlPath(resp.asString());
        System.out.println("the response of add request is " +obj.getString("AddResult"));
        
     String actualresult = obj.getString("AddResult");  
        Assert.assertEquals("11", actualresult);
      
        
        
        
	}
	
	
}
