package tripmark;

import tripmark.Stories;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Place {
	// Gson gson = new Gson();
	private UUID placeID;
	private String placeName;
	private String placeDetail;
	private String introMessage;
	private int pageView;
	private int visiterCount;

	private String commendSight;
	private String commendHotel;
	private String temperature;
	private String recentComment;
	ArrayList<Stories> stories;
	
	public Place() {
		super();
	}

	public Place(String placeName, ArrayList<Stories> stories) {
		this.placeID = UUID.randomUUID();
		this.placeName = placeName;
		// country -> placeDetail
		this.placeDetail = "detail: country";
		this.introMessage = "information...";
		this.stories = stories;
		this.pageView = 0;
		this.visiterCount = 0;
		this.commendSight = "";
		this.commendHotel = "airbnb";
		this.temperature = "10C";
		this.recentComment = "Ohhhhhhhhh...";
	}

	public UUID getPlaceId() {
		return placeID;
	}

	public void setPlaceId(UUID placeID) {
		this.placeID = placeID;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceDetail() {
		return placeDetail;
	}

	public void setPlaceDetail(String placeDetail) {
		this.placeDetail = placeDetail;
	}

	public String getIntroMessage() {
		return introMessage;
	}

	public void setIntroMessage(String introMessage) {
		this.introMessage = introMessage;
	}

	public int getPageView() {
		return pageView;
	}

	public void setPageView(int pageView) {
		this.pageView = pageView;
	}

	public int getVisiterCount() {
		return visiterCount;
	}

	public void setVisiterCount(int visiterCount) {
		this.visiterCount = visiterCount;
	}

	public String getCommendSight() {
		return commendSight;
	}

	public void setCommendSight(String commendSight) {
		this.commendSight = commendSight;
	}

	public String getCommendHotel() {
		return commendHotel;
	}

	public void setCommendHotel(String commendHotel) {
		this.commendHotel = commendHotel;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRecentComment() {
		return recentComment;
	}

	public void setRecentComment(String recentComment) {
		this.recentComment = recentComment;
	}

	public ArrayList<Stories> getStories() {
		return stories;
	}

	public void setStories(ArrayList<Stories> stories) {
		this.stories = stories;
	}

}
