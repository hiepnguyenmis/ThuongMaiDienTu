(function(module){
    module.controller('indexControllers',function($localStorage,$scope){
        

        $scope.username=$localStorage.currentUser.email;
        console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp", ['naif.base64'])));