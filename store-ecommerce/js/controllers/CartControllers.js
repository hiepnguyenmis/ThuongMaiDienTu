(function (module) {
    module.controller('CartController', function ($http, $scope,$localStorage) {
        var baseUrl = 'http://localhost:8080/api/';

        this.$onInit = function () {
            getAccount();
            
        }
        $scope.user={};
        getAccount = function () {
            $http({
                method: 'GET',
                url: baseUrl + 'users?email=' + $localStorage.currentUser.email
            }).then(function mySucces(response) {
                $scope.user = response.data;
                console.log(response.data);
                getCart();

            })
        }

        getCart = function () {
            console.log($scope.user.id);
            
            $http({
                method: "GET",
                url: baseUrl + 'accounts/' + $scope.user.id + '/carts'
            }).then(function mySuccess(response) {
                $scope.carts = response.data;
            });
            // $http.get(baseUrl+'accounts/'+169+'/carts')
			//   .then(function mySucces(res){
			// 	console.log('thêm ok');
			//   },(err)=>{
			// 	console.log('that bai');
			//   });
        }
    });
}(angular.module('myApp')));