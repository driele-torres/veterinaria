package controller;

import db.connection.CriadorDeSessao;
import db.dao.EspecieDAO;
import model.Especie;

public class EspecieController{
    private EspecieDAO especieDao;
    
    public EspecieController(){
        especieDao= new EspecieDAO(CriadorDeSessao.getSession());
    }
    
    public void salvarEspecie(Especie especie){
        especieDao.adiciona(especie);
    }
}