function changeJsp() {
    var elemLogin = document.getElementById('jsp_login');
    var elemRegister = document.getElementById('jsp_register');
    var elemBtnSignIn = document.getElementById('btn_signin');
    var elemBtnSignUp = document.getElementById('btn_sgnup');


    if(elemLogin.style.display == "none"){
        elemBtnSignIn.style.display = "none";
        elemBtnSignUp.style.display = "block";
        elemRegister.style.display = "none"; 
        elemLogin.style.display = "flex";
    } else {
        elemBtnSignIn.style.display = "block";
        elemBtnSignUp.style.display = "none";
        elemLogin.style.display = "none";
        elemRegister.style.display = "flex";
    }


};