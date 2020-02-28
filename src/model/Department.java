package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID")
	private int id;
	@Column(name = "DEPARTMENT_NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="EMPS_IN_DEP",
	      joinColumns={ @JoinColumn(name="DEPARTMENT_ID", referencedColumnName="DEPARTMENT_ID") },
	      inverseJoinColumns={ @JoinColumn(name="EMP_ID", referencedColumnName="ID", unique=true) }
	  )

	private List<Employee> listOfEmployees;

	
	public Department() {
		super();
	}
	
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public Department(String name, List<Employee> listOfEmployees) {
		super();
		this.name = name;
		this.listOfEmployees = listOfEmployees;
	}
	
	public Department(int id, String name, List<Employee> listOfEmployees) {
		super();
		this.id = id;
		this.name = name;
		this.listOfEmployees = listOfEmployees;
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

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", listOfEmployees=" + listOfEmployees + "]";
	}
	
	
	
}