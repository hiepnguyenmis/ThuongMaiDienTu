(function(module){
    module.controller('productsControllers',function($scope,$http){
        var baseUrl='http://localhost:8080/api/products/';
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
        $scope.getdataCategory=function(){
            $http({
                method: "GET",
                url:'http://localhost:8080/api/categories/'
            }).then(function mySuccess(response){
                $scope.categories=response.data;
            });
        }
        // $scope.createProduct= function(idCategory){
            
        //     var data={
        //         productCode:$scope.productCode,
        //         name:$scope.Name,
        //         price: $scope.Price,
        //         thumbnail: $scope.Thumbnail,
        //         stock: $scope.Stock,
        //         cpu:$scope.cpu,
        //         ram: $scope.ram,
        //         hardDisk: $scope.hardDisk,
        //         screen: $scope.screen,
        //         category: idCategory,



        //     };

        // }
        $scope.deleteProduct=function(id){
            $http.delete(baseUrl+id).then((response)=>{
                $scope.getdataProducts();
                alert('Xóa thành công!');
            }, (err)=>{
                alert('Xóa thất bại');
            });
        }
    });
}(angular.module('myApp')));