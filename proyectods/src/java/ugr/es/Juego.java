package ugr.es;

import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Juego {
    private Ranking ranking;
    private ArrayList<Pregunta> preguntas;
    private String idSesion;
    
    public Juego(){}
    public Juego(ArrayList<Pregunta> preguntas, String idSesion){
        this.preguntas = new ArrayList<>();
        this.preguntas = (ArrayList<Pregunta>) preguntas.clone();
        this.idSesion = idSesion;
        this.ranking = new Ranking();
    }
    
    public String getIdSesion() {
        return this.idSesion;
    }
    
    public HashMap<String, Integer> obtenerRanking() {
        return this.ranking.getRanking();
    }
    
    public ArrayList<Pregunta> obtenerPreguntas() {
        return this.preguntas;
    }
    
    public void addJugador(String usuario) {
        this.ranking.addUser(usuario);
    }
    
    public void aumentarPuntuacion(String usuario) {
        this.ranking.aumentar(usuario);
    }
}
