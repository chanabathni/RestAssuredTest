package Restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Response {


	@Test
	public void Responsetest(){
	
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
				/*given().header("content-type","Application/JSON").param("status", "available")
				.get("/pet/findByStatus")
				.then().body("name",hasItems("doggie","test","fis"));*/
		
				given().header("content-type","Application/JSON").param("username", "ajay")
				.get("/user/ajay")
				.then().statusCode(200);
				
	}
	
	
}
