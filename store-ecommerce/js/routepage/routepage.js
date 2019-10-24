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
    .state('about',{
      url:'/about',
      templateUrl:'pages/about-us.html'
    })
    .state('login',{
      url:'/login',
      templateUrl:'pages/login-register.html'
    });

});