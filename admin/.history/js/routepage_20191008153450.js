var app = angular.module("myApp", ['ui.router', 'vcRecaptcha']).controller("myCtrl", [
  'recaptchaFactory',
  myCtrl
]);;
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
    controller:'loginContronller'
  });
});

var myCtrl = function (recaptchaFactory) {
  var recaptcha = recaptchaFactory.create('.my-recaptcha', {
      sitekey: 'yoursitekey'
  });
  recaptcha.render();
}
