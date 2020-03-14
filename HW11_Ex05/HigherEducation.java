package bg.swift.HW11_Ex05;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation{

	protected HigherEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, double finalGrade) throws FinalGradeException, NoGradeException {
		super(enrollmentDate, graduationDate, institutionName, finalGrade);
	}

	@Override
	protected String getDegree() {
		return "higher";
	}

	@Override
	protected boolean gotGraduated() {
		return false;
	}
}
