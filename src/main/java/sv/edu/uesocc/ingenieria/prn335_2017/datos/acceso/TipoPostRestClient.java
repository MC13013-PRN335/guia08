package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Stateless
public class TipoPostRestClient {
    
    public List<TipoPost> findAll() {
        Client cliente = crearCliente();
        WebTarget path = cliente.target(Configuracion.getUrlBase()).path("/");
        List<TipoPost> valores = path.request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<TipoPost>>(){});
        
        return valores;
    }
    
    public List<TipoPost> findLike(String query) {
        Client cliente = crearCliente();
        WebTarget path = cliente.target(Configuracion.getUrlBase()).path("like/" + query);
        List<TipoPost> valores = path.request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<TipoPost>>(){});
        
        return valores;
    }
    
    private Client crearCliente() {
        return ClientBuilder.newClient();
    }
}
