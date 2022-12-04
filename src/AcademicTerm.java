import java.util.*;

public class AcademicTerm {
	// Class Fields
	private int year;
	private int semester;
	private List<Course> listCourses = new ArrayList<Course>();

	
	/**
	 * Parameterized Constructor
	 * 
	 * @param year
	 * @param semester
	 */
	public AcademicTerm(int year, int semester) {
		this.year = year;
		this.semester = semester;
	}
	// Getters
	
	/**
	 * @return
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * @return
	 */
	public int getSemester() {
		return this.semester;
	}

	/**
	 * @return
	 */
	public List<Course> getListCourses() {
		return this.listCourses;
	}


	// Methods
	
	/**
	 * Adds the Course object input into the AcademicTerm object
	 * If the total units for the academic term exceeds the limit,
	 * the course won't be allowed to be added in the AcademicTerm object
	 * 
	 * @param course
	 * @throws Exception
	 */
	public void AddCourse(Course course) throws Exception {
		if (!this.CheckUnitCount(course)) {
			this.listCourses.add(course);
		} else {
			throw new Exception("\nNumber of Units exceeds the limit unit for the semester");
		}

	}

	/**
	 * Removes the selected course. If does not exist in the AcademicTerm object's
	 * list of courses, a prompt will show.
	 * 
	 * @param course
	 * @throws Exception
	 */
	public void RemoveCourse(Course course) throws Exception {
		if (this.listCourses.contains(course)) {
			this.listCourses.remove(course);
		} else {
			throw new Exception("\nThis Course is not found on this Period");
		}
	}

	/**
	 * Checks the total units count in of the courses inside the AcademicTerm object
	 * If it exceeds the maximum, which is 26, it will return true. Otherwise, it will 
	 * return false.
	 * 
	 * @param course
	 * @return
	 */
	private boolean CheckUnitCount(Course course) {
		int count = course.getUnits();
		for (Course currentCourse : this.listCourses) {
			count += currentCourse.getUnits();
		}
		return count >= 26;
	}

	/**
	 * Displays the full details of the AcademicTerm object
	 * It displays different prompts depending on the value of the AcademicTerm's 
	 * class fields.
	 * If the AcademicTerm's year and semseter is 1, it will show the courses of the AcademicTerm
	 * First Year - First Semester.
	 * If the year is 1 and the Semester, it will do the same for the AcademicTerm First Year-Second Semester
	 * If the AcademicTerm does not have any courses in it yet, it will display
	 * "No Courses Set" under that AcademicTerm's details.
	 * 
	 * @return
	 */
	public String GetFullDetails() {
		String details = "";

		if (this.year == 1) {
			if (this.semester == 1) {
				details += "\n--- FIRST YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- FIRST YEAR - SECOND SEMESTER ---\n";
			}
		} else if (this.year == 2) {
			if (this.semester == 1) {
				details += "\n--- SECOND YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- SECOND YEAR - SECOND SEMESTER ---\n";
			}
		} else if (this.year == 3) {
			if (this.semester == 1) {
				details += "\n--- THIRD YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- THIRD YEAR - SECOND SEMESTER ---\n";
			}
		} else {
			if (this.semester == 1) {
				details += "\n--- FOURTH YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- FOURTH YEAR - SECOND SEMESTER ---\n";
			}
		}

		if (!this.listCourses.isEmpty()) {
			for (Course currentCourse : this.listCourses) {
				details += currentCourse.GetFullDetails() + "\n";
			}
		} else {
			details += "\nNO COURSES SET\n";
		}
		return details;
	}
}
