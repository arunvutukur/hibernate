package com.lov2code.hibernate.myproject1toMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.myproject1toMany.entity.Person;
import com.lov2code.hibernate.myproject1toMany.entity.Subject;




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
					session.beginTransaction();
					
					// create the objects					
					Person person = new Person(15,"below","asdasd");	
					
					person.addSubject(new Subject("yellow1","demo"));
					person.addSubject(new Subject("yellow2","demo"));
					person.addSubject(new Subject("yellow3","demo"));
					person.addSubject(new Subject("yellow4","demo"));
					//Subject subject =new Subject("wish12!@#","demo2");
					
					System.out.println(person);
					//person.addSubject(subject);
							
					// start a transaction
					//session.beginTransaction();
					
					// save the instructor
					//
					// Note: this will ALSO save the details object
					// because of CascadeType.ALL
					//
					//System.out.println("Saving person: " + person.getSubject());
					session.save(person);					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					session.close();
					factory.close();					
				}
			}	

	}
	
	

