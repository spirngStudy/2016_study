<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ include file="/WEB-INF/views/common/default-head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
var myApp = angular.module('myApp', []);

myApp.controller('MainCtrl', ['$scope', function ($scope) {
    
    $scope.text = 'Hello, Angular fanatic.';
    
}]);
</script>
</head>
<body>
<div ng-app="myApp">
    <div ng-controller="MainCtrl">
         {{ text }}
    </div>
</div>
</body>
</html>