package com.lov2code.hibernate.one_bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		try {				
			// start a transaction
			session.beginTransaction();
			
			int id= 2;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
			
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			//System.out.println("Saving instructor: " + tempInstructor);
			//session.save(tempInstructor);					
			
			System.out.println("tempInstructorDetail is "+ tempInstructorDetail );
			System.out.println("The associated Instructor Detail is "+ tempInstructorDetail.getInstructor() );
			
			System.out.println("The temp Instructore detail " +tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
			//close the session incase of leaks
			session.close();
		}	
		
		
	}
	
	
}
