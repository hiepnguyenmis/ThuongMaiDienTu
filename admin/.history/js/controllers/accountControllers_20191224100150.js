(function () {
    'use strict';

    angular
        .module('myApp')
        .controller('LoginController', Controller);

    function Controller($location, AuthenticationService) {
        var vm = this;

        vm.login = login;

        initController();

        function initController() {
            // reset login status
            AuthenticationService.Logout();
        };

        function login() {
            vm.loading = true;
            AuthenticationService.Login(vm.email, vm.password, function (result) {
                vm.loading = false;
                if (result === true) {
      
                    $location.path('/');
                } 
                else {             
                    vm.error = 'Đăng nhập thất bại. Vui lòng kiểm tra thông tin.';
                    
                }
            });
        };

        logout = () =>{
            AuthenticationService.Logout();
            $location.path(/)
        }
    }
})();