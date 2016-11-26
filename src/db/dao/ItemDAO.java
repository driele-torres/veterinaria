package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Item;

public class ItemDAO extends DAOHibernate<Item>{
	public ItemDAO(Session session) {
		super(session,Item.class);
	}
	public Item procuraItemPorReferencia(String referencia) {
		return (Item) getSession().createQuery("from Item u where u.referencia = :referencia")
				.setParameter("referencia", referencia).uniqueResult();
	}
	public Item procuraItemPorNome(String nome) {
		return (Item) getSession().createQuery("from Item u where u.nome = :nome")
				.setParameter("nome", nome).uniqueResult();
	}
}