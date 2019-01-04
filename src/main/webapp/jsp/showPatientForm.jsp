<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST"
          action="calculateRisk" modelAttribute="patientForm">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="weight">
                      Weight</form:label></td>
                    <td><form:input path="weight"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
        <form:form method="POST" action="${contextPath}/logout" >
          <input type="submit" value="Logout"/>
        </form:form>
        
</body>
</html> --%>


