const content = document.getElementById('content');
const selectPlatforms = document.getElementById('platforms');

window.addEventListener('DOMContentLoaded', async () => {
    showCards();
    showLoginOrLogout("./reviews.html");
    const platforms = await findAllPlatforms();
    platforms.content.forEach(platform => {
        const option = document.createElement('option');
        option.value = platform.id
        option.text = platform.name;
        selectPlatforms.add(option);
    });
})

async function findReviewsByPlatform(){
    const platformId = selectPlatforms.value;
    const response = await fetch(`${BASE_URL}/reviews?platformId=${platformId}`);
    const data = await response.json();
    showCards(data);
}

async function findAllPlatforms(){
    const response = await fetch(`${BASE_URL}/platforms`)
    const data = await response.json();
    return data;
}

async function findAll(){
    const response = await fetch(`${BASE_URL}/reviews?sort=moment,desc`)
    const data = await response.json();
    return data;
}

async function showCards(list){
    if(list !== undefined){
        var page = list;
    }else{
        var page = await findAll(); 
    }
    content.innerHTML = "";
    page.content.forEach(review => {
        const formatDate = new Intl.DateTimeFormat(
            'pt-BR', {
                timeZone: 'America/Boa_Vista',
                dateStyle: 'short',
                timeStyle: 'short'
            }).format(new Date(review.moment));
        content.innerHTML += `
            <div class="card">
                <h2>${review.author.name} - ${formatDate}</h2>
                <p>
                    ${review.comment}    
                </p>
                <p>
                    <strong>Nota: ${review.score}</strong>
                </p>
                <p>
                    <strong>Plataforma: ${review.platform.name}</strong>
                </p>
            </div> 
        `;
    });
}
