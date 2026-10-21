public class Song {
	private String title;
	private String composer;
	public Song(String title, String composer) {
		this.title = title;
		this.composer = composer;
	}
	public String getAttributes() {
		return this.getTitle() + ", by " + this.getComposer();
	}
	public String getTitle() {
		return this.title;
	}
	public String getComposer() {
		return this.composer;
	}
}