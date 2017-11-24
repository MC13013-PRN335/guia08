package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoPostRestClient;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Named(value = "frmTipoPost")
@RequestScoped
public class FrmTipoPost implements Serializable {
    private String filtro;
    private List<TipoPost> tipoPostActuales;

    @Inject
    private TipoPostRestClient cliente;
    
    public FrmTipoPost() {
    }
    
    @PostConstruct
    private void prueba() {
        filtro = "";
        getTipoPostFromServer();
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    public String getEstadoConteo() {
        if(tipoPostActuales.isEmpty()) {
            return "No se han encontrado coincidencias";
        }
        else {
            return "Elementos encontrados: " + tipoPostActuales.size();
        }
    }
    
    public List<TipoPost> getTipoPostActuales() {
        return tipoPostActuales;
    }
    
    public void getTipoPostFromServer() {
        if(filtro.trim().equals("")) {
            tipoPostActuales = cliente.findAll();
        }
        else {
            tipoPostActuales = cliente.findLike(filtro);
        }
    }
}
