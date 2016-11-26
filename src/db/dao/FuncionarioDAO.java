package db.dao;

import org.hibernate.Session;

import db.access.DAOHibernate;
import model.Funcionario;

public class FuncionarioDAO extends DAOHibernate<Funcionario>{
	public FuncionarioDAO(Session session) {
		super(session,Funcionario.class);
	}
        
	public Funcionario procuraFuncionarioPorFuncao(String funcao) {
		return (Funcionario) getSession().createQuery("from Funcionario u where u.funcao = :funcao")
				.setParameter("funcao", funcao).uniqueResult();
	}
}