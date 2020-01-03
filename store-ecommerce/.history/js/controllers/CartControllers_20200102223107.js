(function (module) {
    module.controller('CartController', function ($http, $scope,$localStorage) {
        var baseUrl = 'http://localhost:8080/api/';

        this.$onInit = function () {
            getAccount();
            
        }
        $scope.user={};
        let paypal={};
        let paypalLoad=true;
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
        // Render the PayPal button into #paypal-button-container
      
        //paypal
        let addScript = false;
        let finalAmout=1;
        let paypalConfig={
            env: 'sandbox',
            client: {
                sandbox: 'AXl0a9RUrxJtPtIjD0Y7zD5mt284LMkGqRqmMp0iarm_NKQ93j1IOwd6pBaSZfLNjfQHqeShhoH220rO',
                production: 'EDk67qBPAMPiw9rADN3yc2tnirnPEI5dhqWFqS-rSiw4wpwVIobyCS_H1uuyQdom4P1b846tyDS3plMP'
            },
            commit:true,
            payment:(data, actions)=>{
                return actions.payment.create({
                     payment:{
                         transactions:  [
                             {amount: {total: 10, currency: 'USD'}}
                         ]
                     }
                });
            },
            onAuthorize: (data, actions) =>{
                return actions.payment.execute().then((payment)=>{
                    //do somthing when payment is successful
                    console.log('thành công');
                    
                })
            }
        };
        $scope.$on('$viewContentLoaded', function(){
            //Here your view content is fully loaded !!
            if(!this.addScript){
                this.addPaypalScript().then(()=>{
                    paypal.Button.render(this.paypalConfig, '#paypal-button-container');
                    this.paypalLoad=true;
                })
            }
          });

        addPaypalScript = function(){
            this.addScript=true;
            return new Promise((resolve, reject)=>{
                let scripttagElement = document.createElement('script');
                scripttagElement.src='https://www.paypalobjects.com/api/checkout.js';
                scripttagElement.onload = resolve;
                document.body.appendChild(scripttagElement)
            })
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