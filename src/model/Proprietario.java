package model;

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


@Entity
@Table(name = "proprietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietario.findAll", query = "SELECT p FROM Proprietario p")
    , @NamedQuery(name = "Proprietario.findByIdproprietario", query = "SELECT p FROM Proprietario p WHERE p.idproprietario = :idproprietario")
    , @NamedQuery(name = "Proprietario.findByNome", query = "SELECT p FROM Proprietario p WHERE p.nome = :nome")
    , @NamedQuery(name = "Proprietario.findByEndereco", query = "SELECT p FROM Proprietario p WHERE p.endereco = :endereco")
    , @NamedQuery(name = "Proprietario.findByTelefone", query = "SELECT p FROM Proprietario p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Proprietario.findByCpf", query = "SELECT p FROM Proprietario p WHERE p.cpf = :cpf")})
public class Proprietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idproprietario")
    private Integer idproprietario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPetProprietario")
    private Collection<Pet> petCollection;

    public Proprietario() {
    }

    public Proprietario(Integer idproprietario) {
        this.idproprietario = idproprietario;
    }

    public Proprietario(Integer idproprietario, String cpf) {
        this.idproprietario = idproprietario;
        this.cpf = cpf;
    }

    public Integer getIdproprietario() {
        return idproprietario;
    }

    public void setIdproprietario(Integer idproprietario) {
        this.idproprietario = idproprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        hash += (idproprietario != null ? idproprietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proprietario)) {
            return false;
        }
        Proprietario other = (Proprietario) object;
        if ((this.idproprietario == null && other.idproprietario != null) || (this.idproprietario != null && !this.idproprietario.equals(other.idproprietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Proprietario[ idproprietario=" + idproprietario + " ]";
    }
    
}
