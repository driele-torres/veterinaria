package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Raca;

public class RacaDAO extends DAOHibernate<Raca>{
	public RacaDAO(Session session) {
		super(session,Raca.class);
	}
        
	public Raca procuraRacaPorDescricao(String descricao) {
		return (Raca) getSession().createQuery("from Raca u where u.descricao = :descricao")
				.setParameter("descricao", descricao).uniqueResult();
	}
        
        public Raca procuraRacaPorID(Integer ID) {
		return (Raca) getSession().createQuery("from Raca u where u.idraca = :id")
				.setParameter("id", ID).uniqueResult();
	}
}