import java.util.*;

public class Curriculum {
	// Class Fields
	private static int idCounter = 1;
	private int id;
	private String yearEffectivity;
	private List<AcademicTerm> listAcademicTerms = new ArrayList<AcademicTerm>();

	// Parameterized Constructor
	/**
	 * The Curriculum's constructor creates 8 AcademicTerm objects and 
	 * adds them into a List.
	 * It is because the multiplicity between Curriculum and AcademicTerm class is 
	 * exactly 8. 
	 * In every Curriculum object made, there must be 8 AcademicTerm objects composed in it.
	 * The AcademicTerm class acts as containers for the course, 8 is made in the curriculum to act as the
	 * 1st Year 1st Semester, 1st Year 2nd Semester, and so on.
	 * 
	 * @param yearEffectivity
	 */
	public Curriculum(String yearEffectivity) {
		this.id = idCounter;
		this.yearEffectivity = yearEffectivity;
		idCounter++;

		this.listAcademicTerms.add(new AcademicTerm(1, 1));
		this.listAcademicTerms.add(new AcademicTerm(1, 2));
		this.listAcademicTerms.add(new AcademicTerm(2, 1));
		this.listAcademicTerms.add(new AcademicTerm(2, 2));
		this.listAcademicTerms.add(new AcademicTerm(3, 1));
		this.listAcademicTerms.add(new AcademicTerm(3, 2));
		this.listAcademicTerms.add(new AcademicTerm(4, 1));
		this.listAcademicTerms.add(new AcademicTerm(4, 2));
	}

	// Methods
	/**
	 * Adds a course on the selected period.
	 * Uses the following as its parameter: course, year, and semester
	 * The only allowed input for year is 1-4 inclusive and for the semester is
	 * 1-2 inclusively. 
	 * If the course already exists, it wont be added into the curriculum.
	 * 
	 * @param course
	 * @param year
	 * @param semester
	 * @throws Exception
	 */
	public void AddCourseOnPeriod(Course course, int year, int semester) throws Exception {
		if (year < 1 || year > 4 || semester < 1 || semester > 2) {
			throw new Exception("\nYear count does not follow the allowable period (4 Years and 2 Semester per Year)");
		} else if (!this.CheckFor(course)) {
			for (AcademicTerm period : this.listAcademicTerms) {
				if (period.getYear() == year) {
					if (period.getSemester() == semester) {
						period.AddCourse(course);
					}
				}
			}
		} else {
			throw new Exception("\nThis course is already inside one of the Academic Term");
		}
	}
	
	/**
	 * Removes a course selected by the user in the Curriculum.
	 * The method loops through the list of AcademicTerms 
	 * and then checks the courses list inside the AcademicTerm object if it contains the 
	 * course to remove.
	 * If the course is not found, a prompt will show.
	 * 
	 * @param course
	 * @throws Exception
	 */
	public void RemoveCourseInCurriculum(Course course) throws Exception {
		for (AcademicTerm period : listAcademicTerms) {
			if (period.getListCourses().contains(course)) {
				period.RemoveCourse(course);
				return;
			}
		}
		throw new Exception("\nThis course is not found in this curriculum");
	}

	/**
	 * Checks if the input course exists in the Curriculum
	 * Returns true if it exists, otherwise false.
	 * 
	 * @param course
	 * @return
	 */
	private boolean CheckFor(Course course) {
		boolean isExisting = false;

		for (AcademicTerm period : listAcademicTerms) {
			if (period.getListCourses().contains(course)) {
				isExisting = true;
			}
		}
		return isExisting;
	}

	/**
	 * Displays the following:
	 * Curriculum ID, Year of Effectivity, and the List of courses inside the curriculum
	 * together with their full details; courses' details in each academic term.
	 * 
	 * @return
	 */
	public String GetFullDetails() {
		String details = "\nCURRICULUM ID : " + this.id + "\nYEAR OF EFFECTIVITY: " + this.yearEffectivity
				+ "\n\n===== LIST OF COURSES INSIDE THE CURRICULUM =====\n";

		for (int i = 0; i < this.listAcademicTerms.size(); i++) {
			details += this.listAcademicTerms.get(i).GetFullDetails() + "\n";
		}

		return details;
	}
}
