(function(module){
    module.controller('ListProductController', function($scope,$http, $stateParams){
        var baseUrl = 'http://localhost:8080/api/';
     
        
        this.$onInit=function(){
            getResult();
            console.log('init');
            
           
            
        }
        
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

    });
}(angular.module('myApp')));