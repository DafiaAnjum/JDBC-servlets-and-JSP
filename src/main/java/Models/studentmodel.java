package Models;

public class studentmodel {
private String pinno;
private String name;
private String email;
private String branch;
public String getPinno() {
	return pinno;
}
public void setPinno(String pinno) {
	this.pinno = pinno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public studentmodel(String pinno, String name, String email, String branch) {
	super();
	this.pinno = pinno;
	this.name = name;
	this.email = email;
	this.branch = branch;
}
public studentmodel() {
	super();
	// TODO Auto-generated constructor stub
}

}
