$(document).ready(function () {

    let singleChirp = $('#singleChirp');
    let nick = getNickFromUrlGivenChirpPage();
    let chirpId = getChirpIdFromUrl();

    getLoggedUser();
    addPageTitleWithUserNickFromUrl(nick);
    getSingleChirp(nick, chirpId, singleChirp);

    $(singleChirp).on('keyup', '#new-comment-text', function () {
        let commentText = $('#new-comment-text');
        let charCount = $('#char-count');
        charCount.text(commentText.val().length + '/280');
        if(commentText.val().length > 280) {
            commentText.addClass('red-border');
            commentText.removeClass('form-style');
            commentText.addClass('red-counter')
        } else {
            commentText.removeClass('red-border');
            commentText.addClass('form-style');
            commentText.removeClass('red-counter')
        }
    });

    postNewComment(chirpId);


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

function postNewComment(chirpId) {
    $('#singleChirp').on('click', 'input#new-comment-submit' , function () {

        let commentText = $('textarea#new-comment-text');
        let commentCharDisplay = $('#char-count');
        let elementToAppendComment = $('#commentFeed');

        if(commentText.val().length <= 280) {
            let comment = {
                commentText: commentText.val(),
                user: null,
                created: null,
                chirp: {
                    id: chirpId
                }
            };

            $.ajax({
                url: "/chirp/rest/comment/" + chirpId,
                type: "POST",
                dataType: "json",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': $('meta[name="_csrf"]').attr('content')
                },
                data: JSON.stringify(comment)
            }).done(function () {
                commentText.val('');
                commentCharDisplay.text('0/280');
                elementToAppendComment.html('');
                allCommentsForChirp(chirpId, elementToAppendComment);
            }).fail(function (xhr, status, err) {
                alert('There is problem with adding yours comment!')
            }).always(function (xhr, status) {
            })
        } else {
            alert('Your comment can only have 280 characters!')
        }
    });

}