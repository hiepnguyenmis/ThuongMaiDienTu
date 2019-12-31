(function(module){
    module.controller('indexControllers',function($localStorage,$scope, $rootScope){
        
        $scope.finish=false;
        let email = $localStorage.currentUser.email;
        let partten = '@gmail.com'
        let position = email.indexOf('@gmail.com');
        $rootScope.username=email.slice();
         
        //console.log($localStorage.currentUser.email);
        
    });
}(angular.module("myApp")));