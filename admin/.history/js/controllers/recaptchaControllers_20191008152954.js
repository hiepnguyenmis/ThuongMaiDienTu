(function(module){
    module.controller('recapController',function($scope,$http){
        

        $http({
            method: "GET",
            url: "http://localhost:8080/api/categories"
        }).then(function mySuccess(response){
            $scope.categories=response.data;
        });
    });
}(angular.module("myApp")));