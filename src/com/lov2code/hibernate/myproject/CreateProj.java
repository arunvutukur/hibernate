package com.lov2code.hibernate.myproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.myproject.entity.Person;
import com.lov2code.hibernate.myproject.entity.Subject;


public class CreateProj {

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
					
					// create the objects					
					Person person = new Person(12 ,"Arun123","next@gmail.com");		
					Subject subject =new Subject("wish127","wow!!");
					
					person.setSubject(subject);
	
					session.beginTransaction();
					
					// save the instructor
					//
					// Note: this will ALSO save the details object
					// because of CascadeType.ALL
					//
					System.out.println("Saving person: " + person);
					session.save(person);					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}	

	}
	
	

