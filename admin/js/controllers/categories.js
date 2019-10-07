(function(module){
    module.controller('categories',function($scope,$http){
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

        $http({
            method: "GET",
            url: "http://localhost:8080/api/categories"
        }).then(function mySuccess(response){
            $scope.categories=response.data;
        });
    });
}(angular.module("myApp")));