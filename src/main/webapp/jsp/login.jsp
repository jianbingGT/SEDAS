<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title></title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/signin.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Alegreya+Sans|Quicksand|Source+Sans+Pro"
      rel="stylesheet"
    />
  </head>
  <body>
      <div class="grid-container">
        <form class="form-signin" method="POST" action="${contextPath}/login">
          <div class="logo">SEDAS</div>
          <h1 id="signin">Please sign in</h1>
          <label for="username" class="sr-only">Username</label>
          <input name="username"
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            required
            autofocus
          />
          <label for="password" class="sr-only">Password</label>
          <input name="password"
            type="password"
            id="inputPassword"
            class="form-control"
            placeholder="Password"
            required
          />
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <div class="checkbox mb-3">
		              <%-- <span style="color: red; font-size: 12px;">${error}</span> --%>
		              <c:if test="${param.logout != null }">
		                  <i> You have been logged out successfully! </i>
		              </c:if>
          </div>
          <button
            class="btn btn-lg btn-primary btn-block"
            style="font-size: 14px;"
            type="submit"
          >
            Sign in
          </button>
          <p class="mb-3 text-muted" style="margin-top:20px; text-align: center;"><a href="${contextPath}/registration">Create an account</a></p>
          <p class="copyright">&copy; 2018</p>
        </form>
      </div>

  </body>
</html>

