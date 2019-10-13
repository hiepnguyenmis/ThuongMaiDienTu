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
        $scope.updateCategory= function(id,dataName){
            let data={
                name:dataName};
                $http.put(baseUrl+id, data).then((response)=>{
                    $window.location.reload();
                }, (err)=>{
                    alert('sửa thất bại');
                });
        }
        $scope.deleteCategory=function(category){
            
            console.log(category.id);
            
            // $http.delete(baseUrl+category.id,data).then((response)=>{
            //     $window.location.reload();
            // }, (err)=>{
            //     alert('sửa thất bại');
            // });
           $http.delete(baseUrl+category.id).then((response)=>{
               console.log('xoá ok');
               
           }, (err)=>{
               console.log(err);
               
           })
        }
        
    });
}(angular.module("myApp")));