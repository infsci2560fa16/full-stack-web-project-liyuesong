package tripmark.controller;

import tripmark.Place;
import tripmark.Stories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.Date;

public class PlaceController {

	private Date date = new Date();
	// private SimpleDateFormat created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public Place buildStories(String placeName) throws Exception {
        ArrayList<Stories> subscription = new ArrayList<>();
        Connection connection = null;

        try {
        	// TODO: find stories related to this place in the database by placeName.
        } catch (Exception e) {
        	throw new Exception(this.getClass() + " build stories: database failure.");
        } finally {
        	if (connection != null) {
        		try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(this.getClass() + " build stories: Could not close connection to database.");
                }
        	}
        }

        /* test data */
        Stories ParisStory1 = new Stories("Things to do in Paris", "yuesongli", date, "");
        Stories ParisStory2 = new Stories("Eating in Paris", "someone else", date, "");
        Stories ParisStory3 = new Stories("The Seine", "Jay", date, "");
        Stories ParisStory4 = new Stories("Coffee and Cats in Paris", "catCat", date, "");
        Stories ParisStory5 = new Stories("French Elegance", "French women", date, "");
        subscription.add(ParisStory1);
        subscription.add(ParisStory2);
        subscription.add(ParisStory3);
        subscription.add(ParisStory4);
        subscription.add(ParisStory5);

        Place placeInfo = new Place(placeName, subscription);
        System.out.println("Place: " + placeInfo.getPlaceName());

        return placeInfo;
    }

    // public Place buildRecommendationStories() throws Exception {
    // 	Connection connection = null;
    // 	ArrayList<Stories> subscription

    // }
}
