import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory = null;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ManageEmployee emp = new ManageEmployee();
		ArrayList<Certificate> set1 = new ArrayList<Certificate>();
		set1.add(new Certificate(1, "MCA"));
		set1.add(new Certificate(2, "MBA"));
		set1.add(new Certificate(3, "PMP"));
		
		Employee e = new Employee(45511,"Samanvi", "Jain", 1000);
		e.setCertificates(set1);
		
		emp.addEmployee(e);
		System.out.println("\n List of all employees\n");
		emp.listEmployee();
		factory.close();
	}
	
	public int addEmployee(Employee emp) {
		int empId = 0;
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			empId = (Integer)session.save(emp);
			
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return empId;
	}
	
	public void listEmployee() {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			List<Employee> emps = session.createQuery("FROM Employee").list();
			for(Employee e : emps) {
				System.out.println(e.getId());
				System.out.println(e.getFirstName());
				System.out.println(e.getLastName());
				System.out.println(e.getSalary());
				
				List<Certificate> certificates = e.getCertificates();
				for(Certificate c : certificates) {
					System.out.println(c.getId());
					System.out.println(c.getName());
				}
				tx.commit();
			}
		} catch(Exception e) {
			tx.rollback();
			
		}
		session.close();
	}
}
