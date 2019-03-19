package com.java.hib.bean;

import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory;
	public static void main(String[] args) {
		factory = new Configuration().configure("/com/java/hib/bean/hibernate.cfg.xml").buildSessionFactory();
		
		Employee emp = new Employee();
		emp.setEmp_id(45509);
		emp.setFirstName("Avishka");
		emp.setLastName("Jainapur");
		emp.setSalary(20);
		
		TreeSet<Certificate> set1 = new TreeSet<Certificate>();
		set1.add(new Certificate(1, "SCJP"));
		set1.add(new Certificate(2, "WCSCJP"));
		
		emp.setCertificates(set1);
		ManageEmployee me = new ManageEmployee();
		me.addEmployee(emp);
		System.out.println("Employee inserted successfully");
		
		factory.close();
	}
	
	public int addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		int employeeId = 0;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			employeeId = (Integer)session.save(emp);
			tx.commit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		} finally{
			session.close();			
		}
		return employeeId;
	}
}
