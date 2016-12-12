  <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand">Travel Diary</a>
                <#if text == "Destination">
                    <a href="#side-menu-toggle" id="side-menu-toggle" class="btn btn-dark btn-lg toggle" style="display: none">
                        <i class="fa fa-bars"></i>
                    </a>
                </#if>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="../index.html"></a>
                    </li>
                    <li class="page-scroll" id="page-scroll-signin">
                        <a href="../index.html">Sign Out</a>
                    </li>

                    <#if text == "Share Travel Stories">
                        <li class="page-scroll">
                            <a class="page-scroll-des">Destination</a>
                        </li>
                        <li class="page-scroll">
                            <a class="page-scroll-stories">Stories In Time</a>
                        </li>

                    <#elseif text == "Destination">
                        <li class="page-scroll" id="page-scroll-destination" style="display: none">
                            <a class="page-scroll-des">Destination</a>
                        </li>
                        <li class="page-scroll">
                            <a class="page-scroll-share">Share Travel Stories</a>
                        </li>
                        <li class="page-scroll">
                            <a class="page-scroll-stories">Stories In Time</a>
                        </li>

                    <#elseif text == "Stories In Time">
                        <li class="page-scroll">
                            <a class="page-scroll-des">Destination</a>
                        </li>
                        <li class="page-scroll">
                            <a class="page-scroll-share">Share Travel Stories</a>
                        </li>
                    <#else>
                        <li class="page-scroll" id="page-scroll-signin">
                            <a href="signin.html">Sign In</a>
                        </li>
                        <li class="page-scroll" id="page-scroll-destination" style="display: none">
                            <a class="page-scroll-des">Destination</a>
                        </li>
                        <li class="page-scroll">
                            <a class="page-scroll-share">Share Travel Stories</a>
                        </li>
                        <li class="page-scroll">
                            <a class="page-scroll-stories">Stories In Time</a>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>