// Code goes here
(function(module){
	module.controller('single_product_controllers', function($scope) {
		$scope.change_image_slider= function(image_slider){
			$scope.image=[
				{id:"1",front_image:"../images/m1.jpg"},
				{id:"2",back_image:"../images/si1.jpg"},
				{id:"3",left_image:"../images/si1.jpg"},
				{id:"4",right_image:"../images/m1.jpg"}
			];
		}
	});	  
}(angular.module('myApp')));