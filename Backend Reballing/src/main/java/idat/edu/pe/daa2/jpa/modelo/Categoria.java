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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
, @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria")
, @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.Nombre = :Nombre")})

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Integer idCategoria;
	@Basic(optional = false)
	@Column(name = "Nombre")
	private String Nombre;
	
	public Categoria() {
	 }

	 public Categoria(Integer idCategoria) {
		 this.idCategoria = idCategoria;
	 }
	 
	 public Categoria(Integer idCategoria, String Nombre) {
	     this.idCategoria= idCategoria;
	     this.Nombre = Nombre;
	 }

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	 
	@Override
	 public boolean equals(Object object) {
		 // TODO: Warning - this method won't work in the case the id fields are not set
		 if (!(object instanceof Categoria)) {
			 return false;
		 }
		 Categoria other = (Categoria) object;
		 if ((this.idCategoria== null && other.idCategoria!= null) || (this.idCategoria!= null && !this.idCategoria.equals(other.idCategoria))) {
			 return false;
		 }
		 return true;
	 }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Categoria[ idCategoria =" + idCategoria + " ]";
    }

	public Categoria buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
