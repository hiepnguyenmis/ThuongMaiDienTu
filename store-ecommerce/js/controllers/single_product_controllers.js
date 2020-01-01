(function (module) {
	module.controller('single_product_controllers', function ($stateParams, $http, $scope, $localStorage) {
		var baseUrl = 'http://localhost:8080/api/';
		
		this.$onInit = function () {
			getdataSingleProducts();
			$scope.getProduct();
			getAccount();
		}
		$scope.images=[];
		$scope.defaultImage={};
		$scope.user={};
		getdataSingleProducts = function () {
			$http({
				method: "GET",
				url: baseUrl + 'products/' + $stateParams.id
			}).then(function mySuccess(response) {
				$scope.singleProducts = response.data;
				console.log($scope.singleProducts);
				$scope.images = $scope.singleProducts.images;
				$scope.defaultImage = $scope.images[0];
			});
		}
		$scope.change_image_slider = function (id) {
			console.log(id);
			$scope.images.forEach(img => {
				if(img.id===id){
					$scope.defaultImage = img;
				}
			});
		}
		$scope.getProduct=function(){
			$http({
				method:'GET',
				url: baseUrl+'products'	
			}).then(function mySucces(response){
				$scope.products = response.data;
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

		
		$scope.AddToCart=function(){
			console.log('add cart');
			
			if($localStorage.currentUser==null){
			  $location.path('/login');
			}else{
			//   $http({
			// 	method:'GET',
			// 	url: baseUrl+'products'+idproduct	
			//   }).then(function mySucces(response){
			// 	$rootScope.products = response.data;
			//   });
	  
			  
			  var data={
				account:$scope.user,
				product:$scope.singleProducts,
				quantity:1
			  }
			  console.log(data);
			  
			  $http.post(baseUrl+'carts', data).then(function mySucces(res){
				console.log('thêm ok');
				
			  })
	  
			}
		  }
	});
}(angular.module('myApp')));