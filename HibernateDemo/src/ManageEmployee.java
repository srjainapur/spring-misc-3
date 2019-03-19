

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		/* Let us have a set of certificates for the first employee  */
		HashSet<Certificate> set1 = new HashSet<Certificate>();
		set1.add(new Certificate(1,"MCA"));
		set1.add(new Certificate(2,"MBA"));
		set1.add(new Certificate(3,"PMP"));
		ManageEmployee me = new ManageEmployee();
		me.saveEmployee(new Employee(45509, "Satish", "Jainapur", new Date("27/01/2018"), 10000, set1));
		
		/*System.out.println("All Employees are as follow");
		System.out.println(me.getAllEmployee());
		
		me.updateEmployee(45507, 200000);*/
		
		factory.close();
	}
	
	public int saveEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction tx = null;
		int empId = 0;

		try {
			tx = session.beginTransaction();
			empId = (Integer) session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return empId;
	}
	
	public List<Employee> getAllEmployee(){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> list = null;
		
		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM Employee").list();
		} catch(Exception e) {
			tx.rollback();
		} finally{
			tx.commit();
			session.close();
		}
		
		return list;
	}
	
	/* Method to UPDATE salary for an employee */
	   public void updateEmployee(Integer EmployeeID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setSalary( salary );
			 session.update(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to DELETE an employee from the records */
	   public void deleteEmployee(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
