package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "raca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raca.findAll", query = "SELECT r FROM Raca r")
    , @NamedQuery(name = "Raca.findByIdraca", query = "SELECT r FROM Raca r WHERE r.idraca = :idraca")
    , @NamedQuery(name = "Raca.findByDescricao", query = "SELECT r FROM Raca r WHERE r.descricao = :descricao")})
public class Raca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idraca")
    private Integer idraca;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_raca_especie", referencedColumnName = "idespecie")
    @ManyToOne
    private Especie idRacaEspecie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPetRaca")
    private Collection<Pet> petCollection;

    public Raca() {
    }

    public Raca(Integer idraca) {
        this.idraca = idraca;
    }

    public Integer getIdraca() {
        return idraca;
    }

    public void setIdraca(Integer idraca) {
        this.idraca = idraca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Especie getIdRacaEspecie() {
        return idRacaEspecie;
    }

    public void setIdRacaEspecie(Especie idRacaEspecie) {
        this.idRacaEspecie = idRacaEspecie;
    }

    @XmlTransient
    public Collection<Pet> getPetCollection() {
        return petCollection;
    }

    public void setPetCollection(Collection<Pet> petCollection) {
        this.petCollection = petCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idraca != null ? idraca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Raca)) {
            return false;
        }
        Raca other = (Raca) object;
        if ((this.idraca == null && other.idraca != null) || (this.idraca != null && !this.idraca.equals(other.idraca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Raca[ idraca=" + idraca + " ]";
    }
    
}
