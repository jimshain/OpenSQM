<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>OpenSQM</title>
    <!-- Bootstrap core CSS -->
	<link href="<c:url value="/assets/css/bootstrap.min.css" context="/OpenSQM-1.0/v1.0" />" rel="stylesheet" />
    <!--<link href="/assets/css/bootstrap.min.css" rel="stylesheet">-->
    <!-- Custom styles for this template -->
    <!--<link href="css/app.css" rel="stylesheet">-->
	<link href="<c:url value="/assets/css/app.css" context="/OpenSQM-1.0/v1.0" />" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	<div class="wrapper">
		<section id="nav">
			<header><h2>OpenSQM</h2></header>
			<ul class="nav nav-stacked">
				<!--<li active-link="active"><a href="#/dashboard"><span class="glyphicon glyphicon-dashboard"></span> &nbsp; Dashboard</a></li>-->
				<li active-link="active"><a href="#/categories"><span class="glyphicon glyphicon-th"></span> &nbsp; Categories</a></li>
				<li active-link="active"><a href="#/questions"><span class="glyphicon glyphicon-question-sign"></span> &nbsp; Questions</a></li>
				<li active-link="active"><a href="#/reports"><span class="glyphicon glyphicon-file"></span> &nbsp; Reports</a></li>
				<li active-link="active"><a href="#/exclusions"><span class="glyphicon glyphicon-calendar"></span> &nbsp; Exclusions</a></li>
			</ul>
		</section>
		<section id="body">
			<div id="content" ui-view></div>
		</section>		
	</div>
	<jsp:include page="includes/scripts.jsp" />
  </body>
</html>
