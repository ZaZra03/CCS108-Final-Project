
public class Course {
	// Class Fields
	private static int idCounter = 1;
	private int id;
	private String courseCode;
	private String description;
	private int units;
	private String preRequisite;
	private String coRequisite;
	
	// Getters
	public int getUnits() {
		return this.units;
	}
	
	public int getId() {
		return this.id;
	}

	// Parameterized Constructor
	public Course(String courseCode, String description, int units, String preRequisite, String coRequisite) {
		this.id = idCounter;
		this.courseCode = courseCode;
		this.description = description;
		this.units = units;
		this.preRequisite = preRequisite;
		this.coRequisite = coRequisite;
		idCounter++;
	}

	// Methods
	public String GetCourseDetails() {
		return "\nCOURSE ID : " + this.id + "\nCOURSE CODE : " + this.courseCode + "\nDESCRIPTION : " + this.description;
	}
	
	public String GetFullDetails() {
		return "\nCOURSE ID : " + this.id + "\nCOURSE CODE : " + this.courseCode + "\nDESCRIPTION : " + this.description + "\nUNITS : " + this.units
				+ "\nPRE-REQUISITE : " + (this.preRequisite.isBlank() ? "NONE" : this.preRequisite) + "\nCO-REQUISITE : "
				+ (this.coRequisite.isBlank() ? "NONE" : this.coRequisite);
	}
}
