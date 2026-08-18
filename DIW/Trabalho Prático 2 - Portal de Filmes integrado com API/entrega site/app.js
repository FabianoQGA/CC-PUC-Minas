/**
 * chave: cb99b92711c0fd31af3371cf6f4fbcc2
 * https://api.themoviedb.org/3/movie/550?api_key=cb99b92711c0fd31af3371cf6f4fbcc2
 * esse arquivo vai requisitar os filmes populares e os mais recentes da api api.themovie.db
*/

// id, title, overview, release date, poster_path

const apikey = 'cb99b92711c0fd31af3371cf6f4fbcc2';

const mostraFilmes = (data) => {
    let dadosFilmes = JSON.parse(data.target.response);
    localStorage.setItem ( 'db_filmes', data.target.response);

    let dadosHTML = '';

    for (let i = 0; i < 4; i++)
    {
        let filme = dadosFilmes.results[i];
        dadosHTML += `
        <div class="card col-3 bgcolor">
            <img src="https://image.tmdb.org/t/p/w500${filme.poster_path}" height="40%" width="80%" alin    class="imgAjaxPopular" alt="${filme.tile}.jpg">
            <div class="card-body" horizontal-align="center">
                <h5 class="card-title">${filme.title}</h5>
                <p class="card-text">${filme.overview}</p>
                <br>Data:${filme.release_date}</br>
                <a href="detalhes.html?id=${filme.id}" class="btn btn-primary">Detalhes...</a>
            </div>
        </div>
        `;
    }
    document.getElementById('divLista').innerHTML = dadosHTML;
}

const mostraFilmes2 = (data2) => {
    let dadosFilmes2 = JSON.parse(data2.target.response);
    localStorage.setItem ( 'db_filmes', data2.target.response);

    let dadosHTML2 = '';

    for (let i = 0; i < 4; i++)
    {
        let filme2 = dadosFilmes2.results[i];
        dadosHTML2 += `
        <div class="card col-3 bgcolor" margin-bottom="40px">
            <img src="https://image.tmdb.org/t/p/w500${filme2.poster_path}" height="40%" width="80%" class="imgAjaxPopular" alt="${filme2.title}.jpg">
            <div class="card-body" horizontal-align="center">
                <h5 class="card-title">${filme2.title}</h5>
                <p class="card-text">${filme2.overview}</p>
                <br>Data:${filme2.release_date}</br>
                <a href="detalhes.html?id=${filme2.id}" class="btn btn-primary">Detalhes...</a>
            </div>
        </div>
        `;
    }
    document.getElementById('divRecente').innerHTML = dadosHTML2;
}

const funcErro = () => {
    alert ('Requisição de informações mal sucedida');
}

const mostraInfo = () => {
    let xhr = new XMLHttpRequest ();
    let xhr2 = new XMLHttpRequest ();
    let url = `https://api.themoviedb.org/3/movie/popular?api_key=${apikey}&language=pt-BR&page=1`;
    let url2 = `https://api.themoviedb.org/3/movie/upcoming?api_key=${apikey}&language=pt-BR&page=1`;
    xhr.onload = mostraFilmes;
    xhr.onerror = funcErro;
    xhr.open ('GET', url, true);
    xhr.send ();
    xhr2.onload = mostraFilmes2;
    xhr2.onerror = funcErro;
    xhr2.open ('GET', url2, true);
    xhr2.send ();
}

const init = () => {
    mostraInfo ();
}

document.body.onload = init;
