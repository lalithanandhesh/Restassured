package RestAssured01;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class restAssured01 {
	public String url = "https://reqres.in/api/users?page=2";
	
	@Test (enabled = false)
	public void LIST_USERS1() {
		Response rep = get(url);
		System.out.println(rep.statusCode());
		int statusCode= rep.statusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(rep.asString());
		System.out.println(rep.getBody());
		
		
	}
	
	@Test (enabled = false)
	public void LIST_USERS2() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get(url).then().statusCode(200).body("data.id",equalTo(0)).log().all();
	}

	@Test (enabled = false)
	public void SINGLE_USER() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id",equalTo(2)).log().all();
	}
	
	@Test (enabled = false)
	public void SINGLE_USER_NOT_FOUND() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get("https://reqres.in/api/users/23").then().statusCode(404);
	} 
	
	
	@Test (enabled = false)
	public void LIST_RESOURCE() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	} 
	
	@Test (enabled = false)
	public void SINGLE_RESOURCE() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get("https://reqres.in/api/unknown/2").then().statusCode(200).log().all();
	} 
	
	@Test (enabled = false)
	public void SINGLE_RESOURCE_NotFound() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();
	} 
	
	
	@Test (enabled = false)
	public void CREATE() {
		JSONObject js = new JSONObject();
		js.put("name", "Meghna Suresh");
		js.put("job", "Employee");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	
	@Test (enabled = false)
	public void UPDATE() {
		
		JSONObject js = new JSONObject();
		js.put("name", "Meghna Suresh");
		js.put("job", "CEO");
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	
	}
	
	@Test (enabled = true)
	public void PATCH() {
		JSONObject js = new JSONObject();
		js.put("name", "ABCD");
		js.put("job", "QA");
		given().body(js.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	} 
	
	@Test (enabled = false)
	public void DELETE() {
		
		given().when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	
	}
	
	@Test (enabled = false)
	public void REGISTER_SUCCESSFUL() {
		JSONObject js = new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
	} 
	
	
	@Test (enabled = false)
	public void DELAYED_RESPONSE() {
		//given().get(url).then().statusCode(200).body("data.first_name", hasItems("Meghna"));
		given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
	} 
	
}

