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
}
