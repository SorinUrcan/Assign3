package model.mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.data.Consultation;
import model.db.DB;

public class ConsultationMapper {
	
	public List<Consultation> getAllConsultations() {
		List<Consultation> consultations = new ArrayList<>();
		ResultSet res = DB.getDBInstance().executeQuery("select * from consultations;");
		try {
			while (res.next()) {
				Consultation consultation = new Consultation();
				consultation.setId(Integer.parseInt(res.getString("id")));
				consultation.setPid(Integer.parseInt(res.getString("pid")));
				consultation.setDid(res.getString("did"));
				consultation.setDate(res.getString("date"));
				consultation.setDescription(res.getString("description"));
				consultations.add(consultation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultations;
	}
	
	public void createConsuldation(Consultation consultation) {
		StringBuilder query = new StringBuilder();
		query.append("insert into consultations (id,pid,did,date,description) values ('");
		query.append(consultation.getId());
		query.append("','");
		query.append(consultation.getPid());
		query.append("','");
		query.append(consultation.getDid());
		query.append("','");
		query.append(consultation.getDate());
		query.append("','");
		query.append(consultation.getDescription());
		query.append("');");
		DB.getDBInstance().executeUpdate(query.toString());
	}
	
	public void updateConsultation(Consultation oldUser, Consultation newUser) {
		StringBuilder query = new StringBuilder();
		
		if (newUser.getDescription().equals("") && newUser.getDate().equals("")) {
			query.append("update consultations set did='");
			query.append(newUser.getDid());
		} else if (newUser.getDescription().equals("") && (!newUser.getDate().equals(""))) {
			query.append("update consultations set pid='");
			query.append(newUser.getPid());
			query.append("',date='");
			query.append(newUser.getDate()); 
		} else {
			query.append("update consultations set description='");
			query.append(newUser.getDescription());
		} 
		
		query.append("' where id='");
		query.append(oldUser.getId());
		query.append("';");
		DB.getDBInstance().executeUpdate(query.toString());
	}

	public void deleteConsultation(Consultation consultation) {
		StringBuilder query = new StringBuilder();
		query.append("delete from consultations where id='");
		query.append(consultation.getId());
		query.append("';");
		DB.getDBInstance().executeUpdate(query.toString());
	}
}
