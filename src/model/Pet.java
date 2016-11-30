package model;
// Generated Nov 30, 2016 1:53:31 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pet generated by hbm2java
 */
public class Pet  implements java.io.Serializable {


     private Integer idpet;
     private Proprietario proprietario;
     private Raca raca;
     private String descricao;
     private Date dataNascimento;
     private Set prontuarios = new HashSet(0);

    public Pet() {
    }

	
    public Pet(Proprietario proprietario, Raca raca) {
        this.proprietario = proprietario;
        this.raca = raca;
    }
    public Pet(Proprietario proprietario, Raca raca, String descricao, Date dataNascimento, Set prontuarios) {
       this.proprietario = proprietario;
       this.raca = raca;
       this.descricao = descricao;
       this.dataNascimento = dataNascimento;
       this.prontuarios = prontuarios;
    }
   
    public Integer getIdpet() {
        return this.idpet;
    }
    
    public void setIdpet(Integer idpet) {
        this.idpet = idpet;
    }
    public Proprietario getProprietario() {
        return this.proprietario;
    }
    
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    public Raca getRaca() {
        return this.raca;
    }
    
    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Set getProntuarios() {
        return this.prontuarios;
    }
    
    public void setProntuarios(Set prontuarios) {
        this.prontuarios = prontuarios;
    }




}


