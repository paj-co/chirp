$(document).ready(function () {

    var chirpFeed = $('#chirpFeed');

    function getAllChirps() {
        $.ajax({
            url: "http://localhost:8080/chirp/rest/chirps/",
            type: "GET",
            dataType: "json"
        }).done(function (result) {
            result.forEach(function (el) {
                var chirpDiv = $('<div>', {class: 'chirp'});
                var chirpTitleP = $('<p>');
                var chirpContentP = $('<p>');

                var chirpTitleSpan = $('<span>', {class: 'chirpTitle'});
                var chirpTitleSpanGrayNick = $('<span>', {class: 'chirpTitleGray'});
                var chirpTitleSpanGrayCreated = $('<span>', {class: 'chirpTitleGray'});

                chirpTitleSpan.text(el.user.firstName + ' ' + el.user.lastName);
                chirpTitleSpanGrayNick.text(' @' + el.user.nick);
                chirpTitleSpanGrayCreated.text(' | ' + el.created.hour + ':' + el.created.minute + ' | '
                    + el.created.dayOfMonth + '-' + el.created.monthValue + '-' + el.created.year);

                chirpTitleP.append(chirpTitleSpan);
                chirpTitleP.append(chirpTitleSpanGrayNick);
                chirpTitleP.append(chirpTitleSpanGrayCreated);

                chirpContentP.text(el.text);

                chirpDiv.append(chirpTitleP);
                chirpDiv.append(chirpContentP);

                chirpFeed.append(chirpDiv);
            })
        }).fail(function (xhr, status, err) {
        }).always(function (xhr, status) {
        });
    }

    getAllChirps();

});