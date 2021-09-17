public class Student {

	private String name;
	private int ID;
	private double GPA;
	private int grade;

	public Student() {
		name = "";
		ID = 0;
		GPA = 0.0;
		grade = 0;
	}

	public Student(String name, int ID, double GPA, int grade) {
		super();
		this.name = name;
		this.ID = ID;
		this.GPA = GPA;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String toString() {
		return ("Name: " + name + "\nID: " + ID + "\nGPA: " + GPA + "\ngrade: " + grade + "\n\n");
	}

}
