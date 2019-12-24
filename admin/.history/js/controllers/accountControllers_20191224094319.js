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
                if (result === true) {
                    vm.loading = false;
                    $location.path('/');
                } else {
                  
                    
                    vm.loading = false;
                    alert(vm.error);
                    vm.error = 'Username or password is incorrect';
                    
                }
            });
        };
    }
})();