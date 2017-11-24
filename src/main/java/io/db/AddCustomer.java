package io.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JinqJPAStreamProvider;

public class AddCustomer {
	static EntityManager em;
	private static EntityManagerFactory entityManagerFactory;
	private static JinqJPAStreamProvider streams;

	public AddCustomer(EntityManager em) {
		this.em = em;
	}

	private DBCustomer createCustomer(String firstname, String lastname, String address) {
		DBCustomer c = new DBCustomer();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setAddress(address);
		return c;
	}

	public static void createDatabase(EntityManagerFactory entityManagerFactory, String firstname, String lastname,
			String address) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			new AddCustomer(em).go(firstname, lastname, address);
		} finally {
			em.close();
		}

	}

	void go(String firstname, String lastname, String address) {
		em.getTransaction().begin();

		DBCustomer c = createCustomer(firstname, lastname, address);

		em.persist(c);
		em.flush();

		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		// Configure Jinq for the given JPA database connection
		entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");

		// create sample data
		AddCustomer.createDatabase(entityManagerFactory, "test12 firstname", "test12 lastname", "test12 address");
	}

}
