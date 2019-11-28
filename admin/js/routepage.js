var app = angular.module("myApp", ['ui.router','ckeditor', 'chart.js']);
app.config(function($stateProvider, $urlRouterProvider){
  $urlRouterProvider.otherwise('/home');
    $stateProvider
    .state('home', {
      url: '/home',
      templateUrl: 'pages/main.html'
  })
  .state('categories', {
    url: '/categories',
    templateUrl: 'pages/categories.html',
    controller: 'categoriesControllers'
  })
  .state('addposts', {
    url: '/addposts',
    templateUrl: 'pages/addposts.html',
    controller: 'postsControllers'
  })
  .state('editpost',{
    url: '/editpost',
    templateUrl: 'pages/editpost.html',
    cont: 'postsControllers'
  })
  .state('posts', {
    url: '/posts',
    templateUrl: 'pages/posts.html',
  })
  .state('login',{
    url:'/login',
    templateUrl:'pages/login.html',
    controller:'loginContronller'
  })
  .state('products',{
    url:'/products',
    templateUrl:'pages/products.html',
    controller:'productsControllers'
  })
  .state('customers',{
    url:'/customers',
    templateUrl:'pages/customers.html'
  })
  .state('profiles',{
    url:'/profiles',
    templateUrl:'pages/profiles.html'
  })
  .state('registers',{
    url:'/registers',
    templateUrl:'pages/registers.html'
  })
  .state('reports',{
    url:'/reports',
    templateUrl:'pages/reports.html',
    controller:'reportsControllers'
  })
  .state('orders',{
    url:'/orders',
    templateUrl:'pages/orders.html'
  });
});
