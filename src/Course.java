
public class Course {
	// Class Fields
	private static int idCounter = 1;
	private int id;
	private String courseCode;
	private String description;
	private int units;
	private String preRequisite;
	private String coRequisite;
	
	/**
	 * Parameterized Constructor
	 * Uses the course code, description, number of units, and pre and co Requisite as its
	 * parameter.
	 * The Course's ID counter increases by one every time a new Course 
	 * object is made.
	 * 
	 * @param courseCode
	 * @param description
	 * @param units
	 * @param preRequisite
	 * @param coRequisite
	 */
	public Course(String courseCode, String description, int units, String preRequisite, String coRequisite) {
		this.id = idCounter;
		this.courseCode = courseCode;
		this.description = description;
		this.units = units;
		this.preRequisite = preRequisite;
		this.coRequisite = coRequisite;
		idCounter++;
	}
	// Getters
	/**
	 * @return
	 */
	public int getUnits() {
		return this.units;
	}
	
	/**
	 * @return
	 */
	public int getId() {
		return this.id;
	}


	// Methods
	/**
	 * Returns the primary Details of the Course object, they are:
	 * the Course ID, code, and description.
	 * 
	 * @return
	 */
	public String GetCourseDetails() {
		return "\nCOURSE ID : " + this.id + "\nCOURSE CODE : " + this.courseCode + "\nDESCRIPTION : " + this.description;
	}
	
	/**
	 * Patulong dito, di ko gets yung ?
	 * 
	 * @return
	 */
	public String GetFullDetails() {
		return "\nCOURSE ID : " + this.id + "\nCOURSE CODE : " + this.courseCode + "\nDESCRIPTION : " + this.description + "\nUNITS : " + this.units
				+ "\nPRE-REQUISITE : " + (this.preRequisite.isBlank() ? "NONE" : this.preRequisite) + "\nCO-REQUISITE : "
				+ (this.coRequisite.isBlank() ? "NONE" : this.coRequisite);
	}
}
