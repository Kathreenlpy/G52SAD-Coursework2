import java.io.File;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.ColorAdjust;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImageViewController 
{
    // Private fields for components 
    @FXML
    private ImageView myImage;

    @FXML
    private ToggleGroup myToggleGroup;

    @FXML
    private Button nextButton,preButton,zoomInButton,zoomOutButton,rotateLButton,rotateRButton,oriButton;
    
    
    @FXML
    private Image[] images;
    private int current;
    private Stage stage;
 
    // Initialize method
    public void initialize() 
    {
    	
    	 images= new Image[10];
    	
    	for(int i =0; i< 10; i++){
    	
    		images[0] = new Image("dog.jpg");
    		images[1] = new Image("cat.jpg");
    		images[2] = new Image("hummingbird.jpg");
    		images[3] = new Image("dog2.png");
    		images[4] = new Image("cat2.png");
    		images[5] = new Image("fox.jpg");
    		images[6] = new Image("rabbit.jpg");
    		images[7] = new Image("monkey.jpg");
    		images[8] = new Image("batman.bmp");
    		images[9] = new Image("koala.jpg");
    		
    	}
    }
    
    
    @FXML
    //button action
  private void handleButtonAction (ActionEvent event) {
  
    		
    		if(event.getSource() == nextButton){
    			nextImage();
    		}
    		else if (event.getSource() == preButton){
    			prevImage();
    		}
    		else if (event.getSource() == zoomInButton){
    			ZoomIn();
    		}
    		else if(event.getSource()==zoomOutButton){
    			ZoomOut();
    	   }
    		else if(event.getSource()==rotateLButton){
    			rotateImageLeft();
    	   }
    		else if(event.getSource()==rotateRButton){
    		   rotateImage();
    	   }
    		else if(event.getSource()==oriButton){
    			ori();
    	   }
    	}

    public void nextImage(){
    	 ++current;
    	 
    	 if(current == images.length){
    		 current = 0;
    		 }
    	 
		myImage.setImage(this.images[current]); //get rid of prev image
    }
    
    public void prevImage(){
    	
    	--current;
    	
    	if(current == -1){
    		current = images.length-1;
    		
    	}
    	 	
		myImage.setImage(this.images[current]);
    }
    
   
     public void rotateImage(){
    	myImage.setRotate(myImage.getRotate()+90);
    	
    	}
    
     public void rotateImageLeft(){
     	myImage.setRotate(myImage.getRotate()-90);
     	
     	}
     
     public void rotateImageMore(){
    	 myImage.setRotate(myImage.getRotate()+180);
     }
     public void colorImageAdjust(){
    	 ColorAdjust colorAdjust = new ColorAdjust();
    	 colorAdjust.setContrast(0.1);
    	 colorAdjust.setHue(-0.05);
    	 colorAdjust.setBrightness(0.1);
    	 colorAdjust.setSaturation(0.2);
    	 myImage.setPreserveRatio(true);
    	 myImage.setEffect(colorAdjust);
     }
     
     public void imageDark(){
    	 ColorAdjust dark = new ColorAdjust();
    	 dark.setBrightness(-0.5);
    	 myImage.setEffect(dark);
     }
     
     public void ori(){
    	 ColorAdjust originalImage = new ColorAdjust();
    	 originalImage.setContrast(0.0);
    	 originalImage.setHue(0.0);
    	 originalImage.setBrightness(0.0);
    	 originalImage.setSaturation(0.0);
    	 myImage.setPreserveRatio(true);
    	 myImage.setEffect(originalImage);
    	 myImage.setRotate(360);
    	 myImage.setFitWidth(200);
    	 myImage.setFitHeight(275);
     }
     
     public void ZoomIn(){
    	 myImage.setFitWidth(myImage.getFitWidth()+5);
    	 myImage.setFitHeight(myImage.getFitHeight()+5);
     }
     
     public void ZoomOut(){
    	 myImage.setFitWidth(myImage.getFitWidth()-5);
    	 myImage.setFitHeight(myImage.getFitHeight()-5);
     }
     public void init(Stage stage){
    	 this.stage = stage;
     }
   
     public void openFile(){
       	 FileChooser fileChooser = new FileChooser();
       	 fileChooser.setTitle("Open");
       	 fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
       	 fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
       	 
       	 File file = fileChooser.showOpenDialog(stage);
       	 
       	 if(file !=null){
       		System.out.println("Chosen File: " + file);
       	 }
        }
     
     public void closeFile(){
    	 Platform.exit();
     }


	public static void main(String[] args){
		new ImageViewController();
		
	}

    
}

