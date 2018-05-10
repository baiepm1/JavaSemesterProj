import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class cardPicker extends Application{
	
	//***Card image size is 225 x 325 ******
	
	private ImageView pic1;
	private ImageView pic2;
	private ImageView pic3;
	private ImageView pic4;

	
	Button go;
	HBox hb = new HBox(20);
	Scene sn;
	
	//Add textfield for user to enter expression
    TextField txtExpression = new TextField();
    Label lblExpression = new Label("Enter an expression:");
    //Add verify button
    Button btnVerify = new Button("Verify");
	
	cardClass[] cardArray = new cardClass[52];	//0-51 = 52cards
	
	@Override
	public void start(Stage arg0) throws Exception {
        
//----------------manually filling array with card value and image------------//
		
		//cardClass(value, image);
		cardArray[0] = new cardClass(2, "2_of_clubs.png");
		cardArray[1] = new cardClass(2, "2_of_diamonds.png");
		cardArray[2] = new cardClass(2, "2_of_hearts.png");
		cardArray[3] = new cardClass(2, "2_of_spades.png");
		cardArray[4] = new cardClass(3, "3_of_clubs.png");
		cardArray[5] = new cardClass(3, "3_of_diamonds.png");
		cardArray[6] = new cardClass(3, "3_of_hearts.png");
		cardArray[7] = new cardClass(3, "3_of_spades.png");

		cardArray[8] = new cardClass(4, "4_of_clubs.png");
		cardArray[9] = new cardClass(4, "4_of_diamonds.png");
		cardArray[10] = new cardClass(4, "4_of_hearts.png");
		cardArray[11] = new cardClass(4, "4_of_spades.png");
		
		cardArray[12] = new cardClass(5, "5_of_clubs.png");
		cardArray[13] = new cardClass(5, "5_of_diamonds.png");
		cardArray[14] = new cardClass(5, "5_of_hearts.png");
		cardArray[15] = new cardClass(5, "5_of_spades.png");
		
		cardArray[16] = new cardClass(6, "6_of_clubs.png");
		cardArray[17] = new cardClass(6, "6_of_diamonds.png");
		cardArray[18] = new cardClass(6, "6_of_hearts.png");
		cardArray[19] = new cardClass(6, "6_of_spades.png");
		
		cardArray[20] = new cardClass(7, "7_of_clubs.png");
		cardArray[21] = new cardClass(7, "7_of_diamonds.png");
		cardArray[22] = new cardClass(7, "7_of_hearts.png");
		cardArray[23] = new cardClass(7, "7_of_spades.png");
		
		cardArray[24] = new cardClass(8, "8_of_clubs.png");
		cardArray[25] = new cardClass(8, "8_of_diamonds.png");
		cardArray[26] = new cardClass(8, "8_of_hearts.png");
		cardArray[27] = new cardClass(8, "8_of_spades.png");
		
		cardArray[28] = new cardClass(9, "9_of_clubs.png");
		cardArray[29] = new cardClass(9, "9_of_diamonds.png");
		cardArray[30] = new cardClass(9, "9_of_hearts.png");
		cardArray[31] = new cardClass(9, "9_of_spades.png");
		
		cardArray[32] = new cardClass(10, "10_of_clubs.png");
		cardArray[33] = new cardClass(10, "10_of_diamonds.png");
		cardArray[34] = new cardClass(10, "10_of_hearts.png");
		cardArray[35] = new cardClass(10, "10_of_spades.png");
		
		cardArray[36] = new cardClass(11, "jack_of_clubs.png");
		cardArray[37] = new cardClass(11, "jack_of_diamonds.png");
		cardArray[38] = new cardClass(11, "jack_of_hearts.png");
		cardArray[39] = new cardClass(11, "jack_of_spades.png");
		
		cardArray[40] = new cardClass(12, "queen_of_clubs.png");
		cardArray[41] = new cardClass(12, "queen_of_diamonds.png");
		cardArray[42] = new cardClass(12, "queen_of_hearts.png");
		cardArray[43] = new cardClass(12, "queen_of_spades.png");
		
		cardArray[44] = new cardClass(13, "king_of_clubs.png");
		cardArray[45] = new cardClass(13, "king_of_diamonds.png");
		cardArray[46] = new cardClass(13, "king_of_hearts.png");
		cardArray[47] = new cardClass(13, "king_of_spades.png");
		
		cardArray[48] = new cardClass(1, "ace_of_clubs.png");
		cardArray[49] = new cardClass(1, "ace_of_diamonds.png");
		cardArray[50] = new cardClass(1, "ace_of_hearts.png");
		cardArray[51] = new cardClass(1, "ace_of_spades.png");
		
//----------------------making 4 random numbers--------------------//
		Random rand = new Random();

		int card1 = rand.nextInt(51);
		int card2 = rand.nextInt(51);
		while(card2 == card1) {		//exclude repeat cards
			card2 = rand.nextInt(51);
		}
		int card3 = rand.nextInt(51);
		while(card3 == card1 || card3 == card2) {	//exclude repeat cards
			card3 = rand.nextInt(51);
		}
		int card4 = rand.nextInt(51);
		while(card4 == card1 || card4 == card2 || card4 == card3) {		//exclude repeat cards
			card4 = rand.nextInt(51);
		}
		
//----------------making the picture based on random number---------------//
		pic1 = new ImageView(cardArray[card1].getPic());
		pic2 = new ImageView(cardArray[card2].getPic());
		pic3 = new ImageView(cardArray[card3].getPic());
		pic4 = new ImageView(cardArray[card4].getPic());
        
		go = new Button("GO!");				//making button
		go.setOnAction(goEventListener);	//making button do stuff
		
		btnVerify.setOnAction(verifyEventListener);
		 
//-----------------------fill hbox-------------------------//
        BorderPane bpane = new BorderPane();
        bpane.setPadding(new Insets(10));
        
        HBox bottomPane = new HBox(10, lblExpression, txtExpression, btnVerify);
        HBox centerPane = new HBox(go, pic1, pic2, pic3, pic4); 

        
        bpane.setCenter(centerPane);
        bpane.setBottom(bottomPane);
       
        sn = new Scene(bpane);		//**** for some reason i cant change the color idk
        arg0.setTitle("Card Game!");
        arg0.setScene(sn);
        arg0.show();
	}
//-------------------------------------------------button doing stuff----------------------------//
	 EventHandler<ActionEvent> goEventListener
	    = (ActionEvent event) -> {
//------------------------re-make 4 random nums-------------------------//
	    	Random rand = new Random();
			int card1 = rand.nextInt(51);
			int card2 = rand.nextInt(51);
			while(card2 == card1) {		//exclude repeat cards
				card2 = rand.nextInt(51);
			}
			int card3 = rand.nextInt(51);
			while(card3 == card1 || card3 == card2) {	//exclude repeat cards
				card3 = rand.nextInt(51);
			}
			int card4 = rand.nextInt(51);
			while(card4 == card1 || card4 == card2 || card4 == card3) {		//exclude repeat cards
				card4 = rand.nextInt(51);
			}
//----------------re-make 4 images based on new rand nums---------------//
			pic1 = new ImageView(cardArray[card1].getPic());
			pic2 = new ImageView(cardArray[card2].getPic());
			pic3 = new ImageView(cardArray[card3].getPic());
			pic4 = new ImageView(cardArray[card4].getPic());
//----------------clear hbox then refill it----------------------------//
			
			hb.getChildren().clear();
	        hb.getChildren().add(go);
			hb.getChildren().add(pic1);
	        hb.getChildren().add(pic2);
	        hb.getChildren().add(pic3);
	        hb.getChildren().add(pic4);		        
	    };
	    
//----------------Verify Button: Solve the Expression----------------------------//
	    EventHandler<ActionEvent> verifyEventListener = (ActionEvent e) -> {

	    	//Declare variables
	    	String expression = txtExpression.getText();
	    	List<String> list = new ArrayList<>();
	    	int solution;

	    	//Convert the string 'expression' to an ArrayList
	    	list = new ArrayList<String>(Arrays.asList(expression.split(" ")));

	    	//Following the rules of Order of Operations, navigate
	    	//through the 'list' using a while loop to determine
	    	//if there is a multiplication ('*') or division ('/') symbol
	    	//multiply or divide the values located before and after the symbol
	    	while (list.contains("*") || list.contains("/")) {
	    		int a = list.indexOf("*");
	    		int b = list.indexOf("/");
	    		if (((b > a) || (b <= -1)) && (a >= 0)) {
	    			int firstNum = Integer.parseInt(list.get(a - 1));
	    			int secondNum = Integer.parseInt(list.get(a + 1));
	    			list.set(a - 1, String.valueOf((firstNum * secondNum)));
	    			list.remove(a);
	    			list.remove(a);
	    		} else if (b >= 0) {
	    			int firstNum = Integer.parseInt(list.get(b - 1));
	    			int secondNum = Integer.parseInt(list.get(b + 1));
	    			list.set(b - 1, String.valueOf(Math
	    					.round((((double) firstNum) / ((double) secondNum)))));
	    			list.remove(b);
	    			list.remove(b);
	    		}
	    	}

	    	//Followed by multiplication and division
	    	while (list.contains("+") || list.contains("-")) {
	    		int a = list.indexOf("+");
	    		int b = list.indexOf("-");
	    		if (((b > a) || (b <= -1)) && (a >= 0)) {
	    			int firstNum = Integer.parseInt(list.get(a - 1));
	    			int secondNum = Integer.parseInt(list.get(a + 1));
	    			list.set(a - 1, String.valueOf((firstNum + secondNum)));
	    			list.remove(a);
	    			list.remove(a);
	    		} else if (b >= 0) {
	    			int firstNum = Integer.parseInt(list.get(b - 1));
	    			int secondNum = Integer.parseInt(list.get(b + 1));
	    			list.set(b - 1, String.valueOf((firstNum - secondNum)));
	    			list.remove(b);
	    			list.remove(b);
	    		}
	    	}

	    	//Using convertToExpression to convert the ArrayList to String
	    	//then storing the value in 'solution'
	    	solution = Integer.parseInt(convertToExpression(list).replace(" ", ""));

	    	//For testing purposes, sysout 'solution'
	    	System.out.println(solution);



	    };

	    //Convert the ArrayList back to String using a for loop
	    protected String convertToExpression(List<?> list) {
	    	String expression = "";
	    	for (int i = 0; i < list.size(); i++) {
	    		if (i != (list.size() - 1))
	    			expression += list.get(i) + " ";
	    		else
	    			expression += list.get(i);
	    	}
	    	return expression;
	    }
//----------------------------------------------------------------------//
	    
	 //launch program
	 public static void main(String[] arg0)
	    {
	        launch(arg0);
	    }
}
