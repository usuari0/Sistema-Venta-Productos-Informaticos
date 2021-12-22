package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tipo_usuario")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Tipo_usuario.findAll", query = "SELECT t FROM Tipo_usuario t")
, @NamedQuery(name = "Tipo_usuario.findByIdTipo_usuario", query = "SELECT t FROM Tipo_usuario t WHERE t.idTipo_usuario = :idTipo_usuario")
, @NamedQuery(name = "Tipo_usuario.findByCargo", query = "SELECT t FROM Tipo_usuario t WHERE t.Cargo = :Cargo")})

public class Tipo_usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Integer idTipo_usuario;
	@Basic(optional = false)
	@Column(name = "Cargo")
	private String Cargo;
	
	public Tipo_usuario() {
	 }

	 public Tipo_usuario(Integer idTipo_usuario) {
		 this.idTipo_usuario = idTipo_usuario;
	 }
	 
	 public Tipo_usuario(Integer idTipo_usuario, String Cargo) {
	     this.idTipo_usuario= idTipo_usuario;
	     this.Cargo = Cargo;
	 }

	public Integer getIdTipo_usuario() {
		return idTipo_usuario;
	}

	public void setIdTipo_usuario(Integer idTipo_usuario) {
		this.idTipo_usuario = idTipo_usuario;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	 
	@Override
	 public boolean equals(Object object) {
		 // TODO: Warning - this method won't work in the case the id fields are not set
		 if (!(object instanceof Tipo_usuario)) {
			 return false;
		 }
		 Tipo_usuario other = (Tipo_usuario) object;
		 if ((this.idTipo_usuario== null && other.idTipo_usuario!= null) || (this.idTipo_usuario!= null && !this.idTipo_usuario.equals(other.idTipo_usuario))) {
			 return false;
		 }
		 return true;
	 }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Tipo_usuario[ idTipo_usuario =" + idTipo_usuario + " ]";
    }

	public Tipo_usuario buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
