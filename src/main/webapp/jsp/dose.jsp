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
        <div class="sidebar-items active">
          <i class="fas fa-capsules"></i> Dose
        </div>
        <div class="sidebar-items">
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
           
         <form method="POST" action="${contextPath}/guidelines">
         <div class="col-md-12">
		  <h1 style="font-size:30px;">Dose/Timing Options</h1>
		
		
		  <div class="row">
		    <div class="form-group col-xs-6">
		      <label class="control-label" for="risk_score">Patient Risk Score</label>
		      <div>
		        <input type="text" value="${finalscore}" readonly="readonly" class="form-control" id="finalscore">
		      </div>
		    </div>
		    <div class="form-group col-xs-6">
		      <label for="risk_category" class="control-label">Patient Risk Category</label>
		      <div>
		        <input type="text" value="${finalcategory}" readonly="readonly" class="form-control" id="finalcategory">
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="radio" class="control-label">Option 1:</label>
		    <div>
		      <input type="radio" id="optionone" value="option1" style="display: none;" name = "doseOption" required>
		      <a id="option1"></a>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="radio" class="control-label">Option 2:</label>
		    <div>
		      <input type="radio" id="optiontwo" value="option2" style="display: none;" name = "doseOption">
		      <a id="option2"></a>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="radio" class="control-label">Option 3:</label>
		    <div>
		      <input type="radio" id="optionthree" value="option3" style="display: none;" name = "doseOption">
		      <a id="option3"></a>
		    </div>
		    <div class="form-group row">
		      <div class="pull-right">
		        <input type="submit" class="btn pull" value="Save and Next" />
		      </div>
		    </div>
		  </div>
		</div>
                
                
                <%--<p>Fentanyl</p><br>--%>

                <%--<a>-timing</a>--%>
                <%--<select>--%>
                  <%--<option value="5">5 min</option>--%>
                  <%--<option value="4">4 min</option>--%>
                  <%--<option value="3">3 min</option>--%>
                <%--</select>--%>
                <%--<br>--%>
                <%--<br>--%>

                <%--<a>-Dose</a><br>--%>
                <%--<select>--%>
                  <%--<option value="25">25 mcgIV</option>--%>
                  <%--<option value="40">40 mcgIV</option>--%>
                  <%--<option value="50">50 mcgIV</option>--%>
                <%--</select>--%>
                <%--<br>--%>
                <%--<br>--%>

                <%--<p>Midazolam</p>--%>
                <%--<a>-timing</a>--%>
                <%--<select>--%>
                  <%--<option value="2">2 min</option>--%>
                  <%--<option value="1">1 min</option>--%>
                <%--</select>--%>
                <%--<br>--%>
                <%--<br>--%>

                <%--<a>-Dose</a>--%>
                <%--<select>--%>
                  <%--<option value="0.5">0.5 mcgIV</option>--%>
                  <%--<option value="1">1 mcgIV</option>--%>
                  <%--<option value="2">2 mcgIV</option>--%>
                <%--</select>   --%>
                <br>
                <br>
                
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
         
         
         
         
         
         </div>

        </div>
      </div>

      <script>
	    function getDose(){
	        var score=document.getElementById("finalscore").value;
	        if (score<=10){
	            document.getElementById("option1").innerHTML = "Fentnyl/dose: 25 mcg IV/duration: 30min ";
	            document.getElementById("option2").innerHTML = "Midazolam/dose: 0.5 mcg IV/duration: 30min ";
	            document.getElementById("option3").innerHTML = "Naloxone/dose: 0.1 mcg IV/duration: 40min ";
	            document.getElementById("optionone").style="";
	            document.getElementById("optiontwo").style="";
	            document.getElementById("optionthree").style="";
	            document.getElementById("optionone").setAttribute("value", "Fentnyl/dose: 25 mcg IV/duration: 30min ");
	            document.getElementById("optiontwo").setAttribute("value", "Midazolam/dose: 0.5 mcg IV/duration: 30min ");
	            document.getElementById("optionthree").setAttribute("value", "Naloxone/dose: 0.1 mcg IV/duration: 40min ");
	        } else if(score>10 && score<=20){
	            document.getElementById("option1").innerHTML = "Fentnyl/dose: 35 mcg IV/duration: 50min ";
	            document.getElementById("option2").innerHTML = "Midazolam/dose: 1 mcg IV/duration: 40min ";
	            document.getElementById("option3").innerHTML = "Naloxone/dose: 0.1 mcg IV/duration: 50min ";
	            document.getElementById("optionone").style="";
	            document.getElementById("optiontwo").style="";
	            document.getElementById("optionthree").style="";
	            document.getElementById("optionone").setAttribute("value", "Fentnyl/dose: 35 mcg IV/duration: 50min ");
	            document.getElementById("optiontwo").setAttribute("value", "Midazolam/dose: 1 mcg IV/duration: 40min ");
	            document.getElementById("optionthree").setAttribute("value", "Naloxone/dose: 0.1 mcg IV/duration: 50min ");
	        } else if(score>20){
	            document.getElementById("option1").innerHTML = "Fentnyl/dose: 45 mcg IV/duration: 60min ";
	            document.getElementById("option2").innerHTML = "Midazolam/dose: 2 mcg IV/duration: 40min ";
	            document.getElementById("option3").innerHTML = "Naloxone/dose: 0.2 mcg IV/duration: 60min ";
	            document.getElementById("optionone").style="";
	            document.getElementById("optiontwo").style="";
	            document.getElementById("optionthree").style="";
	            document.getElementById("optionone").setAttribute("value", "Fentnyl/dose: 45 mcg IV/duration: 60min ");
	            document.getElementById("optiontwo").setAttribute("value", "Midazolam/dose: 2 mcg IV/duration: 40min ");
	            document.getElementById("optionthree").setAttribute("value", "Naloxone/dose: 0.2 mcg IV/duration: 60min ");
	        }
	
	    }
	    getDose();
</script>

    
</body>

</html>
