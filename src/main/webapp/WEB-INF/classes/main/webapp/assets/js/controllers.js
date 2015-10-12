angular.module('myApp.controllers', [])
.controller('DashboardCtrl', function($scope) {
			
})
.controller('CategoriesCtrl', function($scope, $localstorage, $filter) {
	$scope.categories = [
		{
			category:"Money Transfer",
			weight:"10",
			created:new Date()
		},
		{
			category:"Check Cashing",
			weight:"20",
			created:new Date()
		}
	];
	
	$scope.sortType     = 'category'; // set the default sort type
	$scope.sortReverse  = false;  // set the default sort order
	
	$scope.saved_items = $localstorage.getObject("CAT_ITEMS");   
	
		if($scope.saved_items.length !== undefined){
			$scope.categories = $scope.saved_items;
		}
	$scope.item = {};
	$scope.save = function(){
		$scope.saved_items = $localstorage.getObject("CAT_ITEMS");   
		if($scope.saved_items.length !== undefined){
			$scope.categories = $scope.saved_items;
		}
		if($scope.From.$valid){
			//alert(JSON.stringify($scope.item));
			$scope.item.created = Date.now();
			$scope.categories.push($scope.item);
			$localstorage.setObject("CAT_ITEMS", $scope.categories);
			$scope.categories = $localstorage.getObject("CAT_ITEMS");
			$scope.item = {};
			
			$('#add_category').modal('hide');
			
		}else{
			alert("Invalid Entry!!!");
		}	
	};
	$scope.delete = function(index){
		var r = confirm("Are you sure, you want to remove this category ?");
		if (r == true) {
			$scope.categories.splice(index, 1)
			$localstorage.setObject("CAT_ITEMS", $scope.categories);
			$scope.categories = $localstorage.getObject("CAT_ITEMS");
			alert("Category removed successfull!!!");
		} 
	};
	$scope.edit = function(item){
		$scope.item = item;
		$('#edit_category').modal('show');
		
	};
			
})
.controller('QuestionsCtrl', function($scope, $localstorage) {
	
	$scope.questions = [
		{
			question:"Why did the chicken cross the road?",
			category:"Money Transfer",
			active:"Y",
			created:new Date()
		},
		{
			question:"How much would could a wookchuck chuck?",
			category:"Check Cashing",
			active:"Y",
			created:new Date()
		}
	]; 
	$scope.categories = $localstorage.getObject("CAT_ITEMS");	
	$scope.saved_items = $localstorage.getObject("QUESTIONS");   
	
		if($scope.saved_items.length !== undefined){
			$scope.questions = $scope.saved_items;
		}
	$scope.item = {};

	$scope.save = function(){
		$scope.saved_items = $localstorage.getObject("QUESTIONS");   
		if($scope.saved_items.length !== undefined){
			$scope.questions = $scope.saved_items;
		}
		if($scope.From.$valid){
			$scope.item.active = "Y";
			$scope.item.created = Date.now();
			$scope.questions.push($scope.item);
			$localstorage.setObject("QUESTIONS", $scope.questions);
			$scope.questions = $localstorage.getObject("QUESTIONS");
			$scope.item = {};
			$('#add_question').modal('hide');
			
		}else{
			alert("Invalid Entry!!!");
		}	
	};
		
			
})
.controller('ReportsCtrl', function($scope) {

		$scope.reports = [
			{store:100,taken:47,passed:23,percent:49},
			{store:110,taken:101,passed:5,percent:5},
			{store:240,taken:30,passed:27,percent:90},
			{store:594,taken:390,passed:143,percent:79},
			{store:560,taken:204,passed:231,percent:80},
			{store:560,taken:204,passed:231,percent:80}
		];
		
			
})
.controller('ExclusionsCtrl', function($scope) {
	
		$scope.exclusions = [
			{day:"Oct 09, 2015", start_time:"10:00", end_time:"14:00"},
			{day:"Oct 10, 2015", start_time:"11:00", end_time:"16:00"},
			{day:"Oct 11, 2015", start_time:"15:00", end_time:"18:00"}
		];
			
});
