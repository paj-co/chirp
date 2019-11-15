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
        let chirpCommentCount = $('<p>');
        let commentFeed = $('<div>', {id: 'commentFeed'});

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
        chirpDiv.append(chirpCommentCount);
        chirpA.append(chirpDiv);

        if(wrapInLink === true) {
            howManyComments(el.id, chirpCommentCount);
            pageElement.append(chirpA);
        } else {
            chirpDiv.removeClass('chirp');
            chirpDiv.addClass('singleChirp');
            chirpDiv.append(addCommentForm());
            allCommentsForChirp(el.id, commentFeed);
            chirpDiv.append(commentFeed);
            pageElement.append(chirpDiv)
        }

    });
}

function addPageTitleWithUserNickFromUrl(nick) {
    $('title').text('@' + nick + ' | Chirp')
}

function howManyComments(chirpId, commentCountElement) {
    $.ajax({
        url: "/chirp/rest/comment/count/" + chirpId,
        type: "GET",
        dataType: "json"
    }).done(function (commentCount) {
        commentCountElement.text('Comments: ' + commentCount);
    }).fail(function (xhr, status, err) {
    }).always(function (xhr, status) {
    });
}

function allCommentsForChirp(chirpId, elementToAppendComments) {
    $.ajax({
        url: "/chirp/rest/comment/" + chirpId,
        type: "GET",
        dataType: "json"
    }).done(function (result) {
        result.forEach(function (el) {
            let commentDiv = $('<div>', {class: 'comment'});
            let commentTitleP = $('<p style="margin-bottom: 0">');
            let commentContentP = $('<p>');

            let commentTitleSpan = $('<span>', {class: 'commentTitle'});
            let commentTitleSpanGrayNick = $('<span>', {class: 'commentTitleGray'});
            let commentTitleSpanGrayCreated = $('<span>', {class: 'commentTitleGray'});

            commentTitleSpan.html('<a href="/chirp/' + el.user.nick + '">' + el.user.firstName + ' ' + el.user.lastName + '</a>');
            commentTitleSpanGrayNick.html('<a href="/chirp/' + el.user.nick + '">' + ' @' + el.user.nick + '</a>');
            commentTitleSpanGrayCreated.text(' | ' + el.created.hour + ':' + el.created.minute + ' | '
                + el.created.dayOfMonth + '-' + el.created.monthValue + '-' + el.created.year);

            commentTitleP.append(commentTitleSpan);
            commentTitleP.append(commentTitleSpanGrayNick);
            commentTitleP.append(commentTitleSpanGrayCreated);

            commentContentP.text(el.commentText);

            commentDiv.append(commentTitleP);
            commentDiv.append(commentContentP);

            elementToAppendComments.append(commentDiv);
        })
    }).fail(function (xhr, status, err) {
    }).always(function (xhr, status) {
    })
}

function addCommentForm() {
    return $(
        '<div id="form">' +
            '<form id="comment-form">' +
                '<textarea id="new-comment-text" class="form-style" name="comment" placeholder=" What\'s your comment?" ></textarea>' +
                '<input id="new-comment-submit" type="button" value="Comment">' +
                '<div>' +
                    '<span id="char-count">0/280</span>' +
                '</div>' +
            '</form>' +
            '<hr>' +
        '</div>'
    );
}