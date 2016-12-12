    <section id="editByPlaces">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h3>Edit your stories</h3>
                        <hr class="small">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <form name="addTitle" id="js-upload-form" novalidate>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    <input type="text" class="form-control" placeholder="Title" id="title" required data-validation-required-message="Please enter Note's title.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="form-group col-lg-12 text-center">
                                    <a href="#editDetails" class="btn btn-circle page-scroll" id="submitTitle">
                                        <i class="fa fa-angle-double-down animated"></i>
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <br>
        <section id="editDetails">
            <div class="container">
                <div class="row" id="detail-title">
                    <div class="col-lg-12 text-center">
                        <h3>Edit your stories</h3>
                        <hr class="small">
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <form name="editNotes" id="editNotes" novalidate>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    <label for="datepicker">Date</label>
                                    <input type="text" class="form-control" placeholder="Date" id="datepicker" required data-validation-required-message="Please enter date of stories.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    <label>Place</label>
                                    <input type="email" class="form-control" placeholder="Place" id="place" required data-validation-required-message="Please enter place.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    <label>Stories</label>
                                    <textarea rows="5" class="form-control" placeholder="add stories..." id="stories" required data-validation-required-message="Add stories"></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="form-group col-lg-12 text-center">
                                    <a href="#addPhoto" class="btn btn-circle page-scroll" id="submitDetail">
                                        <i class="fa fa-angle-double-down animated"></i>
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <br>
        <section>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3>Edit your stories</h3>
                    <hr class="small">
                </div>
            </div>
            <br>
            <div class="container">
                <div class="row" id="addPhoto">
                    <div class="row" id="addPhoto-title">
                    </div>
                    <div class="col-lg-10 col-lg-offset-1">
                        <div class="row">
                            <div class="col-md-3">
                                <a href="#">
                                    <img class="img-responsive" src="../img/stories/story1.JPG" alt="">
                                </a>
                            </div>
                            <div class="col-md-7" id="info-adding">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="form-group col-lg-12 text-center">
                                <a href="views/timeline.html" class="btn btn-circle page-scroll" id="submit">
                                    <i class="fa fa-angle-double-down animated"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>