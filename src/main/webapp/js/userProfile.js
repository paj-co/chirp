$(document).ready(function () {

    let userChirpFeed = $('#userChirpFeed');
    let nick = getNickFromUrl();

    getLoggedUser();
    addPageTitleWithUserNickFromUrl(nick);
    getAllUserChirps(nick, userChirpFeed);

});

function getAllUserChirps(userNick, elementToAppend) {
    $.ajax({
        url: "/chirp/rest/chirps/" + userNick,
        type: "GET",
        dataType: "json"
    }).done(function (result) {
        addChirpsToPage(elementToAppend, result, true);
    }).fail(function (xhr, status, err) {
        alert("Problem loading user chirp")
    }).always(function (xhr, status) {
    });
}

function getNickFromUrl() {
    let url = $(location).attr('href');
    let indexOfLastSlash = url.lastIndexOf('/') + 1;
    return url.substr(indexOfLastSlash);
}