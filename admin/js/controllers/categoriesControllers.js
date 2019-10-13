(function(module){
    module.controller('categoriesControllers',function($scope,$http,$window){
        //$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        var baseUrl='http://localhost:8080/api/categories/';
        
        
        $http({
            method: "GET",
            url:baseUrl
        }).then(function mySuccess(response){
            $scope.categories=response.data;
        });
        $scope.createCategory = function(){
            let data = {name: $scope.name};
            
            $http.post(baseUrl, data).then((response)=>{
                $window.location.reload();
            }, (err)=>{
                alert('Thêm thất bại');
            });
        }
        $scope.updateCategory= function(category){
            let data={
                name:category.name};
                $http.put(baseUrl+category.id, data).then((response)=>{
                    $window.location.reload();
                }, (err)=>{
                    alert('Sửa thất bại');
                });
        }
        $scope.deleteCategory=function(id){
            $http.delete(baseUrl+id).then((response)=>{
                
                $window.location.reload();
            }, (err)=>{
                alert('Xóa thất bại');
            });
        }
    });
}(angular.module("myApp")));