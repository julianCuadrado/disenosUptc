angular.module('home', []).controller('Controller', function($http, $scope) {     
    
    $scope.administrador = {};
    $scope.usuario = {};
    $scope.cerrar = "";
    
    $scope.guardarAdministradorEmpresa = function (){
        if($scope.administrador.nombreEmpresa && $scope.administrador.correo && $scope.administrador.contrasenia
                && $scope.confirmacion){
            if($scope.administrador.contrasenia === $scope.confirmacion){
                $scope.cerrar = "modal";
                $http.post("./webresources/ServicioAdministradorEmpresa",  JSON.stringify($scope.administrador), {})
                        .success(function(data, status, header, config){
                            alert("Datos guardados");
                    $scope.cerrar = "";
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
    
    $scope.ingresar = function (){
        $http.post("./webresources/ServicioAdministradorEmpresa/atenticarse",{'correo':$scope.usuario.correo , 'contrasenia':$scope.usuario.contrasenia},{})
                .success(function(data, status, header, config){
                       if(data.mensaje === 1){
                           alert("Error datos erroneos");
                       }else{
                           alert("Acceso permitido");
                           window.location.replace("./views/empresa.html");
                       }
                }).error(function (data, status, header, config){
        });
    };
    
    $scope.listarProyectos = function (){
        
    };
});