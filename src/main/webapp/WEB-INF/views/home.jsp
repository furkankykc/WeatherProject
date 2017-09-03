<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<style>
body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    -webkit-animation: fadeEffect 1s;
    animation: fadeEffect 1s;
}

/* Fade in tabs */
@-webkit-keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}

@keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

	<title>Home</title>
	
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'menu1')">Menu-1</button>
  <c:if test="${loggedUser.getIsAdmin()}">
 	 <button class="tablinks" onclick="openTab(event, 'menu2')">Menu-2</button>
 </c:if>
  <button class="tablinks" onclick="openTab(event, 'menu3')">Menu-3</button>
   <c:if test="${loggedUser.getIsAdmin()}">
  <button class="tablinks" onclick="openTab(event, 'menu4')">Menu-4</button>
  </c:if>
</div>
<div id="menu1" class="tabcontent">
  <h3>Menu-1 : Lokasyon Duzenle</h3>
  
 <form:form commandName="locationBean" action="Location" method="POST">
    	<label>Location Name</label> 
    	<input type='text' maxlength="20" name='locationName'/>
    	<input name="add" type="submit" value="Insert Location" class="btn">
		</form:form>
	  <table border="1">
        <tr>
        	<td>Id</td>
         	<td>Location Name</td>
           
        </tr>
        
        
	
<c:forEach items="${locations}" var="location">
			<tr>
			<td>${location.getId()} </td>
			<td>${location.getLocationName()}</td>	
			
			
<form:form method="POST" action="Location">
			<input type="hidden" value="${location.getId()}" name="id">
			<input type="hidden" value="${location.getLocationName()}" name="locationName">
			<td>
			<label>&nbsp;</label> <input type="submit" name ="details" value = "update" class = "btn"></td>
		<td><label>&nbsp;</label> <input type="submit" name ="del" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
			
	</c:forEach>

	</table>
</div>

<div id="menu2" class="tabcontent">
  <h3>Menu-2 : Hava Durumu</h3>
  	<form:form commandName="locationBean" action="Location" method="POST">
	
	<form:select path="id" id="id">
			<c:forEach items="${locations}" var="c">
				<form:option name="id" value="${c.getId()}" label="${c.getLocationName() }" />
			</c:forEach>
		</form:select>
		<input name="query" type="submit" value="Query" class="btn">
</form:form>
		<table border="1">
  <tr>
         <td>Logs</td>
         </tr>
        <tr>
         	<td>Id</td>
            <td>User</td>
            <td>Location</td>
            <td>Time</td>
            <td>IP</td>
			<td>Result</td>
        </tr> 
        
        
			<tr>
			<td>${queryResult.getCurrentObservation().getDisplayLocation().getFull()} </td>
			<td>${queryResult.getCurrentObservation().getDisplayLocation().getLatitude()}</td>
			<td>${queryResult.getCurrentObservation().getDisplayLocation().getLongitude()}</td>
			<td>${queryResult.getCurrentObservation().getDisplayLocation().getElevation()}</td>
			<td>${queryResult.getCurrentObservation().getTemperatureString()}</td>
			<td>${queryResult.getCurrentObservation().getTempF()}</td>

			</tr>
	</table>
 
</div>

<div id="menu3" class="tabcontent">
  <h3>Menu-3 : Kullanici Duzenle</h3>
 <form:form commandName="userBean" action="User" method="POST">

<li><label>User Name</label> <input type='text' name='username' />
    <label>Password</label> <input type='password' name='password' />

		
				<input name="add" type="submit" value="Insert User" class="btn">
	
</form:form>
<table border="1">
  <tr>
         <td>User</td>
         </tr>
        <tr>
         	<td>Id</td>
            <td>UserName</td>
            <td>Password</td>
            <td>Tipi	</td>

        </tr> 
        
        
<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.getId()} </td>
			<td>${user.getUsername()}</td>
			<td>${user.getPassword()}</td>
			<td>${user.getIsAdmin()}</td>
<form:form method="POST" action="User">
			<input type="hidden" value="${user.getId()}" name="id">
			<td>
			<label>&nbsp;</label> <input type="submit" name ="details" value = "update" class = "btn"></td>
			<td><label>&nbsp;</label> <input type="submit" name ="del" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
	</c:forEach>
	</table>
 

</div>

<div id="menu4" class="tabcontent">
   <form:form commandName="logBean" action="Log" method="POST">
   <form:select path="userId" id="id">
		<form:option name="userId" value="0" label="None" />
	<c:forEach items="${users}" var="c">
		<form:option name="userId" value="${c.getId()}" label="${c.getUsername() }" />
	</c:forEach>
	</form:select>
<form:select path="locationId" id="id">
	<form:option name="locationId" value="0" label="None" />
	<c:forEach items="${locations}" var="c">
		<form:option name="locationId" value="${c.getId()}" label="${c.getLocationName() }" />
	</c:forEach>
	</form:select>
	
	 <input type="date" name="timeString">
		
				<input name="query" type="submit" value="Filter" class="btn">
	
</form:form>
  <h3>Menu-4 : Raporlar</h3>
 	<table border="1">
  <tr>
         <td>Logs</td>
         </tr>
        <tr>
         	<td>Id</td>
            <td>User</td>
            <td>Location</td>
            <td>Time</td>
            <td>IP</td>
			<td>Result</td>
        </tr> 
        
        
<c:forEach items="${logs}" var="log">
			<tr>
			<td>${log.getId()} </td>
			<td>${log.getUserId()}</td>
			<td>${log.getLocationId()}</td>
			<td>${log.getTime()}</td>
			<td>${log.getIp()}</td>
			<td>${log.getResultStatus()}</td>

			</tr>
	</c:forEach>
	</table>
 
  
</div>

<script>
function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}
window.onload = openTab(event,'${menu}');
</script>




${msg }
${durum.getCurrentObservation().getDisplayLocation().getFull()}	

${durum.getCurrentObservation().getTempC()}	
  <form:form  action="logout" method="POST">
	<input name="logOut" type="submit" value="Logout" class="btn">
	</form:form>
</body>
</html>
