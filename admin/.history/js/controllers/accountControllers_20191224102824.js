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
            vm.loading = false;
            AuthenticationService.Login(vm.email, vm.password, function (result) {
                vm.loading = true;
                if (result === true) {
      
                    $location.path('/');
                } 
                else {             
                    vm.error = 'Đăng nhập thất bại. Vui lòng kiểm tra thông tin.';
                    
                }
            });
        };

       
    }
})();