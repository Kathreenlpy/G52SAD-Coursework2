import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;   
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageView extends Application 
{ 
	private Button nextButton,preButton,zoomInButton,zoomOutButton,rotateLButton,rotateRButton,oriButton;
	private MenuItem exitMenuItem,openMenuItem,rotateLeft,rotateRight,rotateMore,colorAdjustMI,darkMI,oriMI;
	private ImageViewController ivc = new ImageViewController();
	
	 
   public void start(Stage stage) throws Exception
   {  
	  
      // Load the FXML file.
      Parent parent = FXMLLoader.load(getClass().getResource("ImageView.fxml"));
      
      
   // Build the scene graph.
      BorderPane rootBP = new BorderPane();
      Scene scene = new Scene(parent); 
      Group root = new Group();
      
      //create menubar
      MenuBar menuBar = new MenuBar();
      menuBar.prefWidthProperty().bind(stage.maxWidthProperty());
      rootBP.setTop(menuBar);
      
      //content of Menu bar
      Menu menuFile = new Menu("File");
      Menu menuEdit = new Menu("Edit");
      Menu menuView = new Menu("View");
      
      menuFile.setMnemonicParsing(true);
      MenuItem exitMenuItem = new MenuItem("Exit");
      menuFile.getItems().add(exitMenuItem);
      exitMenuItem.setOnAction(e->handleButtonAction(e));
      
      menuFile.setMnemonicParsing(true);
      MenuItem openMenuItem = new MenuItem("Open");
      menuFile.getItems().add(openMenuItem);
      openMenuItem.setOnAction(e->handleButtonAction(e));
      
      
      menuEdit.setMnemonicParsing(true);
      MenuItem rotateLeft = new MenuItem("Rotate Left");
      menuEdit.getItems().add(rotateLeft);
      rotateLeft.setOnAction(e->handleButtonAction(e));
     
      menuEdit.setMnemonicParsing(true);
      MenuItem rotateRight = new MenuItem("Rotate Right");
      menuEdit.getItems().add(rotateRight);
      rotateRight.setOnAction(e->handleButtonAction(e));
      
      menuEdit.setMnemonicParsing(true);
      MenuItem rotateMore = new MenuItem("Rotate UpsideDown");
      menuEdit.getItems().add(rotateMore);
      rotateMore.setOnAction(e->handleButtonAction(e));
      
      menuEdit.setMnemonicParsing(true);
      MenuItem colorAdjustMI = new MenuItem("Brighter");
      menuEdit.getItems().add(colorAdjustMI);
      colorAdjustMI.setOnAction(e->handleButtonAction(e));
      
      menuEdit.setMnemonicParsing(true);
      MenuItem darkMI = new MenuItem("Darker");
      menuEdit.getItems().add(darkMI);
      darkMI.setOnAction(e->handleButtonAction(e));
      
      
      menuEdit.setMnemonicParsing(true);
      MenuItem oriMI = new MenuItem("Reset");
      menuEdit.getItems().add(oriMI);
      oriMI.setOnAction(e->handleButtonAction(e));
      
      menuBar.getMenus().addAll(menuFile,menuEdit,menuView);
      
      nextButton = new Button("Next");
      nextButton.setOnAction(e->handleButtonAction(e));
      
      preButton = new Button("Previous");
      preButton.setOnAction(e->handleButtonAction(e));
      
      zoomInButton = new Button("Zoom In");
      zoomInButton.setOnAction(e->handleButtonAction(e));
      
      zoomOutButton = new Button("Zoom Out");
      zoomOutButton.setOnAction(e->handleButtonAction(e));
      
      rotateLButton = new Button("Rotate Left");
      rotateLButton.setOnAction(e->handleButtonAction(e));
      
      rotateRButton = new Button("Rotate Right");
      rotateRButton.setOnAction(e->handleButtonAction(e));
      
      
      

      
      
      
       
      // Display our window, using the scene graph.
      root.getChildren().add(nextButton);
      root.getChildren().add(preButton);
      
      stage.setTitle("ImageViewDemo"); 
      HBox hbRoot = new HBox();
      hbRoot.getChildren().add(menuBar);
      rootBP.setTop(menuBar);
      stage.setScene(scene);
      stage.show(); 
   }
   
private void handleButtonAction(ActionEvent event){
	   
	   
	   if(event.getSource()==nextButton){
		   ivc.nextImage();
	   }
	   else if (event.getSource()==preButton){
		   ivc.prevImage();
	   }
	   else if(event.getSource()==zoomInButton){
		   ivc.ZoomIn();
	   }
	   else if(event.getSource()==zoomOutButton){
		   ivc.ZoomOut();
	   }
	   else if(event.getSource()==rotateLButton){
		   ivc.rotateImageLeft();
	   }
	   else if(event.getSource()==rotateRButton){
		   ivc.rotateImage();
	   }
	   else if(event.getSource()==oriButton){
		   ivc.ori();
	   }
	   else if(event.getSource()==rotateLeft){
		   ivc.rotateImageLeft();
	   }
	   else if(event.getSource()==rotateRight){
		   ivc.rotateImage();
	   }
	   else if(event.getSource()==rotateMore){
		   ivc.rotateImageMore();
	   }
	   else if(event.getSource()==colorAdjustMI){
		   ivc.colorImageAdjust();
	   }
	   else if(event.getSource()==darkMI){
		   ivc.imageDark();
	   }
	   else if(event.getSource()==oriMI){
		   ivc.ori();
	   }
	   else if(event.getSource()==openMenuItem){
		   ivc.openFile();
	   }
	   else if(event.getSource()==exitMenuItem){
		   ivc.closeFile();
	   }
	  /* else if(event.getSource()==zoomInMI){
		   ivc.ZoomIn();
	   }*/
   }
   
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
 } 