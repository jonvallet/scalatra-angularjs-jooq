var todoApp = angular.module('todoApp', []);

todoApp.controller('TodoCtrl', function ($scope,$http) {

  $scope.todos = []
  $scope.newTodo = {}
  $scope.new = function(todo) {
    var newItem = {
      "name":$scope.newTodo.name,
      "description":$scope.newTodo.description,
      "done":false
    }
    saveNew(newItem)
  }

  $http.get('/api/todo').then(function successCallback(response) {
    $scope.todos = response.data
  })

  function saveNew(todo) {
    $http.post('/api/todo', todo).then(function successCallback(response) {
      $scope.todos.push(response.data)
    })
  }

});