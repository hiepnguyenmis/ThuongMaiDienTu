(function(module){
    module.controller('HomeController',function($http, $scope,$rootScope,$localStorage){
        var baseUrl='http://localhost:8080/api/';
        
        this.$onInit=function(){
            getdataProducts();
            getdataTopSale();
            getdataNewProducts();
        }
       getdataProducts=function(){
            $http({
                method: "GET",
                url:baseUrl+'products'
            }).then(function mySuccess(response){
                $scope.products=response.data;
                console.log( $scope.products);
                
            });
        }
        getdataNewProducts=function(){
            $http({
                method: "GET",
                url:baseUrl+'products'
            }).then(function mySuccess(response){
                $scope.newproducts=response.data;
                console.log( $scope.products);
                
            });
        }
        getdataTopSale=function(){
            $http({
                method: "GET",
                url:baseUrl+'products'
            }).then(function mySuccess(response){
                $scope.topsale=response.data;
                console.log( $scope.products);
            });
        }
        getAccount=function(){
			$http({
				method:'GET',
				url: baseUrl+'users?email='+ $localStorage.currentUser.email
			  }).then(function mySucces(response){
				$scope.user = response.data;
				console.log(response.data);
			  })
        }
		$scope.AddToCart=function(id){
		
			if($localStorage.currentUser==null){
			  $location.path('/login');
			}else{
				$http.get(baseUrl+'products/'+id).then(function mySucces(res){
					console.log(res.data);
					let p ={
						product: res.data
					}
					$http.post(baseUrl+'accounts/'+$scope.user.id+'/carts', p)
					.then(function mySucces(res){
					  console.log('thêm ok');
					  
					  //$rootScope.amountOfProducts=$rootScope.carts.items.length+1
					  $http({
						  method: "GET",
						  url: baseUrl+'accounts/'+$rootScope.user.id+'/carts'
						}).then(function mySuccess(response) {
						  
						  $rootScope.carts = response.data;
						  $rootScope.amountOfProducts=$rootScope.carts.items.length;
						});
					},(err)=>{
					  console.log('that bai');
					});
				})
			}
		  }
    });
}(angular.module('myApp')));