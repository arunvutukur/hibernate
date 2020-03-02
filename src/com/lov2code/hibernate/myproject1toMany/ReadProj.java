package com.lov2code.hibernate.myproject1toMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.myproject1toMany.entity.Person;
import com.lov2code.hibernate.myproject1toMany.entity.Subject;




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
            System.out.println("Get the person details" +person);
            
            //Getting Person details biidirectional
            //Subject subject= session.get(Subject.class, getId);
            
            //System.out.println("Get Person details: " + person.getSubject());
            System.out.println("Getting the subject details");
            System.out.println(person.getSubject());
            
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
