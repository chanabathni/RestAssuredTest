package Restassured;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Jsonobject {

	
	@Test(enabled= false)
	public void json(){
		RestAssured.baseURI="https://localhost:3000";
		JSONObject  jsonobj= new JSONObject();
		JSONObject category= new JSONObject();
		JSONObject tags= new JSONObject();
		
		
		jsonobj.put("id",0);
		jsonobj.put("name","ajay");
		jsonobj.put("status","approved");
		category.put("id",0);
		category.put("name", "samsung");
		jsonobj.put("category",category);
		tags.put("id",0);
		tags.put("name", "sony");
		jsonobj.put("tags",tags);
		JSONArray array1= new JSONArray();   //jsonarray
		array1.add("vijay");
		array1.add("kumar");
		jsonobj.put("PhotoUrls",array1);
		
		
		System.out.println(jsonobj);
		
	}
		
		@Test
		public void JsonResponse()
		{
			RestAssured.baseURI="https://localhost:3000";
			JSONObject  jsonobj= new JSONObject();
			
						
			jsonobj.put("Stream","commerce");
			jsonobj.put("firstname","ajay");
			jsonobj.put("lastname","kumar");
		Response obj ;
		
	
			 obj = given().contentType(ContentType.JSON)
			.body(jsonobj)
			.post("/students")
			.then()
			.statusCode(201)
			.log().all().extract().response();
			
		
		//String val=responseobject
		
		

		}
			
			
		
	
	
	
	
	
	
	
}
