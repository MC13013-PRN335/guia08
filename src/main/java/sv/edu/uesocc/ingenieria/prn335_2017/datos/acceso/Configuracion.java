package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

public class Configuracion {
    
    public static String getUrlBase() {
        String url = System.getenv("URL_SERVER");
        if(url ==  null) {
            return "http://localhost:8080/RestServer/guia8/tipopost/";
        }
        else return url;
    }
}
