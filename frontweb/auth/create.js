
window.addEventListener("DOMContentLoaded", () => {
    if(localStorage.getItem("token") !== null){
        window.location = "../home/index.html"
    }
})

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

    const res = await fetch(`${BASE_URL}/users`, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    const data = await res.json();    
    if(data.status == 422){
        Swal.fire({
            title: 'E-mail já está em uso',
            icon: 'warning',
            timer: 3000, // Tempo de exibição do toast em milissegundos
            toast: true,
            position: 'top-end',
            showConfirmButton: false
        })
    }else{
        window.location = './login.html'
    }
});
