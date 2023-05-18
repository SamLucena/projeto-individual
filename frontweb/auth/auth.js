const CREDENTIALS = CLIENT_ID + ":" + CLIENT_SECRET;
const AUTH_HEADER = "Basic " + base64Encode(CREDENTIALS);

document.getElementById('submit').addEventListener('click', e => {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const grant_type = "password";
    const user = {
        username: email,
        password,
        grant_type
    }

    axios.post(`${BASE_URL}/oauth/token`, jsonToFormEncoded(user), {
            headers: {
                'Authorization': AUTH_HEADER,
                'Content-Type': "application/x-www-form-urlencoded"
            }
        }
    );
});

function jsonToFormEncoded(object){
    var formData = new URLSearchParams();
    for(var key in object){
        if(object.hasOwnProperty(key)){
            formData.append(key, object[key])
        } 
    }
    return formData.toString();
}

function base64Encode(str){
    return btoa(encodeURIComponent(str));
}
