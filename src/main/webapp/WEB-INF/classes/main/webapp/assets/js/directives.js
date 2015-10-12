angular.module('myApp.directives', [])
.directive('activeLink', ['$location', function(location) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs, controller) {
            var clazz = attrs.activeLink;
            var path = element.children()[0].getAttribute('href');
            path = path.substring(1); //hack because path does bot return including hashbang
            scope.location = location;
            scope.$watch('location.path()', function(newPath) {
                if (path === newPath) {
                    element.addClass(clazz);
                } else {
                    element.removeClass(clazz);
                }
            });
        }

    };

}])
.directive("customSort", function() {
	return {
		restrict: 'A',
		transclude: true,    
		scope: {
		  order: '=',
		  sort: '='
		},
		template : 
		  ' <a ng-click="sort_by(order)" style="color: #555555;">'+
		  '    <span ng-transclude></span>'+
		  '    <i ng-class="selectedCls(order)"></i>'+
		  '</a>',
		link: function(scope) {
					
		// change sorting order
		scope.sort_by = function(newSortingOrder) {       
			var sort = scope.sort;
			
			if (sort.sortingOrder == newSortingOrder){
				sort.reverse = !sort.reverse;
			}                    

			sort.sortingOrder = newSortingOrder;        
		};
		
	   
		scope.selectedCls = function(column) {
			if(column == scope.sort.sortingOrder){
				return ('icon-chevron-' + ((scope.sort.reverse) ? 'down' : 'up'));
			}
			else{            
				return'icon-sort' 
			} 
		};      
	  }// end link
	}
});