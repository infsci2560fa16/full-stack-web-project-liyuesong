package tripmark.service;

import com.google.gson.Gson;
import tripmark.Place;
import tripmark.User;
import tripmark.Stories;
import tripmark.controller.PlaceController;
import tripmark.utils.ServiceUtils;
import tripmark.utils.XmlUtils;
import spark.Session;
import java.util.HashMap;
import java.util.Map;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.UUID;

import static spark.Spark.get;

public class PlaceService {
    private Gson gson = new Gson();
    private ServiceUtils su = new ServiceUtils();
    private PlaceController pc = new PlaceController();
    private XmlUtils xu = new XmlUtils();

    /**
     * Place Service response to requests handling Place issues.
     */
    public PlaceService() {
        super();
        this.startServe();
    }

    private void startServe() {

        get("/details", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String placeName = request.queryParams("placeName");
            Place subscription = new Place();
            // ArrayList<Stories> storiesList = null;
            Session session = request.session(true);
            response.type("application/xml");
            if (su.hasUserLoggedIn(request, response)) {
                User u = ((User) session.attribute("user"));
                // UUID userId = u.getUserId();
                String email = u.getEmail();
                try {   // get stories in this place.
                    subscription = pc.buildStories(placeName);
                } catch (Exception e) {
                    System.out.println(this.getClass() + "/details: Database failure.");
                    e.printStackTrace();
                }
                // String xml = xu.buildPlaceXML(email, subscription);
                // attributes = getXML(xml);
                // session.attribute("xml", xu.buildPlaceXML(email, subscription));
                return xu.buildPlaceXML(email, subscription);
            } else {    //not login
                try {
                    subscription = pc.buildStories(placeName);
                    // System.out.println("placeName: " + subscription.getPlaceName());
                } catch (Exception e) {
                    System.out.println(this.getClass() + "/details: Database failure.");
                    e.printStackTrace();
                }
                // session.attribute("xml", xu.buildPlaceXML(null, subscription));
                return xu.buildPlaceXML(null, subscription);
            }
        });

        // get("/destinationDetails", (request, response) -> {
        //     Map<String, Object> attributes = new HashMap<>();
        //     Session session = request.session(true);
        //     User u = (User) session.attribute("user");
        //     String xml = session.attribute("xml");
        //     attributes.put("user", u);
        //     attributes.put("xml", xml);
        //     return new ModelAndView(attributes, "destinationDetails.ftl");
        // }, new FreeMarkerEngine());

    }

    // private Map<String, Object> getXML(String xml) {
    //     System.out.println(xml);
    // }
}
