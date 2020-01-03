(function(module){
    module.controller('ListProductController', function($scope,$http, $stateParams){
        var baseUrl = 'http://localhost:8080/api/';
     
        
        this.$onInit=function(){
            getdataProducts();
            console.log('init');
            
           
            
        }
        
        getdataProducts = function () {
			$http({
				method: "GET",
				url: baseUrl + 'products/' + $stateParams.id
			}).then(function mySuccess(response) {
				$scope.productsByCategory = response.data;
				eror
				$scope.images = $scope.singleProducts.images;
				$scope.defaultImage = $scope.images[0];
			});
		}

    });
}(angular.module('myApp')));