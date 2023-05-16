const createForm = document.getElementById('create');
createForm.addEventListener('submit', async e => {
    e.preventDefault();
    
    const fullname = document.getElementById('fullname').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const user = {
        name: fullname,
        email,
        password
    }

    await fetch(`${BASE_URL}/users`, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    window.location = '/auth/login.html';
});
