/**
 * <h1>Advanced Java - Project 5</h1>
 * <h1>Main Class</h1>
 * This class will create and show the controls for a Password Checker
 * <p>
 * <b>Note:</b> Regular expression will be used to check the Password entered
 *
 * @author   Michael Fox
 * @version  Project 05
 * @since   2016.10.30
 */

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Project05Fox extends Application
{
    //Member variables for the main class
    private TextField   txtEnteredPassword;
    private Label       lblPasswordStatus;
    private Button      btnPasswordCheck;
    private FlowPane    root;
	private String 		strResult = "";


    /**
     * Function where all of the JavaFx controls get created and shown
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception
    {
		
        primaryStage.setTitle( "Project 05 - Fox" );

        //Instantiate the controls
        lblPasswordStatus = new Label( "Enter Password" );
        btnPasswordCheck = new Button( "Check Password Format" );
        txtEnteredPassword = new TextField();

        //Do the handler for the pushbutton.  It will initiate the password being checked
        btnPasswordCheck.setOnAction( (input) -> {
			
            String strInput = txtEnteredPassword.getText();
			
            if( CheckPassword(strInput) )
			{
                lblPasswordStatus.setText( "Good Password" );
            }
			else
			{
				lblPasswordStatus.setText(strResult);
			}
        });

		//Do the flow pane and show the controls in the scene
        root = new FlowPane( Orientation.VERTICAL, 0, 10 ); // padding
        root.setAlignment( Pos.CENTER );
        root.getChildren().addAll( lblPasswordStatus, txtEnteredPassword, btnPasswordCheck);
        primaryStage.setScene( new Scene( root, 300, 250 ) );
        primaryStage.show();
    }

	//Use regular expressions to see if it is a good password or not
	//
	//  The password must have:
	//	at least 1 lowercase letter
	//  at least 1 uppercase letter
	//	at least 1 digit (0-9)
	//	at least 1 of the following special characters: !@$#%?
	private boolean CheckPassword(String strPassword)
	{
		boolean bRetValue = true;
		boolean bHaseUpperCase = false;
		boolean bHasLowerCase = false;
		boolean bHasDigit = false;
		boolean bHasSpecialCharacter = false;
		
		bHaseUpperCase = strPassword.matches(".*[A-Z].*");
		bHasLowerCase = strPassword.matches(".*[a-z].*");
		bHasDigit = strPassword.matches(".*[0-9].*");
		bHasSpecialCharacter = strPassword.matches(".*[!@$#%?].*");
		
		if(bHaseUpperCase == false)
		{
			strResult = "Must have an Upper Class letter";
		}
		else if(bHasLowerCase == false)
		{
			strResult = "Must have an Lower Class letter";
		}
		else if(bHasDigit == false)
		{
			strResult = "Must have a Numeric Digit";
		}
		else if(bHasSpecialCharacter == false)
		{
			strResult = "Must have a special character of \"!@$#%?\"";
		}
		
		
		//Must have all the tests above passing
		bRetValue = bHaseUpperCase & bHasLowerCase & bHasDigit & bHasSpecialCharacter;
		
		return(bRetValue);
	}
	
    /**
     * This the main function that runs.  It launches Java FX
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
