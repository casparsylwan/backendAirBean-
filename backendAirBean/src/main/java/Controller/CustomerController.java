package Controller;

import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Customer;
import Model.Order;
import db.CustomerDB;




public class CustomerController {
	
	private ObjectMapper om = new ObjectMapper();
	private CustomerDB db = new CustomerDB();
	
	
	public String saveCustomer( String orderJson) {
		
		String name = new JSONObject(orderJson).getJSONObject("customer").getString("name");
		String email = new JSONObject(orderJson).getJSONObject("customer").getString("email");
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setActive(5);
		db.saveCustomer(customer);
		try {
			orderJson = om.writeValueAsString(customer);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return orderJson;
	}
	
	public String getCustomer( String customerJson ) {
		
		String email = new JSONObject(customerJson).getJSONObject("customer").getString("email");
		
		Customer customer = db.getByKey(email);
		try {
			customerJson = om.writeValueAsString(customer);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerJson;
	}
	
	public void setNewOrder(String customerJson) {
		
		JSONArray orderArray = new JSONObject(customerJson).getJSONObject("order").getJSONArray("order");
		String email = new JSONObject(customerJson).getJSONObject("order").getString("email");
		System.out.println(email);
		Customer customer = db.getByKey(email);
		Order orders = new Order();
		Integer sum = 0;
		
		for(int i = 0; i<orderArray.length(); i++) {
			
			JSONObject order = orderArray.getJSONObject(i);
			sum += order.getInt("price") * order.getInt("amount");
		
			
		}
		orders.setSum(sum);
		orders.setId(19043);
		orders.setDate(new Date());
		
		customer.getOrderHistory().add(orders);
		db.updateCustomer(customer);
		
	}

}
