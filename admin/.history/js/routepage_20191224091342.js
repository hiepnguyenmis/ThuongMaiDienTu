var app = angular.module("myApp", ['ui.router','ckeditor', 'chart.js',"ngStorage"]);
app.config(function($stateProvider, $urlRouterProvider){
  $urlRouterProvider.otherwise('/');
    $stateProvider
    .state('home', {
      url: '/',
      templateUrl: 'pages/main.html',
      controller:'indexControllers'
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
    controller:'LoginController',
    controllerAs: "vm"
  })
  .state('products',{
    url:'/products',
    templateUrl:'pages/products.html',
    controller:'productsControllers'
  })
  .state('customers',{
    url:'/customers',
    templateUrl:'pages/customers.html',
    controller:'customersController'
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
  })

});

app.run(
  function run($rootScope, $http, $location, $localStorage) {
    // keep user logged in after page refresh
    if ($localStorage.currentUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        
    }

    // redirect to login page if not logged in and trying to access a restricted page
    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        var publicPages = ['/login'];
        var restrictedPage = publicPages.indexOf($location.path()) === -1;
        if (restrictedPage && !$localStorage.currentUser) {
            $location.path('/login');
        }
        else
    });
}
);