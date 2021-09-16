import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {
	
	ArrayList<Student> Class = new ArrayList<>();
	JTextArea outputArea;
	JButton addButton;
	JButton removeButton;
	JButton modifyButton;
	
//	JButton addButton = addButton("Compute", 4,1,2,1);
//	JButton computeButton = addButton("Compute", 4,1,2,1);
//	JButton computeButton = addButton("Compute", 4,1,2,1);
//	JLabel incomeLabel = addLabel("Income", 1,1,1,1);
//	DoubleField incomeField = addDoubleField(0.0, 1,2,1,1);
	
	public void mainMenu() {
		outputArea = addTextArea("", 1, 1, 1, 5);
		addButton = addButton("Add Student", 6,1,1,1);
		removeButton = addButton("Remove Student", 7,1,1,1);
		modifyButton = addButton("Modify Student", 8,1,1,1);
//		JButton printClassButton = addButton("Compute", 4,1,2,1);
	}
	
	public void addMenu() {
		JLabel nameLabel = addLabel("Name", 1,1,1,1);
		JTextField nameField = addTextField("", 1,2,1,1);
		
	}
	
	public GUI() {
		mainMenu();
		Student a = new Student("a", 111, 4.1, 90);
		Class.add(a);
		Student b = new Student("b", 121, 2.1, 60);
		Class.add(b);
		updateList();
		
	}
	
	public void buttonClicked(JButton buttonObj){
	    if(buttonObj == addButton) {
	    	addMenu();
	    	System.out.println("add");
	    }
	}
	
	public void updateList() {
		if(Class.size() == 0) {
			outputArea.append ("None");
		} else {
			for(Student s : Class) {
				outputArea.append (s.toString());
			}
		}
	
	}
	
	public static void main(String[] args) {
		JFrame frm = new GUI();
		frm.setTitle("Class");
		frm.setSize(250, 500);
		frm.setVisible(true);
		
	}

}
