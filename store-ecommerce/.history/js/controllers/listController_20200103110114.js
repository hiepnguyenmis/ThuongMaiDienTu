(function(module){
    module.controller('ListProductController', function($scope,$http, $stateParams){
        var baseUrl = 'http://localhost:8080/api/';
     
        
        this.$onInit=function(){
            getResult();
            console.log('init');
            
           
            
        }
        
        

    });
}(angular.module('myApp')));