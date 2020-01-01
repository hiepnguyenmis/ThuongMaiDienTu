(function(module){
    module.controller('indexControllers',function($localStorage,$scope, $rootScope){
        
        $scope.finish=false;
        let email = $localStorage.currentUser.email
        $rootScope.username=;
         
        //console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));