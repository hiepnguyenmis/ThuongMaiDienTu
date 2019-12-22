(function () {
    'use strict';

    angular
        .module('myApp')
        .controller('LoginController', Controller);

    function Controller($location, AuthenticationService, $scope,$http) {
        var vm = this;

        var baseUrl='https://ecommerce-tdmu.herokuapp.com/api/';
       
        vm.login = login;
        vm.signup=signup;

        initController();

        
        function initController() {
            // reset login status
            AuthenticationService.Logout();
        };

        function login() {
            vm.loading = true;
            AuthenticationService.Login(vm.email, vm.password, function (result) {
                if (result == true) {
                    vm.loading = false;
                    $location.path('/home');
                }else if(result==false) { 
                    vm.error = 'Username or password is incorrect';
                    alert(a);
                }
            });
        };

        function signup(){
            $scope.email;
            $scope.password;
            var Email=$scope.email;
            var Password=$scope.password;
            let data = {
                email: Email,
                password:Password 
            };
            $http.post(baseUrl+'signup',data)
            .then((response)=>{
                $scope.notifi="đăng ký thành công!"
                alert('Đăng ký thành công');
                $scope.email='';
                $scope.password='';
            },(err)=>{
                $scope.error="Email đã tồn tại!";
                $scope.email='';
                $scope.password='';
            });
        }
    }
})();