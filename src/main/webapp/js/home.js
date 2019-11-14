$(document).ready(function () {

    let chirpFeed = $('#chirpFeed');
    let newChirpText = $('#new-chirp-text');
    let charCount = $('#char-count');

    newChirpText.on('keyup', function () {
        let chirpTextLength = newChirpText.val().length;
        charCount.text(chirpTextLength + '/280');
        if(newChirpText.val().length > 280) {
            newChirpText.addClass('red-border');
            newChirpText.removeClass('form-style');
            charCount.addClass('red-counter')
        } else {
            newChirpText.removeClass('red-border');
            newChirpText.addClass('form-style');
            charCount.removeClass('red-counter')
        }

    });

    getLoggedUser();
    getAllChirps(chirpFeed);
    sendNewChirp(newChirpText, charCount, chirpFeed);

});

function getAllChirps(elementToAppend) {
    $.ajax({
        // url: "http://localhost:8080/chirp/rest/chirps/",
        url: "rest/chirps/",
        type: "GET",
        dataType: "json"
    }).done(function (result) {
        addChirpsToPage(elementToAppend, result, true);
    }).fail(function (xhr, status, err) {
        alert('Problem loading chirps')
    }).always(function (xhr, status) {
    });
}

function sendNewChirp(chirpTextInput, textLengthDisplay, chirpFeed) {
    $('#new-chirp-submit').on('click', function () {
        var chirp = {
            user: null,
            text: chirpTextInput.val(),
            created: null
        };
        if(chirpTextInput.val().length <= 280) {
            $.ajax({
                // url: "http://localhost:8080/chirp/rest/chirps/",
                url: "rest/chirps/",
                type: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN' : $("meta[name='_csrf']").attr("content")
                },
                data: JSON.stringify(chirp),
                dataType: "json"
            }).done(function (result) {
                chirpTextInput.val('');
                textLengthDisplay.text('0/280');

                chirpFeed.html('');
                getAllChirps(chirpFeed);
            }).fail(function (xhr, status, err) {
                alert('There is problem with adding your chirp!');
            }).always(function (xhr, status) {
            });
        } else {
            alert('Your chirp can only have 280 characters!')
        }
    });
}