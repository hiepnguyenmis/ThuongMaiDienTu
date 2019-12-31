(function(module){
    module.controller('indexControllers',function($localStorage,$scope, $rootScope){
        
        $scope.finish=false;
        let email = 
        $rootScope.username=$localStorage.currentUser.email;
        let position = 
        //console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));