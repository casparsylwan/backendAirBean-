package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerController {
	
	private ObjectMapper om = new ObjectMapper();
	
	public String saveOrder( String orderJson) {
		
		return "{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}";
	}

}
