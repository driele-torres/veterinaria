package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Pet;

public class PetDAO extends DAOHibernate<Pet>{
	public PetDAO(Session session) {
		super(session,Pet.class);
	}
	public Pet procuraPetPorDescricao(String descricao) {
		return (Pet) getSession().createQuery("from Pet u where u.descricao = :descricao")
				.setParameter("descricao", descricao).uniqueResult();
	}
}