var app = angular.module("myApp", ['ngRoute']);
app.config(function($routeProvider){
  
    $$routeProvider
    .state('home', {
      url: '/home',
      templateUrl: 'pages/main.html'
  })
  .state('category', {
    url: '/categories',
    templateUrl: 'pages/categories.html',
    controller: 'categories'
  });
});
