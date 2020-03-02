package com.lov2code.hibernate.myproject;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.myproject.entity.Person;
import com.lov2code.hibernate.myproject.entity.Subject;



public class ReadProj {
	
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
                
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            int getId=5;
                       
            //Getting Subject details unidirectional
            Person person = session.get(Person.class, getId);
            
            //Getting Person details biidirectional
            Subject subject= session.get(Subject.class, getId);
            
            //System.out.println("Get Person details: " + subject.getPerson());
            System.out.println("Get Subject details " +person.getSubject());
            
            // commit the transaction
            session.getTransaction().commit();            
            System.out.println("Done!");
        }catch(NullPointerException NPE) {
        	System.out.println(NPE.getStackTrace());
        }
        finally {
        	session.close();
            factory.close();
        }
    }

}
