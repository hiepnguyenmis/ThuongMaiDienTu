(function(module){
    module.controller('ListProductController',function($scope,$http, $stateParams){
        var baseUrl = 'http://localhost:8080/api/';
        this.$onInit=function(){
            getResult();
        }
        
        getResult =function(){
            if($scope.key!=null){
                $scope.eror=true;
                $http({
                    method:'GET',
                    url:baseUrl+'products/'+ $stateParams.id
                }).then(function mySusses(response){
                    $scope.result=response.data;
                    console.log($stateParams.id);
                    console.log($stateParams.key);
                    console.log($scope.result);
                    if($scope.result.length==0){
                        $scope.eror=false;
                    }
                })
            }else{
                alert('Chưa nhập từ khóa tìm kiếm');
                
            }
        }

    });
}(angular.module('myApp')));