package Restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class jsonfileusingobjects {
	
	@Test
	public void objects()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		HashMap<String,Object> json= new HashMap<String,Object>();
		json.put("stream", "bcom");
		json.put("firstname","jai");
		json.put("lastname", "prakash");
	
		given()
		.contentType(ContentType.JSON)
		 //.body(json.toString()())
		.post("/students").
		then()
		.statusCode(201)
		.log().all();
		
	}
}
		
		
		/*
		
		
Map<String,Object> jsonbody = new HashMap<String ,Object>();
        
        jsonbody.put("stream", "commerce");
        jsonbody.put("firstname", "aditya");
        jsonbody.put("lastname", "sharma");
        
        System.out.println(jsonbody);
        
        
        JSONObject request = new JSONObject();
        
        request.put("stream", "commerce");
        request.put("firstname", "aditya");
        request.put("lastname", "sharma");
        System.out.println(request);
        given()
            .contentType(ContentType.JSON)
            .body(request.toJSONString())
             .post("/students").
        then()
            .statusCode(201)
            .log().all();*/
