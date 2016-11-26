package db.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class CriadorDeSessao {

	private static Configuration config;
	private static SessionFactory sf;
	
	public Session getSession() {
		if(sf == null) {
			getConfig();
			sf =config.buildSessionFactory(new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry());
		}
		return sf.openSession();
	}

	public Configuration getConfig() {
		if(config == null) {
			config = new Configuration().configure();			
		}
		return config;
	}
}