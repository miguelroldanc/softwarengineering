package ugr.es;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pregunta {
    
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String correcta;

    public Pregunta(){}
    
    public Pregunta(String pregunta, String r1, String r2, String r3, String r4, String correcta) {
        this.pregunta = pregunta;
        this.respuesta1 = r1;
        this.respuesta2 = r2;
        this.respuesta3 = r3;
        this.respuesta4 = r4;
        this.correcta = correcta;
    }
    
}
