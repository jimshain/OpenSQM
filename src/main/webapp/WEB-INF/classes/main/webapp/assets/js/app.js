angular.module('myApp', ['ui.router','myApp.controllers', 'myApp.services', 'myApp.directives'])
.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider
    .state('dashboard', {
      url: '/dashboard',
      templateUrl: '/dashboard.jsp',
      controller: 'DashboardCtrl'
    })
	.state('categories', {
      url: '/categories',
      templateUrl: '/categories.jsp',
      controller: 'CategoriesCtrl'
    })
	.state('questions', {
      url: '/questions',
      templateUrl: '/questions.jsp',
      controller: 'QuestionsCtrl'
    })
	.state('reports', {
      url: '/reports',
      templateUrl: '/reports.jsp',
      controller: 'ReportsCtrl'
    })
	.state('exclusions', {
      url: '/exclusions',
      templateUrl: '/exclusions.jsp',
      controller: 'ExclusionsCtrl'
    });

  $urlRouterProvider.otherwise('dashboard');
});
