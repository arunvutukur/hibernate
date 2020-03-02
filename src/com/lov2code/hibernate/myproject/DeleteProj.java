package com.lov2code.hibernate.myproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Person;
import com.luv2code.hibernate.demo.entity.Subject;

public class DeleteProj {
	
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
				
				// start a transaction
				session.beginTransaction();

				// get instructor by primary key / id
				int theId = 7;
				Person person = 
						session.get(Person.class, theId);
				
				System.out.println("Found instructor: " + person);
				
				// delete the instructors
				if (person != null) {
				
					System.out.println("Deleting: " + person);
					
					// Note: will ALSO delete associated "details" object
					// because of CascadeType.ALL
					//
					session.delete(person);				
				}
				
				// commit transaction
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
		}
}


