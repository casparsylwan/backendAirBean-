package Model;

import java.util.Date;

import javax.persistence.Embeddable;




@Embeddable
public class Order {
	
	Integer id;
	
	Integer sum;
	
	Date date = new Date();

}
// \"order\":[], \"orderHistory\":[{\"id\":\"#123456\", \"sum\": 443, \"date\":\"20/12/12\"}]}";