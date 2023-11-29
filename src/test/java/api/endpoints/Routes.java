package api.endpoints;

//maintain only the urls

	
public class Routes {
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	public static String postUrl = baseUrl+"/user";
	public static String getUrl = baseUrl+"/user/{username}";
	public static String updateUrl = baseUrl+"/user/{username}";
	public static String deleteUrl = baseUrl+"/user/{username}";
	
	
//	access petstore orders
	public static String storePostUrl = baseUrl+"/store/order";
	public static String storeGetUrl = baseUrl+"/store/order/{orderId}";
	public static String storeDeleteUrl = baseUrl+"/store/order/{orderId}";
	public static String storeInventoryGetUrl = baseUrl+"/store/inventory";
	
}
