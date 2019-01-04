<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title></title>
  <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
  <link rel="stylesheet" href="./assets/css/regist.css" />
  <link href="./assets/css/common.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans|Quicksand|Source+Sans+Pro" rel="stylesheet" />
</head>

<body>

    <div class="grid-container">
      <form:form class="form-signin" modelAttribute="userForm">
        <div class="logo">SEDAS</div>
        <h1 id="signin">Register Here</h1>

        <spring:bind path="username">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="control-label" for="textinput">Username</label>
            <div>
              <form:input id="username" path="username" placeholder="Insert your Username" class="form-control input-md" required="" type="text"></form:input>
              <form:errors path="username"></form:errors>
              <span class="help-block"> </span>
            </div>
          </div>
        </spring:bind>


  <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label class="control-label" for="textinput">Password</label>
          <div>
            <form:input id="password" path="password" placeholder="Insert your Password" class="form-control input-md" required="" type="password"></form:input>
            <form:errors path="password"></form:errors>
            <span class="help-block"> </span>
          </div>
        </div>
</spring:bind>

<spring:bind path="passwordConfirm">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label class="control-label" for="textinput">Confirm Password</label>
          <div>
            <form:input id="passwordConfirm" path="passwordConfirm" placeholder="Confirm your Password" class="form-control input-md" required="" type="password"></form:input>
            <form:errors path="passwordConfirm"></form:errors>
            <span class="help-block"> </span>
          </div>
        </div>
</spring:bind>

        <button class="btn btn-lg btn-primary btn-block" style="font-size: 14px;" type="submit">
          Submit
        </button>
      </form:form>
    </div>
    <!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


</body>

</html>