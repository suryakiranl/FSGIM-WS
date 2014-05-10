$(document).ready(function() {
	var userId = localStorage.getItem("userId");
	if(!userId) {
		console.log("No logged in user. Redirecting to login page...");
		
		var sURL = document.URL;
		var baseURL = sURL.substring(0, sURL.indexOf('/', 7));

		window.location.replace(baseURL + "/login.html");
	} else {
		// Add a footer for users to use.
		var userName = localStorage.getItem("userName");
		var divHtml = '<div id="footerDiv">' +
		'<span>Welcome ' + userName + '!!</span>' +
		'<a href="login.html" class="close-notify">Logout</a> '+
		'</div>';
		$('body').append(divHtml);
	}
});