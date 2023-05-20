const CLIENT_ID = window.CLIENT_ID || 'gamePlatform';
const CLIENT_SECRET = window.CLIENT_SECRET || 'gamePlatform123';

const CREDENTIALS = `${CLIENT_ID}:${CLIENT_SECRET}`;
const AUTH_HEADER = `Basic ${btoa(CREDENTIALS)}`;

document.getElementById('submit').addEventListener('click', e => {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const grant_type = 'password';
    const data = new URLSearchParams();
    data.append('username', email);
    data.append('password', password);
    data.append('grant_type', grant_type);

    axios.post(`${BASE_URL}/oauth/token`, data, {
        headers: {
            'Authorization': AUTH_HEADER,
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
    .then(res => {
        return res.data;
    })
    .then(data => {
        var token = data.access_token;
        localStorage.setItem("token", token)
        window.location.href = "../reviews/create/save.html";
    })
    .catch(err => console.log(err));
});
