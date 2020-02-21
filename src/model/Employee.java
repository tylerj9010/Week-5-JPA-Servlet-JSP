package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="AGE")
	private int age;
	@Column(name="POSITION")
	private String position;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, int age, String position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String returnEmpDetails() {
		return position + ":" + firstName + lastName + ", " + age;
	}

	
	
	
	
}
