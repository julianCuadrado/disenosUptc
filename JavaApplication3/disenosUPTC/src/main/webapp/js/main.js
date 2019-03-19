angular.module('home', []).controller('Controller', function($http, $scope) {     
    
    $scope.administrador = {};
    $scope.usuario = {};
    $scope.cerrar = "";
    
    $scope.guardarAdministradorEmpresa = function (){
        if($scope.administrador.nombreEmpresa && $scope.administrador.correo && $scope.administrador.contrasenia
                && $scope.confirmacion){
            if($scope.administrador.contrasenia === $scope.confirmacion){
                $http.post("./webresources/ServicioAdministradorEmpresa",  JSON.stringify($scope.administrador), {})
                        .success(function(data, status, header, config){
                            alert("Datos guardados");
                      $('#myModal').modal('hide');
                    $scope.administrador = {};
                }).error(function (data, status, header, config){
                    alert('Error ' + status);
                });
            }else{
                alert("Las contraseñas no coinciden");
            }
        }else{
            alert("Por favor llene todos los campos");
        }
    };
    
    $scope.listarFotos = function(){
        $http.get("./webresources/ServicioFotografia/todas",{})
                .then(function(response) {
                    $scope.listaFotos = response.data;
                    console.log($scope.listaFotos);
        }, function error(response){
            console.log(response);
        }); 
    };
    
    $scope.listarFotos();
    
    $scope.pintar = function (ruta){
        return ruta.substring(1);
    };
    
    $scope.admin = {};
    
    $scope.ingresar = function (){
        $http.post("./webresources/ServicioAdministradorEmpresa/atenticarse",{'correo':$scope.usuario.correo , 'contrasenia':$scope.usuario.contrasenia},{})
                .then(function(response) {
                    if(response.data.administrador === null){
                        alert("Error datos erroneos");
            }else{
                localStorage.setItem('Admin', JSON.stringify(response.data.administrador));
                location.href = "./views/empresa.html";
                $scope.admin = JSON.parse(localStorage.getItem('Admin')).correo;
            }
        }, function error(response){
        });
    };
});