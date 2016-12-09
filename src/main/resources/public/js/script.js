/* main js file */

function signin() {
    var email = $("#inputEmail").val(),
        password = $("#inputPassword").val();
    console.log(email, password);
    $.getJSON("/signin", function(data) {
        console.log(data);
        // if (data.hasOwnProperty("status")) {
        window.location = '/index';
        // }
    });
}

function signup() {
    var email = $("#inputEmail").val(),
        password = $("#inputPassword").val(),
        name = $("#signup-inputUserName").val();
    $.getJSON("/signup", function(data) {
        console.log(data);
        // if (data.hasOwnProperty("status")) {
        window.location = '/index';
        // }
    });
}
