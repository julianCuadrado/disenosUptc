var modulo1= angular.module('proyecto', []).controller('ControllerProyecto', function($http, $scope) {     
    
    $scope.admin = JSON.parse(localStorage.getItem('Admin'));
    $scope.proyecto = JSON.parse(localStorage.getItem('proyectoActual'));
    
    $scope.cerrarSesion = function (){
        if(confirm('\xbfDesea salir?')){
            localStorage.removeItem("Admin");
            localStorage.removeItem("proyectoActual");
            location.href = "../index.html";
        }
    };
});

var todos = angular.module('todos', ['ui.bootstrap']);

todos.controller('TodoController', function($http, $scope) {
    
    $scope.proyecto = JSON.parse(localStorage.getItem('proyectoActual'));
    $scope.filteredFotografias = []
    ,$scope.currentPage = 1
    ,$scope.numPerPage = 10
    ,$scope.maxSize = 5;
    $scope.listaFotografias = [];

    
    $scope.listarFotografias = function() {
        $http.get("../webresources/ServicioFotografia?id="+$scope.proyecto.id,{})
                .then(function(response) {
                    $scope.listaFotografias = response.data;
            console.log($scope.listaFotografias);
            $scope.init();
        }, function error(response){
            console.log(response);
        }); 
    };
    $scope.listarFotografias(); 
    
    $scope.numPages = function () {
        return Math.ceil($scope.listaFotografias.length / $scope.numPerPage);
    };
  
    $scope.$watch('currentPage + numPerPage', function() {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
        , end = begin + $scope.numPerPage;
        $scope.filteredFotografias = $scope.listaFotografias.slice(begin, end);
    });
    
    $scope.init = function (){
            var begin = (($scope.currentPage - 1) * $scope.numPerPage)
            , end = begin + $scope.numPerPage;
            $scope.filteredFotografias = $scope.listaFotografias.slice(begin, end);
    };
});

angular.element(document).ready(function() {
    var myDiv1 = document.getElementById("div1");
    angular.bootstrap(myDiv1, ["proyecto"]);

    var myDiv2 = document.getElementById("div2");
    angular.bootstrap(myDiv2, ["todos"]);
});

