$(function() {
    var title;
    $("#title").change(function() {
        title = $(this).val();
    });
    var titleHtml;
    $("#submitTitle").click(function() {
        titleHtml = "<div class='col-lg-12 text-center'></div>" + "<h3 style='text-align: center'>" + title + "</h3><hr class='small'>";
        $("#detail-title").html(titleHtml);
    });
    var disable = false,
        picker = new Pikaday({
            field: document.getElementById('datepicker'),
            firstDay: 1,
            minDate: new Date(2000, 0, 1),
            maxDate: new Date(2020, 12, 31),
            yearRange: [2000, 2020],

            showDaysInNextAndPreviousMonths: true
        });
    var date, place, stories;
    $("#datepicker").change(function() {
        date = $(this).val();
        // var d = new Date(date);
        // var year = d.getFullYear(),
        //     month = d.getMonth + 1,
        //     day = d.getDate();
        // var date = year
        // console.log(d.toLocalString());
    }); 
    $("#place").change(function() {
    	place = $(this).val();
    });
    $("#stories").change(function() {
    	stories = $(this).val();
    });
    var infoHtml;
    $("#submitDetail").click(function() {
        $("#addPhoto-title").html(titleHtml);
        infoHtml = "<div class='post-preview'><a href='post.html'><h3 class='post-title'>" + place + "</h3>";
        infoHtml += "<h4 class='post-subtitle'>" + stories + "</h4></a>";
        infoHtml += "<p class='post-meta'>Posted by <a href='#'>user</a> on " + date + "</p></div>";
        $("#info-adding").html(infoHtml);
    });
});
