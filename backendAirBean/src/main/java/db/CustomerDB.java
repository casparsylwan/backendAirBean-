package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Model.Customer;

public class CustomerDB {

	private EntityManagerFactory emf = EMF.emf;



	public Customer getByKey(String email){

		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();		
		Customer customer = em.find(Customer.class, email);       		

		em.close();

		return customer;
	}

	public void updateCustomer(Customer customer) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
		em.close();

	}

	public void saveCustomer(Customer customer) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(customer);      		
		em.getTransaction().commit();
		em.close();

	}

}
