import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static List<Program> listPrograms = new ArrayList<Program>();
	static List<Course> listCourses = new ArrayList<Course>();

	public static void main(String[] args) {
		// while loop to continuously loop the program until the user wishes to exit
		while (true) {
			// try-catch statement to ensure the user will enter proper input
			try {
				System.out.println("\nMain Menu. Please select an Operation");
				System.out.println("1. Create New Program");
				System.out.println("2. Create New Course");
				System.out.println("3. Display Program List");
				System.out.println("4. Display Course List");
				System.out.println("5. Edit College Program");
				System.out.println("6. Exit");
				System.out.print(">> ");

				int response = Integer.parseInt(in.readLine());

				if (response < 1 || response > 6) {
					throw new NumberFormatException();
				}

				outer: switch (response) {
				case 1:
					CreateNewProgram();
					break;
				case 2:
					CreateNewCourse();
					break;
				case 3:
					DisplayProgramList();
					break;
				case 4:
					DisplayCourseList();
					break;
				case 5:
					System.out.println("\nEditing a College Program...");
					DisplayProgramList();
					System.out.print("\nPlease Enter College Program ID: ");
					int programId = Integer.parseInt(in.readLine());
					for (Program program : listPrograms) {
						if (program.getId() == programId) {
							EditCollegeProgram(program);
							break outer;
						}
					}
					throw new Exception("\nCollege Program ID: " + programId + " is not found. Returning to Main Menu");
				case 6:
					System.out.println("\nClosing Program");
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input. Returning to Main Menu...");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void CreateNewProgram() throws Exception {
		System.out.println("\nCreating a new Program...");
		System.out.print("\nEnter the Program's Name: ");
		String name = in.readLine();
		
		if (name.isBlank()) {
			throw new Exception("\nProgram's Name cannot be empty. Returning to Main Menu...");
		}
		Program program = new Program(name);
		listPrograms.add(program);
		System.out.println("\nProgram Created! Opening Program's Menu...");
		EditCollegeProgram(program);
	}

	public static void CreateNewCourse() throws Exception {
		System.out.println("\nCreating a new Course...");
		System.out.print("\nEnter the Course's Code: ");
		String courseCode = in.readLine();
		System.out.println("Enter the Course's Description: ");
		String description = in.readLine();
		System.out.println("Enter the Number of Units: ");
		int units = Integer.parseInt(in.readLine());
		System.out.println("Enter the Pre-Requisite Course (Leave Blank if None): ");
		String preRequisite = in.readLine();
		System.out.println("Enter the Co-Requisite Course (Leave Blank if None): ");
		String coRequisite = in.readLine();
		
		if (courseCode.isBlank() || description.isBlank() || units < 1) {
			throw new Exception("\nOne of inputs is Invalid. Returning to Main Menu...");
		}
		
		Course course = new Course(courseCode, description, units, preRequisite, coRequisite);
		listCourses.add(course);
		System.out.println("\nCourse Created! Returning to Main Menu...");
	}

	public static void DisplayProgramList() throws Exception {
		if (!listPrograms.isEmpty()) {
			System.out.println("\nDisplaying All Programs inside the List...");
			for (Program program : listPrograms) {
				System.out.println(program.GetProgramDetails() + "\n");
			}
		} else {
			throw new Exception("\nProgram List is Empty. Please add some Programs first!");
		}
	}

	public static void DisplayCourseList() throws Exception {
		if (!listCourses.isEmpty()) {
			System.out.println("\nDisplaying All Courses inside the List...");
			for (Course course : listCourses) {
				System.out.println(course.GetCourseDetails() + "\n");
			}
		} else {
			throw new Exception("\nCourse List is Empty. Please add some Courses first!");
		}
	}

	public static void EditCollegeProgram(Program program) {
		// while loop to continuously loop the program until the user wishes to exit
		while (true) {
			// try-catch statement to ensure the user will enter proper input
			try {
				System.out.println("\nProgram Menu. Select an Operation");
				System.out.println("1. Add Curriculum");
				System.out.println("2. Add Course");
				System.out.println("3. Remove Course");
				System.out.println("4. Display Program Details");
				System.out.println("5. Delete Curriculum");
				System.out.println("6. Delete College Program");
				System.out.println("7. Back to Main Menu");
				System.out.print(">> ");

				int response = Integer.parseInt(in.readLine());

				if (response < 1 || response > 7) {
					throw new NumberFormatException();
				}

				outer: switch (response) {
				case 1:
					System.out.println("\nAdding Curriculum to " + program.getName() + "...");
					System.out.print("\nEnter Curriculum's Year of Effectivity: ");
					String yearEffectivity = in.readLine();
					if (yearEffectivity.isBlank()) {
						throw new Exception("\nYear of Effectivity cannot be blank. Returning to Program Menu...");
					}
					program.AddCurriculum(yearEffectivity);
					System.out.println("\nCurriculum Added! Returning to Program Menu...");
					break;
				case 2:
					System.out.println("\nAdding a Course to the Curriculum...");
					DisplayCourseList();
					System.out.print("\nEnter Course ID: ");
					int courseId = Integer.parseInt(in.readLine());
					System.out.print("Enter the Academic Year (1-4): ");
					int year = Integer.parseInt(in.readLine());
					System.out.print("Enter the Semester (1-2): ");
					int semester = Integer.parseInt(in.readLine());
					for (Course course : listCourses) {
						if (course.getId() == courseId) {
							program.getCurriculum().AddCourseOnPeriod(course, year, semester);
							System.out.println("\nCourse Added to Curriculum! Returning to Program Menu...");
							break outer;
						}
					}
					throw new Exception("\nCourse ID: " + courseId + " not found. Returning to Program Menu...");
				case 3:
					System.out.println("\nRemoving a Course in the Curriculum...");
					DisplayCourseList();
					System.out.print("\nEnter Course ID: ");
					courseId = Integer.parseInt(in.readLine());
					for (Course course : listCourses) {
						if (course.getId() == courseId) {
							program.getCurriculum().RemoveCourseInCurriculum(course);
							System.out.println("\nCourse Removed from Curriculum! Returning to Program Menu...");
							break outer;
						}
					}
					throw new Exception("\nCourse ID: " + courseId + " not found. Returning to Program Menu...");
				case 4:
					System.out.println("\nDisplaying " + program.getName() + " Full Details...");
					System.out.println(program.GetFullDetails());
					break;
				case 5:
					System.out.println("\nWarning! Deleting this Program's Curriculum...");
					System.out.println(
							"\nThere is no way to recover the Curriculum after deletion. \nAre you sure to delete this Program's Curriculum?");
					System.out.println("1. Delete Curriculum");
					System.out.println("2. Cancel");
					System.out.print(">> ");

					response = Integer.parseInt(in.readLine());

					if (response < 1 || response > 2) {
						throw new NumberFormatException();
					}

					if (response == 1) {
						System.out.println("\nProceeding to delete the Program's Curriculum...");
						program.DeleteCurriculum();
						System.out.println("Program's Curriculum has been deleted!");
					} else {
						System.out.println("\nReturning to Program Menu...");
					}
					break;
				case 6:
					System.out.println("\nWarning! Deleting this Program...");
					System.out.println(
							"\nThere is no way to recover this Program after deletion. \nAre you sure to delete this Program?");
					System.out.println("1. Delete Program");
					System.out.println("2. Cancel");
					System.out.print(">> ");

					response = Integer.parseInt(in.readLine());

					if (response < 1 || response > 2) {
						throw new NumberFormatException();
					}

					if (response == 1) {
						System.out.println("\nProceeding to delete this Program...");
						listPrograms.remove(program);
						System.out.println("This Program has been deleted! Returning to Main Menu...");
						return;
					} else {
						System.out.println("\nReturning to Program Menu...");
						break;
					}
				case 7:
					System.out.println("\nReturning to Main Menu...");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input. Returning to Program Menu...");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
