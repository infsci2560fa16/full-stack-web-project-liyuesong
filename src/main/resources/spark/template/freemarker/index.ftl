<!DOCTYPE html>
<html lang="en">

<head>
    <#include "header.ftl">
</head>

<body>
    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle">
        <i class="fa fa-bars"></i>
    </a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#top" onclick="">${user.email}</a>
            </li>
            <li>
                <a href="views/signin.html">Sign Out</a>
            </li>
            <li>
                <a onclick="" class="page-scroll-share">Share Travel Stories</a>
            </li>
            <li>
                <a onclick="" class="page-scroll-stories">Stories In Time</a>
            </li>
            <li>
                <a href="#about">About</a>
            </li>
            <li>
                <a id="menu-close" href="#">
                    Close<i class="fa fa-times"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Travel Diary</h1>
            <h3>Record Moments in Your Travel &amp; Share Stories</h3>
            <br>
            <a class="btn btn-dark brn-lg" id="btn-goDestinationPage">Destination</a>
        </div>
    </header>
    <!-- stories -->
    <!--section id="stories" class="stories">
        <div class="container">
            <div></div>
        </div>
    </section-->
    <!-- contact -->
    <section id="about" class="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>About</h2>
                    <hr class="small">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3>This is a place you can make travel plans and share your trip with friends as well as strangers.</h3>
                    <p>Contact Me: YUL131@PITT.EDU</p>
                </div>
            </div>
        </div>
    </section>
    <br>
    <hr>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; yul131@pitt.edu 2016</p>
                </div>
            </div>
        </div>
        <a id="to-top" href="#top" class="btn btn-dark btn-lg"><i class="fa fa-chevron-up fa-fw fa-1x"></i></a>
    </footer>
    <script>
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    </script>
</body>

</html>
