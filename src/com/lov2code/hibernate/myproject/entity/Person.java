package com.lov2code.hibernate.myproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="person")
public class Person {
	
	    // Define our fields
	
		// Define constructor
		
		// Define getter/setter
		
		// Define toString
		
		// Annotate fields
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	public Person(int id, String name, String email) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
		
	}	


	@Column(name="name")
	private String Name;
	

	@Column(name="email")
	private String email;

	
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Subject")
	private Subject subject;
	
	public Person() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}	
	
	public Subject getSubject() { return subject; }
	  
	  
	public void setSubject(Subject subject) { this.subject = subject; }  
	

	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", email=" + email + "]";
	}
	
	
	 

}
