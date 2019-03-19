angular.module('listar', []).controller('controllerListaProyecto', function ($http, $scope) {
    $scope.listaProyectos1 = [];
    $scope.listaFotos = [];
    $scope.nombreEmpresa="";
    $scope.nombreProyecto="";
    $scope.fotografia = {};

    $scope.obtenerId = function(id){
        $scope.idFoto =id;
    };

    $scope.listarProyectos = function () {
        $http.get("../webresources/serviciousuario", {})
                .then(function (response) {
                    $scope.listaProyectos1 = response.data;
        }, function error(response) {
            console.log(response);
        });
    };
    $scope.listarProyectos();
    
    $scope.saveInfo = function (id, nmEmpresa,nmProyecto) {
        $http.get("../webresources/serviciousuario/consultafotos?id_proyecto="+id, {})
                .then(function (response) {
                    $scope.listaFotos = response.data;
            $scope.nombreEmpresa = nmEmpresa;
            $scope.nombreProyecto = nmProyecto;
            console.log($scope.nombreEmpresa);
        }, function error(response) {
            console.log(response);
        });
    };
    
    $scope.validarImagen = function (){
        var img = document.getElementById('foto');  
        return (img.naturalWidth < 800 && img.naturalHeight < 600);
    };
    
    $scope.validarCorreo = function(correo){
        var expresion = /^[a-z0-9._-]{2,50}@[gmail|hotmail|uptc|outlook]+\.([a-z]{2,4})+(.co)?$/;
        return expresion.test(correo);
    };
    
    $scope.enviarImg = function(){
        var fotografia = document.getElementById('fotografia');
        if(fotografia.files && fotografia.files[0]){
            if($scope.validarCorreo($scope.fotografia.correo)){
                if(!$scope.validarImagen($scope.fotografia.correo)){
                    var reader = new FileReader();
                    reader.readAsDataURL(fotografia.files[0]);
                    reader.onload = function () {
                        $http.post("../webresources/serviciousuario", {"idP":$scope.idFoto,"nombreF":$scope.fotografia.nombresFotografo,"apellidoF":$scope.fotografia.apellidosFotografo,"correo":$scope.fotografia.correo,"precio":$scope.fotografia.precioSolicitado, "foto":reader.result}, {})
                                .success(function(data, status, header, config){
                                    alert("Hemos recibido tu fotografía y la estamos \nprocesando para que sea publicada");
                            $('#exampleModal').modal('hide');
                            $scope.administrador = {};
                            $scope.fotografia = {};
                        }).error(function (data, status, header, config){
                            alert('Error ' + status);
                        });
                    };
        
                }else{
                    var img = document.getElementById('foto');  
                    alert("Error la imagen debe ser minimo 800x600\nactualmente la imagen es de "+ img.naturalWidth +"x"+img.naturalHeight);
                }
            }else{
                alert("Por favor ingrese un correo valido");
            }
        }
    };
});

