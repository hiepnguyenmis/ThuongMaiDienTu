(function(module){
    module.controller('productsControllers',function($scope,$http){
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        var baseUrl='http://localhost:8080/api/products/';
        this.$onInit = function(){
            $scope.getdataProducts();
            $scope.getdataCategory();
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
        $scope.createProduct= function(){
            $scope.images=[
                {path:$scope.image_back},
                {path:$scope.image_front},
                {path:$scope.image_left},
                {path:$scope.image_right}
            ]
            var data={
                productCode:$scope.productCode,
                name:$scope.Name,
                price: $scope.Price,
                thumbnail: $scope.Thumbnail,
                stock: $scope.Stock,
                cpu:$scope.cpu,
                ram: $scope.ram,
                hardDisk: $scope.hardDisk,
                screen: $scope.screen,
                category: $scope.idCategory,
                images:images
            };
            $http.post(baseUrl, data).then((response)=>{
                $scope.getdataProducts();
                $scope.Name='';
                //$scope.Thumbnail=""
                $scope.Stock='';
                $scope.cpu='';
                $scope.ram='';
                $scope.hardDisk='';
                $scope.screen='';
            }, (err)=>{
                alert('Thêm thất bại');
            });
        }
        $scope.deleteProduct=function(id){
            $http.delete(baseUrl+id).then((res)=>{
                $scope.getdataCategory();
            }, (err)=>{
                alert('xóa thất bại')
            })
        }

    });
    // 
    module.directive('file',['$parse',function($parse){
        return{
            restrict:'A',
            link: function(scope, element,attrs){
                var model= $parse(attrs.fileModel);
                var medelSetter=model.assign;

                element.bind('change',function(){
                    scope.$apply(function(){
                        modelSetter(scope,element[0].file[0]);
                    })
                })
            }
        }
    }])

    module.service('multipartFrom',['$http', function($http){
      this.post=function(uploadUrl,data){
        var fd= new FormData();
        for (var key in data)
            fd.append(key,data[key]);
        $http.post(uploadUrl,fd,{
            transformRequest:angular.identity,
            headers:{'Content-Type':underfile}
        })
      }  
    }])
}(angular.module('myApp')));