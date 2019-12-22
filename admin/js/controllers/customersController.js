(function(module){
    module.controller('customersController',function($scope,$http){
        var baseUrl='https://ecommerce-tdmu.herokuapp.com/api/customers/';
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