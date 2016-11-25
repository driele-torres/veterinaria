/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mysql;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gmcore
 */
@Entity
@Table(name = "resultado_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoItem.findAll", query = "SELECT r FROM ResultadoItem r")
    , @NamedQuery(name = "ResultadoItem.findByIdresultadoItem", query = "SELECT r FROM ResultadoItem r WHERE r.idresultadoItem = :idresultadoItem")})
public class ResultadoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idresultado_item")
    private Integer idresultadoItem;
    @JoinColumn(name = "id_resultado_item", referencedColumnName = "iditem")
    @ManyToOne(optional = false)
    private Item idResultadoItem;

    public ResultadoItem() {
    }

    public ResultadoItem(Integer idresultadoItem) {
        this.idresultadoItem = idresultadoItem;
    }

    public Integer getIdresultadoItem() {
        return idresultadoItem;
    }

    public void setIdresultadoItem(Integer idresultadoItem) {
        this.idresultadoItem = idresultadoItem;
    }

    public Item getIdResultadoItem() {
        return idResultadoItem;
    }

    public void setIdResultadoItem(Item idResultadoItem) {
        this.idResultadoItem = idResultadoItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultadoItem != null ? idresultadoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoItem)) {
            return false;
        }
        ResultadoItem other = (ResultadoItem) object;
        if ((this.idresultadoItem == null && other.idresultadoItem != null) || (this.idresultadoItem != null && !this.idresultadoItem.equals(other.idresultadoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ResultadoItem[ idresultadoItem=" + idresultadoItem + " ]";
    }
    
}
