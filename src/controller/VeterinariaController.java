package controller;

import db.connection.CriadorDeSessao;
import db.dao.EspecieDAO;
import db.dao.ExameDAO;
import db.dao.GrupoAcessoDAO;
import db.dao.ItemDAO;
import db.dao.PetDAO;
import db.dao.ProntuarioDAO;
import db.dao.ProprietarioDAO;
import db.dao.RacaDAO;
import db.dao.UsuarioDAO;
import db.dao.VeterinarioDAO;
import db.dao.FuncionarioDAO;
import java.util.List;
import model.Especie;
import model.Exame;
import model.GrupoAcesso;
import model.Item;
import model.Pet;
import model.Prontuario;
import model.Proprietario;
import model.Raca;
import model.Usuario;
import model.Veterinario;
import model.Funcionario;

public class VeterinariaController {
    private EspecieDAO especieDao;
    private RacaDAO racaDao;
    private PetDAO petDao;
    private ProprietarioDAO proprietarioDao;
    private ProntuarioDAO prontuarioDao;
    private ExameDAO exameDao;
    private VeterinarioDAO veterinarioDao;
    private UsuarioDAO usuarioDao;
    private ItemDAO itemDao;
    private GrupoAcessoDAO grupoDAO;
    private FuncionarioDAO funcionarioDAO;
    
    public VeterinariaController(){
        especieDao = new EspecieDAO(CriadorDeSessao.getSession());
        racaDao = new RacaDAO(CriadorDeSessao.getSession());
        petDao = new PetDAO(CriadorDeSessao.getSession());
        proprietarioDao = new ProprietarioDAO(CriadorDeSessao.getSession());
        exameDao = new ExameDAO(CriadorDeSessao.getSession());
        veterinarioDao = new VeterinarioDAO(CriadorDeSessao.getSession());
        usuarioDao = new UsuarioDAO(CriadorDeSessao.getSession());
        itemDao = new ItemDAO(CriadorDeSessao.getSession());
        prontuarioDao = new ProntuarioDAO(CriadorDeSessao.getSession());
        grupoDAO = new GrupoAcessoDAO(CriadorDeSessao.getSession());
        funcionarioDAO = new FuncionarioDAO(CriadorDeSessao.getSession());
    }
    
    public void salvarGrupo(GrupoAcesso grupo){
        grupoDAO.adiciona(grupo);
    }
   
    public void salvarEspecie(Especie especie){
        especieDao.adiciona(especie);
    }
    
    public void atualizaEspecie(Especie especie){
        especieDao.atualiza(especie);
    }
    
    public boolean salvarRaca(Raca raca){
        if(racaDao.procuraRacaPorDescricao(raca.getDescricao()) == null){
            racaDao.adiciona(raca);
            return true;
        }
        return false;      
    } 
    
    public boolean atualizarRaca(Raca raca){
        racaDao.atualiza(raca);
        return true;
    }
    
    public boolean salvarPet(Pet pet){
        if(petDao.procuraPetPorDescricao(pet.getDescricao()) == null){
            petDao.adiciona(pet);
            return true;
        }
        return false;      
    }
    
    public boolean atualizarPet(Pet pet){
        petDao.atualiza(pet);
        return true;
    }
    public boolean salvarExame(Exame exame){
        if(exameDao.procuraExamePorNome(exame.getNome()) == null){
           exameDao.adiciona(exame); 
           return true;
        }
        return false;
    }
    
     public boolean atualizarExame(Exame exame){
        exameDao.atualiza(exame);
           return true;
    }
     
    public boolean salvarUsuario(Usuario usuario){
        if(usuarioDao.procuraUsuarioPorCPF(usuario.getCpf()) == null){
            usuarioDao.adiciona(usuario);
            return true;
        }
        return false;    
    }
    
    public boolean atualizarUsuario(Usuario usuario){
        usuarioDao.atualiza(usuario);
            return true;
    }
    
    public List<Usuario> procurarUsuariosPorDescricao(String name){
        return usuarioDao.procuraUsuariosPorNome(name);
    }
    
    public List<Veterinario> procurarVeterinariosPorDescricao(String name){
        return veterinarioDao.procuraVeterinariosPorNome(name);
    }
    
    public boolean salvarProntuario(Prontuario prontuario){
        prontuarioDao.adiciona(prontuario);
        return true;
    }
    
    public boolean salvarFuncionario(Funcionario funcionario){
        if(usuarioDao.procuraUsuarioPorCPF(funcionario.getUsuario().getCpf()) == null){
            if(salvarUsuario(funcionario.getUsuario()))
                funcionarioDAO.adiciona(funcionario);
            return true;
        }
        return false;   
    }
    
    public Usuario procuraUsuarioPorUsername(String username){
        return usuarioDao.procuraUsuarioPorUsername(username);
    }
    
    public boolean salvarItem(Item item){
        if(itemDao.procuraItemPorNome(item.getNome()) == null){
             itemDao.adiciona(item);
             return true;
        }
        return false;
    }
    
    
    public boolean atualizaItem(Item item){
        itemDao.atualiza(item);
        return true;
    }
    
    public List<Item> recuperarItemsPorDescricao(String descricao){
        return itemDao.procuraItemsPorDescricao(descricao);
    }
    
    public boolean salvarProprietario(Proprietario prop){
        if(proprietarioDao.procuraProprietarioPorCPF(prop.getCpf()) == null){
            proprietarioDao.adiciona(prop);  
            return true;
        }
        return false;
         
    }
    
    public boolean atualizarProprietario(Proprietario prop){
        proprietarioDao.atualiza(prop);
            return true;  
    }
    
    public boolean salvarVeterinario(Veterinario veterinario){
        if(usuarioDao.procuraUsuarioPorCPF(veterinario.getUsuario().getCpf()) == null){
            salvarUsuario(veterinario.getUsuario());
            veterinarioDao.adiciona(veterinario); 
           return true;
        }
        return false;         
    }
    
    public boolean atualizaVeterinario(Veterinario veterinario){
        this.atualizarUsuario(veterinario.getUsuario());
        veterinarioDao.atualiza(veterinario);
        return true;         
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
     
    public List<Exame> recuperarExamesPorDescricao(String descricao){
        return exameDao.procuraExamesPorNome(descricao);
    }
     
     public List<Pet> recuperarPets(){
         return petDao.procuraTodos();
     }
     
     public List<Pet> recuperarPetsPorDescricao(String descricao){
         return petDao.procuraPetsPorDescricao(descricao);
     }
     
     public List<Especie> recuperarEspeciesPorDescricao(String descricao){
         return especieDao.procuraEspeciesPorDescricao(descricao);
     }
     public List<Proprietario> recuperarProprietarios(){
         return proprietarioDao.procuraTodos();
     }
     
     public List<Proprietario> recuperarProprietariosPorDescricao(String descricao){
         return proprietarioDao.procuraProprietariosPorNome(descricao);
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
     
     public Exame recuperarExameporID(Integer ID){
         return exameDao.procuraExamePorID(ID);
     }
     
     public Raca recuperarRacaDesc(String descricao){
         return racaDao.procuraRacaPorDescricao(descricao);
     }
     
     public List<Raca> recuperarRacasDesc(String descricao){
         return racaDao.procuraRacasPorDescricao(descricao);
     }
     
     public Raca recuperarRacaPorID(Integer ID){
         return racaDao.procuraPorID(ID);
     }
     
    public Proprietario recuperarProprietarioDesc(String descricao){
         return proprietarioDao.procuraProprietarioPorNome(descricao);
    }
    
    public Proprietario recuperarProprietarioID(Integer ID){
        return proprietarioDao.procuraPorID(ID);
    }
    
    public List<Prontuario> recuperarProntuarios(){
         return prontuarioDao.procuraTodos();
    }
    
    public Especie recuperarEspeciePorID(Integer ID){
        return especieDao.procuraEspeciePorID(ID);
    }
    
    public List<GrupoAcesso> recuperarGrupos(){
        return grupoDAO.procuraTodos();
    }
    
    public GrupoAcesso recuperarGrupoID(Integer ID){
        return grupoDAO.procuraPorID(ID);
    }
    
    public Pet recuperarPetID(Integer ID){
        return petDao.procuraPorID(ID);
    }
    
    public Veterinario recuperarVeterinarioID(Integer ID){
        return veterinarioDao.procuraPorID(ID);
    }
}