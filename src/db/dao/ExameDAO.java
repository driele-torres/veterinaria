
package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Exame;

public class ExameDAO extends DAOHibernate<Exame>{
	public ExameDAO(Session session) {
		super(session,Exame.class);
	}
        
	public Exame procuraExamePorNome(String nome) {
		return (Exame) getSession().createQuery("from Exame u where u.nome = :nome")
				.setParameter("nome", nome).uniqueResult();
	}
        
	public Exame procuraExamePorArea(String area) {
		return (Exame) getSession().createQuery("from Exame u where u.area = :area")
				.setParameter("area", area).uniqueResult();
	}
        
        public Exame procuraExamePorID(Integer ID) {
		return (Exame) getSession().createQuery("from Exame u where u.idexame = :id")
				.setParameter("id", ID).uniqueResult();
	}
        
        
}

