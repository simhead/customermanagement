package io.db;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;

public class ListCustomers {

	private static EntityManagerFactory entityManagerFactory;
	private static JinqJPAStreamProvider streams;

	private static EntityManager em;

	// Helper accessor methods
	public static JinqStream<DBCustomer> customers(EntityManager jem, JinqJPAStreamProvider jstream) {
		return jstream.streamAll(jem, DBCustomer.class);
	}

	
	public static void main(String[] args) {
		
		// Configure Jinq for the given JPA database connection
		entityManagerFactory = Persistence.createEntityManagerFactory("JPATestDefault");
		em = entityManagerFactory.createEntityManager();
		streams = new JinqJPAStreamProvider(entityManagerFactory);

		// Configure Jinq to output the queries it executes
		streams.setHint("queryLogger", new JPAQueryLogger() {
			@Override
			public void logQuery(String query, Map<Integer, Object> positionParameters,
					Map<String, Object> namedParameters) {
				System.out.println("  " + query);
			}
		});
		System.out.println("*******************************************************");

		System.out.println("LIST OF CUSTOMERS");
		customers(em, streams)
				.forEach(c -> System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getAddress()));
		System.out.println("*******************************************************");

		// Simple ascending sort based on a customer name
		System.out.println("SORT CUSTOMERS BY NAME IN ASCENDING ORDER");
		customers(em, streams).sortedBy(c -> c.getFirstname())
				.forEach(c -> System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getAddress()));
		System.out.println("*******************************************************");

		// Simple descending sort based on a customer name
		System.out.println("SORT CUSTOMERS BY NAME IN DESCENDING ORDER");
		customers(em, streams).sortedDescendingBy(c -> c.getFirstname())
				.forEach(c -> System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getAddress()));
		System.out.println("*******************************************************");

		em.close();
	}

}
