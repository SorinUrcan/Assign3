package model.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import control.LoginController;
import model.data.User;
import net.Command;
import net.CommandType;
import net.Response;
import view.AdminView;
import view.DoctorView;
import view.LoginDialog;
import view.SecretaryView;

public class LoginModel {
	private ClientSocket clientSocket;

	public LoginModel(ClientSocket connection) {
		this.clientSocket = connection;
	}

	public void checkLogin(User user, LoginDialog login) {
		Command command = new Command();
		command.setCommandType(CommandType.LOGIN);
		List<Object> users = new ArrayList<>();
		users.add(user);
		command.setCommandData(users);
		Response response = clientSocket.executeCommand(command);
		
		
		if (response.getInfo().equals("secretary")) {
			SecretaryModel secretaryModel = new SecretaryModel();
			SecretaryView secretaryView = new SecretaryView(secretaryModel);
			//new secretaryController(secretaryView, secretaryModel);
			login.closeDialog();
			secretaryView.openWindow();
		} else if (response.getInfo().equals("admin")) {
			AdminModel adminModel = new AdminModel();
			AdminView adminView = new AdminView(adminModel);
			login.closeDialog();
			adminView.openWindow();
		} else if (response.getInfo().equals("doctor")) {
			DoctorModel doctorModel = new DoctorModel();
			DoctorView doctorView = new DoctorView(doctorModel);
			doctorView.setUsername(user.getUsername());
			login.closeDialog();
			doctorView.openWindow();
		} else {
			JOptionPane.showMessageDialog(null, "Wrong user details inserted!");
		}
	}

	public void closeConnection() {
		Command command = new Command();
		command.setCommandType(CommandType.FINISH);
		clientSocket.executeCommand(command);
		clientSocket.closeConnection();
	}

	public static void main(String args[]) {
		LoginDialog login = new LoginDialog();
		LoginModel loginModel = new LoginModel(ClientSocket.getConnection());
		new LoginController(login, loginModel);
		login.openDialog();	
	}
}
