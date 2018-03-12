package model.mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.data.Patient;
import model.db.DB;

public class PatientMapper {
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		ResultSet res = DB.getDBInstance().executeQuery("select * from patients;");
		try {
			while (res.next()) {
				Patient patient = new Patient();
				patient.setId(Integer.parseInt(res.getString("id")));
				patient.setName(res.getString("name"));
				patient.setCnp(res.getString("cnp"));
				patient.setBirthday(res.getString("birthday"));
				patient.setAddress(res.getString("address"));
				patients.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}
	
	public void createPatient(Patient patient) {
		StringBuilder query = new StringBuilder();
		query.append("insert into patients (id,name,cnp,birthday,address) values ('");
		query.append(patient.getId());
		query.append("','");
		query.append(patient.getName());
		query.append("','");
		query.append(patient.getCnp());
		query.append("','");
		query.append(patient.getBirthday());
		query.append("','");
		query.append(patient.getAddress());
		query.append("');");
		DB.getDBInstance().executeUpdate(query.toString());
	}
	
	public void updateUser(Patient oldUser, Patient newUser) {
		StringBuilder query = new StringBuilder();
		query.append("update patients set name='");
		query.append(newUser.getName());
		query.append("',cnp='");
		query.append(newUser.getCnp());
		query.append("',birthday='");
		query.append(newUser.getBirthday());
		query.append("',address='");
		query.append(newUser.getAddress());
		
		query.append("' where id='");
		query.append(oldUser.getId());
		query.append("';");
		DB.getDBInstance().executeUpdate(query.toString());
	}

	public void deleteUser(Patient patient) {
		StringBuilder query = new StringBuilder();
		query.append("delete from patients where id='");
		query.append(patient.getId());
		query.append("';");
		DB.getDBInstance().executeUpdate(query.toString());
	}
}
