/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.data.Consultation;
import model.data.Patient;
import model.data.User;
import net.Command;
import net.CommandType;
import net.Response;

public class SecretaryModel extends Observable {
	
	//USERS
	public List<User> getAllDoctors() {
		List<User> users = new ArrayList<>();
		Command command = new Command();
		command.setCommandType(CommandType.READ_USERS);
		Response response = ClientSocket.getConnection().executeCommand(command);
		for (Object obj : response.getResponseData()) {
			if (((User) obj).getType().equals("doctor"))
				users.add((User) obj);
		}
		return users;
	}
	
	//PATIENTS
	public void createPatient(Patient user) {
		Command command = new Command();
		command.setCommandType(CommandType.CREATE_PATIENT);
		List<Object> users = new ArrayList<>();
		users.add(user);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}

	public void updatePatient(Patient oldUser, Patient newUser) {
		Command command = new Command();
		command.setCommandType(CommandType.UPDATE_PATIENT);
		List<Object> users = new ArrayList<>();
		users.add(oldUser);
		users.add(newUser);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}

	public void deletePatient(Patient user) {
		Command command = new Command();
		command.setCommandType(CommandType.DELETE_PATIENT);
		List<Object> users = new ArrayList<>();
		users.add(user);
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
	
	//CONSULTATIONS
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
	
	public void createConsultation(Consultation user) {
		Command command = new Command();
		command.setCommandType(CommandType.CREATE_CONSULTATION);
		List<Object> users = new ArrayList<>();
		users.add(user);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}
	
	public void updatConsultation(Consultation oldUser, Consultation newUser) {
		Command command = new Command();
		command.setCommandType(CommandType.UPDATE_CONSULTATION);
		List<Object> users = new ArrayList<>();
		users.add(oldUser);
		users.add(newUser);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}
	
	public void notifyDoctor(String doctor) {
		Command command = new Command();
		command.setCommandType(CommandType.UPDATE_CONSULTATION);
		List<Object> users = new ArrayList<>();
		Consultation oldUser = new Consultation();
		oldUser.setDid("-1");
		Consultation newUser = new Consultation();
		newUser.setDid(doctor);
		
		users.add(oldUser);
		users.add(newUser);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}
	
	public void deleteConsultation(Consultation user) {
		Command command = new Command();
		command.setCommandType(CommandType.DELETE_CONSULTATION);
		List<Object> users = new ArrayList<>();
		users.add(user);
		command.setCommandData(users);
		ClientSocket.getConnection().executeCommand(command);
	}
	
	//AVAILABLE DOCTORS
	public String getAllAvailableDoctors(String wantedDate) {
		String allAvailableDoctors = "";
		List<Consultation> allConsultations = getAllConsultations();
		List<User> allDoctors = getAllDoctors();
		
		for (User doctor: allDoctors) {
			boolean available = true;
			for (Consultation con: allConsultations) {
				if (con.getDid().equals(doctor.getUsername()))
					if (con.getDate().equals(wantedDate)) {
						available = false;
					}
			}
			if (available)
				allAvailableDoctors += doctor.getUsername() + " ";
		}	
		return allAvailableDoctors;
	}

	public void closeConnection() {
		Command command = new Command();
		command.setCommandType(CommandType.FINISH);
		ClientSocket.getConnection().executeCommand(command);
		ClientSocket.getConnection().closeConnection();
	}
}
