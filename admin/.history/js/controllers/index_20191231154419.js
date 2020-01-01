(function(module){
    module.controller(' ',function($localStorage,$scope){
        
        $scope.finish=false;
        $scope.username=$localStorage.currentUser.email;
        //console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));