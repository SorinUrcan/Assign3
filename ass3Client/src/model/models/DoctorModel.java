package model.models;

import java.util.ArrayList;
import java.util.List;

import model.data.Consultation;
import model.data.Patient;
import net.Command;
import net.CommandType;
import net.Response;

public class DoctorModel {

	public void updatConsultation(Consultation oldUser, Consultation newUser) {
		Command command = new Command();
		command.setCommandType(CommandType.UPDATE_CONSULTATION);
		List<Object> users = new ArrayList<>();
		users.add(oldUser);
		users.add(newUser);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}
	
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		Command command = new Command();
		command.setCommandType(CommandType.READ_PATIENTS);
		Response response = ClientSocket.getConnection().executeCommand(command);
		for (Object obj : response.getResponseData()) {
			patients.add((Patient) obj);
		}
		return patients;
	}
	
	public List<Consultation> getAllConsultations() {
		List<Consultation> patients = new ArrayList<>();
		Command command = new Command();
		command.setCommandType(CommandType.READ_CONSULTATIONS);
		Response response = ClientSocket.getConnection().executeCommand(command);
		for (Object obj : response.getResponseData()) {
			patients.add((Consultation) obj);
		}
		return patients;
	}
}
