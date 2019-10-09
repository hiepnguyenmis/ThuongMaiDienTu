(function(module){
    module.controller('loginControllers',function ($scope, gRecaptcha) {
        gRecaptcha.initialize({key: $scope.recaptchaPublicKey}) // returns a promise
      });
}(angular.module("myApp")));