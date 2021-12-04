package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CategoriaModel.findAll", query = "SELECT c FROM CategoriaModel c"),
	@NamedQuery(name = "CategoriaModel.findByIdCategoria", query = "SELECT c FROM CategoriaModel c WHERE c.idCategoria = :idCategoria"),
	@NamedQuery(name = "CategoriaModel.findByNomCategoria", query = "SELECT c FROM CategoriaModel c WHERE c.nomCategoria = :nomCategoria"),
})
public class CategoriaModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCategoria")
	private Integer idCategoria;
	
	@Basic(optional = false)
	@Column(name = "nomCategoria")
	private String nomCategoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria", fetch=FetchType.LAZY)
	@JsonBackReference(value = "categoria_cursos")
	private List<CursosModel> cursosList;

	public CategoriaModel() {
		
	}
	
	public CategoriaModel(Integer idCategoria, String string, String string2) {
	    this.idCategoria = idCategoria;
	}
	
	public CategoriaModel(Integer idCategoria, String nomCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomCategoria = nomCategoria;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	@XmlTransient
	public List<CursosModel> getCursosList() {
		return cursosList;
	}

	public void setCursosList(List<CursosModel> cursosList) {
		this.cursosList = cursosList;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCategoria != null ? idCategoria.hashCode() : 0);
		return hash;
		
	}
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof CategoriaModel)) {
			return false;
		}
		CategoriaModel other = (CategoriaModel) object;
		if((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && this.idCategoria.equals(other.idCategoria))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "idat.edu.pe.daa2.jpa.modelo.CategoriaModel[idCategoria=" + idCategoria + "]";
	}
	
	public CategoriaModel buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
