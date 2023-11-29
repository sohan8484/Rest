package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response PlaceOrderForPet(Store payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.storePostUrl);
		return response;
	}
	
	public static Response getPurchaseOrderById(int orderId){
		Response response = given()
				.pathParam("orderId", orderId)

				.when()
			.get(Routes.storeGetUrl);
		
		return response;
	}
	
	public static Response deletePurchaseOrderById(int orderId){
		Response response = given()
				.pathParam("orderId", orderId)

				.when()
			.get(Routes.storeDeleteUrl);
		
		return response;
	}
	
	public static Response getInventoryReturns(){
		Response response = given()

				.when()
			.get(Routes.storeInventoryGetUrl);
		
		return response;
	}
	
}
