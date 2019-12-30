(function(module){
    module.controller('indexControllers',function($localStorage,$scope){
        
        $scope.finish=false;
        $scope.username=$localStorage.currentUser.email;
        console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));