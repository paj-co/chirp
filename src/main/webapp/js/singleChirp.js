$(document).ready(function () {

    let singleChirp = $('#singleChirp');
    let nick = getNickFromUrlGivenChirpPage();
    let chirpId = getChirpIdFromUrl();


    getLoggedUser();
    addPageTitleWithUserNickFromUrl(nick);
    getSingleChirp(nick, chirpId, singleChirp);
});


function getChirpIdFromUrl() {
    let url = $(location).attr('href');
    let indexOfLastSlash = url.lastIndexOf('/') + 1;
    return url.substr(indexOfLastSlash);
}

function getNickFromUrlGivenChirpPage() {
    let url = $(location).attr('href');
    let indexOfLastSlash = url.lastIndexOf('/') + 1;
    let urlWithNick = url.substr(0, indexOfLastSlash - 1);
    return urlWithNick.substr(urlWithNick.lastIndexOf("/") + 1);
}

function getSingleChirp(userNick, chirpId, elementToAppend) {
    $.ajax({
        // url: "http://localhost:8080/chirp/rest/chirps/" + userNick + '/chirp/' + chirpId,
        url: "/chirp/rest/chirps/" + userNick + '/' + chirpId,
        type: "GET",
        dataType: "json"
    }).done(function (result) {
        addChirpsToPage(elementToAppend, result,false);
    }).fail(function (xhr, status, err) {
        console.log('Problem with loading one chirp')
    }).always(function (xhr, status) {
    });
}