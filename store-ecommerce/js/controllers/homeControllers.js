(function(module){
    module.controller('HomeController',function($http, $scope){
        var baseUrl='http://localhost:8080/api/';
        
        this.$onInit=function(){
            getdataProducts();
        }
       getdataProducts=function(){
            $http({
                method: "GET",
                url:baseUrl+'products'
            }).then(function mySuccess(response){
                $scope.products=response.data;
                console.log( $scope.products);
                
            });
        }
    });
}(angular.module('myApp')));