app.controller("productController", function productController($scope) {
$scope.selectedIndex = 'newProduct';
$scope.product = {id:'', client_id:'', label:''};

$scope.products = [
{id:'data', client_id:'data', label:'data'},
{id:'data2', client_id:'data2', label:'data2'}
];

$scope.newProduct = true;
$scope.error = false;
$scope.incomplete = false; 

$scope.editProduct = function(index) {
  if (index == 'new') {
      $scope.cleanForm();
    } else {
      $scope.newProduct = false;
      $scope.selectedIndex = index;
      $scope.product.id = $scope.products[index].id;
      $scope.product.client_id = $scope.products[index].client_id;
      $scope.product.label = $scope.products[index].label;
    }
};


$scope.saveProduct = function() {
 if ($scope.selectedIndex != 'newProduct') {
    $scope.clients[$scope.selectedIndex].id = $scope.product.id;
    $scope.clients[$scope.selectedIndex].client_id = $scope.product.client_id;
    $scope.clients[$scope.selectedIndex].label = $scope.product.label;
 } else {
    $scope.products.push(angular.copy($scope.product));
    $scope.cleanForm();
 }
};

$scope.cleanForm = function() {
   $scope.newProduct = true;
   $scope.incomplete = true;
   $scope.selectedIndex = 'newProduct';
   $scope.index = '';
   $scope.product.id = '';
   $scope.product.client_id = '';
   $scope.product.label = '';
};

$scope.$watch('product.id', function() {$scope.test();});
$scope.$watch('product.client_id', function() {$scope.test();});
$scope.$watch('product.label', function() {$scope.test();});

$scope.test = function() {
  $scope.incomplete = false;
  if ($scope.newProduct && (!$scope.product.id.length
 || !$scope.product.client_id.length
 || !$scope.product.label.length
)) {
       $scope.incomplete = true;
  }
};

});
