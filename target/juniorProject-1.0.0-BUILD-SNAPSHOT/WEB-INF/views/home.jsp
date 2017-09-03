<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<label>MENU1-LOKASYON DÜZENLE</label>
<form:form commandName="locationBean" action="Location" method="POST">
    	<label>Location Adi</label> 
    	<input type='text' maxlength="20" name='locationName'/>
    	<input name="add" type="submit" value="Location Ekle" class="btn">
		</form:form>
	  <table border="1">
        <tr>
        	<td>Id</td>
         	<td>YER ADI</td>
           
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
	<form:form commandName="locationBean" action="Location" method="POST">
	
	<form:select path="id" id="id">
			<c:forEach items="${locations}" var="c">
				<form:option name="id" value="${c.getId()}" label="${c.getLocationName() }" />
			</c:forEach>
		</form:select>
		<input name="query" type="submit" value="Sorgula" class="btn">
</form:form>
	${ queryResult}
<form:form commandName="userBean" action="User" method="POST">

<li><label>User Name</label> <input type='text' name='username' />
    <label>Password</label> <input type='password' name='password' />

		
				<input name="add" type="submit" value="User Ekle" class="btn">
	
<table border="1">
  <tr>
         <td>Kullanıcı</td>
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
 
</form:form>
${msg }
<!--<c:if test="${loggedUser.getIsAdmin()}">-->
   

<!-- </c:if> -->
${durum.getCurrentObservation().getDisplayLocation().getFull()}	

${durum.getCurrentObservation().getTempC()}	

</body>
</html>
