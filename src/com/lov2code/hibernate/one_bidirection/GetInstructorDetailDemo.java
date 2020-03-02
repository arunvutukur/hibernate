package com.lov2code.hibernate.one_bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.one_bidirection.Instructor;
import com.lov2code.hibernate.one_bidirection.InstructorDetail;

public class GetInstructorDetailDemo {
	
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
			
			// create the objects
			/*
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!");		
			*/
			
			/*
			 * Instructor tempInstructor = new Instructor("Madhu", "Patel",
			 * "madhu@luv2code.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new InstructorDetail(
			 * "http://www.youtube.com", "Guitar");
			 */		
			
			// associate the objects
			//tempInstructor.setInstructorDetail(tempInstructorDetail);
			
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
