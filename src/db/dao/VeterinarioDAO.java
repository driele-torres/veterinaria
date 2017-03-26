package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import java.util.List;
import model.Veterinario;

public class VeterinarioDAO extends DAOHibernate<Veterinario>{
	public VeterinarioDAO(Session session) {
		super(session,Veterinario.class);
	}
        
	public Veterinario procuraVeterinarioPorEspecialidade(String especialidade) {
		return (Veterinario) getSession().createQuery("from Especialidade u where u.especialidade = :especialidade")
				.setParameter("especialidade", especialidade).uniqueResult();
	}
        
        public List<Veterinario> procuraVeterinariosPorNome(String nome) {
		return (List<Veterinario>) getSession().createQuery("from Veterinario v where v.especialidade like :nome")
				.setParameter("nome", nome).list();
	}
}