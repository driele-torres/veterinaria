package db.connection;
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
    public static Session getSession()
    {
        inicializar();
        return sessionFactory.openSession();
    } 
}