var todoApp = angular.module('todoApp', []);

todoApp.controller('TodoCtrl', function ($scope) {
  $scope.todos = [
    {"id":1,"name":"name","description":"description","done":false},
    {"id":2,"name":"name2","description":"description2","done":true},
    {"id":3,"name":"name3","description":"description3","done":true},
    {"id":4,"name":"name3","description":"description3","done":false}
  ];
  $scope.newTodo = {}
  $scope.new = function(todo) {
    var newItem = {"id":$scope.todos.length+1,
                   "name":$scope.newTodo.name,
                   "description":$scope.newTodo.description,
                   "done":false}
    $scope.todos.push(newItem)
  }
});