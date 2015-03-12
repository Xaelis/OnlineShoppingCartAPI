app.controller("clientController", function clientController($scope) {
$scope.id = '';
$scope.name = '';
$scope.column = '';
$scope.clients = [
{id:1, name:'Toto', column:100},
{id:2, name:'Titi', column:150},
];

$scope.newClient = true;
$scope.error = false;
$scope.incomplete = false; 

$scope.editClient = function(id) {
  if (id == 'new') {
    $scope.newClient = true;
    $scope.incomplete = true;
    $scope.id = '';
    $scope.name = '';
    $scope.column = '';
    } else {
    $scope.newClient = false;
    $scope.id = $scope.clients[id-1].id;
    $scope.name = $scope.clients[id-1].name;
    $scope.column = $scope.clients[id-1].column;
  }
};

$scope.saveClient = function() {
  $scope.clients[$scope.id-1].name = $scope.name;
  $scope.clients[$scope.id-1].column = $scope.column;
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
  if ($scope.newClient && (!$scope.id.length ||  !$scope.name.length ||  !$scope.column.length)) {
       $scope.incomplete = true;
  }
};

});
