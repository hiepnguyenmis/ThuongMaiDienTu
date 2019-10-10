var app = angular.module("myApp", ['ui.router','ui.tinymce']);
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
  .state('posts', {
    url: '/posts',
    templateUrl: 'pages/posts.html',
    controller: 'TinyMceController'
  })
  .state('login',{
    url:'/login',
    templateUrl:'pages/login.html',
    controller:'loginContronller'
  });
});
