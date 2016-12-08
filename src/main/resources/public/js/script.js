/* main js file */

// sign in
$("#but-signin").on("click", function() {
    var userAccount = $("inputEmail").val(),
        password = $("inputPassword").val();
    $.getJSON("/login", function(data) {
    	if(data.hasOwnProperty("status")) {
    		window.location = '/index';
    	}
    })
})
