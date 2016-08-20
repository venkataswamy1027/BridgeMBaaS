$(document).ready(function() {
	$('.nav-trigger').click(function() {
		$('.side-nav').toggleClass('visible');
	});
});
(function() {
	  'use strict';

	  angular.module('MyApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache'])
	      .controller('AppCtrl', AppCtrl);

	  function AppCtrl($scope) {
	    $scope.currentNavItem = 'page1';
	  }
	})();