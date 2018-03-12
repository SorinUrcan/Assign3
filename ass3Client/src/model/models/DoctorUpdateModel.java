package model.models;

import java.util.TimerTask;

import net.Command;
import net.CommandType;
import net.Response;
import view.DoctorView;

public class DoctorUpdateModel extends TimerTask {

	private DoctorView doctorView;
	private Command command;

	public DoctorUpdateModel(DoctorView doctorView) {
		this.doctorView = doctorView;
		command = new Command();
		command.setCommandType(CommandType.CHECK_UPDATE);
	}

	@Override
	public void run() {
		Response response = ClientSocket.getConnection().executeCommand(command);
		if (response != null) {
			doctorView.update(null, response.getInfo());
			}
		}
	}

