package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.*;
import io.restassured.response.Response;

//CRUD
public class UserEndPoints {
	public static Response createUser(User payload){
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
			.post(Routes.postUrl);
		
		return response;
	}
	
	public static Response readUser(String userName){
		Response response = given()
				.pathParam("username", userName)

				.when()
			.get(Routes.getUrl);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){
		Response response = given()
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
			.put(Routes.updateUrl);
		
		return response;
	}
	
	public static Response deleteUser(String userName){
		Response response = given()
				.pathParam("username", userName)

				.when()
			.delete(Routes.deleteUrl);
		
		return response;
	}
}
