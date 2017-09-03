<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Paneli </title>
</head>
<a> Kütüphane Otomasyon Sistemi Admin Paneli</a>

<br>
</br>
<body> 
<!--  th:action="@{/greeting}" th:object="${greeting}"  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table border="1">

	<td>Lokasyonlar</td>
	
  <td>
  <form method="get" action="Location">
    <button type="submit">Ekle</button>	</form></td>
        <tr>
        	<td>Id</td>
         	<td>Lokasyon Adı</td>
        </tr>
        
        
<c:forEach items="${locations}" var="location">
			<tr>
			<td>${location.getId()} </td>
			<td>${location.getLocationName()} </td>	
			
<form:form method="POST" action="Location">
			<input type="hidden" value="${location.getId()}" name="id">
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
	 
			</tr>
			
	</c:forEach>
	</table>
	<table border="1">
  
         <td> Kullanıcı</td>
         
  <td><form method="get" action="User">
    <button type="submit">Ekle</button>	</td>
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
			
			<td><label>&nbsp;</label> <input type="submit" name ="remove" action ="remove" value = "delete" class = "btn"></td>
			
	 </form:form>
			</tr>
	</c:forEach>
	</table>
 
</body>
</html>