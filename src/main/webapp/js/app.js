$(document).ready(function () {

    var chirpFeed = $('#chirpFeed');
    var newChirpText = $('#new-chirp-text');

    function getAllChirps() {
        $.ajax({
            // url: "http://localhost:8080/chirp/rest/chirps/",
            url: "rest/chirps/",
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
        }).fail(function (xhr, status, err) {
            alert('There is problem with adding your chirp!');
        }).always(function (xhr, status) {
        });
    });

    getAllChirps();

});