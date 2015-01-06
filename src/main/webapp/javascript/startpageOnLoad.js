//document.getElementById("RegisterForm").addEventListener("load", hideRegisterForm);
//document.getElementById("RegisterForm").onload = function() { hideRegisterForm() };

function hideRegisterForm()
{
    document.getElementById("registerForm").style.display = 'none';
    document.getElementById("signinForm").style.display = 'block';
}