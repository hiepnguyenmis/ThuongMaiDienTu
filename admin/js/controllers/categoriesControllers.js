(function(module){
    module.controller('categoriesControllers',function($scope,$http){
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        const baseUrl="http://localhost:8080/api/categories"
        $http({
            method: "GET",
            url: baseUrl
        }).then(function mySuccess(response){
            $scope.categories=response.data;
        });
        $scope.createCategory=function(){
            $http({
                method: 'POST',
                url: baseUrl,
                data: { name: 'test' }
               }
            ).then(function(){
                alert("thêm thành công");
            });
        };
        
    });

}(angular.module("myApp")));