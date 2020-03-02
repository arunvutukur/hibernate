package com.lov2code.hibernate.myproject1toMany.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;

	//This is already referenced as a foreign key as such you should not refer this column
	//@Column(name="state_id")
	//private int state_id;
	
	public City( String name, String type ) {		
		this.name = name;
		this.type = type;	
	}
	
	public City() {
		
	}
	
	
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", type=" + type +  "]";
	}

	/*
	 * public int getState_id() { return state_id; }
	 * 
	 * public void setState_id(int state) { this.state_id = state; }
	 */


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
