package controller;

import db.dao.EspecieDAO;
import db.dao.PetDAO;
import db.dao.ProprietarioDAO;
import db.dao.RacaDAO;
import java.util.List;
import model.Especie;
import model.Pet;
import model.Raca;

public class VeterinariaController{
    private EspecieDAO especieDao;
    private RacaDAO racaDao;
    private PetDAO petDao;
    private ProprietarioDAO proprietarioDao;
    
    
   
    public void salvarEspecie(Especie especie){
        especieDao.adiciona(especie);
    }
    
    public void salvarRaca(Raca raca){
        racaDao.adiciona(raca);
    }   
    
    public void salvarVeterinario(Pet pet){
        petDao.adiciona(pet);   
    }
    
    public List<Especie> recuperarEspecies(){
        return especieDao.procuraTodos();
    }
    
    public List<Raca> recuperarRacas(){
        return racaDao.procuraTodos();
    }
}
