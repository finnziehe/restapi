package com.ziehe.demorest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class init {

	
	Configuration con = new Configuration().configure().addAnnotatedClass(Mitarbeiter.class); 
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
	SessionFactory sf = con.buildSessionFactory(reg); 
	Session test = sf.openSession(); 
	org.hibernate.Transaction tx = test.beginTransaction();

	public void getConnection() {
	
		
		Session test = sf.openSession(); 
		
		
}

	
	
	public void Commit() {
		tx.commit();
		
		
		
	}
}


