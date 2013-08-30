
public class Person implements java.io.Serializable{
 public static int count=0;
 private String name;
 private String alias;
 private int age;
 private String height;
 
public Person(String name, String alias, int age, String height) {
	super();
	this.name = name;
	this.alias = alias;
	this.age = age;
	this.height = height;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAlias() {
	return alias;
}
public void setAlias(String alias) {
	this.alias = alias;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getHeight() {
	return height;
}
public void setHeight(String height) {
	this.height = height;
}
 


}
