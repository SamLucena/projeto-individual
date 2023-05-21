function logout() {
    localStorage.clear();
}

function showLoginOrLogout(to) {
    if (localStorage.getItem("token") === null) {
        login.innerHTML = `
        <a href="./../auth/login.html">
            Login
            <span class="material-symbols-outlined">
                login
            </span>
        </a>`;
    } else {
        login.innerHTML = `
        <a href="${to}" onclick='logout()'>
            Sair
            <span class="material-symbols-outlined">
                logout
            </span>
        </a>`;
    }
}