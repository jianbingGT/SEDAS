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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
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
        <div class="sidebar-items">
          <i class="fas fa-star-half-alt"></i> Guide
        </div>
        <div class="sidebar-items active">
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
            <div id=" weight" class="panel-item active">
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
        <h1 style="font-size:30px;">Feedback</h1>
           
        <form method="POST" action="${contextPath}/end" class="form-horizontal" name="theForm">
        
                    
                    <div class="row">
                    <div class="form-group col-xs-6">
                    <label for="text" class="control-label">Soberness</label> 
                    <select id="level" class="select form-control" name="selection" >
                      <option value="1">Level I - very sober</option>
                      <option value="2">Level II - medium sober</option>
                      <option value="3">Level III - sleepy</option>
                    </select>
                    </div>
                    </div>
                    <div class="form-group">
                    <label for="text" class="control-label">Degree of Pain</label>
                    <input type="text" id="pain" class="form-control" required="required" name="degree" placeholder="0(no pain) -> 9(terrible pain)"/>
                    </div>
                    <div class="form-group">
                    <label for="text" class="control-label">Satisfaction of Nurse Performance</label>
                    <input type="text" id="nurse" class="form-control" required="required" name="satisfaction" placeholder="0(terrible) -> 9(perfect)"/>
                    </div>
                    <div class="form-group">
                    <label for="text" class="control-label">Recovery Situation</label>
                    <input type="text" id="recovery" class="form-control" required="required" name="recovery"/>
                    </div>
                <div class="pull-right"><input id="logout" type="button" class="btn" value="Save & Logout" onclick="report()"/></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" style="display: none;" id="checktext"/>
            </form>

		<form:form method="POST" action="${contextPath}/backtoguide" >
         <div class="pull-left"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></div>
          <input type="submit" class="btn" value="back"/>
        </form:form>
         
         </div>

        </div>
      </div>

      
		<script>
		function report() {
		    var hislevel=document.getElementById("level").value;

            if (!document.getElementById("pain").value)
            {
                document.getElementById("checktext").click();
                return;
            }
            if (!document.getElementById("nurse").value)
            {
                document.getElementById("checktext").click();
                return;
            }
            if (!document.getElementById("recovery").value)
            {
                document.getElementById("checktext").click();
                return;
            }

            if (hislevel==1){
                swal({
                        title: "Level I",
                        text: "The patient can leave right now.",
                        type: "success"
                    },
                    function(){
                        document.theForm.submit();
                    });
        	} else if (hislevel==2){
                swal({
                        title: "Level II",
                        text: "The patient need to stay for 30 minutes",
                        type: "success"
                    },
                    function(){
                        document.theForm.submit();
                    });
	        } else if (hislevel==3){
                swal({
                        title: "Level III",
                        text: "The patient to stay for 4 hours",
                        type: "success"
                    },
                    function(){
                        document.theForm.submit();
                    });
	        }
		} 
		
              
         </script>

    
</body>

</html>
