package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Proprietario;

public class ProprietarioDAO extends DAOHibernate<Proprietario>{
	public ProprietarioDAO(Session session) {
		super(session,Proprietario.class);
	}
        
	public Proprietario procuraProprietarioPorNome(String nome) {
		return (Proprietario) getSession().createQuery("from Proprietario u where u.nome = :nome")
				.setParameter("nome", nome).uniqueResult();
	}
}