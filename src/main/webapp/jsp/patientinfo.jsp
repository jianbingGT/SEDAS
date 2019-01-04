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
    <link rel="stylesheet" href="./assets/css/sedas.css" />
    <link rel="stylesheet" href="./assets/css/all.css" />
    <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Quattrocento|Shadows+Into+Light|Alegreya+Sans|Quicksand|Source+Sans+Pro"
      rel="stylesheet"
    />
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
        <div class="sidebar-items active">
          <i class="far fa-user-circle"></i> Profile
        </div>
        <div class="sidebar-items">
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
     <!-- <div class="issue">
          <h3>Health issues</h3>
          <span class="time">NOV 19TH 04:51 PM</span>
          <p>The patient need sedaton.</p>
        </div> -->

        <div class="sedation">
          <div class="sedation-container">
          <h1>Assistant</h1>
  <div id="results">
              <form method="POST" action="${contextPath}/dose">
                <div class="result-panel-score">
                  <div class="score"><i class="fas fa-poll-h"></i>SCORE</div>

                  <p id="re-score">20</p>
                  <input
                    type="hidden"
                    readonly="readonly"
                    id="myscore"
                    name="myscore"
                  />
                </div>
                <div class="result-panel-risk">
                  <div class="asa"><i class="fas fa-exclamation"></i>RISK</div>
                  <p id="re-cat">III</p>
                  <input
                    type="hidden"
                    readonly="readonly"
                    id="mycategory"
                    name="mycategory"
                  />
                </div>
                <br />
                <input
                  id="calDose"
                  type="hidden"
                  name="dose"
                  value="Calculate Dose"
                />
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                />
                  <input type="hidden" id="sedationID" name="sedationID" value="${sedationID}">
              </form>
            </div>
            <input
              id="startEva"
              type="submit"
              name="score"
              value="Evaluate"
              onclick="myFunction()"
            />  
          </div>

          <div class="score-panel">
            <h1>Background</h1>
            <div id="tobacco" ${isSmoking ?"class='panel-item active'":"class='panel-item'"}>
              <i ${isSmoking ?"class='fas fa-check-circle'":"class='far fa-circle'"}></i> Tobacco
            </div>
            <div id="benzodiazepine" ${isBenzo ?"class='panel-item active'":"class='panel-item'"}>
              <i ${isBenzo  ?"class='fas fa-check-circle'":"class='far fa-circle'"}></i> Benzodiazephi Use
            </div>
            <div id="opioid" ${isOpioid ?"class='panel-item active'":"class='panel-item'"}>
              <i ${isOpioid  ?"class='fas fa-check-circle'":"class='far fa-circle'"}></i> Opiod Use
            </div>
            <div id="other" ${isOther ?"class='panel-item active'":"class='panel-item'"}>
              <i ${isOther  ?"class='fas fa-check-circle'":"class='far fa-circle'"}></i> Other Use
            </div>
          </div>
        </div>

        <div class="blood active">
          <span class="title">Blood Pressure</span>
          <div class="read">
            <i class="fas fa-heartbeat"></i>${patientBloodPres}<span class="unit"
              >mm/hg</span
            >
          </div>
        </div>

        <div class="hight active">
          <span class="title">Height</span>
          <div class="read"><i class="fas fa-male"></i>${patientHeight}<span class="unit">cm</span>
          </div>
        </div>

        <div class="bmi active">
          <span class="title">BMI</span>
          <div class="read"><i class="far fa-smile"></i>${patientBmi}</div>
        </div>

        <div class="weight active">
          <span class="title">weight</span>
          <div class="read">
            <i class="fas fa-weight"></i>${patientWeight}<span class="unit">lb</span>
          </div>
        </div>

          <%--<div class="active">--%>
              <%--<span class="title">SedationOption</span>--%>
              <%--<div class="read">--%>
                  <%--<i class="fas fa-weight"></i>${patientWeight}<span class="unit">lb</span>--%>
              <%--</div>--%>
          <%--</div>--%>
      </div>
    </div>

    <script>
    console.log(${isSmoking});
   function myFunction() {
	   var hisage=${patientAge};
	   var hisage_value=0;
       var hisgender="${patientGender}";
       var hisgender_value=0;
       var hisbmi="${patientBmi}";
       var hisbmi_value=0;
       var histobacco=$("#tobacco");
       var histobacco_value=0;
       var hisbenz=$("#benzodiazepine");
       var hisbenz_value=0;
       var hisopioid=$("#opioid");
       var hisopioid_value=0;
       var hispsy_value=0;
       //define the final score and level
       var totalscore=0;
       var asalevel="";
       //score system
       if (hisage>18 && hisage<=39){
           hisage_value=10;
       } else if (hisage>=40 && hisage<=49){
           hisage_value=6;
       } else if (hisage>=50 && hisage<=59){
           hisage_value=4;
       } else if (hisage>60){
           hisage_value=0;
       }

       if (hisgender=="female"){
           hisgender_value=3;
       }

       if (hisbmi<25){
           hisbmi_value=2;
       }

       if (hisbenz.hasClass("active")){
           hisbenz_value = 6;
       }

       if (hisopioid.hasClass("active")){
           hisopioid_value = 4;
       }
       //getting the final score and level
       totalscore=hisage_value+hisgender_value+hisbmi_value+hisbenz_value+hisopioid_value+hispsy_value;
       if (totalscore >= 0 && totalscore <= 5){
           asalevel="I";
       } else if(totalscore >= 6 && totalscore <= 10){
           asalevel="II";
       } else if(totalscore >= 11 && totalscore <= 15){
           asalevel="III";
       } else if(totalscore >= 16 && totalscore <= 19){
           asalevel="IV";
       } else if (totalscore>=20){
           asalevel="V";
       }
       
       console.log(asalevel);
       console.log(totalscore);
       document.getElementById("myscore").value=totalscore;
       document.getElementById("mycategory").value=asalevel;
       document.getElementById("re-score").innerHTML = totalscore;
       document.getElementById("re-cat").innerHTML = asalevel;
       document.getElementById("startEva").style.display="none";

       document.getElementById("calDose").setAttribute("type", "submit");

       
            //getting all the information from the textboxes
          /*   /* 
           
 */
          /*   //show the final score and level
            document.getElementById("drug")[0].innerHTML = "hello";
            document.getElementById("suggest")[0].innerHTML = "world"; */
 
        }
        
   
    </script>
    
    <script>
      $(document).ready(function() {
        $("#startEva").click(function() {
          $("#results").slideDown("slow");
        });
      });
    </script>
  </body>
</html>
