package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

public class EmployeeHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeJpa");

	public void addNewEmployee(Employee toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Employee> showAllEmps() {
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allItems = em.createQuery("select i from Employee i").getResultList();
		return allItems;
		
	}

	public List<Employee> searchForEmp(String fName, String lName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select e from Employee e where e.firstName ="
				+ ":selectedFirstName and e.lastName = :selectedLastName", Employee.class);
		typedQuery.setParameter("selectedFirstName", fName);
		typedQuery.setParameter("selectedLastName", lName);
		
		List<Employee> foundEmps = typedQuery.getResultList();
		em.close();
		return foundEmps;
	}

	public Employee searchForEmpById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Employee found = em.find(Employee.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEmp(Employee toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public void deleteEmp(Employee toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select e from Employee e where e.id ="
				+ ":selectedId", Employee.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		Employee result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();	
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
