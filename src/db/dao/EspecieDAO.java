package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import java.util.List;
import model.Especie;

public class EspecieDAO extends DAOHibernate<Especie>{
	public EspecieDAO(Session session) {
		super(session,Especie.class);
	}
	public Especie procuraEspeciePorDescricao(String descricao) {
		return (Especie) getSession().createQuery("from Especie u where u.descricao = :descricao")
				.setParameter("descricao", descricao).uniqueResult();
	}
	public Especie procuraEspeciePorNomeCientifico(String nomeCientifico) {
		return (Especie) getSession().createQuery("from Especie u where u.nomeCientifico = :nomeCientifico")
				.setParameter("nomeCientifico", nomeCientifico).uniqueResult();
	}
        public Especie procuraEspeciePorID(Integer ID){
            return (Especie) getSession().createQuery("from Especie u where u.idespecie = :id")
				.setParameter("id", ID).uniqueResult();
        }
        
        public List<Especie> procuraEspeciesPorDescricao(String descricao) {
		return (List<Especie>) getSession().createQuery("from Especie u where u.descricao like :descricao")
				.setParameter("descricao", descricao).list();
	}
}