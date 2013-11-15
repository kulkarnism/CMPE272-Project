package edu.sjsu.cmpe.unilinks.resources;



public class UniversityObject {
	private String schoolName,tuitionFees,location,contact,department;
	private String springApplnDate,fallApplnDate;
	private long greScore,toeflScore;
	double ieltsScore;

	public UniversityObject()
	{
		
	}

	public UniversityObject(String schoolName, String tuitionFees,
			String location, String contact, String department,
			String springApplnDate, String fallApplnDate, long greScore,
			long toeflScore, long ieltsScore) {
		super();
		this.schoolName = schoolName;
		this.tuitionFees = tuitionFees;
		this.location = location;
		this.contact = contact;
		this.department = department;
		this.springApplnDate = springApplnDate;
		this.fallApplnDate = fallApplnDate;
		this.greScore = greScore;
		this.toeflScore = toeflScore;
		this.ieltsScore = ieltsScore;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getTuitionFees() {
		return tuitionFees;
	}


	public void setTuitionFees(String tuitionFees) {
		this.tuitionFees = tuitionFees;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getSpringApplnDate() {
		return springApplnDate;
	}


	public void setSpringApplnDate(String springApplnDate) {
		this.springApplnDate = springApplnDate;
	}


	public String getFallApplnDate() {
		return fallApplnDate;
	}


	public void setFallApplnDate(String fallApplnDate) {
		this.fallApplnDate = fallApplnDate;
	}


	public long getGreScore() {
		return greScore;
	}


	public void setGreScore(long greScore) {
		this.greScore = greScore;
	}


	public long getToeflScore() {
		return toeflScore;
	}


	public void setToeflScore(long toeflScore) {
		this.toeflScore = toeflScore;
	}


	public double getIeltsScore() {
		return ieltsScore;
	}


	public void setIeltsScore(double d) {
		this.ieltsScore = d;
	}

}
