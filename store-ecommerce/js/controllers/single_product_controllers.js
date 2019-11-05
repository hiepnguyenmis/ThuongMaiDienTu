// Code goes here
(function(module){
	module.controller('single_product_controllers', function($scope) {
		$scope.image=[
			{id:"1",img:"/images/si1.jpg"},
			{id:"2",img:"/images/si1.jpg"},
			{id:"3",img:"/images/si1.jpg"},
			{id:"4",img:"/images/si1.jpg"}
		];
		$scope.url_image=$scope.image[0].img;

		$scope.change_image_slider= function(id_image,url){
			
			$scope.url_image=url;
			if(id_image=$scope.image.id){
				$scope.url_image=$scope.image.img;
			}
		}
	});	  
}(angular.module('myApp')));