// var app = angular.module("myApp", ['ui.router']);
// app.config(function($stateProvider, $urlRouterProvider){
//   $urlRouterProvider.otherwise('/home');
//     $stateProvider
//     .state('home', {
//       url: '/home',
//       templateUrl: 'pages/main.html'
//   })
//   .state('category', {
//     url: '/categories',
//     templateUrl: 'pages/categories.html',
//     controller: 'categories'
//   });
// });

var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "main.htm"
  })
  .when("/red", {
    templateUrl : "red.htm"
  })
  .when("/green", {
    templateUrl : "green.htm"
  })
  .when("/blue", {
    templateUrl : "blue.htm"
  });
});