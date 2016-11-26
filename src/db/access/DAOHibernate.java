package db.access;

import java.util.List;
import org.hibernate.Session;

public abstract class DAOHibernate <T> implements GenericAccess<T>{
    private final Class<T> type;
	private final Session session;

	public DAOHibernate(Session session, Class<T> type){
		this.type = type;
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	public void adiciona(T t) {
		getSession().save(t);
		getSession().flush();
	}
	
	public void atualiza(T t) {
		getSession().merge(t);
		getSession().flush();
	}
	
	public void remove(T t) {
		getSession().delete(t);
		getSession().flush();
		getSession().clear();
	}
	@SuppressWarnings("unchecked")
	public T procuraPorID(int id) {
		return (T)getSession().load(type, id);
	}
	@SuppressWarnings("unchecked")
	public List<T> procuraTodos(){
		return (List<T>) getSession().createQuery("from "+type.getName()).list();
	}
}
