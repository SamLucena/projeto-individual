const indicators = document.getElementById('indicators');
const buttonReview = document.getElementById('buttonReview');

window.addEventListener('DOMContentLoaded', async () => {
    if(localStorage.getItem("token") == null){
        buttonReview.style.display = "none";
    }
    showLoginOrLogout("./dashboard.html")
    const response = await fetch(`${BASE_URL}/platforms`);
    const data = await response.json();
    data.content.forEach(plat => {
        const reviews = plat.reviews;
        let sumScore = 0;
        let authorConter = 0;
        reviews.forEach(rev => {
            sumScore += rev.score;
            authorConter++;
        });
        let avg = sumScore / reviews.length;
        indicators.innerHTML += `
            <div class="card-ind">
                <div class="platform">${plat.name}</div>
                <div>Reviews:
                    <span class="value">${plat.reviews.length}</span>
                </div>
                <div>
                    Usuários: 
                    <span>${authorConter}</span>
                </div>
                <div class="content-score">
                    Nota Média: 
                    <span class="avg">${avg.toFixed(1)}</span>
                </div>
            </div>
        `
    });
    chartSetup(document.getElementById('chart'), data.content)
});

function chartSetup(chart, platforms) {
    const labels = [];
    const scores = [];
    platforms.forEach(plat => {
        let sum = 0;
        labels.push(plat.name);
        plat.reviews.forEach(rev => {
            sum += rev.score;
        });
        let avg = sum / plat.reviews.length;
        scores.push(avg);
    });

    const data = {
        labels: labels,
        datasets: [{
            label: 'Notas Média',
            data: scores,
            backgroundColor: "rgba(124, 179, 66, 0.3)",
            borderColor: "rgba(124, 179, 66, 1)",
            borderWidth: 1
        }]
    };

    const config = {
        type: 'bar',
        data: data,
        options: {
            indexAxis: 'y',
            scales: {
                y: {
                    beginAtZero: true,
                    ticks: {
                        color: "black",
                        font: {
                            weight: 'bold'
                        }
                    }
                },
                x: {
                    ticks: {
                        color: "black",
                        font: {
                            weight: 'bold'
                        }
                    }
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Notas Médias das Plataformas',
                    font: {
                        size: 18,
                        weight: 'bold',
                        family: 'Poppins'
                    },
                    color: 'black'
                },
                legend: {
                    labels: {
                        color: "black"
                    }
                }
            }
        },
    };
    new Chart(chart, config)
}