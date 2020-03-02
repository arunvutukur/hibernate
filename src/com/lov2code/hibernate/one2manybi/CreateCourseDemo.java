package com.lov2code.hibernate.one2manybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseDemo {
	
	
	private static int id=1;
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			Course tempCourse1 = new Course("Air Guitar the ultimate guide");
			Course tempCourse2 = new Course("Nonsense");
				
			// add courses to instructor			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);			
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			System.out.println("Saving Course1: " + tempCourse1 +" Course2: " +tempCourse2);
					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			//ADD CLEAN UP (STANDARD)
			
			session.close();
			factory.close();
		}
	}

}





