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
    <link rel="stylesheet" href="./assets/css/guide.css" />
    <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Alegreya+Sans|Quicksand|Source+Sans+Pro"
      rel="stylesheet"
    />
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="./assets/js/step.js"></script>
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

        <div class="stepbystep container">
          <h3 class="title" style="text-align: center; margin-bottom: 60px;">
            Please fill the patient information.
          </h3>
          <div class="stepwizard col-md-offset-3">
            <div class="stepwizard-row setup-panel">
              <div class="stepwizard-step">
                <a
                  href="#step-1"
                  type="button"
                  class="btn btn-primary btn-circle"
                  >1</a
                >
                <p>Step 1</p>
              </div>
              <div class="stepwizard-step">
                <a
                  href="#step-2"
                  type="button"
                  class="btn btn-default btn-circle"
                  disabled="disabled"
                  >2</a
                >
                <p>Step 2</p>
              </div>
              <div class="stepwizard-step">
                <a
                  href="#step-3"
                  type="button"
                  class="btn btn-default btn-circle"
                  disabled="disabled"
                  >3</a
                >
                <p>Step 3</p>
              </div>
            </div>
          </div>

          <form role="form" action="${contextPath}/savePatientInfo" method="post">
            <div class="row setup-content" id="step-1">
              <div class="guide">
                <div class="col-md-12">
                  <h3>Basic Information</h3>

                  <div class="row">
                    <div class="form-group col-xs-6">
                    <label class="control-label" for="last_name">Last Name</label>
                    <div >
                    <input id="last_name" name="lastName" placeholder="Last Name" type="text" class="form-control" required="required">
                    </div>
                    </div>
                    <div class="form-group col-xs-6">
                    <label for="first_name" class="control-label">First Name</label>
                    <div >
                    <input id="first_name" name="firstName" placeholder="First Name" type="text" class="form-control" required="required">
                    </div>
                    </div>
                  </div>




  <div class="form-group">
    <label for="gender" class="control-label">Gender</label>
    <div >
      <label class="radio-inline">
        <input type="radio" name="gender" value="male" checked>
              Male
      </label>
      <label class="radio-inline">
        <input type="radio" name="gender" value="female">
              Female
      </label>
      <label class="radio-inline">
        <input type="radio" name="gender" value="other">
              Other
      </label>
    </div>
  </div>
  <div class="form-group">
    <label for="birthday" class="control-label">Birthday</label>
    <div >
      <input id="birthday" name="birthday" placeholder="YY/MM/DD" type="date" class="form-control" required="required">
    </div>
  </div>

  <div class="row">
    <div class="form-group col-xs-6">
      <label for="address" class="control-label">Address</label>
      <div >
        <input id="address" name="address" placeholder="address" type="text" class="form-control" required="required">
      </div>
    </div>
    <div class="form-group col-xs-6">
      <label for="phone" class="control-label">Phone</label>
      <div >
        <input id="phone" name="phone" placeholder="000-00-000" type="text" class="form-control" required="required">
      </div>
    </div>
  </div>


                  <button
                    class="btn btn-primary nextBtn btn-lg pull-right"
                    type="button"
                  >
                    Next
                  </button>
                </div>
              </div>
            </div>
            <div class="row setup-content" id="step-2">
              <div class="guide">
                <div class="col-md-12">
                  <h3>Measurements</h3>
                  <div class="row">
    <div class="form-group col-xs-6">
      <label for="hight" class="control-label">Hight</label>
      <div >
        <input id="hight" name="height" placeholder="patient height(cm)" type="text" class="form-control" required="required">
      </div>
    </div>
    <div class="form-group col-xs-6">
      <label for="weight" class="control-label">Weight</label>
      <div >
        <input id="weight" name="weight" placeholder="(lb)" type="text" class="form-control" required="required">
      </div>
    </div>
  </div>

  <div class="row">
    <div class="form-group col-xs-6">
      <label for="bp" class="control-label">Blood Pressure</label>
      <div >
        <input id="bp" name="bloodpressure" placeholder="mm/hg" type="text" class="form-control" required="required">
      </div>
    </div>
    <div class="form-group col-xs-6">
      <label for="bmi" class="control-label">BMI</label>
      <div >
        <input id="bmi" name="bmi" placeholder="BMI" type="text" class="form-control" required="required">
      </div>
    </div>
  </div>
                  <button
                    class="btn btn-primary nextBtn btn-lg pull-right"
                    type="button"
                  >
                    Next
                  </button>
                </div>
              </div>
            </div>
            <div class="row setup-content" id="step-3">
              <div class="guide">
                <div class="col-md-12">
                  <h3>Background</h3>
                  <div class="row">
          <div class="col-md-4">
            Tobacco
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="tobacco" value="yes" required>
              <label class="form-check-label">Yes</label>
            </div>
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="tobacco" value="no">
              <label class="form-check-label">No</label>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            Benzodiazephi Use
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="benz" value="yes" required>
              <label class="form-check-label">Yes</label>
            </div>
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="benz" value="no">
              <label class="form-check-label">No</label>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            Opiod Use
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="opiod" value="yes" required>
              <label class="form-check-label">Yes</label>

            </div>
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="opiod" value="no">
              <label class="form-check-label">No</label>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            Other Use
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="other" value="yes" id ="other1" required>
              <label class="form-check-label">Yes</label>

            </div>
          </div>
          <div class="col-md-4">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="other" value="no" id ="other2">
              <label class="form-check-label">No</label>
            </div>
          </div>
        </div>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  <button
                    class="btn btn-success btn-lg pull-right"
                    type="submit"
                  >
                    Save Patient
                  </button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
