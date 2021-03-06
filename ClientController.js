app.controller("clientController", function clientController($scope) {
$scope.selectedIndex = 'newClient';
$scope.client = {id:'', name:'', column:''};

$scope.clients = [
{id:'dataid', name:'dataname', column:'datacolumn'},
{id:'dataid2', name:'dataname2', column:'datacolumn2'}
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
    $scope.clients[$scope.selectedIndex].id = $scope.client.id;
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

$scope.$watch('client.id', function() {$scope.test();});
$scope.$watch('client.name', function() {$scope.test();});
$scope.$watch('client.column', function() {$scope.test();});

$scope.test = function() {
  $scope.incomplete = false;
  if ($scope.newClient && (!$scope.client.id.length
 || !$scope.client.name.length
 || !$scope.client.column.length
)) {
       $scope.incomplete = true;
  }
};

});
