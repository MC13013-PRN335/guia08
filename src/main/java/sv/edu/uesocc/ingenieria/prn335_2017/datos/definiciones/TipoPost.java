package sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones;

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
import javax.xml.bind.annotation.XmlTransient;


/**
 *  Para el querie TipoPost.findUsados se asume que "usados" se refiere a que esta
 *  relacionado al menos 1 vez en la tabla 'Post' o en la tabla 'TipoPostSeccion'
 */
@Entity
@Table(name = "tipo_post", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPost.findAll", query = "SELECT t FROM TipoPost t")
    , @NamedQuery(name = "TipoPost.findByIdTipoPost", query = "SELECT t FROM TipoPost t WHERE t.idTipoPost = :idTipoPost")
    , @NamedQuery(name = "TipoPost.findByNombre", query = "SELECT t FROM TipoPost t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoPost.findByActivo", query = "SELECT t FROM TipoPost t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoPost.findByDescripcion", query = "SELECT t FROM TipoPost t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoPost.findUsados", query = "SELECT t FROM TipoPost t WHERE t.idTipoPost IN (SELECT DISTINCT t1.idTipoPost FROM TipoPost t1 JOIN t1.postList p) "
            + "OR t.idTipoPost IN (SELECT DISTINCT t1.idTipoPost FROM TipoPost t1 JOIN t1.tipoPostSeccionList tps)")
})
public class TipoPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_post")
    private Integer idTipoPost;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPost")
    private List<TipoPostSeccion> tipoPostSeccionList;
    @OneToMany(mappedBy = "idTipoPost")
    private List<Post> postList;

    public TipoPost() {
    }

    public TipoPost(Integer idTipoPost) {
        this.idTipoPost = idTipoPost;
    }

    public TipoPost(Integer idTipoPost, String nombre) {
        this.idTipoPost = idTipoPost;
        this.nombre = nombre;
    }

    public Integer getIdTipoPost() {
        return idTipoPost;
    }

    public void setIdTipoPost(Integer idTipoPost) {
        this.idTipoPost = idTipoPost;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TipoPostSeccion> getTipoPostSeccionList() {
        return tipoPostSeccionList;
    }

    public void setTipoPostSeccionList(List<TipoPostSeccion> tipoPostSeccionList) {
        this.tipoPostSeccionList = tipoPostSeccionList;
    }

    @XmlTransient
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPost != null ? idTipoPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPost)) {
            return false;
        }
        TipoPost other = (TipoPost) object;
        if ((this.idTipoPost == null && other.idTipoPost != null) || (this.idTipoPost != null && !this.idTipoPost.equals(other.idTipoPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.prn335.basedatos.TipoPost[ idTipoPost=" + idTipoPost + " ]";
    }
    
}
