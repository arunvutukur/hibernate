package com.lov2code.hibernate.myproject1toMany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lov2code.hibernate4.one2manyuni.Review;

@Entity
@Table(name="subject")
public class Subject {

			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
			private int id;	
			
			@Column(name="tag")
			private String Tag;
			
			
			@Column(name="Description")
			private String Description;
				
			//@OneToOne(mappedBy="subject", cascade=CascadeType.ALL) private Person person;
	 
			public int getId() {
				return id;
			}


			public void setId(int id) {
				this.id = id;
			}


			public String getTag() {
				return Tag;
			}


			public void setTag(String tag) {
				Tag = tag;
			}


			public String getDescription() {
				return Description;
			}


			public void setDescription(String description) {
				Description = description;
			}

	/*
	 * public Person getPerson() { return person; }
	 * 
	 * 
	 * public void setPerson(Person person) { this.person = person; }
	 */
			

	/*
	 * public void setSubject(List<Subject> subject) {
	 * 
	 * }
	 */


			@Override
			public String toString() {
				return "Subject [id=" + id + ", Tag=" + Tag + ", Description=" + Description + "]";
			}


			public Subject(String tag, String description) {
				//super();
				//this.id = id;
				Tag = tag;
				Description = description;
				
			}	
			
			public Subject() {
				
			}
			
}
