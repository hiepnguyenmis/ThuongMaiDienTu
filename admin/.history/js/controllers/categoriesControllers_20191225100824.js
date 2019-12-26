(function(module){
    module.controller('categoriesControllers',function($scope,$http){
        //$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        var baseUrl='http:localhost:8080/api/categories/';
        this.$onInit = function(){
            $scope.loading = true;
            $scope.getdataCategory();
        }
        $scope.getdataCategory=function(){
            $http({
                method: "GET",
                url:baseUrl
            }).then(function mySuccess(response){
                console.log('fetching data');
                
                $scope.categories=response.data;
                $scope.loading=false;
                console.log(response);
                
            });
        }
        $scope.createCategory = function(){
            let data = {name: $scope.name};
            $http.post(baseUrl, data).then((response)=>{
                $scope.getdataCategory();
                $scope.name='';
            }, (err)=>{
                alert('Thêm thất bại');
            });
        }
        $scope.updateCategory= function(category){
            let data={name:category.name};
                $http.put(baseUrl+category.id, data).then((response)=>{
                    $scope.getdataCategory();
                }, (err)=>{
                    alert('Sửa thất bại');
            });
        }
        $scope.deleteCategory=function(id){
            $http.delete(baseUrl+id).then((response)=>{
                $scope.getdataCategory();
            }, (err)=>{
                alert('Xóa thất bại');
            });
        }
    });
}(angular.module("myApp")));