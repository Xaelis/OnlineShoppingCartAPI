app.controller("clientController", function clientController($scope) {
$scope.selectedIndex = 'newClient';
$scope.client = {id: '', name:'', column:''};
$scope.clients = [
{id:1, name:'Toto', column:100},
{id:2, name:'Titi', column:150},
];

$scope.newClient = true;
$scope.error = false;
$scope.incomplete = false; 

$scope.editClient = function(index) {
  if (index == 'new') {
     $scope.cleanForm();
    } else {
    $scope.newClient = false;
    $scope.selectedIndex = index;
    $scope.client.id = $scope.clients[index].id;
    $scope.client.name = $scope.clients[index].name;
    $scope.client.column = $scope.clients[index].column;
  }
};

$scope.saveClient = function() {
  if ($scope.selectedIndex != 'newClient') {
    $scope.clients[$scope.selectedIndex].name = $scope.client.name;
    $scope.clients[$scope.selectedIndex].column = $scope.client.column;
 } else {
    $scope.clients.push(angular.copy($scope.client));
    $scope.cleanForm();
 }
};

$scope.cleanForm = function() {
   $scope.newClient = true;
   $scope.incomplete = true;
   $scope.selectedIndex = 'newClient';
   $scope.index = '';
   $scope.client.id = '';
   $scope.client.name = '';
   $scope.client.column = '';
};

//$scope.$watch('passw1',function() {$scope.test();});
//$scope.$watch('passw2',function() {$scope.test();});
$scope.$watch('client.id', function() {$scope.test();});
$scope.$watch('client.name', function() {$scope.test();});
$scope.$watch('client.column', function() {$scope.test();});

$scope.test = function() {
  /*if ($scope.passw1 !== $scope.passw2) {
    $scope.error = true;
    } else {
    $scope.error = false;
  }*/
  $scope.incomplete = false;
  if ($scope.newClient && (!$scope.client.id.length ||  !$scope.client.name.length ||  !$scope.client.column.length)) {
       $scope.incomplete = true;
  }
};

});
