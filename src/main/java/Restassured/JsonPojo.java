package Restassured;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.postreq;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonPojo {

	
	@Test
	public void pojoclass() throws JsonProcessingException
	{
	RestAssured.baseURI="http://localhost:3000";
	postreq  pojoobj= new postreq();
		pojoobj.setFirstname("krishna");
		pojoobj.setLastname("varma");
		pojoobj.setStream("bcom");
		


ObjectMapper map= new ObjectMapper();
String abc= map.writerWithDefaultPrettyPrinter().writeValueAsString(pojoobj);
System.out.println(abc);/*

Response r;	
		r=*/ 
		given()
		.contentType(ContentType.JSON)
		.body(abc)
		 .post("/students").
		then()
		.statusCode(201)
		.log().all();
		
		//String val =r.jsonPath().getString("id");
		//System.out.println(val);
		//obj.setAttribute("id", val); 
	}
		
	//@Test
    public void secondtest(ITestContext obj)
    {
		
		RestAssured.baseURI="localhost:3000";
        System.out.println("In second test case " + obj.getAttribute("id").toString()); 
        
        
    }

	
	
}
