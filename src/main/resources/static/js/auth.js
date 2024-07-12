// src/main/resources/static/js/auth.js

document.addEventListener('DOMContentLoaded', function() {
    // Attach event listener to the logout button
    const logoutButton = document.querySelector('#logoutButton');
    if (logoutButton) {
        logoutButton.addEventListener('click', function(event) {
          //  event.preventDefault();  // Prevent the default button action

            // Call the /logout endpoint to log out the user
            fetch('/logout', {
                method: 'GET',  // Use GET for logout
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => {
                if (response.ok) {
                    // Redirect to the login page after successful logout
                    window.location.href = '/login';
                } else {
                    console.error('Logout failed');
                }
            })
            .catch(error => {
                console.error('Error during logout:', error);
            });
        });
    }

    // Call the checkSession function to ensure user is logged in
    checkSession();
});

function checkSession() {
    fetch('/session/checkSession')
        .then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error('Not logged in');
            }
        })
        .then(data => {
            if (!data.loggedIn) {
                window.location.href = '/login';
            }
        })
        .catch(error => {
            window.location.href = '/login?error';
        });
}
