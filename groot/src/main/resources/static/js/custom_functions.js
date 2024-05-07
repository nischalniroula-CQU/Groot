	if (localStorage.getItem('userToken')) {
        // User is logged in, update UI accordingly
        // For example:
        document.getElementById('usernotloggedin').style.display = 'none'; // Hide login button
        document.getElementById('userloggedin').style.display = 'block'; // Show logout button
    } else {
        // User is not logged in, update UI accordingly
        // For example:
        document.getElementById('usernotloggedin').style.display = 'block'; // Show login button
        document.getElementById('userloggedin').style.display = 'none'; // Hide logout button
    }
    
    function logout() {
        // Remove the userToken from localStorage
        localStorage.removeItem('userToken');
        window.location.href = '/index';
    }
    // Add event listener to logout button
    document.getElementById('logout').addEventListener('click', logout);