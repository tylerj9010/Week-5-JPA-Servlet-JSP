package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Department;

public class DepartmentHelper {

		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeJpa");

		public void insertNewDepartment(Department s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Department> getDepartments() {
			EntityManager em = emfactory.createEntityManager();
			List<Department> allDetails = em.createQuery("SELECT d FROM Department d").getResultList();
			return allDetails;
		}

		public Department searchForListById(Integer tempId) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Department found = em.find(Department.class, tempId);
			em.close();
			return found;
		}

		public void deleteItem(Department toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Department> typedQuery = em.createQuery("select d from Department d where d.id = :selectedid",Department.class);
			typedQuery.setParameter("selectedid", toDelete.getId());
			
			typedQuery.setMaxResults(1);

			Department result = typedQuery.getSingleResult();

			em.remove(result);
			em.getTransaction().commit();
			em.close();
			
		}
	
		public void updateList(Department toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}

}