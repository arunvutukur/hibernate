package com.lov2code.hibernate4.one2manyuni;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="course")
public class Course {
	
	// Define our fields
	
	// Define constructor
	
	// Define getter/setter
	
	// Define toString
	
	// Annotate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Column(name="title")
	private String title;
	
	
	//***DO NOT USE CASCADE ALL AS IT WILL EFFECT DURING DELETION
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;

	public Course(String title) {
		// TODO Auto-generated constructor stub
		
		this.title =title;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
				
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title +  "]";
	}
	
	//Add a convenience method
	public void addReview(Review theReview) {
		
		if(reviews ==null) {
			reviews =new ArrayList<>();
		}
		
		reviews.add(theReview);
	}
	
}
