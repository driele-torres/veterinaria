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
@Table(name = "grupo_acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoAcesso.findAll", query = "SELECT g FROM GrupoAcesso g")
    , @NamedQuery(name = "GrupoAcesso.findByIdgrupoAcesso", query = "SELECT g FROM GrupoAcesso g WHERE g.idgrupoAcesso = :idgrupoAcesso")
    , @NamedQuery(name = "GrupoAcesso.findByDescricao", query = "SELECT g FROM GrupoAcesso g WHERE g.descricao = :descricao")})
public class GrupoAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idgrupo_acesso")
    private Integer idgrupoAcesso;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idUsuarioGrupoAcesso")
    private Collection<Usuario> usuarioCollection;

    public GrupoAcesso() {
    }

    public GrupoAcesso(Integer idgrupoAcesso) {
        this.idgrupoAcesso = idgrupoAcesso;
    }

    public Integer getIdgrupoAcesso() {
        return idgrupoAcesso;
    }

    public void setIdgrupoAcesso(Integer idgrupoAcesso) {
        this.idgrupoAcesso = idgrupoAcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoAcesso != null ? idgrupoAcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoAcesso)) {
            return false;
        }
        GrupoAcesso other = (GrupoAcesso) object;
        if ((this.idgrupoAcesso == null && other.idgrupoAcesso != null) || (this.idgrupoAcesso != null && !this.idgrupoAcesso.equals(other.idgrupoAcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.GrupoAcesso[ idgrupoAcesso=" + idgrupoAcesso + " ]";
    }
    
}
