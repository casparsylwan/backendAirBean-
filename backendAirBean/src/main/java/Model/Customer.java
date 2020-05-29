package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	Integer id;
	
	String name;
	
	List<String> order = new ArrayList<>();
	
	List<String> orderHistory = new ArrayList<>();
	
	String email;
	

	public Customer() {
		super();
	}

	public Customer(Integer id, String name, List order, List orderHistory, String email) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
		this.orderHistory = orderHistory;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getOrder() {
		return order;
	}

	public void setOrder(List order) {
		this.order = order;
	}

	public List getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List orderHistory) {
		this.orderHistory = orderHistory;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
