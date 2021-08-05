var quizzMe = angular.module("QuizzMe",[]);

quizzMe.controller("controlador",
    function($scope, $http){
        var servidor = "http://localhost:8080/coronavirus/rest/QuizzMe";
        $scope.id = getId();
        $scope.user = getUser();
        $scope.indice = 0;
        $scope.respuestaActual = -1;
        $scope.solucion = -1;
        $scope.pregunta = "Texto con la pregunta";
        $scope.respuesta1 = "Respuesta 1";
        $scope.respuesta2 = "Respuesta 2";
        $scope.respuesta3 = "Respuesta 3";
        $scope.respuesta4 = "Respuesta 4";
        $scope.preguntas = [
            {
                "pregunta":"¿Cual es la capital de la República de Bolivia?",
                "respuesta1":"Sucre",
                "respuesta2":"Bogotá",
                "respuesta3":"Montevideo",
                "respuesta4":"Asunción",
                "correcta": "1"
            },
            {
                "pregunta":"Cual es la capital de Bangladesh",
                "respuesta1":"Roma",
                "respuesta2":"Estocolmo",
                "respuesta3":"Dacca",
                "respuesta4":"Madrid",
                "correcta": "3"
            },
            {
                "pregunta":"¿Quién proclamó la República Popular de China y fue su líder máximo hasta 1976?",
                "respuesta1":"Confucio",
                "respuesta2":"Sun Yat-sen",
                "respuesta3":"Mao Tse-Tung",
                "respuesta4":"Chiang Kai-shek",
                "correcta": "3"
            },
            {
                "pregunta":"¿De qué nacionalidad es el corredor de media distancia Saïd Aouita?",
                "respuesta1":"Marruecos",
                "respuesta2":"Senegal",
                "respuesta3":"Camerún",
                "respuesta4":"Etiopía",
                "correcta": "1"
            }

        ]; 

        $scope.pregunta = $scope.preguntas[0].pregunta;
        $scope.respuesta1 = $scope.preguntas[0].respuesta1;
        $scope.respuesta2 = $scope.preguntas[0].respuesta2;
        $scope.respuesta3 = $scope.preguntas[0].respuesta3;
        $scope.respuesta4 = $scope.preguntas[0].respuesta4;
        /*
        var peticionGet = servidor + "/juego?idSesion=" + $scope.id;
        $http.get(peticionGet).then(function(p){ 
            $scope.preguntas = p;
                console.log(p);
                $scope.pregunta = $scope.preguntas[$scope.indice].pregunta;
                $scope.respuesta1 = $scope.preguntas[$scope.indice].respuesta1;
                $scope.respuesta2 = $scope.preguntas[$scope.indice].respuesta2;
                $scope.respuesta3 = $scope.preguntas[$scope.indice].respuesta3;
                $scope.respuesta4 = $scope.preguntas[$scope.indice].respuesta4;
                }
            );
        console.log($scope.preguntas);
        */
        $scope.siguientePregunta = function(){
            if($scope.respuestaActual != -1){
                if($scope.preguntas.length > $scope.indice){
                    var acierto = "0";
                    if($scope.respuestaActual == $scope.preguntas[$scope.indice].correcta){
                        var acierto = "1";
                    }
                    var peticionPut = servidor + "/juego?idSesion=" + $scope.id + "&user=" +
                                      $scope.user + "&numPregunta=" + $scope.indice + "&acierto=" + acierto;
                    $http.put(peticionPut);
                    
                    $scope.indice = $scope.indice + 1;
                    $scope.pregunta = $scope.preguntas[$scope.indice].pregunta;
                    $scope.respuesta1 = $scope.preguntas[$scope.indice].respuesta1;
                    $scope.respuesta2 = $scope.preguntas[$scope.indice].respuesta2;
                    $scope.respuesta3 = $scope.preguntas[$scope.indice].respuesta3;
                    $scope.respuesta4 = $scope.preguntas[$scope.indice].respuesta4;                    
                    $scope.respuestaActual = -1;
                }
                else{
                    //Redirigir hacia el ranking
                    var url = "rank.html?id=" + $scope.id + "&user=" + $scope.user;
                    location.href = url;
                }
                
            }
            else{
                alert("Tienes que seleccionar una respuesta.");               
            }        
        }

        $scope.opcion1 = function(){
            $scope.respuestaActual = "1";
            console.log($scope.respuestaActual);
        }
        $scope.opcion2 = function(){
            $scope.respuestaActual = "2";
            console.log($scope.respuestaActual);
        }
        $scope.opcion3 = function(){
            $scope.respuestaActual = "3";
            console.log($scope.respuestaActual);
        }
        $scope.opcion4 = function(){
            $scope.respuestaActual = "4";
            console.log($scope.respuestaActual);
        }
    }
);

getId = function(){
    var parametros = location.search;
    parametros = parametros.substr(4,parametros.length);
    parametros = parametros.split("&");

    var id = parametros[0];
    return id;
}

getUser = function(){
    var parametros = location.search;
    parametros = parametros.substr(4,parametros.length);
    parametros = parametros.split("&");
    parametros = parametros[1].substr(5, parametros[1].length);

    var user = parametros;
    return user;
}