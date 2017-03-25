package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import java.util.List;
import model.Pet;

public class PetDAO extends DAOHibernate<Pet>{
	public PetDAO(Session session) {
		super(session,Pet.class);
	}
	public Pet procuraPetPorDescricao(String descricao) {
		return (Pet) getSession().createQuery("from Pet u where u.descricao = :descricao")
				.setParameter("descricao", descricao).uniqueResult();
	}
        
        public List<Pet> procuraPetsPorDescricao(String descricao) {
		return (List<Pet>) getSession().createQuery("from Pet u where u.descricao like :descricao")
				.setParameter("descricao", descricao).list();
	}
}