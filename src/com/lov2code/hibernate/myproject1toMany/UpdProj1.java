package com.lov2code.hibernate.myproject1toMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.myproject1toMany.entity.City;
import com.lov2code.hibernate.myproject1toMany.entity.State;

public class UpdProj1 {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(City.class)
								.addAnnotatedClass(State.class)
								.buildSessionFactory();				
		// Create session
		Session session = factory.getCurrentSession();
						
		int theId=20;
		
		try {			
			session.beginTransaction();				
							
			//Create the objects					
			//Person person = new Person(15,"below","asdasd");
			State state =session.get(State.class, theId);
			

			System.out.println("Updating State...");
		
			state.setName("Andhra Pradesh");		
			
			//Session update or else transaction will fail
			session.update(state);			
			
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