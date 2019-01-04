# Sedation Assistance Application

### Team Name
* Super Six

### Team Member
* Jianbing Zhang
* Lu Yu
* Qinfang Shen
* Shanshan Wang
* Zhi Li
* Yanqun Xu

### Project Name
* Sedation Assistance Application

[Github Repository](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist)

## Logging In/Registering a New User

![Login](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Login.JPG)

**When the provider has an account already**

* Enter the username and password
* Click the "login" button
* The provider will be directed to the patient search page

![Register](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Register.JPG)

**If the provider is new to the system**

* Enter the username
* Enter the password
* Confirm the password
* Click the "submit" button
* The provider will be directed to the patient search page

## Patient Search/Create New Patient

Once the patient log in
they will be on the page to search an existing patient or create a new patient


![Patient id](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/PatientSearch.JPG)

* If you want to test an existing patient, you can enter the patient first name: **Ahmad** Last name: **Cassin** and the birthday: **1984-08-26**
* This patient will be pulled from the FHIR database
* If you just want to create a new patient you can click the "create" button

## Create a new patient

After you click "create" button, you will be able to enter few information for the new patient.

![Basic info](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Basicinfo.JPG)

* Enter the new patient's last name
* Enter the new patient's first name
* Choose the new patient's gender
* Enter the new patient's birthday
* Enter the new patient's phone number
* Enter the new patient's Address
* Click on the "Next" button when you have all the information provided

![Body info](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Bodyinfo.JPG)
 
* Enter the new patient's height
* Enter the new patient's weight
* Enter the new patient's blood pressure
* Enter the new patient's BMI
* Click on the "Next" button when you have all the information provided

![Medical info](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Medicalinfo.JPG)

* Choose if the new patient use tobacco
* Choose if the new patient use Benzodiazephi
* Choose if the new patient use opiod 
* Choose if the new patient use other medicine
* Now you have finished all the information and click "save patient" button
* You will be directed to the evaluation page after this

## Existing Patient - confirmation of information

If you have a existing patient number, as we said, you can enter the patient first name: **Ahmad** Last name: **Cassin** and the birthday: **1984-08-26**

This patient has complete information so the evaluation will be more successful and complete

However, even though you have an existing patinet, you still need to confirm his/her information


![Basic info](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Basicinfo.JPG)

* Confirm the existing patient's last name
* Confirm the existing patient's first name
* Confirm the existing patient's gender
* Confirm the existing patient's birthday
* Confirm the existing patient's phone number
* Confirm the existing patient's Address
* Click on the "Next" button when you have all the information confirmed

![Body info](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Bodyinfo.JPG)
 
* Confirm the existing patient's height
* Confirm the existing patient's weight
* Confirm the existing patient's blood pressure
* Confirm the existing patient's BMI
* Click on the "Next" button when you have all the information confirmed

![Medical info](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Medicalinfo.JPG)

* Confirm if the existing patient use tobacco
* Confirm if the existing patient use Benzodiazephi
* Confirm if the existing patient use opiod 
* Confirm if the existing patient use other medicine
* Now you have finished all the information confirmed and click "save patient" button
* You will be directed to the evaluation page after this

## Existing Patient - evaluation

Then you will enter the evaluation page. you will start your evaluation from here

![Evaluation](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Evaluation.JPG)

* You can see all the basic and medical information of the patient
* On the upper right side of the page you can see a button called "evaluation"
* After clicking on the button, you will start the evaluation

![Evaluation result](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Evaluationresult.JPG)

* You can still see all the basic and medical information of the patient
* On the upper right side of the page, now you can see the **score and ASA level** of the patient
* Below that there is a button called "Calculate Dose".
* According to the score, the next page will provide accordingly dose options

![Dose](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Dose.JPG)

* On this page, you can still see all the basic and medical information of the patient
* Also, you can see the score and ASA level of the patient
* Below that the doctor can choose one option for the time/dose foe the patient
* Click on "Save and next" button, you will see the guideline for the sedation

![Guidelines](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Guidelines.JPG)

* On the page, there are several guidelines for the nurse to perform the sedation
* Click on the "Next" button to go to the feedback page.

![Feedback](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Feedback.JPG)

* Choose soberness level of the patient
* Write the degree of pain of the patient
* Write the satisfaction of nurse performance
* Write the recovery situation of the patient
* Now you have finished the evaluation and click "save & logout" button

![Sober](https://github.gatech.edu/gt-cs6440-hit-fall2018/Sedation-Assist/blob/master/Final%20Delivery/Screen/Sober.JPG)

* According to the soberness of the patient
* The website will provide the information that how long the patient should stay in the facility
* The page will be directed back to the log in/register page
