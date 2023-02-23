package RestAssured01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class restAssured02 {
  @Test (enabled = false)
  public void Users() {
	  
			//given().get("http://localhost:3000/users").then().statusCode(200).body("first_name", hasItems("Meghna"));
			given().get("http://localhost:3000/users").then().statusCode(200).body("ID[1]", equalTo(8)).log().all();
		
  }
  
  @Test (enabled = false)
  public void JobRoles() {
	given().get("http://localhost:3000/JobRole").then().statusCode(200).log().all();
  }
	  
  @Test (enabled = true)
	public void put_User() {
		
		JSONObject js = new JSONObject();
		js.put("first_name", "ABDC");
		js.put("last_name", "EFG");
		js.put("ID", "10");
		given().body(js.toJSONString()).when().put("http://localhost:3000/users").then().statusCode(200).log().all();
	
	}
}
