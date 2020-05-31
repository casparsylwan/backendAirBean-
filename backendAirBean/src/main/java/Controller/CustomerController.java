package Controller;

import java.util.HashMap;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Customer;
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

}
