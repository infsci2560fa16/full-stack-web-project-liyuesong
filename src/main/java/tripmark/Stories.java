package tripmark;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Stories {
	// Gson gson = new Gson();
	private UUID storyID;
	private String title;
	private String editor;
	private Date date;
	private String content;
	
	public Stories(String title, String editor, Date date, String content) {
		super();
		this.storyID = UUID.randomUUID();
		this.title = title;
		this.editor = editor;
		this.date = date;
		this.content = content;
	}

	public UUID getStoryID() {
		return storyID;
	}

	public void setStoryID(UUID storyID) {
		this.storyID = storyID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
