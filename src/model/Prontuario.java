package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "prontuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prontuario.findAll", query = "SELECT p FROM Prontuario p")
    , @NamedQuery(name = "Prontuario.findByIdprontuario", query = "SELECT p FROM Prontuario p WHERE p.idprontuario = :idprontuario")
    , @NamedQuery(name = "Prontuario.findByData", query = "SELECT p FROM Prontuario p WHERE p.data = :data")
    , @NamedQuery(name = "Prontuario.findByObservacao", query = "SELECT p FROM Prontuario p WHERE p.observacao = :observacao")
    , @NamedQuery(name = "Prontuario.findByRealizado", query = "SELECT p FROM Prontuario p WHERE p.realizado = :realizado")})
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idprontuario")
    private Integer idprontuario;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "realizado")
    private Boolean realizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultaProntuario")
    private Collection<ConsultaExame> consultaExameCollection;
    @JoinColumn(name = "id_prontuario_pet", referencedColumnName = "idpet")
    @ManyToOne
    private Pet idProntuarioPet;
    @JoinColumn(name = "id_prontuario_veterinario", referencedColumnName = "idveterinario")
    @ManyToOne
    private Veterinario idProntuarioVeterinario;

    public Prontuario() {
    }

    public Prontuario(Integer idprontuario) {
        this.idprontuario = idprontuario;
    }

    public Integer getIdprontuario() {
        return idprontuario;
    }

    public void setIdprontuario(Integer idprontuario) {
        this.idprontuario = idprontuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    @XmlTransient
    public Collection<ConsultaExame> getConsultaExameCollection() {
        return consultaExameCollection;
    }

    public void setConsultaExameCollection(Collection<ConsultaExame> consultaExameCollection) {
        this.consultaExameCollection = consultaExameCollection;
    }

    public Pet getIdProntuarioPet() {
        return idProntuarioPet;
    }

    public void setIdProntuarioPet(Pet idProntuarioPet) {
        this.idProntuarioPet = idProntuarioPet;
    }

    public Veterinario getIdProntuarioVeterinario() {
        return idProntuarioVeterinario;
    }

    public void setIdProntuarioVeterinario(Veterinario idProntuarioVeterinario) {
        this.idProntuarioVeterinario = idProntuarioVeterinario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprontuario != null ? idprontuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prontuario)) {
            return false;
        }
        Prontuario other = (Prontuario) object;
        if ((this.idprontuario == null && other.idprontuario != null) || (this.idprontuario != null && !this.idprontuario.equals(other.idprontuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Prontuario[ idprontuario=" + idprontuario + " ]";
    }
    
}
