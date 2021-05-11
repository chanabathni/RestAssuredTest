package Restassured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Datadriven {

	@Test(dataProvider= "PostRequestdata")
    public void method(String name1,String name2,String name3)
    {                 
        JSONObject jsonobj = new JSONObject(); //main body object        
        jsonobj.put("stream", name1);
        jsonobj.put("firstname",name2);
        jsonobj.put("lastname", name3);
        
        RestAssured.baseURI="http://localhost:3000";
        given()
        	.contentType(ContentType.JSON)
        	.body(jsonobj.toJSONString())
        	.post("/students").
         then()
         	.statusCode(201)
         	.log().all();
    }
               
    @DataProvider(name ="PostRequestdata")
    public Object[][] postrequestdata(){
    	 return new  Object[][]
    			 { {"ajay","kumar","ch"},{"vinay","kumar","goud"}};
     
     } 
        
	
	
	
}
