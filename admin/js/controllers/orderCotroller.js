(function(module){
    module.controller('OrderController',function($scope,$http){
        $http.get('http://localhost:8080/api/orders').then(function suc(res){
            $scope.oders= res.data;
            console.log();
            
        })
    });
}(angular.module('myApp')));

///đang chờ xử lý đang vận chuyển hoàn thành hủy đơn