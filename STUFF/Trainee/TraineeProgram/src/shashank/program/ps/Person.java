package shashank.program.ps;

public class Person {
	
	private String name;
	final int maxBook = 5;
	 int personId;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", personId=" + personId + "]";
	}
	
	

}
