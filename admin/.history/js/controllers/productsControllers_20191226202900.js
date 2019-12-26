(function(module){
    module.controller('productsControllers',function($scope,$http){
        //$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        var baseUrl='http://localhost:8080/api/';
        $scope.selectedCategory=-1;
        $scope.updatedCategory=-1;
        $scope.category={};
        $scope.thumbnail = [];
        $scope.images=[];
        $scope.image1 = [];
        $scope.image2 = [];
        $scope.image3 = [];
        $scope.image4 = [];
        this.$onInit = function(){
            $scope.loading= true;
           
            $scope.getdataProducts();
            $scope.getdataCategory();
        }
        $scope.getdataProducts=function(){
            $http({
                method: "GET",
                url:baseUrl+'products'
            }).then(function mySuccess(response){
                console.info('Fetching')
                $scope.products=response.data;
                $scope.loading = false;
            });
        }
        $scope.getdataCategory=function(){
            $http({
                method: "GET",
                url:baseUrl+'categories'
            }).then(function mySuccess(response){
                $scope.categories=response.data;
            });
        }

        $scope.getCategoryById= function(id){
            $http.get(baseUrl+'categories/'+id).then(function success(res){
                $scope.category = res.data;
              
                
            })
        }

        $scope.getSelected = function(cateId){
            $scope.updatedCategory=cateId;
            $scope.getCategoryById(cateId)
            
        }

        $scope.createProduct= function(){
            
            // $scope.images=[
            //     {path:$scope.image_back},
            //     {path:$scope.image_front},
            //     {path:$scope.image_left},
            //     {path:$scope.image_right}
            // ]
            console.log($scope.image1);
            console.log($scope.image2);
            console.log($scope.image3);
            console.log($scope.image4);
            
            let img1 = {
                path: $scope.image1.base64
            }
            let img2
            $scope.images.push(image1)
            console.log($scope.images);
            var data={
                productCode:$scope.productCode,
                name:$scope.Name,
                price: $scope.Price,
                thumbnail: $scope.thumbnail.base64,
                stock: $scope.Stock,
                cpu:$scope.cpu,
                ram: $scope.ram,
                hardDisk: $scope.hardDisk,
                screen: $scope.screen,
                category: $scope.category,
                images:null
            };

            console.log(data);
            
            $http.post(baseUrl+'products', data).then((response)=>{
                
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

        $scope.updateProduct = function(product){
            product.category=$scope.category;
            console.log(product);
            console.log(product.category.id);
            
            
            $http.put(baseUrl+'products/'+product.id, product).then((res)=>{
                $scope.getdataProducts();
                document.getElementById('closeUpdateModal'+product.id).click();
                $scope.updatedCategory=-1;
                $scope.sucMessage = 'Cập nhật thông tin thành công!';
            }, (err)=>{
                console.error(err);
                $scope.errMessage = 'Cập nhật thông tin thất bại!';
                alert('Cập nhật thất bại')
            })
        }

        $scope.deleteProduct=function(id){
            $http.delete(baseUrl+'products/'+id).then((res)=>{
                $scope.getdataProducts();
            }, (err)=>{
                alert('xóa thất bại');
            })
        }

    });
    


    }(angular.module('myApp')));