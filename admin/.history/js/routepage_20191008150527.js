var app = angular.module("myApp", ['ui.router', 'vcRecaptcha']);
app.config(function($stateProvider, $urlRouterProvider){
  $urlRouterProvider.otherwise('/home');
    $stateProvider
    .state('home', {
      url: '/home',
      templateUrl: 'pages/main.html'
  })
  .state('category', {
    url: '/categories',
    templateUrl: 'pages/categories.html',
    controller: 'categoriesControllers'
  })
  .state('login',{
    url:'/login',
    templateUrl:'pages/login.html',
    controller:'loginControllers'
  });
});
