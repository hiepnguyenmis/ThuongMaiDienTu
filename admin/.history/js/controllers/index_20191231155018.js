(function(module){
    module.controller('indexControllers',function($localStorage,$scope, $rootScope){
        
        $scope.finish=false;
        $rootScope.username=$localStorage.currentUser.email;
        
        //console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));