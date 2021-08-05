package ugr.es;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("QuizzMe")
public class Servicio {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello Plain";
    }

    @GET
    @Path("hello2")
    public String sayPlainTextHello2() {
        return "jolines";
    }
    
    
    private static ArrayList<Juego> juegos = new ArrayList<>();
    private static int idJuegoServicio = 0;
    
    private static int encontrarPartida(String id){
        int pos = -1;
        int tamJuegos = juegos.size();
        for(int i=0;i < tamJuegos;i++){
            if( id.equals(juegos.get(i).getIdSesion()) ){
                pos = i;
            }
        }
        return pos;
    }
    private static ArrayList<Pregunta> geografia = new ArrayList<>();
    private static ArrayList<Pregunta> historia = new ArrayList<>();
    private static ArrayList<Pregunta> musica = new ArrayList<>();
    private static ArrayList<Pregunta> deportes = new ArrayList<>();


    static {
        // Geografía
        Servicio.geografia.add(new Pregunta("¿Cual es la capital de la República de Bolivia?", "Sucre", "Bogotá", "Montevideo", "Asunción", "1"));
        Servicio.geografia.add(new Pregunta("¿Cual es la capital de Bangladesh?", "Roma", "Estocolmo", "Dacca", "Madrid", "3"));
        Servicio.geografia.add(new Pregunta("¿De qué colores es la bandera de Rusia?", "Amarillo y rojo", "Negro y verde", "Blanco, azul y rojo", "Roja", "3"));
        Servicio.geografia.add(new Pregunta("¿Dónde se encuentra la ciudad de Bolzano (Bozen)?", "En la suiza italiana", "Al norte de Italia", "Al este de Benimaclet", "En la región de Alsacia", "2"));
        Servicio.geografia.add(new Pregunta("¿Qué es el Som Kirguís?", "La moneda oficial en Kirguistán", "El primer presidente democrático de Kirguistán", "Un baile tradicional de Somalia", "Una provincia de Kirguistán", "1"));
        Servicio.geografia.add(new Pregunta("¿Qué río atraviesa la ciudad de Burgos dividiéndola en dos?", "Río Arlanzón", "Río Duratón", "Río Adaja", "Río Arlanza", "1"));
        Servicio.geografia.add(new Pregunta("¿Qué animal aparece en el anverso del escudo de los Estados Unidos de América?", "Hurón", "Águila", "Nutria", "Oso pardo", "2"));
        Servicio.geografia.add(new Pregunta("¿Cual es la capital del Sultanato de Omán?", "Riad", "Caracas", "París", "Mascate", "4"));
        Servicio.geografia.add(new Pregunta("¿Dónde se encuentra en río Yenisei?", "En China", "En Rusia", "En India", "En Corea", "2"));
        Servicio.geografia.add(new Pregunta("¿Cuántos distritos tiene la ciudad de Nueva York?", "5", "3", "2", "4", "5"));

        // Historia
        Servicio.historia.add(new Pregunta("¿Quién proclamó la República Popular de China y fue su líder máximo hasta 1976?", "Confucio", "Sun Yat-sen", "Mao Tse-Tung", "Chiang Kai-shek", "3"));
        Servicio.historia.add(new Pregunta("¿Qué Papa convocó Las Cruzadas?", "Inocencio XI", "Urbano II", "Clemente X", "Benedi", "2"));
        Servicio.historia.add(new Pregunta("¿Cómo se llamaban las tropas que envió Franco para apoyar a Hitler en la campaña de Rusia?", "Comando Hendaya", "División Azul", "División Cóndor", "Comando Franco", "2"));
        Servicio.historia.add(new Pregunta("¿Quién creó el Ejército Rojo de la Unión Soviética?", "Vladimir Ilyich Lenin", "Iósif Stalin", "León Trotsky", "Ivan el Terrible", "3"));
        Servicio.historia.add(new Pregunta("Durante la Segunda Guerra Mundial ¿Cuál de los siguientes países perteneció a las Potencias Aliadas?", "Japón", "Alemania", "Italia", "Francia", "4"));
        Servicio.historia.add(new Pregunta("¿Quién es el actual presidente de Francia?", "Michelle Bachelet Jeria", "Emmanuel Macron", "Evo Morales Ayma", "Nicolas Sarkozy", "2"));
        Servicio.historia.add(new Pregunta("¿Cuál es el nombre oficial de la constitución Mexicana?", "Constitución Revolucionaria Mexicana", "Real Co", "Constitución Mexicana de 1857", "Constitución Política de los Estados Unidos Mexicanos que reforma la del 5 de febrero de 1857", "4"));
        Servicio.historia.add(new Pregunta("¿Qué es Hezbolá?", "La Organización para la Liberación de Palestina", "Un partido político israelí", "Una organización terrorista egipcia", "Una organización política y paramilitar libanesa", "4"));
        Servicio.historia.add(new Pregunta("¿En qué guerra luchó la URSS durante el mandato de Iósif Stalin?", "Guerra de los Balcanes", "Guerra de Afganistán", "II Guerra Mundial", "I Guerra Mundial", "3"));
        Servicio.historia.add(new Pregunta("¿En qué guerra luchó la URSS durante el mandato de Iósif Stalin?", "La gaditana", "La Consti", "Constitucioncilla", "La Pepa", "4"));


        // Música
        Servicio.musica.add(new Pregunta("¿A qué cantante de los 70 debemos la canción I Will Survive?", "Glenn Frey", "Tina Turner", "Gloria Gaynor", "Donna Summer", "3"));
        Servicio.musica.add(new Pregunta("¿De quién es el álbum Depende (1998)?", "Dover", "Dinamita pa los pollos", "Efecto mariposa", "Jarabe de Palo", "4"));
        Servicio.musica.add(new Pregunta("¿En qué año nació la cantante Madonna?", "1961", "1958", "1952", "1950", "2"));
        Servicio.musica.add(new Pregunta("¿Cómo se tituló el primer álbum de Enrique Iglesias?", "Experiencia religiosa", "Enrique Iglesias", "Por amarte", "Trapecista", "2"));
        Servicio.musica.add(new Pregunta("¿En qué ópera de Georges Bizet se narran los amores de una gitana empleada en una fábrica de tabaco?", "Madame Butterfly", "La flauta mágica", "El barbero de Sevilla", "Carmen", "4"));
        Servicio.musica.add(new Pregunta("¿De quién son las Cuatro Estaciones?", "Vivaldi", "Beethoven", "Bach", "Mozart", "1"));
        Servicio.musica.add(new Pregunta("¿Quién es Whitney Houston?", "Cantante de gospel de origen africano", "Vocalista del grupo Eurythmics", "Cantante estadounidense protagonista de 'El guardaespaldas'", "Vocalista del grupo Abba", "2"));
        Servicio.musica.add(new Pregunta("¿En qué año lanzó Madonna Ray of Light?", "1991", "1996", "2004", "1998", "4"));
        Servicio.musica.add(new Pregunta("¿Cómo se llama el fundador de Iron Maiden?", "Brian May", "Joey Ramone", "Steve Harris", "Sid Vicious", "3"));
        Servicio.musica.add(new Pregunta("¿Quién fue Juanito Valderrama?", "Percusionista, tocaba el cajón flamenco", "Guitarrista flamenco", "Cantaor flamenco", "Bailaor flamenco", "3"));

        // Deportes
        Servicio.deportes.add(new Pregunta("¿Quién es Mike Powell?", "Saltador de altura y plusmarquista mundial con 2,46 centímetros", "Jugador de la NBA en los Boston Celtics", "Saltador de longitud que batió el record impuesto por Bob Beamon", "Plusmarquista mundial de maratón", "3"));
        Servicio.deportes.add(new Pregunta("¿De qué nacionalidad es el corredor de media distancia Saïd Aouita?", "Marruecos", "Senegal", "Camerún", "Etiopía", "1"));
        Servicio.deportes.add(new Pregunta("¿De qué país es el equipo de fútbol Juventus?", "Francia", "Italia", "Alemania", "Grecia", "2"));
        Servicio.deportes.add(new Pregunta("¿En qué deporte destaca Johan Santana?", "Fútbol", "Tenis", "Balonmano", "Béisbol", "4"));
        Servicio.deportes.add(new Pregunta("¿Qué piloto ha ganado más veces seguidas el Campeonato Mundial de Rally?", "Sébastien Loeb", "Tommi Mäkinen", "Fernando Alonso", "Carlos Sainz", "1"));
        Servicio.deportes.add(new Pregunta("¿Cómo se llaman los agujeros de arena de los campos de golf?", "Rough", "Bunker", "Water hazard", "Fairway", "2"));
        Servicio.deportes.add(new Pregunta("¿Con qué tipo de pelota se juega al padel?", "Ninguna de las tres", "Como la de tenis", "Como la de baloncesto", "Como la de golf", "2"));
        Servicio.deportes.add(new Pregunta("¿Cuántas veces ganó Federico Martín Bahamontes la clasificación de la montaña en el Tour de Francia?", "3 veces", "6 veces", "10 veces", "5 veces", "2"));
        Servicio.deportes.add(new Pregunta("¿Qué jugador de béisbol tiene el record de home runs en una temporada en las Grandes Ligas?", "Miguel Cabrera", "Ichiru Zuzuki", "Samy Sosa", "Barry Bong", "4"));
        Servicio.deportes.add(new Pregunta("¿Cuantos juegos tiene un set en un partido de tenis?", "2", "4", "6", "5", "3"));

    }
    
    
    
    @PUT
    @Path("/crear")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String crearPartida(@QueryParam("numPreguntas") int numPreguntas, @QueryParam("tema1") String tema1, @QueryParam("tema2") String tema2, @QueryParam("tema3") String tema3, @QueryParam("tema4") String tema4) {
        int contador = 0;
        boolean t1, t2, t3, t4;
        t1 = tema1.equals("0");
        t2 = tema2.equals("0");
        t3 = tema3.equals("0");
        t4 = tema4.equals("0");

        if(t1) contador++;
        if(t2) contador++;
        if(t3) contador++;
        if(t4) contador++;
        
        int preguntaTema = numPreguntas / contador;
        ArrayList<Pregunta> preguntasJuego = new ArrayList<>();
        for(int i=0; i < preguntaTema; i++){
            if(t1) preguntasJuego.add(Servicio.geografia.get(i));
            if(t2) preguntasJuego.add(Servicio.historia.get(i));
            if(t3) preguntasJuego.add(Servicio.musica.get(i));
            if(t4) preguntasJuego.add(Servicio.deportes.get(i));
        }
        
        int restante = numPreguntas%contador;
        if(restante > 0){
            if(t1){
                for(int j = 0;j < restante;j++){
                    preguntasJuego.add(Servicio.geografia.get(preguntaTema+j));
                }
            } else if(t2){
                for(int j = 0;j < restante;j++){
                    preguntasJuego.add(Servicio.historia.get(preguntaTema+j));
                }
            } else if(t3){
                for(int j = 0;j < restante;j++){
                    preguntasJuego.add(Servicio.musica.get(preguntaTema+j));
                }
            } else if(t4){
                for(int j = 0;j < restante;j++){
                    preguntasJuego.add(Servicio.deportes.get(preguntaTema+j));
                }
            }
        }

        Servicio.juegos.add(new Juego(preguntasJuego, Integer.toString(Servicio.idJuegoServicio)));
        Servicio.idJuegoServicio += 1;
        return Integer.toString(Servicio.idJuegoServicio - 1);
    }
    
    
    @PUT
    @Path("/unir")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String unirse(@QueryParam("idSesion") String idSesion, @QueryParam("user") String user) {
        int posicion = Servicio.encontrarPartida(idSesion);
        if( posicion == -1 ){
            return "0";
        }
        Servicio.juegos.get(posicion).addJugador(user);
        return "1";
    }
    
    @GET
    @Path("/juego")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pregunta> devolverPreguntas(@QueryParam("idSesion") String idSesion) {
        int posicion = Servicio.encontrarPartida(idSesion);
        return Servicio.juegos.get(posicion).obtenerPreguntas();
    }
    
    @PUT
    @Path("/juego") //    /juego?idSesion=88w&user=pepe
    @Consumes(MediaType.TEXT_PLAIN)
    public void siguientePregunta(@QueryParam("idSesion") String idSesion, @QueryParam("user") String user, @QueryParam("numPregunta") String numPregunta, @QueryParam("acierto") boolean acierto) {
        int posicion = Servicio.encontrarPartida(idSesion);
        if(acierto) Servicio.juegos.get(posicion).aumentarPuntuacion(user);
    }
    
    @GET
    @Path("/rank/{idSesion}") //   rank/6473
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String,Integer> obtenerRanking(@PathParam("idSesion") String idSesion) {
        int posicion = Servicio.encontrarPartida(idSesion);
        return Servicio.juegos.get(posicion).obtenerRanking();
    }
    
}
