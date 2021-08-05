package ugr.es;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ranking {
    private HashMap<String, Integer> ranking;
    
    public Ranking(){
        this.ranking = new HashMap<>();
    }
    public HashMap<String, Integer> getRanking(){
        return this.ranking;
    }
    public void setRanking(HashMap<String, Integer> ranking) {
        this.ranking = ranking;
    }
    public void aumentar(String usuario) {
        this.ranking.put(usuario, this.ranking.get(usuario) + 1);
    }
    public void addUser(String usuario) {
        this.ranking.put(usuario, 0);
    }
}
