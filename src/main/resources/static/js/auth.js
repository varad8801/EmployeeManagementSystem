// auth.js
document.addEventListener('DOMContentLoaded', function() {
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
            window.location.href = '/login';
        });
}
