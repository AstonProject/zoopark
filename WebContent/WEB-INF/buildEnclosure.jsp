<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/buildEnclosure.css" />
<title>Building_menu</title>
</head>
<body>
	<h1>Building menu</h1>
	<br>
	<div class="enclosureChoice">
		<form action="createEnclosure" method="post" id="FormCreateEnclosure">
			<h3>Enclosure type</h3>
			<br>

			<div id="radio1">
				<input type="radio" name="enclosureType" value="Elephant"
					id="radio_elephant"> <img
					src="${pageContext.request.contextPath}/assets/images/Contruction_menu_elephant.png" alt="logo" /> <input
					type="radio" name="enclosureType" value="Giraffe"
					id="radio_giraffe"> <img
					src="${pageContext.request.contextPath}/assets/images/Contruction_menu_giraffe.png" alt="logo" /> <input
					type="radio" name="enclosureType" value="Lion" id="radio_lion">
				<img src="${pageContext.request.contextPath}/assets/images/Contruction_menu_lion.png" alt="logo" /> <input
					type="radio" name="enclosureType" value="Camel" id="radio_camel">
				<img src="${pageContext.request.contextPath}/assets/images/Contruction_menu_camel.png" alt="logo" />
			</div>
			<br>

			<h3 class="Enclosure-Description-Title">Description</h3>

			<div class="enclosureDescription">
				
			</div>
			<br>

			<h3>Enclosure size</h3>

			<div id="radio2">
				<input type="radio" name="enclosureSize" value="1"
					id="size_1"> 1 <input type="radio" name="enclosureSize"
					value="2" id="size_2"> 2 <input type="radio"
					name="enclosureSize" value="3" id="size_3"> 3
			</div>
			
			<h3>Price</h3>

			<div class="showPrice">
				<div class="price"></div>
			</div>
			<br> 
			<div class= "decision_menu">
				<span id="decision">
					<input type="submit" value="" class="validate_img"><a href="home"><img src="${pageContext.request.contextPath}/assets/images/cancel.png" alt="logo" /></a>		
				</span>
				<div class="error"></div>
			</div>
		</form>
	</div>

</body>
	<script src="${pageContext.request.contextPath}/assets/vendors/jquery-3.1.1.js"></script>
	<script src="${pageContext.request.contextPath}/assets/scripts/zoo.js"></script>
	<script src="${pageContext.request.contextPath}/assets/scripts/buildEnclosure.js"></script>
</html>