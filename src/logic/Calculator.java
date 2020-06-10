package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application{

	Label result;
	Button[] buttons =  new Button[20];
	int i;
	int counter=0;
	int punto = 0;
	float a =0;
	float b =0; 
	float c = 0;
	float d = 0;
	float res = 0;
	int operation;
	
		
	public static void main(String[] args) {
		launch(args);
	}

	public void buttonAction( int index){
		
		buttons[index].setOnAction(new EventHandler<ActionEvent>() {
					
					public void handle(ActionEvent event){
								if (i==0 && punto == 0) {
									a = a*10 + index;
									result.setText(""+ (int)a);
								}
								if(i==1 && punto == 0) {
									b= b*10 + index;
									result.setText(""+ (int)b);
								}
								if(i==0 && punto == 1) {
									c = c*10 + index ;
									counter++;
									result.setText("" + (int)a +  "." + (int)c);
								}
								if(i==1 && punto == 1) {
									d = d*10 + index;
									counter++;
									result.setText("" + (int)b +  "." + (int)d);
								}
								event.getSource();
							}
				});
		
	}
	
	public void setNewOperation() {
		
				buttons[17].setOnAction(new EventHandler<ActionEvent>() {
					
					public void handle(ActionEvent event){
							a = (float) (a + c/Math.pow(10, counter));
							res = (float) Math.pow(a, 2);
							result.setText("" + res);
							a=0;
							i=0;
							b=0;
							c=0;
							d=0;
							res=0;
							punto= 0 ;
							counter = 0;
							event.getSource();
					}
				});
				
				buttons[18].setOnAction(new EventHandler<ActionEvent>() {
					
					public void handle(ActionEvent event){
						if(i == 0) 	{
							a=-a;
							result.setText("" + a);
						}else {
							b=-b;
							result.setText("" + b);
						}
						event.getSource();	
					}
				});
				
				buttons[19].setOnAction(new EventHandler<ActionEvent>() {
					
					public void handle(ActionEvent event){
						String s;
						if(i == 0 ) {
							s = Float.toString(a);
							if(s.length() > 3) {
								a = Float.parseFloat(s.substring(0, s.length() - 3));
								result.setText("" + (int)a);
							}else {
								a = 0;
								result.setText("" + (int)a);
							}
							
							
						}
						
						if(i == 1 ) {
							s = Float.toString(b);
							if(s.length() > 3) {
								b = Float.parseFloat(s.substring(0, s.length() - 3));
								result.setText("" + (int)b);
							}else {
								b = 0;
								result.setText("" + (int)b);
							}
						}
						event.getSource();
					}
				});
			}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		result = new Label("0");
		result.setPrefWidth(400);
		result.setFont(new Font(30));
		VBox root = new VBox();
		
		GridPane gride = new GridPane();
		root.getChildren().add(result);
		
		
		buttons[10] = new Button("+");
		buttons[11] = new Button("-");
		buttons[12] = new Button("*");
		buttons[13] = new Button("/");
		buttons[14] = new Button("=");
		buttons[15] = new Button(".");
		buttons[16] = new Button("sqrt");
		buttons[17] = new Button("x^2");
		buttons[18] = new Button("+/-");
		buttons[19] = new Button("C");
		
		for(int j=0; j<10 ; j++) {
			
			buttons[j] = new Button("" + j);
			buttons[j].setPrefSize(60,60);
			buttons[j].setMinWidth(stage.getWidth());
			buttons[j].setFont(new Font(18));
			
		} 
		
		for(int j = 10 ; j < 20; j++) {
			
			buttons[j].setPrefSize(60,60);
			buttons[j].setMinWidth(stage.getWidth());
			buttons[j].setFont(new Font(18));
		}
		
		for(int j = 0 ; j<10 ; j++) {
			
			buttonAction(j);
		}
		
		buttons[10].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
					operation = 0;
					a = (float) (a + c/Math.pow(10, counter));
					i=1;
					punto=0;
					counter = 0;
					event.getSource();
			}
		});
		
		buttons[11].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
					operation = 1;
					a = (float) (a + c/Math.pow(10, counter));
					i=1;
					punto=0;
					counter = 0;
					event.getSource();
			}
		});
		
		buttons[12].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
					operation = 2;
					a = (float) (a + c/Math.pow(10, counter));
					i=1;
					punto = 0;
					counter = 0;
					event.getSource();
			}
		});
		
		buttons[13].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
					operation = 3;
					a = (float) (a + c/Math.pow(10, counter));
					i=1;
					punto=0;
					counter = 0;
					event.getSource();
			}
		});
		
		buttons[14].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
				b = (float) (b + d/Math.pow(10, counter));
					if(operation == 0) {
						res = a+b;
						result.setText("" + res);
						
					}else if(operation == 1) {
						res = a-b;
						result.setText("" + res);
						
					}else if(operation == 2) {
						res = a*b;
						result.setText("" + res);
						
					}else if(operation == 3) {
						res = a/b;
						result.setText("" + res);
					}
				a=0;
				i=0;
				b=0;
				c=0;
				d=0;
				res=0;
				punto= 0 ;
				counter = 0;
				event.getSource();
			}
		});
		

		buttons[15].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
					
					punto = 1 ; 
					
					if(i == 0) 	result.setText("" + (int)a + ".");
	
					else if(i == 1) 	result.setText("" + (int)b + ".");
					event.getSource();
			}
		});
		
		buttons[16].setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
					a = (float) (a + c/Math.pow(10, counter));
					res = (float) Math.pow(a, 0.5);
					result.setText("" + res);
					a=0;
					i=0;
					b=0;
					c=0;
					d=0;
					res=0;
					punto= 0 ;
					counter = 0;
					event.getSource();
			}
		});
		
		setNewOperation();
		
		
		gride.add(buttons[18],  0 , 0);
		gride.add(buttons[19],  1 , 0);
		gride.add(buttons[17],  2 , 0);
		gride.add(buttons[16],  3 , 0);
		gride.add(buttons[7],  0 , 1);
		gride.add(buttons[8],  1 , 1);
		gride.add(buttons[9],  2 , 1);
		gride.add(buttons[10],  3 , 1);
		gride.add(buttons[4],  0 , 2);
		gride.add(buttons[5],  1 , 2);
		gride.add(buttons[6],  2, 2);
		gride.add(buttons[11],  3 , 2);
		gride.add(buttons[1],  0 , 3);
		gride.add(buttons[2],  1 , 3);
		gride.add(buttons[3],  2 , 3);
		gride.add(buttons[12],  3 , 3);
		gride.add(buttons[0],  0 , 4);
		gride.add(buttons[15],  1 , 4);
		gride.add(buttons[14],  2 , 4);
		gride.add(buttons[13],  3 , 4);
	
		
		root.getChildren().add(gride);
		
		Scene scene = new Scene(root , 240, 300, Color.BLACK);
		stage.setScene(scene);
		stage.show();
	}

}
