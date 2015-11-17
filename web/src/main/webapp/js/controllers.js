var todoApp = angular.module('todoApp', []);

todoApp.controller('TodoCtrl', function ($scope,$http) {

  $scope.todos = []
  $scope.newTodo = {}
  $scope.new = function(todo) {
    var newItem = {"id":$scope.todos.length+1,
                   "name":$scope.newTodo.name,
                   "description":$scope.newTodo.description,
                   "done":false}
    $scope.todos.push(newItem)
  }

  $http.get('/api/todo').then(function successCallback(response) {
    $scope.todos = response.data
  })

});