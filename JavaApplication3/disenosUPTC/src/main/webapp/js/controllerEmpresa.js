angular.module('empresa', []).controller('ControllerEmpresa', function($http, $scope) {     
    
    $scope.admin = JSON.parse(localStorage.getItem('Admin'));
    $scope.listaProyectos = [];
    $scope.proyecto = {};
    
    $scope.cerrarSesion = function(){
        $http.get("../webresources/serviciousuario", {})
                .then(function (response) {
                   console.log(response.data);
                }, function error(response) {
                    console.log(response);
                });
//        if(confirm('\xbfDesea salir?')){
//            localStorage.removeItem("Admin");
//            location.href = "../index.html";
//        }  
    };
    
    $scope.getProyectos = function (){
        $http.get("../webresources/ServicioProyecto?id="+$scope.admin.id,{})
                .then(function(response) {
                    $scope.listaProyectos = response.data;
        }, function error(response){
            console.log(response);
        }); 
    };
    $scope.getProyectos();
    
    $scope.crear = function(){
        $scope.proyecto = {};
      $('#myModal').modal('show');  
    };
    
    $scope.agregarProyecto = function (){
        if(!$scope.proyecto.id){
            $scope.proyecto.administradorEmpresa = $scope.admin;
        $http.post("../webresources/ServicioProyecto",  JSON.stringify($scope.proyecto), {})
                .success(function(data, status, header, config){
                    alert("Datos guardados");
            $scope.getProyectos();
            $('#myModal').modal('hide');
            $scope.proyecto = {};
        }).error(function (data, status, header, config){
            alert('Error ' + status);
        });
        }else{
           $scope.editarProyecto($scope.proyecto);
           $('#myModal').modal('hide');
        }
    };
    
    $scope.editar = function(data){
        $scope.proyecto = data;
        $('#myModal').modal('show');
    };
    
    $scope.editarProyecto = function (data){
        $http.put("../webresources/ServicioProyecto/edit", data)
                    .success(function(data, status, header, config){
                        $scope.getProyectos();
                alert("datos actualizados");
            }).error(function (data, status, header, config){
                alert(status); 
            });
    };
    
    $scope.eliminarProyecto = function(data){
        if (confirm('\xbfDesea elminar este registro?')) {    
             $http.delete("../webresources/ServicioProyecto/remove?id=" + data.id)
                        .then(function (response) {
                            $scope.getProyectos();
                }, function (err){
                    console.log(err);
                });
        }
    };
    
    $scope.ver = function(data){
        localStorage.setItem('proyectoActual', JSON.stringify(data));
        location.href = "./proyecto.html";
    };
});