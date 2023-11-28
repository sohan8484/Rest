package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	public Logger logger;
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().validSvSeSsn().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority =1)
	public void testPostUser() {
		logger.info("-----------------------post the user ----------------------");
		Response response = UserEndPoints.createUser(userPayload);
				response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
	}	
	@Test(priority = 2)
	public void testGetUserName() {
		logger.info("-------------------------get the user -----------------------");
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());	
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		}
	@Test(priority = 3)
	public void testUpdateUser() {
		logger.info("------------delet the user ----------------------");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
				response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
}
