//universal
function getLoggedUser() {
    $.ajax({
        url: "/chirp/rest/chirps/loggedUser",
        type: "GET",
        dataType: "json"
    }).done(function (user){
        //TODO How by providing only users nick, the application context is applied
        let aUser = $('a[data="user"]');
        aUser.attr('href', '/chirp/' + user.nick);
        aUser.eq(0).text('@' + user.nick);
    }).fail(function (xhr, status, err) {
    }).always(function (xhr, status) {
    });
}

function addChirpsToPage(pageElement, result, wrapInLink) {
    result.forEach(function (el) {
        let chirpDiv = $('<div>', {class: 'chirp'});
        let chirpA = $('<a href="one/' + el.user.nick + '/' + el.id +'"></a>')
        let chirpTitleP = $('<p>');
        let chirpContentP = $('<p>');

        let chirpTitleSpan = $('<span>', {class: 'chirpTitle'});
        let chirpTitleSpanGrayNick = $('<span>', {class: 'chirpTitleGray'});
        let chirpTitleSpanGrayCreated = $('<span>', {class: 'chirpTitleGray'});

        chirpTitleSpan.html('<a href="/chirp/' + el.user.nick + '">' + el.user.firstName + ' ' + el.user.lastName + '</a>');
        chirpTitleSpanGrayNick.html('<a href="/chirp/' + el.user.nick + '">' + ' @' + el.user.nick + '</a>');
        chirpTitleSpanGrayCreated.text(' | ' + el.created.hour + ':' + el.created.minute + ' | '
            + el.created.dayOfMonth + '-' + el.created.monthValue + '-' + el.created.year);

        chirpTitleP.append(chirpTitleSpan);
        chirpTitleP.append(chirpTitleSpanGrayNick);
        chirpTitleP.append(chirpTitleSpanGrayCreated);

        chirpContentP.text(el.text);

        chirpDiv.append(chirpTitleP);
        chirpDiv.append(chirpContentP);
        chirpA.append(chirpDiv);

        if(wrapInLink === true) {
            pageElement.append(chirpA);
        } else {
            chirpDiv.removeClass('chirp');
            chirpDiv.addClass('singleChirp');
            pageElement.append(chirpDiv)
        }

    });
}

function addPageTitleWithUserNickFromUrl(nick) {
    $('title').text('@' + nick + ' | Chirp')
}