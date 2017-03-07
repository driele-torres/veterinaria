package db.dao;

import db.access.DAOHibernate;
import java.util.List;
import model.GrupoAcesso;
import org.hibernate.Session;

/**
 *
 * @author lalaine
 */
public class GrupoAcessoDAO extends DAOHibernate<GrupoAcesso>{
    
    public GrupoAcessoDAO(Session session) {
		super(session,GrupoAcesso.class);
	}
}
