package edu.gudh.hibernatetest.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();		
		//开始事务
		Transaction tran=session.beginTransaction();
		
		//College col=(College)session.get(College.class, "123321");
		//System.out.println(col.getCollegeName());
		//col.setCollegeName("医学护理学院");
		
		College col=new College();
		col.setCollegeName("aaaaaa");
		
		
		try {
			session.save(col);
			session.flush();
			tran.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally{
			session.close();
		}	

	}

}
