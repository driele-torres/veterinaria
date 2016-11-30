package controller;

import db.dao.EspecieDAO;
import db.dao.ExameDAO;
import db.dao.PetDAO;
import db.dao.ProprietarioDAO;
import db.dao.RacaDAO;
import db.dao.VeterinarioDAO;
import java.util.List;
import model.Especie;
import model.Exame;
import model.Pet;
import model.Raca;
import model.Veterinario;

public class VeterinariaController {
    private EspecieDAO especieDao;
    private RacaDAO racaDao;
    private PetDAO petDao;
    private ProprietarioDAO proprietarioDao;
    private ExameDAO exameDao;
    private VeterinarioDAO veterinarioDao;
   
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
    
     public List<Exame> recuperarExames(){
        return exameDao.procuraTodos();
    }
     
     public List<Pet> recuperarPets(){
         return petDao.procuraTodos();
     }
     
     public List<Veterinario> recuperarVeterinarios(){
         return veterinarioDao.procuraTodos();
     }
     
     public Especie recuperarEspecieporDesc(String descricao){
         return especieDao.procuraEspeciePorDescricao(descricao);
     }
}