package controller;

import db.dao.EspecieDAO;
import db.dao.ExameDAO;
import db.dao.ItemDAO;
import db.dao.PetDAO;
import db.dao.ProprietarioDAO;
import db.dao.RacaDAO;
import db.dao.UsuarioDAO;
import db.dao.VeterinarioDAO;
import java.util.List;
import model.Especie;
import model.Exame;
import model.Item;
import model.Pet;
import model.Proprietario;
import model.Raca;
import model.Usuario;
import model.Veterinario;

public class VeterinariaController {
    private EspecieDAO especieDao;
    private RacaDAO racaDao;
    private PetDAO petDao;
    private ProprietarioDAO proprietarioDao;
    private ExameDAO exameDao;
    private VeterinarioDAO veterinarioDao;
    private UsuarioDAO usuarioDao;
    private ItemDAO itemDao;
   
    public void salvarEspecie(Especie especie){
        especieDao.adiciona(especie);
    }
    
    public void salvarRaca(Raca raca){
        racaDao.adiciona(raca);
    }   
    
    public void salvarPet(Pet pet){
        petDao.adiciona(pet);   
    }
    public void salvarExame(Exame exame){
        exameDao.adiciona(exame);   
    }
    public void salvarUsuario(Usuario usuario){
        usuarioDao.adiciona(usuario);   
    }
    public void salvarItem(Item item){
        itemDao.adiciona(item);   
    }
    public void salvarProprietario(Proprietario prop){
        proprietarioDao.adiciona(prop);   
    }
    public void salvarVeterinario(Veterinario veterinario){
        veterinarioDao.adiciona(veterinario);   
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
     public List<Proprietario> recuperarProprietarios(){
         return proprietarioDao.procuraTodos();
     }
     
     public List<Veterinario> recuperarVeterinarios(){
         return veterinarioDao.procuraTodos();
     }
     
     public Especie recuperarEspecieporDesc(String descricao){
         return especieDao.procuraEspeciePorDescricao(descricao);
     }
     public Exame recuperarExameporDesc(String descricao){
         return exameDao.procuraExamePorNome(descricao);
     }
     public Raca recuperarRacaDesc(String descricao){
         return racaDao.procuraRacaPorDescricao(descricao);
     }
     
    public Proprietario recuperarProprietarioDesc(String descricao){
         return proprietarioDao.procuraProprietarioPorNome(descricao);
    }
     
}