package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			
			return metadata.getSessionFactoryBuilder().build();
		}
		catch (Throwable ex) {
			// TODO: handle exception
			System.err.print("Initial SessionFactory creation failed. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
