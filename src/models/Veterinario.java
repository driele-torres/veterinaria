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
@Table(name = "veterinario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veterinario.findAll", query = "SELECT v FROM Veterinario v")
    , @NamedQuery(name = "Veterinario.findByIdveterinario", query = "SELECT v FROM Veterinario v WHERE v.idveterinario = :idveterinario")
    , @NamedQuery(name = "Veterinario.findByCrv", query = "SELECT v FROM Veterinario v WHERE v.crv = :crv")
    , @NamedQuery(name = "Veterinario.findByEspecialidade", query = "SELECT v FROM Veterinario v WHERE v.especialidade = :especialidade")})
public class Veterinario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idveterinario")
    private Integer idveterinario;
    @Column(name = "crv")
    private String crv;
    @Column(name = "especialidade")
    private String especialidade;
    @OneToMany(mappedBy = "idProntuarioVeterinario")
    private Collection<Prontuario> prontuarioCollection;
    @JoinColumn(name = "id_veterinario_usuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idVeterinarioUsuario;

    public Veterinario() {
    }

    public Veterinario(Integer idveterinario) {
        this.idveterinario = idveterinario;
    }

    public Integer getIdveterinario() {
        return idveterinario;
    }

    public void setIdveterinario(Integer idveterinario) {
        this.idveterinario = idveterinario;
    }

    public String getCrv() {
        return crv;
    }

    public void setCrv(String crv) {
        this.crv = crv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @XmlTransient
    public Collection<Prontuario> getProntuarioCollection() {
        return prontuarioCollection;
    }

    public void setProntuarioCollection(Collection<Prontuario> prontuarioCollection) {
        this.prontuarioCollection = prontuarioCollection;
    }

    public Usuario getIdVeterinarioUsuario() {
        return idVeterinarioUsuario;
    }

    public void setIdVeterinarioUsuario(Usuario idVeterinarioUsuario) {
        this.idVeterinarioUsuario = idVeterinarioUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idveterinario != null ? idveterinario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veterinario)) {
            return false;
        }
        Veterinario other = (Veterinario) object;
        if ((this.idveterinario == null && other.idveterinario != null) || (this.idveterinario != null && !this.idveterinario.equals(other.idveterinario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Veterinario[ idveterinario=" + idveterinario + " ]";
    }
    
}
