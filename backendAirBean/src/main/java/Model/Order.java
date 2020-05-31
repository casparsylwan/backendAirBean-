package Model;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Order {
	
	Integer id;
	
	Integer sum;
	
	Date date = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
// \"order\":[], \"orderHistory\":[{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}]}";