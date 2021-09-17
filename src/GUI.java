import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {
	
	static JFrame frm;
	ArrayList<Student> Class = new ArrayList<>();
	Iterator<Student> it;
	JTextArea outputArea;
	JButton addButton;
	JButton removeButton;
	JButton modifyButton;
	JButton addStudentButton;
	JButton removeStudentButton;
	JButton backButton;
	JTextField nameField;
	IntegerField IDField;
	DoubleField GPAField;
	IntegerField gradeField;
	
	public void initMainMenu() {
		it = Class.iterator();
		outputArea = addTextArea("", 1, 1, 1, 6);
		addButton = addButton("Add Student", 7,1,1,1);
		removeButton = addButton("Remove Student", 8,1,1,1);
		modifyButton = addButton("Modify Student", 9,1,1,1);
	}
	
	
	public void mainMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 500);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 1, 6);
		addButton = addButton("Add Student", 7,1,1,1);
		removeButton = addButton("Remove Student", 8,1,1,1);
		modifyButton = addButton("Modify Student", 9,1,1,1);
//		JButton printClassButton = addButton("Compute", 4,1,2,1);
		frm.validate();
		updateList();
	}
	
	public void addMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 250);
		frm.repaint();
		JLabel nameLabel = addLabel("Name", 1,1,1,1);
		nameField = addTextField("", 1,2,1,1);
		JLabel IDLabel = addLabel("ID", 2,1,1,1);
		IDField = addIntegerField(0, 2,2,1,1);
		JLabel GPALabel = addLabel("GPA", 3,1,1,1);
		GPAField = addDoubleField(0.0, 3,2,1,1);
		JLabel gradeLabel = addLabel("Grade", 4,1,1,1);
		gradeField = addIntegerField(0, 4,2,1,1);
		backButton = addButton("Back", 5,1,1,1);
		addStudentButton = addButton("Add Student", 5,2,1,1);
		frm.validate();
	}
	
	public void removeMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 100);
		frm.repaint();
		JLabel nameLabel = addLabel("Name", 1,1,1,1);
		nameField = addTextField("", 1,2,1,1);
		backButton = addButton("Back", 2,1,1,1);
		removeStudentButton = addButton("Remove Student", 2,2,1,1);
		frm.validate();
	}
	
	public GUI() {
		initMainMenu();
		Student a = new Student("a", 111, 4.1, 90);
		Class.add(a);
		Student b = new Student("b", 121, 2.1, 60);
		Class.add(b);
		updateList();
		
	}
	
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == backButton) {
	    	mainMenu();
	    	return;
		} else if(buttonObj == addButton) {
	    	addMenu();
	    	System.out.println("add");
	    	return;
	    } else if(buttonObj == removeButton) {
	    	removeMenu();
	    	return;
	    } else if (buttonObj == addStudentButton) {
	    	String name = nameField.getText();
	    	int ID = IDField.getNumber();
	    	double GPA = GPAField.getNumber();
	    	int grade = gradeField.getNumber();
	    	if(name.equals("")) {
	    		messageBox("Error: Please Enter Name");
	            return;
	    	} else if(!IDField.isValidNumber() || ID <= 0) {
	    		messageBox("Error: Please Make Sure ID is Number and is Greater than 0");
	            return;
	    	} else if(!GPAField.isValidNumber() || GPA <= 0) {
	    		messageBox("Error: Please Make Sure GPA is Number and is Greater than 0");
	            return;
	    	} else if(!gradeField.isValidNumber() || grade <= 0) {
	    		messageBox("Error: Please Make Sure Grade is Number and is Greater than 0");
	            return;
	    	}
	    	Student s = new Student(name, ID, GPA, grade);
	    	Class.add(s);
	    	mainMenu();
	    	return;
	    } else if (buttonObj == removeStudentButton) {
	    	it = Class.iterator();
	    	String name = nameField.getText();
	    	if(name.equals("")) {
	    		messageBox("Error: Please Enter Name");
	            return;
	    	} 
	    	while(it.hasNext()) {
	    		  System.out.println(it.next());
	    	}
	    	mainMenu();
	    	return;
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
		frm = new GUI();
		frm.setTitle("Class");
		frm.setSize(250, 500);
		frm.setVisible(true);
		
	}

}
