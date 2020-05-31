package backendAirBean;

import org.json.JSONException;
import org.json.JSONObject;

import Controller.CustomerController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/customer")
public class CustomerService {

	CustomerController cc = new CustomerController(); 


//	public CustomerService(CustomerController cc) {
//
//		this.cc = cc;
//	}

//	public CustomerService() {
//
//		this.cc = new CustomerController();
//	}



	@GET
	@Path("/all")
	@Produces("application/json")
	public String getAllCustomers() {

		String allCustomers = "{\"id\":1, \"name\":\"caspar Sylwan\", \"email\":\"casparsylwan@gmail.com \", \"order\":[], \"orderHistory\":[{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}]}";
		JSONObject jsonObject = null;
		try {
		     jsonObject = new JSONObject(allCustomers);
		     
		}catch (JSONException err){
		     
		}

		return allCustomers;
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerById(@PathParam("id") Integer id) {

		String customerJson = "cc.getCustomersById(id)";

		return customerJson;
	}

	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerByName(@PathParam("name") String name) {

		String customerJson = "cc.getCustomersByName(name)";

		return customerJson;
	}

	@GET
	@Path("/char")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerByCharInName() {

		String allCustomers = "cc.getAllCustomers()";
		System.out.println(allCustomers);
		return allCustomers;
	}

	@GET
	@Path("/char/{char}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerByCharInName(@PathParam("char") String name) {

		String customerJson = "cc.getCustomersByNameThatHaveChar(name)";

		return customerJson;
	}

	@PUT
	@Path("/updateid/{id}")
	@Produces("application/json")
	public String updateCustomer(@PathParam("id") Integer id, String customerJson) {

//		"cc.updateCustomer(customerJson, id)";
		return "customerJson";
	}
	
	
	@POST
	@Path("/order/new")
	@Produces("application/json")
	public String setNewOrder(String customerJson ) {
		
		cc.setNewOrder(customerJson);
		return "{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/10\"}";
	}

	@POST
	@Path("/new")
	@Produces("application/json")
	public String saveNewCustomer(String customerJson ) {
		
		System.out.println(customerJson);
		String customerStr = cc.saveCustomer(customerJson);
		return customerStr;
				//"{\"id\":1, \"name\":\"caspar Sylwan\", \"email\":\"casparsylwan@gmail.com \", \"order\":[], \"orderHistory\":[{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}]}"; //customerJson;//  "{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}";
				//"{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}";
	}
	
	@POST
	@Path("/login")
	@Produces("application/json")
	public String login(String customerJson ) {
		
		String customerJ = cc.getCustomer( customerJson );
		
		return customerJ;
				//"{\"id\":1, \"name\":\"caspar Sylwan\", \"email\":\"casparsylwan@gmail.com \", \"order\":[], \"orderHistory\":[{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}]}"; //customerJson;//  "{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}";
	}
	
	
	
//	@GET
//	@Path("/order")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String orders() {
//		
//		return new OrderService().getAllOrders();
//	}

//	@Path("{id}/order")
//	public OrderService orders(@PathParam("id") Integer id) {
//		
//		return new OrderService(id);
//	}

}
