package RestAssured01;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Trello {
	public String url = "https://trello.com";
	public String id;
	
  //@Test 
  public void Get_Board() {
	  String str ="/b/jDzsrryw/daily-routine";
		Response response =given().queryParam("key", "e7006a6922ff716f2858ff9182479886")
				.queryParam("token", "ATTAe3600ca1cc6ef64f55f467e9f1cca1925c2a516c5e12bfe7ec382952d1e51e32C5DB2F20")
				.header("Content-Type","application/json").when()
				.get("https://trello.com/"+str).then().extract().response();
		
		System.out.println(response.getBody());
  }
  
  @Test
  public void Create_Board() {
	  baseURI=url;
		Response response1 =given().queryParam("name","trello_demo1").queryParam("key", "e7006a6922ff716f2858ff9182479886")
				.queryParam("token", "ATTAe3600ca1cc6ef64f55f467e9f1cca1925c2a516c5e12bfe7ec382952d1e51e32C5DB2F20")
				.header("Content-Type","application/json").when()
				.post("/1/boards/").then().extract().response();
		
		JsonPath jp = new JsonPath(response1.asString());
		id = jp.get("id");
		System.out.println(id);
		System.out.println(response1);
  }
	
  
 // @Test
  public void Delete_Board() {	
	  baseURI =url;
		
	  Response response3=given().queryParam("key", "e7006a6922ff716f2858ff9182479886")
				.queryParam("token", "ATTAe3600ca1cc6ef64f55f467e9f1cca1925c2a516c5e12bfe7ec382952d1e51e32C5DB2F20")
				.header("content-Type","application/json").when().delete("/1/boards/"+id).then().extract().response();
		
		System.out.println(response3);
  }
  
  @Test
  public void Update_Board() {	
	  baseURI =url;
	// This code sample uses the  'Unirest' library:
	// http://unirest.io/java.html
	  Response response4 = given().queryParam("name","demo1_updated")
	  .queryParam("key", "e7006a6922ff716f2858ff9182479886")
	  .queryParam("token", "ATTAe3600ca1cc6ef64f55f467e9f1cca1925c2a516c5e12bfe7ec382952d1e51e32C5DB2F20")
	  .put("/1/boards/"+id).then().extract().response();
	  

	System.out.println(response4);
  }
	  
  
}
