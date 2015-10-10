angular.module('myApp', ['ui.router','myApp.controllers', 'myApp.services', 'myApp.directives'])
.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider
    .state('dashboard', {
      url: '/dashboard',
      templateUrl: 'pages/dashboard.html',
      controller: 'DashboardCtrl'
    })
	.state('categories', {
      url: '/categories',
      templateUrl: 'pages/categories.html',
      controller: 'CategoriesCtrl'
    })
	.state('questions', {
      url: '/questions',
      templateUrl: 'pages/questions.html',
      controller: 'QuestionsCtrl'
    })
	.state('reports', {
      url: '/reports',
      templateUrl: 'pages/reports.html',
      controller: 'ReportsCtrl'
    })
	.state('exclusions', {
      url: '/exclusions',
      templateUrl: 'pages/exclusions.html',
      controller: 'ExclusionsCtrl'
    });

  $urlRouterProvider.otherwise('dashboard');
});
