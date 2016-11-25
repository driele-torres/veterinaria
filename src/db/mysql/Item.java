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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByIditem", query = "SELECT i FROM Item i WHERE i.iditem = :iditem")
    , @NamedQuery(name = "Item.findByNome", query = "SELECT i FROM Item i WHERE i.nome = :nome")
    , @NamedQuery(name = "Item.findByReferencia", query = "SELECT i FROM Item i WHERE i.referencia = :referencia")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iditem")
    private Integer iditem;
    @Column(name = "nome")
    private String nome;
    @Column(name = "referencia")
    private String referencia;
    @JoinColumn(name = "id_item_exame", referencedColumnName = "idexame")
    @ManyToOne(optional = false)
    private Exame idItemExame;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoItem")
    private Collection<ResultadoItem> resultadoItemCollection;

    public Item() {
    }

    public Item(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Exame getIdItemExame() {
        return idItemExame;
    }

    public void setIdItemExame(Exame idItemExame) {
        this.idItemExame = idItemExame;
    }

    @XmlTransient
    public Collection<ResultadoItem> getResultadoItemCollection() {
        return resultadoItemCollection;
    }

    public void setResultadoItemCollection(Collection<ResultadoItem> resultadoItemCollection) {
        this.resultadoItemCollection = resultadoItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Item[ iditem=" + iditem + " ]";
    }
    
}
