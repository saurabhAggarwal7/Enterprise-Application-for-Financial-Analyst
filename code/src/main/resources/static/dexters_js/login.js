
$(document).ready(function() {

$("#login_btn").click(function(){
	//fire_ajax_submit();
	//fire_ajax_graph();
});


});


function login() {
var search = {}
    search["firstname"] = $("#firstname").val();
    search["password"] = $("#password").val();
     $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/v1/Postuser",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000
  
    });
     $("#test2")[0].click();
    
    
}

function fire_ajax_graph() {
	
    var search = {}
    search["username"] = $("#username").val();
    search["password"] = $("#password").val();

    //$("#login_btn").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/v1/intrinio/AAPL",
        //data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
        	alert("success")

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            //$("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}


function onSignIn (googleUser)
{
    var profile= googleUser.getBasicProfile();
    $(".g-signin2").css("display","none");
    $(".data").css("display","block");
    $("#pic").attr('src',profile.getImageUrl());
    $("#email").text(profile.getEmail());
	$("#firstName").text(profile.getGivenName());
	$("#lastName").text(profile.getFamilyName());
	// $.cookie.raw = true;
	// $.cookie('loginID',profile.getEmail());
	// $.cookie('firstName',profile.getGivenName());
    // $.cookie('lastName',profile.getFamilyName());
    var email=profile.getEmail();
    var role;
    sessionStorage.setItem("firstName",profile.getGivenName());
    sessionStorage.setItem("lastName",profile.getFamilyName());
    if (email === "abhishek.s.prabhudesai@gmail.com") {
        sessionStorage.setItem("role",'admin');
    } else {
        sessionStorage.setItem("role",'user');
    }
}

function signOut()
{
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function(){
        alert("You have been Successfully signed out");

        $(".g-signin2").css("display","block");
        $(".data").css("display","none");
    });
}




