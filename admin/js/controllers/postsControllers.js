(function(module){
    module.controller("postsControllers", [
        '$scope',
        '$rootScope',
        function($scope, $rootScope){
      
          $scope.data = {
            textInput: '',
            options: {
              language: 'vi',
              allowedContent: true,
              entities: false
            }
          };
      
        }]);
}(angular.module('myApp')));