<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form commandName="Location" action="" method="POST">
 <li><label>Name</label> <input value="${location.getLocationName() }" type='text' name='locationName' />
 	<input type="hidden" value="${location.getId()}" name="id">

	<input name="update" action="update"  type="submit" value="Update" class="btn">
	
</form:form>
		<div style="color: red">${msg}</div>



	${location}
</body>
</html>