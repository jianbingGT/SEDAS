<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
  <link rel="stylesheet" href="./assets/css/sedas.css" />
  <link rel="stylesheet" href="./assets/css/all.css" />
  <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
  <link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light|Alegreya+Sans|Quicksand|Source+Sans+Pro" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>

<body>
  <div class="wrapper">
    <div class="grid-container">
       <div class="sidebar">
        <div class="logo">SEDAS</div>
        <div class="sidebar-items">
          <a href="./index.html"><i class="fas fa-user-md"></i> Search Patient</a>
        </div>
        <div class="sidebar-items ">
          <i class="far fa-user-circle"></i> Profile
        </div>
        <div class="sidebar-items">
          <i class="fas fa-capsules"></i> Dose
        </div>
        <div class="sidebar-items active">
          <i class="fas fa-star-half-alt"></i> Guide
        </div>
        <div class="sidebar-items">
          <i class="fas fa-wrench"></i> Feedback
        </div>
      </div>
      <div class="avator"><img src="./assets/images/profile.jpg" alt="" /></div>
      <div class="patientName">
        ${patientName}

        <c:choose>
          <c:when test="${patientGender=='male'}">
            <span class="male"><i class='fas fa-mars'></i></span>
          </c:when>
          <c:otherwise>
            <span class="female"><i class='fas fa-venus'></i></span>
          </c:otherwise>
        </c:choose>

      </div>
      <div class="age">
        <div class="pro">age <span class="input">${patientAge}</span></div>
        <div class="pro">ID <span class="input">${patientId}</span></div>
      </div>
      <div class="contact">
        <div class="pro">Contact <span class="input">${phone}</span></div>
        <div class="pro">
          Address <span class="input">${address}</span>
        </div>
      </div>

      <div class="sedation">
        <div class="sedation-container">
          <h1></h1>
          <div id="results">
            
          </div>
          
        </div>

        <div class="score-panel">
          <h1>Background</h1>
          <div id="tobacco" ${isSmoking ?"class='panel-item active'":" class='panel-item'"}>
              <i ${isSmoking ?" class='fas fa-check-circle'":" class='far fa-circle'"}></i> Tobacco
            </div>
            <div id=" benzodiazepine"
            ${isBenzo ?"class='panel-item active'":" class='panel-item'"}>
              <i ${isBenzo  ?" class='fas fa-check-circle'":" class='far fa-circle'"}></i> Benzodiazephi Use
            </div>
            <div id=" opioid" ${isOpioid
            ?"class='panel-item active'":" class='panel-item'"}>
              <i ${isOpioid  ?" class='fas fa-check-circle'":" class='far fa-circle'"}></i> Opiod Use
            </div>
    
			<div id=" height" class="panel-item active">
              <i class="fas fa-male"></i> Height: ${patientHeight} cm
            </div>
            <div id=" bml" class="panel-item active">
              <i class="fas fa-weight"></i> Weight: ${patientWeight} lb
            </div>
            <div id=" bloodpressure" class="panel-item active">
              <i class="fas fa-heartbeat"></i> Blood Pressure: ${patientBloodPres} mm/hg
            </div>
            <div id=" bml" class="panel-item active">
              <i class="far fa-smile"></i> BMI: ${patientBmi}
            </div>


          </div>

        </div>

        <div class="dose">
           
         <form method="POST" action="${contextPath}/feedback">
                <h1 style="font-size:30px;">Guidelines</h1>
                <p>Guideline 1</p>
                <a>During moderate sedation procedures, the person administering sedation MAY assist with MINOR tasks while maintaining adequate patient monitoring once the patient's level of sedation has been stabilized</a>  
                <br>
                <br>
                <p>Guideline 2</p>
                <a>The clinician monitoring the patient should not be the same individual who is performing the procedure  </a> 
                <br>
                <br>
                <p>Guideline 3</p>
                <a> Deep sedation is generally defined as a state wherein there is a purposeful patient response to tactile/painful stimulation but no patient response to verbal stimulation.  This is not moderate sedation.  Persons providing this level of sedation should be trained in anesthesiology and should have NO additional responsibilities other than the conduct of the deep sedation or anesthesia. </a>
                <br>
       
                <div class="pull-right"><input type="submit" class="btn" value="Next"/></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
         
         <form:form method="POST" action="${contextPath}/backtodose" >
         <div class="pull-left"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></div>
          <input type="submit" class="btn" value="back"/>
        </form:form>
         
         
         
         </div>

        </div>
      </div>

      

    
</body>

</html>
