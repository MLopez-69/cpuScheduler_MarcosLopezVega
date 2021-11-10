package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.FirstInFirstServed;
import models.ganttChart;
import models.process;

public class mainController implements Initializable{
	
	private FirstInFirstServed fifo;
	
    @FXML
    private ComboBox<Integer> processBox;

    @FXML
    private Label gantt1;

    @FXML
    private Label gantt2;

    @FXML
    private Label gantt3;

    @FXML
    private Label gantt4;

    @FXML
    private Label gantt5;

    @FXML
    private Label gantt6;

    @FXML
    private Label gantt7;

    @FXML
    private Label gantt8;

    @FXML
    private Label gantt9;

    @FXML
    private Label gantt10;

    @FXML
    private Label currentProcess;

    @FXML
    private Label p1;

    @FXML
    private Label p2;

    @FXML
    private Label p3;

    @FXML
    private Label p4;

    @FXML
    private Label p5;

    @FXML
    private Label p6;

    @FXML
    private Label p7;

    @FXML
    private Label p8;

    @FXML
    private Label p9;

    @FXML
    private Label p10;
    
    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private TextField text4;

    @FXML
    private TextField text5;

    @FXML
    private TextField text6;

    @FXML
    private TextField text7;

    @FXML
    private TextField text8;

    @FXML
    private TextField text9;

    @FXML
    private TextField text10;

    @FXML
    private Label averageLabel;

    @FXML
    private Label taLabel;

    @FXML
    private Label waitLabel1;

    @FXML
    private Label waitLabel2;

    @FXML
    private Label waitLabel3;

    @FXML
    private Label waitLabel4;

    @FXML
    private Label waitLabel5;

    @FXML
    private Label waitLabel6;

    @FXML
    private Label waitLabel7;

    @FXML
    private Label waitLabel8;

    @FXML
    private Label waitLabel9;

    @FXML
    private Label waitLabel10;

    @FXML
    private Label taLabel1;

    @FXML
    private Label taLabel2;

    @FXML
    private Label taLabel3;

    @FXML
    private Label taLabel4;

    @FXML
    private Label taLabel5;

    @FXML
    private Label taLabel6;

    @FXML
    private Label taLabel7;

    @FXML
    private Label taLabel9;

    @FXML
    private Label taLabel8;

    @FXML
    private Label taLabel10;
    @FXML
    private ComboBox<String> comboBox;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		fifo=new FirstInFirstServed(1);
		initBoxes();
		setLabelsFalse();
		
	}
	
	
	public void initBoxes() {
		processBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
		comboBox.getItems().addAll("FCFS","SJF");
	}
	
	@FXML
    void calculate(ActionEvent event) {
		clearGantt();
		int maxInt= processBox.getValue();
		int count=1;
		while(count<=maxInt) {
			process newProcess= 
			new process(getLabelText(count),getText(count));
			fifo.queue(newProcess);
			count++;
		}
		count=1;
		
		fifo.setTimes();
		
		while(count<=maxInt) {
			setWaitTimeLabel(count,fifo.getWaitTime());
			setTALabel(count,fifo.getTATime());
			setGantt(count);
			fifo.next();
			count++;
		}
		averageLabel.setText
		(String.format("Average: %.2f", fifo.calculateWaitTime()));
		taLabel.setText
		(String.format("Average: %.2f", fifo.calculateTATime()));
    }

    @FXML
    void randomBurst(ActionEvent event) {
    	int maxInt= processBox.getValue();
		int count=1;
		while(count<=maxInt) {
			setRandomText(count);
			count++;
		}
    }
    
    @FXML
    public void setProcessesVisible(){
    	int maxInt= processBox.getValue();
    	setLabelsFalse();
    	int count=1;
    	while(count<=maxInt) {
    		setLabelsVisible(count,true);
    		count++;	
    	}
    	fifo.setMax(maxInt);
    	clearLabels();
    }
    
    public void changeWindow(ActionEvent event) throws IOException {
    	String scheduler=comboBox.getValue();
    	System.out.println(scheduler);
    	switch(scheduler) {
    	case "FCFS":
    		break;
    	case "SJF":
    		Parent root = FXMLLoader.load(getClass().getResource("/views/SJFView.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
    		break;
    	default:break;
    	}
    }
    
    public void setLabelsFalse() {
    	int count=2;
    	while(count<=10) {
    		setLabelsVisible(count,false);
    		count++;
    	}
    }
    
    public void setLabelsVisible(int labels, boolean isTrue) {
    	switch(labels) {
    	case 1:
    		p1.setVisible(isTrue); text1.setVisible(isTrue);
    		waitLabel1.setVisible(isTrue); taLabel1.setVisible(isTrue);
    		break;
    	case 2: 
    		p2.setVisible(isTrue); text2.setVisible(isTrue);
    		waitLabel2.setVisible(isTrue) ;taLabel2.setVisible(isTrue);
    		break;  	
    	case 3: 
    		p3.setVisible(isTrue); text3.setVisible(isTrue);
    		waitLabel3.setVisible(isTrue); taLabel3.setVisible(isTrue);
    		break;
    	case 4: 
    		p4.setVisible(isTrue); text4.setVisible(isTrue);
    		waitLabel4.setVisible(isTrue); taLabel4.setVisible(isTrue);
    		break; 	
    	case 5: 
    		p5.setVisible(isTrue); text5.setVisible(isTrue);
    		waitLabel5.setVisible(isTrue); taLabel5.setVisible(isTrue);
    		break;	
    	case 6: 
    		p6.setVisible(isTrue); text6.setVisible(isTrue);
    		waitLabel6.setVisible(isTrue); taLabel6.setVisible(isTrue);
    		break;
    	case 7: 
    		p7.setVisible(isTrue); text7.setVisible(isTrue);
    		waitLabel7.setVisible(isTrue); taLabel7.setVisible(isTrue);
    		break;
    	case 8: 
    		p8.setVisible(isTrue); text8.setVisible(isTrue);
    		waitLabel8.setVisible(isTrue); taLabel8.setVisible(isTrue);
    		break;
    	case 9: 
    		p9.setVisible(isTrue); text9.setVisible(isTrue);
    		waitLabel9.setVisible(isTrue); taLabel9.setVisible(isTrue);
    		break;
    	case 10: 
    		p10.setVisible(isTrue); text10.setVisible(isTrue);
    		waitLabel10.setVisible(isTrue); taLabel10.setVisible(isTrue);
    		break;
    	}
    	
    }
    
    public void clearGantt() {
    	gantt1.setText("");
    	gantt2.setText("");
    	gantt3.setText("");
    	gantt4.setText("");
    	gantt5.setText("");
    	gantt6.setText("");
    	gantt7.setText("");
    	gantt8.setText("");
    	gantt9.setText("");
    	gantt10.setText("");
    }
    
    public void clearLabels() {
    		text1.clear(); gantt1.setText("");
    		waitLabel1.setText("0"); taLabel1.setText("0");

    		text2.clear(); gantt2.setText("");
    		waitLabel2.setText("0"); taLabel2.setText("0");

    		text3.clear(); gantt3.setText("");
    		waitLabel3.setText("0"); taLabel3.setText("0");

    		text4.clear(); gantt4.setText("");
    		waitLabel4.setText("0"); taLabel4.setText("0");
    		
    		text5.clear(); gantt5.setText("");
    		waitLabel5.setText("0"); taLabel5.setText("0");
 
    		text6.clear(); gantt6.setText("");
    		waitLabel6.setText("0"); taLabel6.setText("0");
    
    		text7.clear(); gantt7.setText("");
    		waitLabel7.setText("0"); taLabel7.setText("0");
 
    		text8.clear(); gantt8.setText("");
    		waitLabel8.setText("0"); taLabel8.setText("0");
 
    		text9.clear(); gantt9.setText("");
    		waitLabel9.setText("0"); taLabel9.setText("0");
    
    		text10.clear(); gantt10.setText("");
    		waitLabel10.setText("0"); taLabel10.setText("0");
    	}
    

	public String getLabelText(int labelNumber) {
    	switch(labelNumber) {
    	case 1: return p1.getText();
    	case 2:return p2.getText();
    	case 3:return p3.getText();
    	case 4:return p4.getText();
    	case 5:return p5.getText();
    	case 6:return p6.getText();
    	case 7:return p7.getText();
    	case 8:return p8.getText();
    	case 9:return p9.getText();
    	case 10:return p10.getText();
    	default:return p1.getText();
    	}	
    }
	
	public void setRandomText(int labelNumber) {
		int newInt=(int) ((Math.random()*9)+1);
		String newString=String.format("%d", newInt);
    	switch(labelNumber) {
    	case 1: text1.setText(newString);break;
    	case 2:text2.setText(newString);break;
    	case 3:text3.setText(newString);break;
    	case 4:text4.setText(newString);break;
    	case 5:text5.setText(newString);break;
    	case 6:text6.setText(newString);break;
    	case 7:text7.setText(newString);break;
    	case 8:text8.setText(newString);break;
    	case 9:text9.setText(newString);break;
    	case 10:text10.setText(newString);break;
    	}	
    }
	
	public int getText(int textNumber) {
    	switch(textNumber) {
    	case 1:return Integer.parseInt(text1.getText());
    	case 2:return Integer.parseInt(text2.getText());
    	case 3:return Integer.parseInt(text3.getText());
    	case 4:return Integer.parseInt(text4.getText());
    	case 5:return Integer.parseInt(text5.getText());
    	case 6:return Integer.parseInt(text6.getText());
    	case 7:return Integer.parseInt(text7.getText());
    	case 8:return Integer.parseInt(text8.getText());
    	case 9:return Integer.parseInt(text9.getText());
    	case 10:return Integer.parseInt(text10.getText());
    	default:return Integer.parseInt(text1.getText());
    	}	
    }
	
	public void setWaitTimeLabel(int labelNumber,int number) {
		String newString=String.format("%d", number);
    	switch(labelNumber) {
    	case 1:waitLabel1.setText(newString);break;
    	case 2:waitLabel2.setText(newString);break;
    	case 3:waitLabel3.setText(newString);break;
    	case 4:waitLabel4.setText(newString);break;
    	case 5:waitLabel5.setText(newString);break;
    	case 6:waitLabel6.setText(newString);break;
    	case 7:waitLabel7.setText(newString);break;
    	case 8:waitLabel8.setText(newString);break;
    	case 9:waitLabel9.setText(newString);break;
    	case 10:waitLabel10.setText(newString);break;
    	}	
    }
	
	public void setTALabel(int labelNumber,int number) {
		String newString=String.format("%d", number);
    	switch(labelNumber) {
    	case 1:taLabel1.setText(newString);break;
    	case 2:taLabel2.setText(newString);break;
    	case 3:taLabel3.setText(newString);break;
    	case 4:taLabel4.setText(newString);break;
    	case 5:taLabel5.setText(newString);break;
    	case 6:taLabel6.setText(newString);break;
    	case 7:taLabel7.setText(newString);break;
    	case 8:taLabel8.setText(newString);break;
    	case 9:taLabel9.setText(newString);break;
    	case 10:taLabel10.setText(newString);break;
    	}	
    }
    
	public void setGantt(int labelNumber) {
    	switch(labelNumber) {
    	case 1:gantt1.setText("p1");break;
    	case 2:gantt2.setText("p2");break;
    	case 3:gantt3.setText("p3");break;
    	case 4:gantt4.setText("p4");break;
    	case 5:gantt5.setText("p5");break;
    	case 6:gantt6.setText("p6");break;
    	case 7:gantt7.setText("p7");break;
    	case 8:gantt8.setText("p8");break;
    	case 9:gantt9.setText("p9");break;
    	case 10:gantt10.setText("p10");break;
    	}	
    }

}
