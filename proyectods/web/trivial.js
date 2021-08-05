var trivial = angular.module("trivial", []);

trivial.controller("controlador",
    function($scope, $http){
        var servidor = 'http://localhost:8080/coronavirus/rest/QuizzMe';
        $scope.id;
        $scope.numPreguntas = "";
        $scope.tema1 = false;
        $scope.tema2 = false;
        $scope.tema3 = false;
        $scope.tema4 = false;

        $scope.seleccionar1 = function(){
            $scope.tema1 = !$scope.tema1;
            if($scope.tema1){
                $scope.uno = "✓";
            }
            else{
                $scope.uno = "";
            }
        }

        $scope.seleccionar2 = function(){
            $scope.tema2 = !$scope.tema2;
            if($scope.tema2){
                $scope.dos = "✓";
            }
            else{
                $scope.dos = "";
            }
        }
        
        $scope.seleccionar3 = function(){
            $scope.tema3 = !$scope.tema3;
            if($scope.tema3){
                $scope.tres = "✓";
            }
            else{
                $scope.tres = "";
            }
        }

        $scope.seleccionar4 = function(){
            $scope.tema4 = !$scope.tema4;
            if($scope.tema4){
                $scope.cuatro = "✓";
            }
            else{
                $scope.cuatro = "";
            }
        }

        $scope.aceptar = function(){
            if(!($scope.tema1 || $scope.tema2 || $scope.tema3 || $scope.tema4)){
                alert("Tiene que elegir al menos un tema.");
            }
            else{
                if(isNaN($scope.numPreguntas) || $scope.numPreguntas == ""){
                    alert("Número de preguntas incorrecto.")
                }
                else{
                    var i = parseInt(($scope.numPreguntas),10);
                    if(i > 20 || i < 1){
                        alert("Número de preguntas incorrecto.");                        
                    }
                    else{
                        var t1 = "1";
                        var t2 = "1";
                        var t3 = "1";
                        var t4 = "1";

                        if($scope.tema1)
                            t1 = "0";
                        if($scope.tema2)
                            t2 = "0";
                        if($scope.tema3)
                            t3 = "0";
                        if($scope.tema4)
                            t4 = "0";

                        var peticionPut = servidor + "/crear?numPreguntas=" + $scope.numPreguntas +
                                        "&tema1=" + t1 + "&tema2=" + t2 +
                                        "&tema3=" + t3 + "&tema4=" + t4;

                        $http.put(peticionPut).then(function(idGenerado){
                            $scope.id = idGenerado.data;
                        });
                    }
                }              
            }
        }
    }
);