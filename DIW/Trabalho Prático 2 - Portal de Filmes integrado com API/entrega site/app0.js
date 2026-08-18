const apikey = 'cb99b92711c0fd31af3371cf6f4fbcc2';

function exibeNoticias () {
    let divTela = document.getElementById('divPesquisa');
    let texto = '';

    let dadosFilmes = JSON.parse (this.responseText);
    for (i=0; i< dadosFilmes.results.length; i++) {
        let filme = dadosFilmes.results[i];

        texto =+ ` 
        <div class="col-2">
            <img src="https://image.tmdb.org/t/p/w500${filme.poster_path}" width="150px" alt="${filme.title}.jpg">
            <div class="card-body">
                <h5>${filme.title} - data: ${filme.release}</h5>
                <p>${filme.overview}</p>
                <a href="detalhes.html?id=${filme.id}" class="btn btn-primary">Detalhes...</a>
            </div>
        </div>         
        `;
    };

    divTela.innerHTML = texto;
}

function executaPesquisa () {
    let query = document.getElementById('btnVal').value;

    let xhr = new XMLHttpRequest ();
    xhr.onload = exibePesquisa;
    xhr.open ('GET', `https://api.themoviedb.org/3/search/movie?api_key=${apikey}&language=pt-BR&query=${query}&page=1&include_adult=false`);
    xhr.send ();
}

document.getElementById ('btnPesq').addEventListener ('click', executaPesquisa);

// API FAZ REQUISIÇÃO FUNCIONAL MAS BUTAO NAO ENTRA NO SITE HTML PARA MOSTRAR OS DADOS