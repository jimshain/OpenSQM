angular.module('myApp', ['ui.router','myApp.controllers', 'myApp.services', 'myApp.directives'])
.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider
    .state('categories', {
      url: '/categories',
      templateUrl: '/OpenSQM-1.0/v1.0/categories',
      controller: 'CategoriesCtrl'
    })
	.state('questions', {
      url: '/questions',
      templateUrl: '/OpenSQM-1.0/v1.0/questions',
      controller: 'QuestionsCtrl'
    })
	.state('reports', {
      url: '/reports',
      templateUrl: '/OpenSQM-1.0/v1.0/reports',
      controller: 'ReportsCtrl'
    })
	.state('exclusions', {
      url: '/exclusions',
      templateUrl: '/OpenSQM-1.0/v1.0/exclusions',
      controller: 'ExclusionsCtrl'
    });

  $urlRouterProvider.otherwise('categories');
});
