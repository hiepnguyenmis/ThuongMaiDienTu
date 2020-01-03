(function (module) {
    module.controller('CartController', function ($http, $scope,$localStorage) {
        var baseUrl = 'http://localhost:8080/api/';

        this.$onInit = function () {
            getAccount();
            
        }
        $scope.user={};
        getAccount = function () {
            $http({
                method: 'GET',
                url: baseUrl + 'users?email=' + $localStorage.currentUser.email
            }).then(function mySucces(response) {
                $scope.user = response.data;
                console.log(response.data);
                getCart();

            })
        }
        $scope.checkout= function(){
            let data ={
                "intent": "CAPTURE",
                "purchase_units": [
                  {
                    "amount": {
                      "currency_code": "USD",
                      "value": "110.00"
                    }
                  }
                ]
            }
            $http.post('https://api.sandbox.paypal.com/v2/checkout/orders', data).then()
        }
        $scope.increaseQ= function(item, id){
           
            console.log(id);
            
            item.quantity++;
            updateCart(item, id);
        }

        $scope.decreaseQ = function(item, id){
            item.quantity--;
            updateCart(item, id);
        }
        
        updateCart= function(item, id){
            let data={
                
                    quantity: item.quantity
             
            }
            console.log(item.quantity);
            
            $http.put(baseUrl+'carts/'+id,data ).then(function mySuccess(res){
                getCart();                
            })
        }
        getCart = function () {
            console.log($scope.user.id);
            
            $http({
                method: "GET",
                url: baseUrl + 'accounts/' + $scope.user.id + '/carts'
            }).then(function mySuccess(response) {
                $scope.carts = response.data;
               console.log($scope.carts);
               $scope.subTotal=$scope.carts.subTotal;
               
                
            });
        }

        ConfirmOrder= function(){

        }
    });
}(angular.module('myApp')));