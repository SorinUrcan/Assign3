package model.data;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 442727953563798452L;
	protected static AtomicInteger count = new AtomicInteger(0); 
	private int id;
	private String name;
	private String cnp;
	private String birthday;
	private String address;
	
	public Patient() {
		id = count.incrementAndGet();
	}
	
	public Patient(String name, String cnp, String birthday, String address) {
		this.id = count.incrementAndGet();
		this.name = name;
		this.cnp = cnp;
		this.birthday = birthday;
		this.address = address;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
