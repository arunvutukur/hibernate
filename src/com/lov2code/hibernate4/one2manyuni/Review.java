package com.lov2code.hibernate4.one2manyuni;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	//Define Fields
	
	//Define Constructors
	
	//Define getter/setters
	
	//Define toString
	
	//Annotate the fields
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name= "comment")
	private String comment;	
	
	//dont since it is already connected
//	@Column(name = "course_id")
//	private int course_id;
	
	public Review(String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	
	public Review() {
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public void setReviews(List<Review> reviews) {
		
	}

	
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

	

}
