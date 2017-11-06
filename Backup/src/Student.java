
public class Student 
{
	private int studentID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String gender;
	private String address;
	
	public Student() 
	{
		
	}

	public Student(int studentID, String firstName, String lastName, String email, String phone, String gender,
			String address) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student ID \t=" + studentID + "\n First Name \t=" + firstName + "\n Last Name \t=" + lastName + "\n Student Email \t="
				+ email + "\n Student Phone \t=" + phone + "\n Student Gender\t=" + gender + "\n Student Address \t=" + address + "\n";
	}
	
	
}
