/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mysql;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e")
    , @NamedQuery(name = "Exame.findByIdexame", query = "SELECT e FROM Exame e WHERE e.idexame = :idexame")
    , @NamedQuery(name = "Exame.findByNome", query = "SELECT e FROM Exame e WHERE e.nome = :nome")
    , @NamedQuery(name = "Exame.findByArea", query = "SELECT e FROM Exame e WHERE e.area = :area")})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idexame")
    private Integer idexame;
    @Column(name = "nome")
    private String nome;
    @Column(name = "area")
    private String area;
    @OneToMany(mappedBy = "idConsultaExame")
    private Collection<ConsultaExame> consultaExameCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItemExame")
    private Collection<Item> itemCollection;

    public Exame() {
    }

    public Exame(Integer idexame) {
        this.idexame = idexame;
    }

    public Integer getIdexame() {
        return idexame;
    }

    public void setIdexame(Integer idexame) {
        this.idexame = idexame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<ConsultaExame> getConsultaExameCollection() {
        return consultaExameCollection;
    }

    public void setConsultaExameCollection(Collection<ConsultaExame> consultaExameCollection) {
        this.consultaExameCollection = consultaExameCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexame != null ? idexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.idexame == null && other.idexame != null) || (this.idexame != null && !this.idexame.equals(other.idexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Exame[ idexame=" + idexame + " ]";
    }
    
}
