package com.lov2code.hibernate.myproject1toMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Person;
import com.luv2code.hibernate.demo.entity.Subject;

public class UpdateProj {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Person.class)
										.addAnnotatedClass(Subject.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					
					int personId = 5;
					
					// now get a new session and start transaction
					
					session.beginTransaction();
					
					// retrieve student based on the id: primary key
					System.out.println("\n Getting student with id: " + personId);
					
					Person person = session.get(Person.class,personId );
					
					System.out.println("Updating student...");
					person.setName("Arunboss");
					person.setEmail("Arun@updated email");
					
					
					//Session update or else transaction will fail
					session.update(person);
					
					// commit the transaction
					session.getTransaction().commit();

					// NEW CODE				
//					// update email for all students
//					System.out.println("Update email for all persons");//					
					//session.createQuery("update person set email='foo@gmail.com'")
//						.executeUpdate();

					
					System.out.println("Done!");
				}
				finally {
					session.close();
					factory.close();
				}
	}
	
}
