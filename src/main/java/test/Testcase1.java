package test;
	import static io.restassured.RestAssured.given;
	import io.restassured.path.xml.XmlPath;
	import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;

	import org.json.simple.JSONObject;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import util.datadrivenfromexcel;

	public class Testcase1 {
		
	@Test(dataProvider= "PostRequestdata")
	public void method(String name1,String name2,String name3)
	    {
	        JSONObject jsonobj = new JSONObject();      
	        jsonobj.put("stream", name1);
	        jsonobj.put("firstname",name2);
	        jsonobj.put("lastname", name3);
	        
	        RestAssured.baseURI="http://localhost:3000";
	        Response r=
	        		given()
	        			.contentType(ContentType.JSON)
	        			.body(jsonobj.toJSONString())
	        			.post("/students").
	        		then()
	        			.statusCode(201)
	        			.log().all().extract().response(); 
	    }
	       
	     @DataProvider(name ="PostRequestdata")
	     public Object[][] postrequestdata() throws IOException{
	    	 Object[][] data= datadrivenfromexcel.gettestdata();
	    	 return data;
	    	
	    			
	    
	     } 		
	}
