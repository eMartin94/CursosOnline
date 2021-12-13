package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.Date;

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
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "multimedia")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "MultimediaModel.findAll", query = "SELECT m FROM MultimediaModel m"),
	@NamedQuery(name = "MultimediaModel.findByIdMultimedia", query = "SELECT m FROM MultimediaModel m WHERE m.idMultimedia = :idMultimedia"),
	@NamedQuery(name = "MultimediaModel.findByDescripcion", query = "SELECT m FROM MultimediaModel m WHERE m.descripcion = :descripcion"),
	@NamedQuery(name = "MultimediaModel.findByFecSubida", query = "SELECT m FROM MultimediaModel m WHERE m.fecSubida = :fecSubida")		
})
public class MultimediaModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idMultimedia")
	private Integer idMultimedia;
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
		
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name = "fecSubida")
	private Date fecSubida;
		
    @JoinColumn(name = "cursos", referencedColumnName = "idCursos")
    @ManyToOne(optional = false)
    private CursosModel cursos;
	
	public MultimediaModel() {
		
	}
	
	public MultimediaModel(Integer idMultimedia) {
		this.idMultimedia = idMultimedia;
	}

	public MultimediaModel(Integer idMultimedia, String descripcion,
			Date fecSubida) {
		super();
		this.idMultimedia = idMultimedia;
		this.descripcion = descripcion;
		this.fecSubida = fecSubida;
	}

	public Integer getIdMultimedia() {
		return idMultimedia;
	}

	public void setIdMultimedia(Integer idMultimedia) {
		this.idMultimedia = idMultimedia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecSubida() {
		return fecSubida;
	}

	public void setFecSubida(Date fecSubida) {
		this.fecSubida = fecSubida;
	}

	public CursosModel getCursos() {
		return cursos;
	}

	public void setCursos(CursosModel cursos) {
		this.cursos = cursos;
	}
	
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MultimediaModel)) {
            return false;
        }
        MultimediaModel other = (MultimediaModel) object;
        if ((this.idMultimedia == null && other.idMultimedia != null) || (this.idMultimedia != null && !this.idMultimedia.equals(other.idMultimedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.MultimediaModel[ idMultimedia=" + idMultimedia + " ]";
    }
}

