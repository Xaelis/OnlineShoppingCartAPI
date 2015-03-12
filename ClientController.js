app.controller("Client", function userController($scope) {
$scope.id = '';
$scope.name = '';
$scope.column = '';
$scope.clients = [
{id:val
, name:val
, column:val
}
];

$scope.edit = true;
$scope.error = false;
$scope.incomplete = false; 

$scope.editClient = function(id) {
  if (id == 'new') {
    $scope.edit = true;
    $scope.incomplete = true;
    $scope.id = '';
    $scope.name = '';
    $scope.column = '';
    } else {
    $scope.edit = false;
    $scope.id = $scope.clients[id-1].id;
    $scope.name = $scope.clients[id-1].name;
    $scope.column = $scope.clients[id-1].column;
  }
};

//$scope.$watch('passw1',function() {$scope.test();});
//$scope.$watch('passw2',function() {$scope.test();});
$scope.$watch('id', function() {$scope.test();});
$scope.$watch('name', function() {$scope.test();});
$scope.$watch('column', function() {$scope.test();});

$scope.test = function() {
  /*if ($scope.passw1 !== $scope.passw2) {
    $scope.error = true;
    } else {
    $scope.error = false;
  }*/
  $scope.incomplete = false;
  if ($scope.edit && (
  !$scope.id.length
||  !$scope.name.length
||  !$scope.column.length
)) {
       $scope.incomplete = true;
  }
};

});
