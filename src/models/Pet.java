/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gmcore
 */
@Entity
@Table(name = "pet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p")
    , @NamedQuery(name = "Pet.findByIdpet", query = "SELECT p FROM Pet p WHERE p.idpet = :idpet")
    , @NamedQuery(name = "Pet.findByDescricao", query = "SELECT p FROM Pet p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Pet.findByDataNascimento", query = "SELECT p FROM Pet p WHERE p.dataNascimento = :dataNascimento")})
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpet")
    private Integer idpet;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToMany(mappedBy = "idProntuarioPet")
    private Collection<Prontuario> prontuarioCollection;
    @JoinColumn(name = "id_pet_proprietario", referencedColumnName = "idproprietario")
    @ManyToOne(optional = false)
    private Proprietario idPetProprietario;
    @JoinColumn(name = "id_pet_raca", referencedColumnName = "idraca")
    @ManyToOne(optional = false)
    private Raca idPetRaca;

    public Pet() {
    }

    public Pet(Integer idpet) {
        this.idpet = idpet;
    }

    public Integer getIdpet() {
        return idpet;
    }

    public void setIdpet(Integer idpet) {
        this.idpet = idpet;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @XmlTransient
    public Collection<Prontuario> getProntuarioCollection() {
        return prontuarioCollection;
    }

    public void setProntuarioCollection(Collection<Prontuario> prontuarioCollection) {
        this.prontuarioCollection = prontuarioCollection;
    }

    public Proprietario getIdPetProprietario() {
        return idPetProprietario;
    }

    public void setIdPetProprietario(Proprietario idPetProprietario) {
        this.idPetProprietario = idPetProprietario;
    }

    public Raca getIdPetRaca() {
        return idPetRaca;
    }

    public void setIdPetRaca(Raca idPetRaca) {
        this.idPetRaca = idPetRaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpet != null ? idpet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.idpet == null && other.idpet != null) || (this.idpet != null && !this.idpet.equals(other.idpet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pet[ idpet=" + idpet + " ]";
    }
    
}
