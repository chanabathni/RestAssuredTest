package Restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class Jsonfilecreation {

	@Test(enabled=false)
	public void get()
	{
		RestAssured.baseURI="http://localhost:3000/";
		given()
		.get("/students")
		.then().statusCode(200)
		.log().all();
	}
	
	
	/*@Test
	public void post()
	{
		RestAssured.baseURI="http://localhost:3000/";
		String jsonbody= "{\"id\":5,\"stream\":\"humanities\",\"firstname\":\"vijay\",\"chauhan\":\"sharma\"}";
		given()
		.contentType(ContentType.JSON)
		.body(jsonbody)
		.post("/details").
		then()
		.statusCode(201)
		.log().all();
	}*/
	
	@Test(enabled=false)
	public void Postmethod()
	{
		
		RestAssured.baseURI="http://localhost:3000";
		
		String jsonbody = "{\"id\":7,\"stream\":\"science\",\"firstname\":\"priya\",\"lastname\":\"jain\"}";

		given()
			.contentType(ContentType.JSON)
			.body(jsonbody)
		 	.post("/students").
		then()
		    .statusCode(201)
		    .log().all();
	}

	@Test(enabled=false)
	public void Put()
	{
		
		RestAssured.baseURI="http://localhost:3000";
		
		String jsonbody = "{\"id\":3,\"stream\":\"science\",\"firstname\":\"ajay\",\"lastname\":\"kumar\"}";

		given()
			.contentType(ContentType.JSON)
			.body(jsonbody)
		 	.put("/students/3").
		then()
		    .statusCode(200)
		    .log().all();
	}

	@Test(enabled=false)
	public void Patch()
	{
		
		RestAssured.baseURI="http://localhost:3000";
		
		String jsonbody = "{\"firstname\":\"ramu\"}";

		given()
			.contentType(ContentType.JSON)
			.body(jsonbody)
		 	.patch("/students/7").
		then()
		    .statusCode(200)
		    .log().all();
	}
	
	@Test(enabled=false)
	public void delete()
	{
		
		RestAssured.baseURI="http://localhost:3000";

		given()
			.contentType(ContentType.JSON)
		 	.delete("/students/4").
		then()
		    .statusCode(200)
		    .log().all();
	}
	
	

	
	
}
