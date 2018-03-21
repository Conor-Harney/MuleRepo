function init(){

	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {
			  
		$scope.emailStrings = [];
		var pl = #[payload];
		for(var eml in pl) {
			var oneEmail = pl[eml];
			$scope.emailStrings.push(oneEmail);
		}
	});
}
