app.controller("Product", function userController($scope) {
$scope.id = '';
$scope.client_id = '';
$scope.label = '';
//Start of user code Sample data block
$scope.products = [
{id:1, fName:'Hege',  lName:"Pege" },
{id:2, fName:'Kim',   lName:"Pim" },
{id:3, fName:'Sal',   lName:"Smith" },
{id:4, fName:'Jack',  lName:"Jones" },
{id:5, fName:'John',  lName:"Doe" },
{id:6, fName:'Peter', lName:"Pan" }
];
End of user code

$scope.edit = true;
$scope.error = false;
$scope.incomplete = false; 

$scope.editProduct = function(id) {
  if (id == 'new') {
    $scope.edit = true;
    $scope.incomplete = true;
    $scope.id = '';
    $scope.client_id = '';
    $scope.label = '';
    } else {
    $scope.edit = false;
    $scope.id = $scope.products[id-1].id;
    $scope.client_id = $scope.products[id-1].client_id;
    $scope.label = $scope.products[id-1].label;
  }
};

//$scope.$watch('passw1',function() {$scope.test();});
//$scope.$watch('passw2',function() {$scope.test();});
$scope.$watch('id', function() {$scope.test();});
$scope.$watch('client_id', function() {$scope.test();});
$scope.$watch('label', function() {$scope.test();});

$scope.test = function() {
  /*if ($scope.passw1 !== $scope.passw2) {
    $scope.error = true;
    } else {
    $scope.error = false;
  }*/
  $scope.incomplete = false;
  if ($scope.edit && (
  !$scope.id.length
||  !$scope.client_id.length
||  !$scope.label.length
)) {
       $scope.incomplete = true;
  }
};

});
