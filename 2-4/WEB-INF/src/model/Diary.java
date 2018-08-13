
package model;

public class Diary {
    private String date;
    private String content;
    private String imgFileUrl;

	public String getContent() {
		return content;
	}


	public String getDate() {
		return date;
	}

	public String getImgFileUrl() {
		return imgFileUrl;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setImgFileUrl(String url) {
		imgFileUrl = url;
	}

}
