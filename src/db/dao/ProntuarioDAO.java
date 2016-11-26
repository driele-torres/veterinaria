package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Prontuario;

public class ProntuarioDAO extends DAOHibernate<Prontuario>{
	public ProntuarioDAO(Session session) {
		super(session,Prontuario.class);
	}
	public Prontuario procuraProntuarioPorObservacao(String observacao) {
		return (Prontuario) getSession().createQuery("from Prontuario u where u.observacao = :observacao")
				.setParameter("observacao", observacao).uniqueResult();
	}
}