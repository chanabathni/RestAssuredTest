package test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Testcase2 {

	
	@Test
	public void second() throws IOException 
	{
		
		FileInputStream fis = new FileInputStream(".\\Json\\calcmul.xml"); 
		RestAssured.baseURI="http://www.dneonline.com";
        Response resp =
		given()
		.headers("content-type","text/xml") 
		.body(IOUtils.toString(fis,"UTF8"))
		.post("/calculator.asmx")
		.then().statusCode(200)
		.log().all().extract().response();
        
        
        XmlPath obj=new XmlPath(resp.asString());
        System.out.println("the response of Multiplication request is " +obj.getString("MultiplyResult"));
   
	
	
}
}
