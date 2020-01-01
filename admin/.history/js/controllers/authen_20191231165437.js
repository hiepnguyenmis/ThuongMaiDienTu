(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('AuthenticationService', Service);

    function Service($http, $localStorage, $window, $sessionStorage ) {
        var service = {};

        service.Login = Login;
        service.Logout = Logout;

        return service;

        function Login(email, password, callback) {
            $http.post('http://localhost:8080/api/token/admin/generate-token', { email: email, password: password })
                .then(function (response) {
                    // login successful if there's a token in the response
                    if (response.data.token) {
                        // store username and token in local storage to keep user logged in between page refreshes
                        $localStorage.currentUser = { email: email, token: response.data.token };
                        // add jwt token to auth header for all requests made by the $http service
                        $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                        //console.log($localStorage.currentUser);
                        
                        // execute callback with true to indicate successful login
                        callback(true);
                    } 
                    
                },function errorCallback(response) {
                    callback(false)
                    
                  });
        }
        function Logout() {
            // remove user from local storage and clear http auth header
            delete $localStorage.currentUser;
            console.log($localStorage.currentUser);
            
            $http.defaults.headers.common.Authorization = '';
            
        }  

         
    }
})();