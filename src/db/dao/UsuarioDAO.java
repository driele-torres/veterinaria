package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Usuario;

public class UsuarioDAO extends DAOHibernate<Usuario>{
	public UsuarioDAO(Session session) {
		super(session,Usuario.class);
	}
        
	public Usuario procuraUsuarioPorUsername(String username) {
		return (Usuario) getSession().createQuery("from Usuario u where u.username = :username")
				.setParameter("username", username).uniqueResult();
	}
        public Usuario procuraUsuarioPorCPF(String cpf) {
		return (Usuario) getSession().createQuery("from Usuario u where u.cpf = :cpf")
				.setParameter("cpf", cpf).uniqueResult();
	}

}
