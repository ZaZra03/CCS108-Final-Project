import java.util.*;

public class Course {
	// Class Fields
	private String courseCode;
	private String description;
	private int units;
	private String preRequisite;
	private String coRequisite;
	private List<Curriculum> listCurriculums = new ArrayList<Curriculum>();
	private int year;
	private int semester;
	
	// Getters
	public int getUnits() {
		return this.units;
	}

	public int getYear() {
		return this.year;
	}

	public int getSemester() {
		return this.semester;
	}

	// Setters
	public void setYear(int year) {
		this.year = year;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	// Parameterized Constructor
	public Course(String courseCode, String description, int units, String preRequisite, String coRequisite) {
		this.courseCode = courseCode;
		this.description = description;
		this.units = units;
		this.preRequisite = preRequisite;
		this.coRequisite = coRequisite;
	}

	// Methods
	public void AddCurriculum(Curriculum curriculum) {
		if (!this.listCurriculums.contains(curriculum)) {
			this.listCurriculums.add(curriculum);
		}
	}

	public void RemoveCurriculum(Curriculum curriculum) {
		if (this.listCurriculums.contains(curriculum)) {
			this.listCurriculums.remove(curriculum);
		}
	}

	public String GetCourseDetails() {
		return "COURSE CODE : " + this.courseCode + "\nDESCRIPTION : " + this.description + "\nUNITS : " + this.units
				+ "\nPRE-REQUISITE : " + (this.preRequisite.isBlank() ? "NONE" : this.preRequisite) + "\nCO-REQUISITE : "
				+ (this.coRequisite.isBlank() ? "NONE" : this.coRequisite) + "\n";
	}
}
