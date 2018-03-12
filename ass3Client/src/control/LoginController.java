package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.data.User;
import model.models.LoginModel;
import view.LoginDialog;

public class LoginController {
	private LoginDialog login;
	private LoginModel loginModel;

	public LoginController(LoginDialog login, LoginModel loginModel) {
		this.login = login;
		this.loginModel = loginModel;
		this.login.addOKListener(new OKListener());
		this.login.addWindowCloseListener(new WindowClose());
	}

	private class OKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			User user = new User();
			user.setUsername(login.getUsername());
			user.setPassword(login.getPassword());
			loginModel.checkLogin(user, login);
		}
	}

	private class WindowClose extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent a) {
			try {
				loginModel.closeConnection();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.exit(0);
		}
	}
}
