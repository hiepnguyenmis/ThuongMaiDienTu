(function(module){
    module.controller('indexControllers',function($localStorage,$scope, $rootScope){
        
        $scope.finish=false;
        let email = $localStorage.currentUser.email;
        let pattern = '@gmail.com';
        let position = email.indexOf(pattern);
        $rootScope.username=email.slice(0, position);
         
        //console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));