var el = document.getElementById("title");
var text = "CRASH BANDICOOT"
var interval = 200;

window.addEventListener("DOMContentLoaded", () => {
    showLoginOrLogout("./index.html");
    showtext(el, text, interval);
});

function showtext(el, text, interval) {
    var char = text.split("").reverse();
    var typer = setInterval(() => {
        if (!char.length) {
            return clearInterval(typer)
        }

        var next = char.pop();
        el.innerHTML += next;
    }, interval);
}