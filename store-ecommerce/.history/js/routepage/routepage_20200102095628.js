var app = angular.module("myApp", ['ui.router', 'ngStorage']);
app.config(function ($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/home');
  $stateProvider
    .state('home', {
      url: '/home',
      templateUrl: 'pages/main.html',
      controller: 'HomeController'
    })
    .state('reports', {
      url: '/reports',
      templateUrl: 'pages/reports.html'
    })
    .state('abouts', {
      url: '/abouts',
      templateUrl: 'pages/about-us.html'
    })
    .state('login', {
      url: '/login',
      templateUrl: 'pages/login-register.html',
      controller: 'LoginController',
      controllerAs: 'vm'
    })
    .state('contact', {
      url: '/contact',
      templateUrl: 'pages/contact.html'
    })
    .state('single-product', {
      url: '/single-product/:id',
      templateUrl: 'pages/single-product-affiliate.html',
      controller: 'single_product_controllers'
    })
    .state('shopping-cart', {
      url: '/shopping-cart',
      templateUrl: 'pages/shopping-cart.html'
    })
    .state('checkout', {
      url: '/checkout',
      templateUrl: 'pages/checkout.html'
    })

    .state('search', {
      url: '/search',
      templateUrl: 'pages/search-engine.html'
    })

    .state('news', {
      url: '/news',
      templateUrl: 'pages/news.html'
    })
    .state('newsdetail', {
      url: '/newsdetail',
      templateUrl: 'pages/newsdetail.html'
    });
});

app.run(
  function run($rootScope, $http, $location, $localStorage) {
    $rootScope.Logout = function () {
      delete $localStorage.currentUser;
      $http.defaults.headers.common.Authorization = '';
      $location.path('/login');

      $rootScope.mgLogout = "Đăng nhập";
    }

    // this.$onInit = function () {
    //   $rootScope.getdataAccounts();
    //   getAccount();
    //   countProduct();
    // }


    console.log($rootScope.finish);

    if ($localStorage.currentUser != null) {
     
      
      var baseUrl = 'http://localhost:8080/api/';
      $rootScope.finish = true;
   
        $http({
          method:'GET',
          url: baseUrl+'users?email='+ $localStorage.currentUser.email
          }).then(function mySucces(response){
            console.log('hello');
          $rootScope.user = response.data;
          console.log('user info'+response.data);
          $http({
            method: "GET",
            url: baseUrl+'accounts/'+$rootScope.user.id+'/carts'
          }).then(function mySuccess(response) {
            
            $rootScope.carts = response.data;
            $rootScope.amountOfProducts=$rootScope.carts.length;
            $http.get()
          });
          })
      
    } else {
      $rootScope.finish = false;

    }
    console.log($localStorage.currentUser);
    console.log($rootScope.finish);
  }
);