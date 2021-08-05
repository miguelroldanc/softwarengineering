var rank = angular.module("rank",[]);

rank.controller("controlador", 
    function($scope, $http){
        var servidor = "http://localhost:8080/coronavirus/rest/QuizzMe";
        $scope.id = getId();
        $scope.ranking = [
            {
                "user":"Bot1",
                "aciertos":"5"
            },
            {
                "user":"Bot2",
                "aciertos":"10"
            },
            {
                "user":"Bot3",
                "aciertos":"2"
            },
            {
                "user":"Bot4",
                "aciertos":"7"
            }
        ];
/*
        var peticionGet = servidor + "/rank/" + $scope.id;
        $http.get(peticionGet).success(function(rank){
                $scope.ranking = rank;
            }
            );

         * 
 */    }
);

getId = function(){
    var parametros = location.search;
    parametros = parametros.substr(4,parametros.length);
    parametros = parametros.split("&");

    var id = parametros[0];
    return id;
}