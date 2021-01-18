package parser;

public class Student {
	int id;
	String name;
	int age;
	String about;
	
	Student(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAbout() {
		return about;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
}
