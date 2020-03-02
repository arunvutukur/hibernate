package com.lov2code.hibernate4.one2manyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
	
	
	private static int id=1;
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		
		try {	
			// start a transaction
			session.beginTransaction();		
			
			//Create a course
			Course tempCourse =new Course("Pacman-how is it");
			
			//Add some reviews
			tempCourse.addReview(new Review("Great course...loved it"));
			tempCourse.addReview(new Review("Great course...loved it"));
			tempCourse.addReview(new Review("Great course...loved it"));
			tempCourse.addReview(new Review("Great course...loved it"));
			tempCourse.addReview(new Review("Great course...loved it"));
			
			//Save the course....and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
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





