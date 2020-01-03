(function (module) {
    module.controller('CartController', function ($http, $scope, $localStorage) {
        var baseUrl = 'http://localhost:8080/api/';

        this.$onInit = function () {
            getAccount();
            //getCart();
            $scope.address='';
            $scope.isPaid='';
            $scope.buyer='';
            $scope.notes='';
            $scope.phone=''


        }
        $scope.user = {};

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
        
        $scope.doCheckout = function () {
            let details=[];
            $scope.carts.items.forEach((item)=>{
                let data={
                    products:item.product,
                    quantity: item.quantity
                }
                details.push(data);
            })
           var data = {
                accounts: $scope.user,
                address: $scope.address,
                isPaid: "UNPAID",
                name: $scope.buyer,
                notes: $scope.notes,
                orderDetails: details,
                orderStatus: "WAITING",
                phone: $scope.phone
            }
            console.log(data);
            $http.post(baseUrl + 'orders', data)
                .then(function mySuccess(res) {
                    //getCart();
                    console.log('Thêm thành công');
                    
                })
            
            
        }

        $scope.increaseQ = function (item, id) {

            console.log(id);

            item.quantity++;
            updateCart(item, id);
        }

        $scope.decreaseQ = function (item, id) {
            item.quantity--;
            updateCart(item, id);
        }

        updateCart = function (item, id) {
            let data = {

                quantity: item.quantity

            }
            console.log(item.quantity);

            $http.put(baseUrl + 'carts/' + id, data).then(function mySuccess(res) {
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
                $scope.subTotal = $scope.carts.subTotal;


            });
        }

        ConfirmOrder = function () {

        }
    });
}(angular.module('myApp')));