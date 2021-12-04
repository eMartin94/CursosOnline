package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CursosModel.findAll", query = "SELECT c FROM CursosModel c"),
	@NamedQuery(name = "CursosModel.findByIdCursos", query = "SELECT c FROM CursosModel c WHERE c.idCursos = :idCursos"),
	@NamedQuery(name = "CursosModel.findByNomCurso", query = "SELECT c FROM CursosModel c WHERE c.nomCurso = :nomCurso"),
	@NamedQuery(name = "CursosModel.findByDescripCurso", query = "SELECT c FROM CursosModel c WHERE c.descripCurso = :descripCurso"),
	@NamedQuery(name = "CursosModel.findByPrecio", query = "SELECT c FROM CursosModel c WHERE c.precio = :precio")	
})
public class CursosModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCursos")
	private Integer idCursos;
	
	@Basic(optional = false)
	@Column(name = "nomCurso")
	private String nomCurso;
	
	@Basic(optional = false)
	@Column(name = "descripCurso")
	private String descripCurso;
	
	@Basic(optional = false)
	@Column(name = "precio")
	private String precio;
	
	@JoinColumn(name = "categoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private CategoriaModel categoria;
	
	public CursosModel() {
	}
	
	public CursosModel(Integer idCursos) {
		this.idCursos = idCursos;
	}
	
	public CursosModel(Integer idCursos, String nomCurso, String descripCurso, String precio) {
//		super();
		this.idCursos = idCursos;
		this.nomCurso = nomCurso;
		this.descripCurso = descripCurso;
		this.precio = precio;
	}


	public Integer getIdCursos() {
		return idCursos;
	}

	public void setIdCursos(Integer idCursos) {
		this.idCursos = idCursos;
	}

	public String getNomCurso() {
		return nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public String getDescripCurso() {
		return descripCurso;
	}

	public void setDescripCurso(String descripCurso) {
		this.descripCurso = descripCurso;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosModel)) {
            return false;
        }
        CursosModel other = (CursosModel) object;
        if ((this.idCursos == null && other.idCursos != null) || (this.idCursos != null && !this.idCursos.equals(other.idCursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.CursosModel[ idCursos=" + idCursos + " ]";
    }
	
}
