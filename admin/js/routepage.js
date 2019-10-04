var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "pages/main.html"
  })
  .when("/table", {
    templateUrl : "pages/tables.html"
  });
});