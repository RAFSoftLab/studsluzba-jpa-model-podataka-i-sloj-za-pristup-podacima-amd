package studsluzba;


import java.io.IOException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import studsluzba.client.MainViewManager;

@SpringBootApplication
@EnableJpaRepositories
public class StudSluzbaApp extends Application{
	
	protected ConfigurableApplicationContext springContext;   
	
	
	public static void main(String[] args) {
		launch(StudSluzbaApp.class);

	}
	 @Override
	    public void init() throws Exception {	   
		    springContext = SpringApplication.run(StudSluzbaApp.class);
		}   

	    
	    @Override
	    public void start(Stage primaryStage) throws IOException {
	    	
	    	primaryStage.setTitle("RAF Studentska služba");
	    	   
	    	MainViewManager mainView = springContext.getBean(MainViewManager.class);    	
	    	primaryStage.setScene(mainView.createScene());
	    	primaryStage.show(); 	
	    	
	    }   

	    
	    @Override
	    public void stop() throws Exception {
	    	springContext.close();
	    	Platform.exit();

	    }

}
