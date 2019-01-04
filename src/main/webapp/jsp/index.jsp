<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
  <%--<meta charset="utf-8" />--%>
  <%--<meta http-equiv="X-UA-Compatible" content="IE=edge" />--%>
  <%--<meta name="viewport" content="width=device-width, initial-scale=1" />--%>
  <%--<title></title>--%>
  <%--<link rel="stylesheet" href="assets/css/bootstrap.min.css" />--%>
  <%--<link rel="stylesheet" href="assets/css/signin.css" />--%>
  <%--<link--%>
          <%--href="https://fonts.googleapis.com/css?family=Alegreya+Sans|Quicksand|Source+Sans+Pro"--%>
          <%--rel="stylesheet"--%>
  <%--/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="grid-container">--%>
  <%--<form class="form-signin" method="POST" action="${contextPath}/confirmPatientInfoForm">--%>
    <%--<div class="form-group">--%>
      <%--<div class="logo">SEDAS</div>--%>
      <%--<h1 id="signin">Please Input Patient Information</h1>--%>
      <%--<div class="searchid">--%>
        <%--<label for="patientFirstName" class="sr-only">First Name</label>--%>
        <%--<input name="patientFirstName" id="patientFirstName" type="text" placeholder="First Name" class="form-control input-md" required>--%>
        <%--<label for="patientLastName" class="sr-only">Last Name</label>--%>
        <%--<input name="patientLastName" id="patientLastName" type="text" placeholder="Last Name" class="form-control input-md" required>--%>
        <%--<label for="patientBirthDate" class="sr-only">Date Of Birth</label>--%>
        <%--<input name="patientBirthDate" id="patientBirthDate" type="text" placeholder="YYYY-MM-DD" class="form-control input-md" required>--%>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
      <%--</div>--%>
    <%--</div>--%>

    <%--<div class="form-group">--%>
      <%--<div>--%>
        <%--<button id="SearchID" name="SearchID" type="submit" class="btn btn-lg btn-primary btn-block"--%>
        <%-->Search</button>--%>
      <%--</div>--%>
    <%--</div>--%>

  <%--</form>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/css/choose.css">
<link rel="stylesheet" href="assets/css/all.css" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<title></title>

</head>
<body>

<div class="split left">
<div class="centered">
<i class="fas fa-search"></i>
<h2>Existing Patient</h2>


<form method="POST" action="${contextPath}/confirmPatientInfoForm">
<div class="form-group">
<div class="searchid">
<input name="patientFirstName" id="patientFirstName" type="text" placeholder="First Name" class="form-control input-md" required>
<input name="patientLastName" id="patientLastName" type="text" placeholder="Last Name" class="form-control input-md" required>
<input name="patientBirthDate" id="patientBirthDate" type="text" placeholder="YYYY-MM-DD" class="form-control input-md" required>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</div>
</div>

<div class="form-group">
<div>
<button id="SearchID" name="SearchID" type="submit" class="btn btn-primary">Search</button>
</div>
</div>

</form>

</div>
</div>

<div class="split right">
<div class="centered">
<i class="fas fa-file-signature"></i>
<h2>New Paitent</h2>
<p>Click the button to create a new patient.</p>
<a href="${contextPath}/inputNewPatientInfo" class="btn btn-default">Create</a>
</div>
</div>

</body>
</html>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="assets/css/choose.css">
    <link rel="stylesheet" href="assets/css/all.css" />
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <title></title>

  </head>
  <body>

    <div class="split left">
      <div class="centered">
        <i class="fas fa-search"></i>
        <h2>Existing Patient</h2>


<form method="POST" action="${contextPath}/confirmPatientInfoForm">
<div class="form-group">
  <div class="searchid">
      <label for="patientFirstName" class="sr-only">First Name</label>
      <input name="patientFirstName" id="patientFirstName" type="text" placeholder="First Name" class="form-control input-md" required>
      <label for="patientLastName" class="sr-only">Last Name</label>
      <input name="patientLastName" id="patientLastName" type="text" placeholder="Last Name" class="form-control input-md" required>
      <label for="patientBirthDate" class="sr-only">Date Of Birth</label>
      <input name="patientBirthDate" id="patientBirthDate" type="text" placeholder="YYYY-MM-DD" class="form-control input-md" required>
    <%--<input name="patientID" id="patientID" type="text" placeholder="Paitent ID" class="form-control input-md" required>--%>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </div>
</div>

<div class="form-group">
  <div>
    <button id="SearchID" name="SearchID" type="submit" class="btn btn-primary">Search</button>
  </div>
</div>

</form>

      </div>
    </div>

    <div class="split right">
      <div class="centered">
        <i class="fas fa-file-signature"></i>
        <h2>New Paitent</h2>
        <p>Click the button to create a new patient.</p>
        <a href="${contextPath}/inputNewPatientInfo" class="btn btn-default">Create</a>
      </div>
    </div>

  </body>
</html>
