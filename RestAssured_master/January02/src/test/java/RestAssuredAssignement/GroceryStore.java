package RestAssuredAssignement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GroceryStore {

	  @Test (enabled = false)
		public void get_Status() {
			
			given().get("https://simple-grocery-store-api.glitch.me/status").then().statusCode(200).log().all();
		}
	  
	  @Test (enabled = false)
		public void get_all() {
			
			given().get("https://simple-grocery-store-api.glitch.me/products").then().statusCode(200).log().all();
		}
	  

	  @Test (enabled = false)
		public void single_Prodcut() {
			
			given().get("https://simple-grocery-store-api.glitch.me/products/4643").then().statusCode(200).log().all();
		}
	  
	  @Test (enabled = false)
			public void create_cart() {
			given().post("https://simple-grocery-store-api.glitch.me/carts").then().statusCode(201).log().all();
		}
	  
	  @Test (enabled = false)
		public void get_cart() {
		given().get("https://simple-grocery-store-api.glitch.me/carts/09YFPgLVlFg8JUNdU3cvw").then().statusCode(200).log().all();
	}
	  
	  @Test (enabled = true)
			public void Add_to_cart() {
		  JSONObject js = new JSONObject();
			js.put("productId","4643");
			given().body(js.toJSONString()).when().post("https://simple-grocery-store-api.glitch.me/carts/09YFPgLVlFg8JUNdU3cvw/items").then().log().all();
	}

	  @Test (enabled = false)
		public void get_cart_items() {
		given().get("https://simple-grocery-store-api.glitch.me/carts/wRaYBA0FQMy9zGjp2r4S-/items").then().statusCode(200).log().all();
	}
	  
	  
	  @Test (enabled = false)
		public void update_quantity() {
		  JSONObject js = new JSONObject();
		  
			js.put("quantity", "2");
		  
			given().body(js.toJSONString()).when().patch("https://simple-grocery-store-api.glitch.me/carts/wRaYBA0FQMy9zGjp2r4S-/items/4643").then().statusCode(201).log().all();
		} 
	  
	  
	  
	  
	  
	  
	  
  }

