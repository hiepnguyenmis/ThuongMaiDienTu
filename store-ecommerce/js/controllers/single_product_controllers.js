(function (module) {
	module.controller('single_product_controllers', function ($stateParams, $http, $scope) {
		var baseUrl = 'http://localhost:8080/api/';
		
		this.$onInit = function () {
			getdataSingleProducts();
		}
		$scope.images=[];
		$scope.defaultImage={};
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
			}).then({
				
			});
		}
	});
}(angular.module('myApp')));