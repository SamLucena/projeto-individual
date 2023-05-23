const platforms = document.getElementById('platforms');

window.addEventListener("DOMContentLoaded", async () => {
    
    if(localStorage.getItem("token") === null){
        window.location = "../../home/index.html"
    }
    const response = await fetch(`${BASE_URL}/platforms`);
    const data = await response.json();
    data.content.forEach(plat => {
        platforms.innerHTML += `
            <option value="${plat.id}">${plat.name}</option>
        `;
    });
})

document.getElementById('create').addEventListener('submit', (e) => {
    e.preventDefault();
    const platformId = platforms.value;
    
    if(platformId === ""){
        Swal.fire({
            title: 'Plataforma Inválida',
            text: 'Selecione uma plataforma válida para registrar sua avaliação',
            icon: 'error',
            timer: 3000, // Tempo de exibição do toast em milissegundos
            toast: true,
            position: 'top-end',
            showConfirmButton: false
          });          
    }else{
        const username = decodeToken(localStorage.getItem("token")).user_name;
        const title = document.getElementById('title').value;
        const comment = document.getElementById('comment').value;
        const score = document.getElementById('score').value;
        
        const review = {
            title,
            author: {
                email: username
            },
            score,
            comment,
            platform: {
                id: platformId
            }
        }

        const data = JSON.stringify(review);

        axios.post(`${BASE_URL}/reviews`, data, {
            headers: {
                'Authorization': 'Bearer ' + localStorage.getItem("token"),
                'Content-Type': 'application/json'
            }
        })
        .then(res => {
            window.location = "../reviews.html";
        })
        .catch(err => console.log(err));
    }
});

function decodeToken(token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}