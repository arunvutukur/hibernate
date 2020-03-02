package com.lov2code.hibernate.myproject1toMany.entity;

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

import com.lov2code.hibernate.myproject.entity.Subject;
import com.lov2code.hibernate4.one2manyuni.Review;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private int code;

	@OneToMany(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="state_id")
	private List<City> city = new ArrayList<>();
		
	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public State( String name, int code) {		
		this.name = name;		
		this.code=code;		
	}
	
	public State() {
		
	}
	

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

	public int getCode() {
		return code;
	}

	public void setCode(int Code) {
		this.code = Code;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
	//Add a convenience method
	public void addCity(City theCity) {							
		city.add(theCity);
	}
	
	
	
	
	
	
	

}
