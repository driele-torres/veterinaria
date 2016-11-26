package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Veterinario;

public class VeterinarioDAO extends DAOHibernate<Veterinario>{
	public VeterinarioDAO(Session session) {
		super(session,Veterinario.class);
	}
        
	public Veterinario procuraVeterinarioPorEspecialidade(String especialidade) {
		return (Veterinario) getSession().createQuery("from Especialidade u where u.especialidade = :especialidade")
				.setParameter("especialidade", especialidade).uniqueResult();
	}
}
