<%@ include file="/WEB-INF/parts/header.jsp" %>
<div id="main-content">
<h2>Your employees</h2>
<div id="employees_container" class="ec1">
	<span class="img_container"><img src="${pageContext.request.contextPath}/assets/images/healer.png" alt="logo" /></span>
	<span class="img_container"><img src="${pageContext.request.contextPath}/assets/images/cleaner.png" alt="logo" /></span>
	<span class="img_container"><img src="${pageContext.request.contextPath}/assets/images/security.png" alt="logo" /></span>
</div>

<div id="employees_container" class="ec2"><p>Assigned</p><span class="assigned_healer"></span><span class="assigned_cleaner"></span><span class="assigned_security"></span></div>
<div id="employees_container" class="ec2"><p>Unassigned</p><span class="unassigned_healer"></span><span class="unassigned_cleaner"></span><span class="unassigned_security"></span></div>
<div id="employees_container" class="ec2"><p>Total</p><span class="total_healer"></span><span class="total_cleaner"></span><span class="total_security"></span></div>

<h2>Engage / Dismiss</h2>
<form action="" method="post" id="FormEngageDismiss">
	<div id="employees_container" class="ec3">
		<span><input type="number" max="0" min="0" value="0" name="quantityHeal" class="mod" id="heal_quantity" /></span>
		<span><input type="number" max="0" min="0" value="0" name="quantityClean" class="mod" id="clean_quantity" /></span>
		<span><input type="number" max="0" min="0" value="0" name="quantitySecurity" class="mod" id="secu_quantity" /></span>
	</div>
	
	<br>
	<h3>Price</h3>
		<div class="showPrice">
			<div class="emp_price">0</div>
		</div>
	<br>
	
	<div class="decision_menu">
		<span id="decision"> 
			<input type="submit" value="" class="validate_img">
			<a href="home"><img src="${pageContext.request.contextPath}/assets/images/cancel.png" alt="logo" /></a>
		</span>
		<div class="error"></div>
	</div>
</form>
</div>
<%@ include file="/WEB-INF/parts/footer.jsp" %>