(function(module){
    module.controller('productsControllers',function($scope,$http){
        var baseUrl='http://localhost:8080/api/products';
        this.$onInit = function(){
            $scope.getdataProducts();
        }
        $scope.getdataProducts=function(){
            $http({
                method: "GET",
                url:baseUrl
            }).then(function mySuccess(response){
                $scope.products=response.data;
            });
        }
    });
}(angular.module('myApp')));