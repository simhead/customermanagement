package io.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JinqJPAStreamProvider;

public class ManageCustomer {
	static EntityManager em;
	private static EntityManagerFactory entityManagerFactory;
	
	public ManageCustomer(EntityManager em) {
		this.em = em;
	}

	public static DBCustomer getDatabase(EntityManagerFactory entityManagerFactory, int customerId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		DBCustomer customer = null;
		try {
			customer = new ManageCustomer(em).go(customerId);
		} finally {
			em.close();
		}
		
		return customer;
	}
	
	public static void manageDatabase(EntityManagerFactory entityManagerFactory, int customerId, String firstname, String lastname,
			String address, int opcode) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			new ManageCustomer(em).go(customerId, firstname, lastname, address, opcode);
		} finally {
			em.close();
		}

	}

	void go(int customerId, String firstname, String lastname, String address, int opcode) {
		DBCustomer c = em.find(DBCustomer.class, customerId);
		
		em.getTransaction().begin();

		if (opcode == 1) { // update data
			c.setAddress(address);
			c.setFirstname(firstname);
			c.setLastname(lastname);
		} else if (opcode == 0) // remove data
			em.remove(c);
		
		em.getTransaction().commit();
	}

	DBCustomer go(int customerId) {
		return em.find(DBCustomer.class, customerId);
	}

	public static void main(String[] args) {
		// Configure Jinq for the given JPA database connection
		entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");

		int customerId = 12;
		// find data
		DBCustomer customer = ManageCustomer.getDatabase(entityManagerFactory, customerId);
		System.out.println(customer.getCustomerid()+" "+customer.getFirstname()+" "+customer.getLastname()+" "+customer.getAddress());
		
		// update data
		System.out.println("Updating customer");
		ManageCustomer.manageDatabase(entityManagerFactory, customerId, "changed firstname", "changed lastname", "changed address", 1);
		
		// check data
		customer = ManageCustomer.getDatabase(entityManagerFactory, customerId);
		System.out.println(customer.getCustomerid()+" "+customer.getFirstname()+" "+customer.getLastname()+" "+customer.getAddress());
		
		// delete data
		System.out.println("Deleting customer");
		ManageCustomer.manageDatabase(entityManagerFactory, customerId, null, null, null, 0);
	}

}
