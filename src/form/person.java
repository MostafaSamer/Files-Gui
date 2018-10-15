package form;

public class person {
	
	private String name = "";
	private String email = "";
	private int age = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public person(String name, String email, int age) {
		
		this.name = name;
		this.email = email;
		this.age = age;
		
		Files fenter = new Files(this.name, this.email, this.age);
		System.out.println("Entered Person");
		
	}
}
