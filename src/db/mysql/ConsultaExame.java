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
@Table(name = "consulta_exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaExame.findAll", query = "SELECT c FROM ConsultaExame c")
    , @NamedQuery(name = "ConsultaExame.findByIdconsultaExame", query = "SELECT c FROM ConsultaExame c WHERE c.idconsultaExame = :idconsultaExame")})
public class ConsultaExame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idconsulta_exame")
    private Integer idconsultaExame;
    @JoinColumn(name = "id_consulta_exame", referencedColumnName = "idexame")
    @ManyToOne
    private Exame idConsultaExame;
    @JoinColumn(name = "id_consulta_prontuario", referencedColumnName = "idprontuario")
    @ManyToOne(optional = false)
    private Prontuario idConsultaProntuario;

    public ConsultaExame() {
    }

    public ConsultaExame(Integer idconsultaExame) {
        this.idconsultaExame = idconsultaExame;
    }

    public Integer getIdconsultaExame() {
        return idconsultaExame;
    }

    public void setIdconsultaExame(Integer idconsultaExame) {
        this.idconsultaExame = idconsultaExame;
    }

    public Exame getIdConsultaExame() {
        return idConsultaExame;
    }

    public void setIdConsultaExame(Exame idConsultaExame) {
        this.idConsultaExame = idConsultaExame;
    }

    public Prontuario getIdConsultaProntuario() {
        return idConsultaProntuario;
    }

    public void setIdConsultaProntuario(Prontuario idConsultaProntuario) {
        this.idConsultaProntuario = idConsultaProntuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsultaExame != null ? idconsultaExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaExame)) {
            return false;
        }
        ConsultaExame other = (ConsultaExame) object;
        if ((this.idconsultaExame == null && other.idconsultaExame != null) || (this.idconsultaExame != null && !this.idconsultaExame.equals(other.idconsultaExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ConsultaExame[ idconsultaExame=" + idconsultaExame + " ]";
    }
    
}
