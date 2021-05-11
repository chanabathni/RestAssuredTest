package Restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RAfirstproj {

	
	@Test
	public void firsttest()
	{
	Response resp= RestAssured.get("https://petstore.swagger.io/v2/pet/9222968140498478213");
	System.out.println("status code "+resp.statusCode());
	System.out.println("Res body \n"+resp.asString());
	System.out.println("status line-> "+resp.statusLine());
	System.out.println("Prettyformat of the code \n"+resp.prettyPrint());
	
	}
}
