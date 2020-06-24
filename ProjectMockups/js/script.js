var expanded = false;
function showCheckboxes() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}

function getSignUpForm(form) {
	hideSignUp();	
	document.getElementById(form).style.display = "block";
}

function hideSignUp() {
var elements = document.getElementsByClassName("signup");
for (var i = 0 ; i < elements.length ;i++) {
	elements[i].style.display="none";
}
}
