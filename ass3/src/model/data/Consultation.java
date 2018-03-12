package model.data;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Consultation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1711796285528070652L;
	private int id;
	private int pid;
	private String did;
	private String date;
	private String description;
	
	protected static AtomicInteger count = new AtomicInteger(0); 
	
	public Consultation() {
		id = count.incrementAndGet();
	}

	public Consultation(int id, int patient_id, String doctor_id, String date,
			String description) {
		this.id = count.incrementAndGet();
		this.pid = patient_id;
		this.did = doctor_id;
		this.date = date;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int cid) {
		this.pid = cid;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
