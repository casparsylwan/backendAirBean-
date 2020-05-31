package db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

}
