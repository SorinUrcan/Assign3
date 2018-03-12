package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.data.Consultation;
import model.data.Patient;
import model.models.SecretaryModel;

public class SecretaryView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -475277969260105642L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtCnp;
	private JTextField txtBirthday;
	private JTextField txtAddress;
	private JTextField tPId;
	private JTextField tName;
	private JTextField tCnp;
	private JTextField tBirthday;
	private JTextField tAddress;
	private JTextField txtConsultations;
	private JTextField tCID;
	private JTextField txtPatients;
	private JTable tPatients = new JTable();
	private JTable tConsultations = new JTable();
	JTextArea tDescription = new JTextArea();
	private SecretaryModel secretaryModel;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextField txtName_1;
	private JTextField txtCnp_1;
	private JTextField txtBirthday_1;
	private JTextField txtAddress_1;
	private JTextField txtPatientid;
	private JTextField txtDoctorid;
	private JTextField txtDate;
	private JTextField tCPId;
	private JTextField tCDId;
	private JTextField txtDescription;
	private JTextField asdDoesNotMatter;
	private JTextField tDoctor;
	private JTextField Hour;
	private JTextField Day;
	private JTextField Month;
	private JTextField Year;
	private JButton btnCheckForAvailable;
	private JButton btnPacientArrivedNotify;
	private JTextField txtHour;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;


	/**
	 * Create the frame.
	 * @param secretaryModel 
	 */
	@SuppressWarnings("serial")
	public SecretaryView(SecretaryModel secretaryModel) {
		setTitle("Secretary Page");
		setResizable(false);
		this.secretaryModel = secretaryModel;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tPatients.setBounds(10, 35, 388, 320);
		contentPane.add(tPatients);
		tPatients.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "id", "name", "cnp", "birthday", "address"
	            }
	        ) {
	            @SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
	            };

	            @SuppressWarnings({ "rawtypes", "unchecked" })
				public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });
		tDescription.setEditable(false);
		
		tDescription.setBounds(426, 472, 435, 70);
		contentPane.add(tDescription);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText("Id:");
		txtId.setBounds(10, 382, 64, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setText("Name:");
		txtName.setBounds(10, 413, 64, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtCnp = new JTextField();
		txtCnp.setEditable(false);
		txtCnp.setText("Cnp:");
		txtCnp.setBounds(10, 444, 64, 20);
		contentPane.add(txtCnp);
		txtCnp.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setEditable(false);
		txtBirthday.setText("Birthday:");
		txtBirthday.setBounds(10, 474, 64, 20);
		contentPane.add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setText("Address:");
		txtAddress.setBounds(10, 505, 64, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		tPId = new JTextField();
		tPId.setBounds(84, 382, 50, 20);
		contentPane.add(tPId);
		tPId.setColumns(10);
		
		tName = new JTextField();
		tName.setText("");
		tName.setBounds(84, 413, 120, 20);
		contentPane.add(tName);
		tName.setColumns(10);
		
		tCnp = new JTextField();
		tCnp.setBounds(84, 444, 120, 20);
		contentPane.add(tCnp);
		tCnp.setColumns(10);
		
		tBirthday = new JTextField();
		tBirthday.setBounds(84, 474, 120, 20);
		contentPane.add(tBirthday);
		tBirthday.setColumns(10);
		
		tAddress = new JTextField();
		tAddress.setBounds(84, 505, 235, 20);
		contentPane.add(tAddress);
		tAddress.setColumns(10);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tPId.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Select an ID!");
				else {
					displayConsultations(secretaryModel.getAllConsultations(), Integer.parseInt(tPId.getText()));
					for (Patient patient : secretaryModel.getAllPatients()) {
						if (patient.getId() == Integer.parseInt(tPId.getText())) {
							tName.setText(patient.getName());
							tAddress.setText(patient.getAddress());
							tBirthday.setText(patient.getBirthday());
							tCnp.setText(patient.getCnp());
							
							tCPId.setText(String.valueOf(patient.getId()));
						}
					}
				}
			}
		});
		btnSelect.setBounds(144, 382, 89, 23);
		contentPane.add(btnSelect);
		
		txtConsultations = new JTextField();
		txtConsultations.setEditable(false);
		txtConsultations.setText("Consultations:");
		txtConsultations.setBounds(426, 11, 86, 20);
		contentPane.add(txtConsultations);
		txtConsultations.setColumns(10);
		
		tConsultations.setBounds(426, 35, 435, 296);
		contentPane.add(tConsultations);
		tConsultations.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "id", "pid", "did", "date"
	            }
	        ) {
	            @SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
	            };

	            @SuppressWarnings({ "rawtypes", "unchecked" })
				public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });
		
		JButton btnSelectConsultation = new JButton("Select Consultation");
		btnSelectConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tCID.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Select an Consultation ID!");
				else {
					displayDescription(secretaryModel.getAllConsultations(), Integer.parseInt(tCID.getText()));
					for (Consultation consultation : secretaryModel.getAllConsultations()) {
						if (consultation.getId() == Integer.parseInt(tCID.getText())) {
							tCID.setText(String.valueOf(consultation.getId()));
							tCPId.setText(String.valueOf(consultation.getPid()));
							tCDId.setText(consultation.getDid());
							printDate(consultation.getDate());
						}
					}
				}
			}
		});
		btnSelectConsultation.setBounds(426, 373, 131, 23);
		contentPane.add(btnSelectConsultation);
		
		tCID = new JTextField();
		tCID.setText("ID");
		tCID.setBounds(426, 342, 86, 20);
		contentPane.add(tCID);
		tCID.setColumns(10);
		
		txtPatients = new JTextField();
		txtPatients.setEditable(false);
		txtPatients.setText("Patients ID:");
		txtPatients.setBounds(10, 11, 73, 20);
		contentPane.add(txtPatients);
		txtPatients.setColumns(10);
		
		JButton btnAddConsultation = new JButton("Create Consultation");
		btnAddConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tPId.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Fill consultation fields!");
				else {
					Consultation c = new Consultation();
					c.setPid(Integer.parseInt(tPId.getText()));
					if (!fieldToDate().equals(""))
						c.setDate(fieldToDate());
					if (!tCDId.getText().equals(""))
						c.setDid(tCDId.getText());
					secretaryModel.createConsultation(c);
					
					displayConsultations();
				}
			}
		});
		btnAddConsultation.setBounds(576, 373, 131, 23);
		contentPane.add(btnAddConsultation);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tName.getText().equals("") || tCnp.getText().equals("") || tBirthday.getText().equals("") || tAddress.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Fill Patient name, cnp, birthday and address!");
				else {
					Patient newP = new Patient();
					newP.setName(tName.getText());
					newP.setCnp(tCnp.getText());
					newP.setAddress(tAddress.getText());
					newP.setBirthday(tBirthday.getText());
					
					secretaryModel.createPatient(newP);
				}
			}
		});
		btnCreate.setBounds(243, 383, 89, 23);
		contentPane.add(btnCreate);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tPId.getText().equals("") || tName.getText().equals("") || tCnp.getText().equals("") || tBirthday.getText().equals("") || tAddress.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Select a patient first!");
				else {
					Patient newP = new Patient();
					newP.setId(Integer.parseInt(tPId.getText()));
					newP.setName(tName.getText());
					newP.setCnp(tCnp.getText());
					newP.setAddress(tAddress.getText());
					newP.setBirthday(tBirthday.getText());
					
					Patient oldP = new Patient();
					oldP.setId(Integer.parseInt(tPId.getText()));
					secretaryModel.updatePatient(oldP, newP);
				}
			}
		});
		btnUpdate.setBounds(243, 412, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tPId.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Fill id to be deleted!");
				else {
					Patient newP = new Patient();
					newP.setId(Integer.parseInt(tPId.getText()));
					secretaryModel.deletePatient(newP);
				}
			}
		});
		btnDelete.setBounds(243, 443, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdateConsultation = new JButton("Update Consultation");
		btnUpdateConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tCID.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Fill consultation ID!");
				else {
					Consultation c = new Consultation();
					c.setId(Integer.parseInt(tCID.getText()));
					c.setPid(Integer.parseInt(tCPId.getText()));
					c.setDid(tCDId.getText());
					c.setDate(fieldToDate());
					c.setDescription("");
					
					Consultation d = new Consultation();
					d.setId(Integer.parseInt(tCID.getText()));
					secretaryModel.updatConsultation(d, c);
					
					displayConsultations();
				}
			}
		});
		btnUpdateConsultation.setBounds(426, 412, 131, 23);
		contentPane.add(btnUpdateConsultation);
		
		JButton btnDeleteConsultation = new JButton("Delete Consultation");
		btnDeleteConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tCID.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Fill consultation ID!");
				else {
					Consultation c = new Consultation();
					c.setId(Integer.parseInt(tCID.getText()));
					secretaryModel.deleteConsultation(c);
					
					displayConsultations();
				}
			}
		});
		btnDeleteConsultation.setBounds(576, 412, 131, 23);
		contentPane.add(btnDeleteConsultation);
		
		txtName_1 = new JTextField();
		txtName_1.setEditable(false);
		txtName_1.setText("Name");
		txtName_1.setBounds(89, 11, 73, 20);
		contentPane.add(txtName_1);
		txtName_1.setColumns(10);
		
		txtCnp_1 = new JTextField();
		txtCnp_1.setEditable(false);
		txtCnp_1.setText("CNP");
		txtCnp_1.setBounds(172, 11, 57, 20);
		contentPane.add(txtCnp_1);
		txtCnp_1.setColumns(10);
		
		txtBirthday_1 = new JTextField();
		txtBirthday_1.setEditable(false);
		txtBirthday_1.setText("Birthday");
		txtBirthday_1.setBounds(233, 11, 73, 20);
		contentPane.add(txtBirthday_1);
		txtBirthday_1.setColumns(10);
		
		txtAddress_1 = new JTextField();
		txtAddress_1.setEditable(false);
		txtAddress_1.setText("Address");
		txtAddress_1.setBounds(316, 11, 82, 20);
		contentPane.add(txtAddress_1);
		txtAddress_1.setColumns(10);
		
		txtPatientid = new JTextField();
		txtPatientid.setEditable(false);
		txtPatientid.setText("PatientID");
		txtPatientid.setBounds(522, 11, 64, 20);
		contentPane.add(txtPatientid);
		txtPatientid.setColumns(10);
		
		txtDoctorid = new JTextField();
		txtDoctorid.setEditable(false);
		txtDoctorid.setText("DoctorID");
		txtDoctorid.setBounds(596, 11, 57, 20);
		contentPane.add(txtDoctorid);
		txtDoctorid.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setText("Date");
		txtDate.setBounds(663, 11, 198, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		tCPId = new JTextField();
		tCPId.setEditable(false);
		tCPId.setText("PatientID");
		tCPId.setBounds(522, 342, 64, 20);
		contentPane.add(tCPId);
		tCPId.setColumns(10);
		
		tCDId = new JTextField();
		tCDId.setEditable(false);
		tCDId.setText("DoctorID");
		tCDId.setBounds(596, 342, 57, 20);
		contentPane.add(tCDId);
		tCDId.setColumns(10);
		
		Hour = new JTextField();
		Hour.setText("8:00");
		Hour.setBounds(797, 342, 64, 20);
		contentPane.add(Hour);
		Hour.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setEditable(false);
		txtDescription.setText("Description:");
		txtDescription.setBounds(426, 444, 86, 20);
		contentPane.add(txtDescription);
		txtDescription.setColumns(10);
		
		asdDoesNotMatter = new JTextField();
		asdDoesNotMatter.setEditable(false);
		asdDoesNotMatter.setText("Available doctors:");
		asdDoesNotMatter.setBounds(426, 553, 96, 20);
		contentPane.add(asdDoesNotMatter);
		asdDoesNotMatter.setColumns(10);
		
		JTextArea availableDoctors = new JTextArea();
		availableDoctors.setEditable(false);
		availableDoctors.setBounds(426, 584, 435, 57);
		contentPane.add(availableDoctors);
		
		tDoctor = new JTextField();
		tDoctor.setBounds(655, 653, 86, 20);
		contentPane.add(tDoctor);
		tDoctor.setColumns(10);
		
		JButton assignDoctor = new JButton("Assign Doctor");
		assignDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tCID.getText().equals("") || tDoctor.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Fill consultation ID and Assigned Doctor ID!");
				else {
					Consultation c = new Consultation();
					c.setId(Integer.parseInt(tCID.getText()));
					c.setPid(0);
					c.setDid(tDoctor.getText());
					c.setDate("");
					c.setDescription("");
					
					Consultation d = new Consultation();
					d.setId(Integer.parseInt(tCID.getText()));
					d.setDid("");
					secretaryModel.updatConsultation(d, c);
					
					displayConsultations();
				}
			}
		});
		assignDoctor.setBounds(751, 652, 110, 23);
		contentPane.add(assignDoctor);
		
		Day = new JTextField();
		Day.setText("28");
		Day.setBounds(797, 374, 64, 20);
		contentPane.add(Day);
		Day.setColumns(10);
		
		Month = new JTextField();
		Month.setText("Apr");
		Month.setBounds(797, 405, 64, 20);
		contentPane.add(Month);
		Month.setColumns(10);
		
		Year = new JTextField();
		Year.setText("2017");
		Year.setBounds(797, 436, 64, 20);
		contentPane.add(Year);
		Year.setColumns(10);
		
		btnCheckForAvailable = new JButton("Check for available doctors:");
		btnCheckForAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				availableDoctors.setText(secretaryModel.getAllAvailableDoctors(fieldToDate()));
			}
		});
		btnCheckForAvailable.setBounds(542, 553, 198, 23);
		contentPane.add(btnCheckForAvailable);
		
		btnPacientArrivedNotify = new JButton("Pacient arrived! Notify Doctor");
		btnPacientArrivedNotify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tCDId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Patient has no doctor assigned!");
				} else if (tCID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Select a consultation for the patient!");
				} else {
					secretaryModel.notifyDoctor(tCDId.getText());
				}
			}
		});
		btnPacientArrivedNotify.setBounds(426, 652, 212, 23);
		contentPane.add(btnPacientArrivedNotify);
		
		txtHour = new JTextField();
		txtHour.setEditable(false);
		txtHour.setText("Hour:");
		txtHour.setBounds(723, 342, 64, 20);
		contentPane.add(txtHour);
		txtHour.setColumns(10);
		
		txtDay = new JTextField();
		txtDay.setEditable(false);
		txtDay.setText("Day:");
		txtDay.setBounds(723, 374, 64, 20);
		contentPane.add(txtDay);
		txtDay.setColumns(10);
		
		txtMonth = new JTextField();
		txtMonth.setEditable(false);
		txtMonth.setText("Month:");
		txtMonth.setBounds(723, 407, 64, 20);
		contentPane.add(txtMonth);
		txtMonth.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setEditable(false);
		txtYear.setText("Year:");
		txtYear.setBounds(723, 436, 64, 20);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		displayPatients(this.secretaryModel.getAllPatients());
	}

	public void displayPatients(List<Patient> patients) {
		DefaultTableModel patientsTable = (DefaultTableModel) tPatients.getModel();
		patientsTable.setRowCount(0);
		for (Patient patient : patients) {
			int id          = patient.getId();
			String name     = patient.getName();
			String cnp      = patient.getCnp();
			String birthday = patient.getBirthday();
			String address  = patient.getAddress();
			patientsTable.addRow(new Object[] { id, name, cnp, birthday, address });
		}
	}
	
	public void displayConsultations() {
		displayConsultations(secretaryModel.getAllConsultations(), Integer.parseInt(tPId.getText()));
	}
	
	public void displayConsultations(List<Consultation> consultations, int patientId) {
		DefaultTableModel patientsTable = (DefaultTableModel) tConsultations.getModel();
		patientsTable.setRowCount(0);
		for (Consultation consultation : consultations) {
			if (consultation.getPid() == patientId) {
				int id      = consultation.getId();
				int pid		= consultation.getPid();
				String did 	= consultation.getDid();
				String date = consultation.getDate();
				patientsTable.addRow(new Object[] { id, pid, did, date });
			}
		}
	}
	
	public void displayDescription(List<Consultation> consultations, int CId) {
		for (Consultation consultation : consultations) {
			if (consultation.getId() == CId) {
				tDescription.setText(consultation.getDescription());
			}
		}
	}
	
	public boolean checkDateInput() {
		if (Hour.getText().equals("") || Day.getText().equals("") || Month.getText().equals("") || Year.getText().equals(""))
			return false;
		else return true;
	}
	
	public String fieldToDate() {
		String date = Hour.getText() + " " + Day.getText() + " " + Month.getText() + " " + Year.getText();
		return date;
	}
	
	public void printDate(String date) {// 8:00 4  feb 1994
		String[] parts = date.split(" ");
		Hour.setText(parts[0]);
		Day.setText(parts[1]);
		Month.setText(parts[2]);
		Year.setText(parts[3]);
	}

	public void openWindow() {
		this.setVisible(true);
	}
}
