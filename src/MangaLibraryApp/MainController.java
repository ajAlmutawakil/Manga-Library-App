package MangaLibraryApp;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Modality;


public class MainController {


	    @FXML
	    private Button btnLibrary;

	    @FXML
	    private Button btnDemo;

	    @FXML
	    private Button btnRead1;

	    @FXML
	    private Button btnRead2;

	    private Book manga1;
	    private Book manga2;

	    @FXML
	    private void initialize() {
	        System.out.println("Manga Library Controller Initialized successfully!");

	        // استخدام / بدلاً من \
	        manga1 = new Book(
	            "HV part 1: A werewolf hunts a skeleton", Arrays.asList(
	            "C:/Users/asljf/Downloads/ilovepdf_pages-to-jpg/Horrible 2_pages-to-jpg-0003.jpg" ,
	            "C:/Users/asljf/Downloads/ilovepdf_pages-to-jpg/Horrible 2_pages-to-jpg-0004.jpg"
	            )
	        );

	        manga2 = new Book(
	            "HV part 2: Their chase leads into a hidden cave city, causing total chaos", Arrays.asList(
	            "C:/Users/asljf/Downloads/ilovepdf_pages-to-jpg/Horrible 2_pages-to-jpg-0006.jpg" ,
	            "C:/Users/asljf/Downloads/ilovepdf_pages-to-jpg/Horrible 2_pages-to-jpg-0007.jpg"
	            )
	        );
	    }

	    @FXML
	    private void handleLibraryAction(ActionEvent event) {
	        System.out.println("Library View Clicked!");
	    }

	    @FXML
	    private void handleDemoAction(ActionEvent event) {
	        System.out.println("Interactive Demo Clicked!");
	    }

	    @FXML
	    private void handelReadManga1(ActionEvent event) {
	        openReaderWindow(manga1);
	    }

	    @FXML
	    private void handelReadManga2(ActionEvent event) {
	        openReaderWindow(manga2);
	    }

	    private void openReaderWindow(Book selectedBook) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReaderView.fxml"));
	            Parent root = loader.load();

	            ReaderController readerController = loader.getController();
	            readerController.setMangaPages(selectedBook.getImagePath());

	            Stage stage = new Stage();
	            stage.setTitle("Read: " + selectedBook.getTitle());
	            stage.setScene(new Scene(root, 800, 750));
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.show();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}