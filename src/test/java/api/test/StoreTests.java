package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	public Logger logger;
	Faker faker;
	Store userPayload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new Store();
		userPayload.setId(faker.idNumber().validSvSeSsn().hashCode());
		userPayload.setPetId(faker.number().numberBetween(1,	 10));
		userPayload.setComplete(false);
		userPayload.setQuantity(faker.number().numberBetween(0, 20));
		userPayload.setShipDate("2023-11-29T15:56:21.341Z");
		userPayload.setStatus("placed");
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority =1)
	public void testPlaceOrderPet() {
		logger.info("-----------------------post the Store api ----------------------");
		Response response = StoreEndPoints.PlaceOrderForPet(userPayload);
				response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 2)
	public void testPurchaseOrderId() {
		logger.info("-----------------------testPurchaseOrderId----------------------");	
		Response response = StoreEndPoints.getPurchaseOrderById(userPayload.getPetId());
		response.then().log().all();
	}
	@Test(priority = 3)
	public void testDeleteOrderId() {
		logger.info("-----------------------testDeleteOrderId----------------------");	
		Response response = StoreEndPoints.deletePurchaseOrderById(userPayload.getPetId());
		response.then().log().all();
	}	
	@Test
	public void testInventoryReturns() {
		logger.info("-----------------------testInventoryReturns----------------------");	
		Response response = StoreEndPoints.getInventoryReturns();
		response.then().log().all();
	}
	
}
