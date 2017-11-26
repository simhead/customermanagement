package io.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	public static boolean manageDatabase(EntityManagerFactory entityManagerFactory, int customerId, String firstname, String lastname,
			String address, int opcode) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean isDeleted = false;
		
		try {
			isDeleted = new ManageCustomer(em).go(customerId, firstname, lastname, address, opcode);
		} finally {
			em.close();
		}
		
		return isDeleted;
	}

	boolean go(int customerId, String firstname, String lastname, String address, int opcode) {
		DBCustomer c = em.find(DBCustomer.class, customerId);
		
		em.getTransaction().begin();

		if (opcode == 1) { // update data
			c.setAddress(address);
			c.setFirstname(firstname);
			c.setLastname(lastname);
		} else if (opcode == 0) { // remove data 
			try {
				em.remove(c);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		em.getTransaction().commit();
		
		return false;
	}

	DBCustomer go(int customerId) {
		return em.find(DBCustomer.class, customerId);
	}

	public static void main(String[] args) {
		// Configure Jinq for the given JPA database connection
		entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");

		int customerId = 8;
		// find data
		/*DBCustomer customer = ManageCustomer.getDatabase(entityManagerFactory, Integer.parseInt(args[0]));
		System.out.println(customer.getCustomerid()+" "+customer.getFirstname()+" "+customer.getLastname()+" "+customer.getAddress());*/
		
		// update data
		/*System.out.println("Updating customer");
		ManageCustomer.manageDatabase(entityManagerFactory, customerId, "changed firstname", "changed lastname", "changed address", 1);
		
		// check data
		customer = ManageCustomer.getDatabase(entityManagerFactory, customerId);
		System.out.println(customer.getCustomerid()+" "+customer.getFirstname()+" "+customer.getLastname()+" "+customer.getAddress());*/
		
		// delete data
		System.out.println("Deleting customer");
		System.out.println("Is deleted customer:: "+ManageCustomer.manageDatabase(entityManagerFactory, customerId, null, null, null, 0));
	}

}
