(function () {
    'use strict';

    angular
        .module('myApp')
        .controller('LoginController', Controller);

    
    function Controller($location, AuthenticationService, $scope,$http, $rootScope) {
        var vm = this;

        var baseUrl='http://localhost:8080/api/';
       
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
                    
                    //$location.path('/home').replace;
                    vm.loading = false;
                    //window.location.reload();
                    window.open("/#!/home","_self");
                    $rootScope.loggined=
                    console.log('login xong');
                    
                    
                }else if(result==false) { 
                    vm.error = 'Username or password is incorrect';
                   
                   
                }
            });
        };
        $scope.confirmPass='';
        function signup(){
            $scope.email;
            $scope.password;
            var ConfirmPass=$scope.confirmPass;
            
            var Email=$scope.email;
            var Password=$scope.password;
            let customerRegister = {
                first_name:$scope.fist_name,
                last_name:$scope.last_name,
                phone: $scope.phone,
                image_url:"default.jpg",
                address:$scope.address
            };
            var data = {
                email: Email,
                password:Password,
                customer: customerRegister
            };
            if(ConfirmPass==Password){
                $http.post(baseUrl+'signup',data)
                .then((response)=>{
                    $scope.notifi="đăng ký thành công!"
                    alert('Đăng ký thành công');
                    $scope.email='';
                    $scope.password='';
                },(err)=>{
                    if(err.status===409){
                        
                        $scope.errorEmail="Email đã tồn tại!";
                        console.log($scope.errorEmail);
                    }
                    
                    $scope.email='';
                    $scope.password='';
                });
            }else{
                $scope.errorConfirm='Mật khẩu không trùng khớp';
                console.log($scope.errorConfirm);
            } 
        }
    }
})();