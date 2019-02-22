angular.module('empresa', []).controller('ControllerEmpresa', function($http, $scope) {     
    
    $scope.admin = JSON.parse(localStorage.getItem('Admin'));
    $scope.listaProyectos = [];
    
    $scope.cerrarSesion = function(){
      if(confirm('\xbfDesea salir?')){
          localStorage.removeItem("Admin");
          location.href = "../index.html";
      }  
    };
    
    $scope.getProyectos = function (){
        $http.get("../webresources/ServicioProyecto?id="+$scope.admin.id,{})
                .then(function(response) {
                    $scope.listaProyectos = response.data;
            console.log($scope.listaProyectos);
        }, function error(response){
                    console.log(response);
        }); 
    };
    $scope.getProyectos();
});