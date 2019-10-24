var app = angular.module("myApp", ['ui.router']);
app.config(function($stateProvider, $urlRouterProvider){
  $urlRouterProvider.otherwise('/home');
    $stateProvider
    .state('home', {
      url: '/home',
      templateUrl: 'pages/main.html'
    })
    .state('reports',{
      url:'/reports',
      templateUrl:'pages/reports.html'
    })
    .state;
});