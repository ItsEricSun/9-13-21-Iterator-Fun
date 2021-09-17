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
	JButton modifyInfoButton;
	JButton modifyStudentButton;
	JButton backButton;
	JButton backModifyButton;
	JTextField nameField;
	IntegerField IDField;
	DoubleField GPAField;
	IntegerField gradeField;
	Student temp;

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
		frm.validate();
		updateList();
	}

	public void addMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 578);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		JLabel IDLabel = addLabel("ID", 8,1,1,1);
		IDField = addIntegerField(0, 8,2,1,1);
		JLabel GPALabel = addLabel("GPA", 9,1,1,1);
		GPAField = addDoubleField(0.0, 9,2,1,1);
		JLabel gradeLabel = addLabel("Grade", 10,1,1,1);
		gradeField = addIntegerField(0, 10,2,1,1);
		backButton = addButton("Back", 11,1,1,1);
		addStudentButton = addButton("Add Student", 11,2,1,1);
		frm.validate();
		updateList();
	}

	public void removeMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 444);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		backButton = addButton("Back", 8,1,1,1);
		removeStudentButton = addButton("Remove Student", 8,2,1,1);
		frm.validate();
		updateList();
	}

	public void modifyMenu() {
		frm.getContentPane().removeAll();
		frm.setSize(250, 444);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		backButton = addButton("Back", 8,1,1,1);
		modifyInfoButton = addButton("Modify Student", 8,2,1,1);
		frm.validate();
		updateList();
	}

	public void modifyStudentMenu(Student s) {
		System.out.println(Class.size());
		frm.getContentPane().removeAll();
		frm.setSize(250, 578);
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField(s.getName(), 7,2,1,1);
		JLabel IDLabel = addLabel("ID", 8,1,1,1);
		IDField = addIntegerField(s.getID(), 8,2,1,1);
		JLabel GPALabel = addLabel("GPA", 9,1,1,1);
		GPAField = addDoubleField(s.getGPA(), 9,2,1,1);
		JLabel gradeLabel = addLabel("Grade", 10,1,1,1);
		gradeField = addIntegerField(s.getGrade(), 10,2,1,1);
		backModifyButton = addButton("Back", 11,1,1,1);
		modifyStudentButton = addButton("Modify Student", 11,2,1,1);
		frm.validate();
		updateList();
		temp = s;
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
		} if(buttonObj == backModifyButton) {
			modifyMenu();
			return;
		} else if(buttonObj == addButton) {
			addMenu();
			return;
		} else if(buttonObj == removeButton) {
			removeMenu();
			return;
		} else if(buttonObj == modifyButton) {
			modifyMenu();
			return;
		} else if (buttonObj == addStudentButton) {
			String name = nameField.getText();
			int ID = IDField.getNumber();
			double GPA = GPAField.getNumber();
			int grade = gradeField.getNumber();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} else if(!IDField.isValid()) {
				messageBox("Error: Please Make Sure ID is Number");
				return;
			} else if(!GPAField.isValid()) {
				messageBox("Error: Please Make Sure GPA is Number");
				return;
			} else if(!gradeField.isValid()) {
				messageBox("Error: Please Make Sure Grade is Number");
				return;
			}
			Student s = new Student(name, ID, GPA, grade);
			Class.add(s);
			mainMenu();
			return;
		} else if (buttonObj == removeStudentButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} 
			it = Class.iterator();
			while(it.hasNext()) {
				Student s = it.next();
				if(s.getName().equals(name)) {
					it.remove();
					mainMenu();
					return;
				}
			}
			messageBox("Error: Student Not Found");
			return;
		} else if (buttonObj == modifyInfoButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} 
			it = Class.iterator();
			while(it.hasNext()) {
				Student s = it.next();
				if(s.getName().equals(name)) {
					modifyStudentMenu(s);
					return;
				}
			}
			messageBox("Error: Student Not Found");
			return;
		} else if (buttonObj == modifyStudentButton) {
			System.out.println(Class.size());
			String name = nameField.getText();
			int ID = IDField.getNumber();
			double GPA = GPAField.getNumber();
			int grade = gradeField.getNumber();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} else if(!IDField.isValid()) {
				messageBox("Error: Please Make Sure ID is Number");
				return;
			} else if(!GPAField.isValid()) {
				messageBox("Error: Please Make Sure GPA is Number");
				return;
			} else if(!gradeField.isValid()) {
				messageBox("Error: Please Make Sure Grade is Number");
				return;
			}
			temp.setName(name);
			temp.setID(ID);
			temp.setGPA(GPA);
			temp.setGrade(grade);
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
