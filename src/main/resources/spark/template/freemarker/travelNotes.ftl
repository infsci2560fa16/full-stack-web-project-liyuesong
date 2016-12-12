<header id="destinationDetail-top" class="destinationDetail-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">
                        Destination1
                        <small>destination details</small>
                    </h3>
            </div>
        </div>
    </div>
</header>
<!-- destination-stories -->
<div class="row" id="destination-stories">
    <div class="row">
        <div class="col-lg-12 col-lg-offset-1">
            <h4>Travel Stories</h4>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-1 col-lg-offset-1">
            <hr class="small-left">
        </div>
    </div>
    <div class="col-lg-10 col-lg-offset-1">
    <!-- loop -->
        <#list 1..count as i>
            <div class="row">
                <div class="col-md-3">
                    <a href="#">
                        <img class="img-responsive" src="../img/stories/story1.JPG"+${i} alt="">
                    </a>
                </div>
                <div class="col-md-7">
                    <div class="post-preview">
                        <a href="#">
                            <h3 class="post-title">
                                Travel Note
                            </h3>
                            <h4 class="post-subtitle">
                                Stroy of somebody...
                            </h4>
                        </a>
                        <p class="post-meta">Posted by <a href="#">Somebody1</a> on November 07, 2016</p>
                    </div>
                </div>
            </div>
        <hr>
        </#list>
        
        <!-- Pager -->
        <ul class="pager">
            <li class="next">
                <a href="#">Older Posts &rarr;</a>
            </li>
        </ul>
    </div>
</div>
<!-- footer -->
<br>
<hr>
<div class="row">
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <p>Copyright &copy; yul131@pitt.edu 2016</p>
                </div>
            </div>
        </div>
        <a id="to-top" href="#top" class="btn btn-dark btn-lg"><i class="fa fa-chevron-up fa-fw fa-1x"></i></a>
    </footer>
</div>
<script type="text/javascript">
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
