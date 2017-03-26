package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import java.util.List;
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
        
        public List<Usuario> procuraUsuariosPorNome(String name) {
		return (List<Usuario>) getSession().createQuery("from Usuario u where u.nome like :name")
				.setParameter("name", name).list();
	}

}
