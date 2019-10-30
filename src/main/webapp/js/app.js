$(document).ready(function () {

    var chirpFeed = $('#chirpFeed');
    var newChirpText = $('#new-chirp-text');
    var charCount = $('#char-count');


    function getAllChirps() {
        $.ajax({
            // url: "http://localhost:8080/chirp/rest/chirps/",
            url: "rest/chirps/",
            type: "GET",
            dataType: "json"
        }).done(function (result) {
            addChirpsToPage(chirpFeed, result);
        }).fail(function (xhr, status, err) {
            alert('Problem loading chirps')
        }).always(function (xhr, status) {
        });
    }

    $('#new-chirp-submit').on('click', function () {
        var chirp = {
            user: null,
            text: newChirpText.val(),
            created: null
        };
        if(newChirpText.val().length <= 280) {
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
                newChirpText.val('');
                charCount.text('0/280');

                chirpFeed.html('');
                getAllChirps();
            }).fail(function (xhr, status, err) {
                alert('There is problem with adding your chirp!');
            }).always(function (xhr, status) {
            });
        } else {
            alert('Your chirp can only have 280 characters!')
        }
    });

    newChirpText.on('keyup', function () {
        var chirpTextLength = newChirpText.val().length;
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

    getAllChirps();

});

function addChirpsToPage(pageElement, result) {
    result.forEach(function (el) {
        var chirpDiv = $('<div>', {class: 'chirp'});
        var chirpTitleP = $('<p>');
        var chirpContentP = $('<p>');

        var chirpTitleSpan = $('<span>', {class: 'chirpTitle'});
        var chirpTitleSpanGrayNick = $('<span>', {class: 'chirpTitleGray'});
        var chirpTitleSpanGrayCreated = $('<span>', {class: 'chirpTitleGray'});

        chirpTitleSpan.text(el.user.firstName + ' ' + el.user.lastName);
        chirpTitleSpanGrayNick.html('<a href="' + el.user.nick + '">' + ' @' + el.user.nick + '</a>');
        chirpTitleSpanGrayCreated.text(' | ' + el.created.hour + ':' + el.created.minute + ' | '
            + el.created.dayOfMonth + '-' + el.created.monthValue + '-' + el.created.year);

        chirpTitleP.append(chirpTitleSpan);
        chirpTitleP.append(chirpTitleSpanGrayNick);
        chirpTitleP.append(chirpTitleSpanGrayCreated);

        chirpContentP.text(el.text);

        chirpDiv.append(chirpTitleP);
        chirpDiv.append(chirpContentP);

        pageElement.append(chirpDiv);
    });
}

function getLoggedUser() {
    $.ajax({
        url: "rest/chirps/loggedUser",
        type: "GET",
        dataType: "json"
    }).done(function (user){
        //TODO How by providing only users nick, the application context is applied
        var aUser = $('a[data="user"]');
        aUser.attr('href', user.nick);
        aUser.eq(0).text('@' + user.nick);
    }).fail(function (xhr, status, err) {
    }).always(function (xhr, status) {
    });
}