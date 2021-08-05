var unir = angular.module("unir", []);

unir.controller("controlador",
    function($scope, $http){
        var servidor = "http://localhost:8080/coronavirus/rest/QuizzMe";
        $scope.user;
        $scope.id = getId();

        $scope.acceder = function(){
            var peticion = servidor + "/unir?idSesion=" + $scope.id + "&user=" + $scope.user;
            $http.put(peticion).then(function(solucion){
                    // Si el servidor devuelve confirmación
                    if(solucion.data == "1")
                        $scope.redireccionar();
                    else
                        alert("Partida no encontrada.");
                }
            )
        }

        $scope.redireccionar = function(){
            var url = "juego.html?id=" + $scope.id + "&user=" + $scope.user;
            document.location.href = url;
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