(function(module){
    module.controller('customersController',function($scope,$http){
        var baseUrl='localhost:8080/api/customers/';
        this.$onInit = function(){
            $scope.getdataCustomer();
        }
        $scope.getdataCustomer=function(){
            $http({
                method: "GET",
                url:baseUrl
            }).then(function mySuccess(response){
                $scope.customers=response.data;
            });
        }
    });
}(angular.module('myApp')));