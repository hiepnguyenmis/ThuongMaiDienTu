(function(module){
    module.controller('productsControllers',function($scope,$http){
        //$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        var baseUrl='http://localhost:8080/api/';
        $scope.selectedCategory=-1;
        $scope.updatedCategory=-1;
        $scope.category={};
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
                console.log($scope.category);
                
            })
        }

        $scope.getSelected = function(cateId){
            $scope.updatedCategory=cateId;
            
        }

        $scope.createProduct= function(){
            
            // $scope.images=[
            //     {path:$scope.image_back},
            //     {path:$scope.image_front},
            //     {path:$scope.image_left},
            //     {path:$scope.image_right}
            // ]

            
            var data={
                productCode:$scope.productCode,
                name:$scope.Name,
                price: $scope.Price,
                thumbnail: 'null',
                stock: $scope.Stock,
                cpu:$scope.cpu,
                ram: $scope.ram,
                hardDisk: $scope.hardDisk,
                screen: $scope.screen,
                category: $scope.category,
                images:null
            };


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

        $scope.updateProduct = function

        $scope.deleteProduct=function(id){
            $http.delete(baseUrl+'products/'+id).then((res)=>{
                $scope.getdataCategory();
            }, (err)=>{
                alert('xóa thất bại');
            })
        }

        // $scope.submit = function() {
        //     if ($scope.form.file.$valid && $scope.file) {
        //       $scope.upload($scope.file);
        //     }
        //   };
        // $scope.uploadFiles=function(files){
        //     if(files && files.length){
        //         for(i=0; i<files.length;i++){
        //             Upload.upload({
        //                 url:'upload/url',
        //                 data:{files:files[i]}
        //             }).then(function(resp){
        //                 console.log('success')
        //             });
        //         }
        //     }https://medium.com/@salonimalhotra1ind/ng-file-upload-angular-js-a96e740b45fc
        // }
    });
    


    }(angular.module('myApp')));