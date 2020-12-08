package studsluzba.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class MainViewManager {
	
		private static List<Object> parameters = new ArrayList<Object>();
		
		@Autowired
		ContextFXMLLoader appFXMLLoader; 
		
		private Scene scene;
		
		public Scene createScene() {	  
		  try {		  
			  FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/main.fxml"));
			  BorderPane borderPane = loader.load();
			  this.scene = new Scene(borderPane);			  
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  return this.scene;
		 }			
		
		public void changeRoot(String fxml) {
			FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/"+fxml+".fxml"));
			try {
				scene.setRoot(loader.load());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void setParameters(List<Object> p) {
			parameters = p;
		}

		public static List<Object> getParameters() {
			return parameters;
		}
		
		public void openModal(String fxml) {
			FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/"+fxml+".fxml"));
			try {
				Parent parent = loader.load();
				Scene scene = new Scene(parent, 400, 300);
		        Stage stage = new Stage();
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.setScene(scene);
		        stage.showAndWait();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void openModalNoWait(String fxml) {
			FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/"+fxml+".fxml"));
			try {
				Parent parent = loader.load();
				Scene scene = new Scene(parent, 400, 300);
		        Stage stage = new Stage();
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.setScene(scene);
		        stage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}


