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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "UsuarioModel.findAll", query = "SELECT u FROM UsuarioModel u"),
	@NamedQuery(name = "UsuarioModel.findByIdUsuario", query = "SELECT u FROM UsuarioModel u WHERE u.idUsuario = :idUsuario"),
	@NamedQuery(name = "UsuarioModel.findByNombre", query = "SELECT u FROM UsuarioModel u WHERE u.nombre = :nombre"),
	@NamedQuery(name = "UsuarioModel.findByNomUsuario", query = "SELECT u FROM UsuarioModel u WHERE u.nomUsuario = :nomUsuario"),
	@NamedQuery(name = "UsuarioModel.findByCorreo", query = "SELECT u FROM UsuarioModel u WHERE u.correo = :correo"),
	@NamedQuery(name = "UsuarioModel.findByContrasena", query = "SELECT u FROM UsuarioModel u WHERE u.contrasena = :contrasena"),	
	@NamedQuery(name = "UsuarioModel.findByFecRegistro", query = "SELECT u FROM UsuarioModel u WHERE u.fecRegistro = :fecRegistro"),	
	@NamedQuery(name = "UsuarioModel.findByFecNacimiento", query = "SELECT u FROM UsuarioModel u WHERE u.fecNacimiento = :fecNacimiento"),	
	@NamedQuery(name = "UsuarioModel.findBySexo", query = "SELECT u FROM UsuarioModel u WHERE u.sexo = :sexo")	
})
public class UsuarioModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idUsuario")
	private Integer idUsuario;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name = "nomUsuario")
	private String nomUsuario;
	
	@Basic(optional = false)
	@Column(name = "correo")
	private String correo;
	
	@Basic(optional = false)
	@Column(name = "contrasena")
	private String contrasena;
	
//	@Basic(optional = false)
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name = "fecRegistro")
	private Date fecRegistro;
	
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "fecNacimiento")
	private Date fecNacimiento;
	
	@Basic(optional = false)
	@Column(name = "sexo")
	private String sexo;
	
	@JoinColumn(name = "permisos", referencedColumnName = "idPermisos")
    @ManyToOne(optional = false)
    private PermisosModel permisos;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UsuarioModel(Integer idUsuario, String nombre, String nomUsuario, String correo, String contrasena,
			Date fecRegistro, Date fecNacimiento, String sexo) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nomUsuario = nomUsuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fecRegistro = fecRegistro;
		this.fecNacimiento = fecNacimiento;
		this.sexo = sexo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public PermisosModel getPermisos() {
		return permisos;
	}

	public void setPermisos(PermisosModel permisos) {
		this.permisos = permisos;
	}
	
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioModel)) {
            return false;
        }
        UsuarioModel other = (UsuarioModel) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.UsuarioModel[ idUsuario=" + idUsuario + " ]";
    }
}
