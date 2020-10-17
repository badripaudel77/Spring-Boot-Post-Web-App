	  function validateTwoPassword() {
		  alert('see...');
		  const password = document.getElementById('password');
		  const confirmPassword = document.getElementById('confirmPassword');
		  
		  if(password.value !== confirmPassword.value) {
			  alert("Two Password Must Match");
			  confirmPassword.setCustomValidity("Two Passwords Didn't match.")
			  return false;
		  }	
		  else {
			  confirmPassword.setCustomValidity("")
			  return true;			  
		  }
		  
		  password.onchange = validateTwoPassword;
		  confirmPassword.onkeyup = validateTwoPassword;	  
	}