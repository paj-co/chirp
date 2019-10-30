$(document).ready(function () {

    var userChirpFeed = $('#userChirpFeed');
    let nick = getNickFromUrl();

    function getAllUserChirps(userNick) {
        $.ajax({
            url: "rest/chirps/" + userNick,
            type: "GET",
            dataType: "json"
        }).done(function (result) {
            addChirpsToPage(userChirpFeed, result);
        }).fail(function (xhr, status, err) {
        }).always(function (xhr, status) {
        });
    }

    function getNickFromUrl() {
        let url = $(location).attr('href');
        let indexOfLastSlash = url.lastIndexOf('/') + 1;
        return url.substr(indexOfLastSlash);
    }

    function addPageTitleWithUserNickFromUrl() {
        $('title').text('@' + nick + ' | Chirp')
    }

    addPageTitleWithUserNickFromUrl();
    getAllUserChirps(nick);


});