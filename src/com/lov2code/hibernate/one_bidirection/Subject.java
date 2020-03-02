package com.lov2code.hibernate.one_bidirection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

    @Entity
	@Table(name="subject")
	public class Subject {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="tag")
		private String tag;	

		@Column(name="description")
		private String description;

		@Override
		public String toString() {
			return "Subject [id=" + id + ", tag=" + tag + ", description=" + description + "]";
		}

		public Subject( String tag, String description) {				
			this.tag = tag;
			this.description = description;
		}	
		
		public Subject() {
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}		
					
	}


