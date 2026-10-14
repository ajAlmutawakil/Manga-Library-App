package MangaLibraryApp;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.InputStream;
import java.io.File;

public class ReaderController {
	

	    @FXML
	    private ImageView pageImageView;

	    @FXML
	    private Label pageTrackerLabel;

	    @FXML
	    private Button btnPrevious;

	    @FXML
	    private Button btnNext;

	    @FXML
	    private Button btnBack;

	    private List<String> pagePaths;
	    private int currentPageIndex = 0;

	    public void setMangaPages(List<String> pages) {
	        this.pagePaths = pages;
	        this.currentPageIndex = 0;
	        updatePage();
	    }

	    @FXML
	    private void handleNextPage(ActionEvent event) {
	        if (pagePaths != null && currentPageIndex < pagePaths.size() - 1) {
	            currentPageIndex++;
	            updatePage();
	        }
	    }

	    @FXML
	    private void handlePreviousPage(ActionEvent event) {
	        if (currentPageIndex > 0) {
	            currentPageIndex--;
	            updatePage();
	        }
	    }

	    @FXML
	    private void handleBack(ActionEvent event) {
	        Stage stage = (Stage) btnBack.getScene().getWindow();
	        stage.close();
	    }

	   
	    private void updatePage() {
	        if (pagePaths == null || pagePaths.isEmpty()) return;

	        try {
	            String path = pagePaths.get(currentPageIndex);
	            Image image = null;

	            // 1. التثبت إذا كان المسار يبدأ بـ C: أو يمثل ملفاً محلياً على الحاسوب
	            File localFile = new File(path);
	            if (localFile.exists()) {
	                image = new Image(localFile.toURI().toString());
	            } else {
	                // 2. المحاولة عبر Classpath إذا لم يكن ملفاً مستقلاً
	                InputStream stream = getClass().getResourceAsStream(path);
	                if (stream != null) {
	                    image = new Image(stream);
	                }
	            }

	            if (image != null && !image.isError()) {
	                pageImageView.setImage(image);
	                pageTrackerLabel.setText("Page " + (currentPageIndex + 1) + " / " + pagePaths.size());

	                btnPrevious.setDisable(currentPageIndex == 0);
	                btnNext.setDisable(currentPageIndex == pagePaths.size() - 1);
	            } else {
	                System.out.println("❌ تعذر تحميل الصورة من المسار: " + path);
	            }

	        } catch (Exception e) {
	            System.out.println("❌ حدث خطأ أثناء تحميل الصورة:");
	            e.printStackTrace();
	        }
	    }
	}