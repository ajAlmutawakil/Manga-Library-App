package MangaLibraryApp;
import java.util.List;

public class Book {
	private String title;
	private List <String> imagePath;
	
	public Book(String title, List <String> imagePath) {
		this.title = title;
		this.imagePath = imagePath;
	}
	
	public String getTitle() {
		return title;
	}
    
	public List <String> getImagePath() {
		return imagePath;
	}

}
