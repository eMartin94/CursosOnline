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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PermisosModel.findAll", query = "SELECT p FROM PermisosModel p"),
	@NamedQuery(name = "PermisosModel.findByIdPermisos", query = "SELECT p FROM PermisosModel p WHERE p.idPermisos = :idPermisos"),
	@NamedQuery(name = "PermisosModel.findByNomPermiso", query = "SELECT p FROM PermisosModel p WHERE p.nomPermiso = :nomPermiso"),
	
})
public class PermisosModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idPermisos")
	private Integer idPermisos;
	
	@Basic(optional = false)
	@Column(name = "nomPermiso")
	private String nomPermiso;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "permisos", fetch=FetchType.LAZY)
	@JsonBackReference(value = "permisos_usuario")
	private List<UsuarioModel> usuarioList;
	
	public PermisosModel() {
		
	}

	public PermisosModel(Integer idPermisos, String nomPermiso) {
		super();
		this.idPermisos = idPermisos;
		this.nomPermiso = nomPermiso;
	}

	public Integer getIdPermisos() {
		return idPermisos;
	}

	public void setIdPermisos(Integer idPermisos) {
		this.idPermisos = idPermisos;
	}

	public String getNomPermiso() {
		return nomPermiso;
	}

	public void setNomPermiso(String nomPermiso) {
		this.nomPermiso = nomPermiso;
	}

	public List<UsuarioModel> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<UsuarioModel> usuarioList) {
		this.usuarioList = usuarioList;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPermisos != null ? idPermisos.hashCode() : 0);
		return hash;
		
	}
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof PermisosModel)) {
			return false;
		}
		PermisosModel other = (PermisosModel) object;
		if((this.idPermisos == null && other.idPermisos != null) || (this.idPermisos != null && this.idPermisos.equals(other.idPermisos))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "idat.edu.pe.daa2.jpa.modelo.PermisosModel[idPermisos=" + idPermisos + "]";
	}
	
	public PermisosModel buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
