var todoApp = angular.module('todoApp', []);

todoApp.controller('TodoCtrl', function ($scope,$http) {

  $scope.todos = []
  $scope.newTodo = {}
  $scope.new = function() {
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

  $scope.updateDone = function (todo) {
    $http.put('/api/todo/'+todo.id+'/done', todo.done)
  }

  $scope.remove = function (remove) {
    $http.delete('/api/todo/'+remove.id).then(function successCallback() {
       var index = $scope.todos.indexOf(remove)
       $scope.todos.splice(index, 1)
    })
  }

});