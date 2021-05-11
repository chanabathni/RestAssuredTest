package Restassured;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Itest {
	@Test()
    public void method(ITestContext obj)
    {
        
        RestAssured.baseURI="http://localhost:3000";
        JSONObject jsonobj = new JSONObject(); //main body object
        jsonobj.put("stream", "commerce");
        jsonobj.put("firstname", "amit");
        jsonobj.put("lastname", "luthra");
        
        //System.out.println(jsonobj);
        Response responseobject = 
             given()
                	.contentType(ContentType.JSON)
                	.body(jsonobj)
                	.post("/students").
              then()
                	.statusCode(201)
                	.log().all().extract().response();
        
        String val = responseobject.jsonPath().getString("id");
        System.out.println(val);
        obj.setAttribute("id", val);  // i am saving the value
        
    }
    
    
    @Test
    public void secondtest(ITestContext obj)
    {
        
        System.out.println("In second test case " + obj.getAttribute("id"));  // printing the value with the help of Key
        
        
    }

}
