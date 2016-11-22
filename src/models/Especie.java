/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gmcore
 */
@Entity
@Table(name = "especie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e")
    , @NamedQuery(name = "Especie.findByIdespecie", query = "SELECT e FROM Especie e WHERE e.idespecie = :idespecie")
    , @NamedQuery(name = "Especie.findByDescricao", query = "SELECT e FROM Especie e WHERE e.descricao = :descricao")
    , @NamedQuery(name = "Especie.findByNomeCientifico", query = "SELECT e FROM Especie e WHERE e.nomeCientifico = :nomeCientifico")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idespecie")
    private Integer idespecie;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nome_cientifico")
    private String nomeCientifico;
    @OneToMany(mappedBy = "idRacaEspecie")
    private Collection<Raca> racaCollection;

    public Especie() {
    }

    public Especie(Integer idespecie) {
        this.idespecie = idespecie;
    }

    public Integer getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(Integer idespecie) {
        this.idespecie = idespecie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    @XmlTransient
    public Collection<Raca> getRacaCollection() {
        return racaCollection;
    }

    public void setRacaCollection(Collection<Raca> racaCollection) {
        this.racaCollection = racaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecie != null ? idespecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.idespecie == null && other.idespecie != null) || (this.idespecie != null && !this.idespecie.equals(other.idespecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Especie[ idespecie=" + idespecie + " ]";
    }
    
}
