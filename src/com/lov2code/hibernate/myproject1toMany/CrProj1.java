package com.lov2code.hibernate.myproject1toMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.myproject1toMany.entity.City;
import com.lov2code.hibernate.myproject1toMany.entity.State;


public class CrProj1 {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(City.class)
										.addAnnotatedClass(State.class)
										.buildSessionFactory();				
				// Create session
				Session session = factory.getCurrentSession();
								
				int id;
				
				try {			
					session.beginTransaction();				
									
					//Create the objects					
					//Person person = new Person(15,"below","asdasd");
					State state= new State("Bihar", 10);					
								
					City city =new City("Patna","Tier 1");
					
					//State is unique
					System.out.println("Saving the state entity \n"+ state);
					
					//person.addSubject(subject);			
					state.addCity(city);
					
					//start a transaction
					//session.beginTransaction();
					
					//save the instructor
					//
					//Note: this will ALSO save the details object
					//because of CascadeType.ALL
					//
					//System.out.println("Saving state: " + state.getCity());
					session.save(state);					
					
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