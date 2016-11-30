package db.connection;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
////import org.hibernate.service.ServiceRegistryBuilder;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//public class CriadorDeSessao {
//
//	private static Configuration config;
//	private static SessionFactory sf;
//	
//	public Session getSession() {
//		if(sf == null) {
//			getConfig();
//			sf =config.buildSessionFactory(new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry());
//		}
//		return sf.openSession();
//	}
//
//	public Configuration getConfig() {
//		if(config == null) {
//			config = new Configuration().configure();			
//		}
//		return config;
//	}
//}
//


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CriadorDeSessao
{
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void inicializar(){
        if ((serviceRegistry == null)||(sessionFactory == null)){
        try
        {
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException he)
        {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
        }
    }

//    public static SessionFactory getSessionFactory()
//    {
//        inicializar();
//        return sessionFactory;
//    } 
    public static Session getSession()
    {
        inicializar();
        return sessionFactory.openSession();
    } 
}