package view;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

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
import model.models.DoctorModel;
import model.models.DoctorUpdateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorView extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -475277969260105642L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField tPId;
	private JTextField txtConsultations;
	private JTextField txtConsultationId;
	private JTextField tCID;
	private JTextField txtPatients;
	private JTable tPatients = new JTable();
	private JTable tConsultations = new JTable();
	JTextArea tDescription = new JTextArea();
	private DoctorModel doctorModel;
	private JTextField pacientArrived;
	private String username;


	/**
	 * Create the frame.
	 * @param doctorModel 
	 */
	@SuppressWarnings("serial")
	public DoctorView(DoctorModel doctorModel) {
		this.doctorModel = doctorModel;

		Timer updateTask;
		DoctorUpdateModel adminUpdate = new DoctorUpdateModel(this);
		updateTask = new Timer();
		updateTask.schedule(adminUpdate, 0, 5000);

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 600);
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
		
		tDescription.setBounds(431, 382, 376, 143);
		contentPane.add(tDescription);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText("Id:");
		txtId.setBounds(10, 382, 64, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		tPId = new JTextField();
		tPId.setBounds(84, 382, 50, 20);
		contentPane.add(tPId);
		tPId.setColumns(10);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tPId.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Select an ID!");
				else displayConsultations(doctorModel.getAllConsultations(), Integer.parseInt(tPId.getText()));
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
		
		tConsultations.setBounds(426, 35, 381, 296);
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
		
		txtConsultationId = new JTextField();
		txtConsultationId.setEditable(false);
		txtConsultationId.setText("Consultation ID:");
		txtConsultationId.setBounds(436, 342, 100, 20);
		contentPane.add(txtConsultationId);
		txtConsultationId.setColumns(10);
		
		JButton btnSelectConsultation = new JButton("Select Consultation");
		btnSelectConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tCID.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Select an Consultation ID!");
				else displayDescription(doctorModel.getAllConsultations(), Integer.parseInt(tCID.getText()));
			}
		});
		btnSelectConsultation.setBounds(667, 341, 140, 23);
		contentPane.add(btnSelectConsultation);
		
		tCID = new JTextField();
		tCID.setBounds(553, 342, 86, 20);
		contentPane.add(tCID);
		tCID.setColumns(10);
		
		JButton btnUpdateDescription = new JButton("Update Description");
		btnUpdateDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tCID.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Select an Consultation ID!");
				else {
					for (Consultation cons : doctorModel.getAllConsultations()) {
						if (cons.getId() == Integer.parseInt(tCID.getText())) {
							Consultation newC = new Consultation();
							newC.setId(cons.getId());
							newC.setPid(cons.getPid());
							newC.setDid(cons.getDid());
							newC.setDate(cons.getDate());
							newC.setDescription(tDescription.getText());
							
							doctorModel.updatConsultation(cons, newC);
						}
					}
				}
			}
		});
		btnUpdateDescription.setBounds(431, 536, 153, 23);
		contentPane.add(btnUpdateDescription);
		
		txtPatients = new JTextField();
		txtPatients.setEditable(false);
		txtPatients.setText("Patients:");
		txtPatients.setBounds(10, 11, 86, 20);
		contentPane.add(txtPatients);
		txtPatients.setColumns(10);
		
		pacientArrived = new JTextField();
		pacientArrived.setText("A pacient arrived!");
		pacientArrived.setEditable(false);
		pacientArrived.setBounds(94, 416, 115, 36);
		contentPane.add(pacientArrived);
		pacientArrived.setColumns(10);
		pacientArrived.setVisible(false);
		
		displayPatients(this.doctorModel.getAllPatients());
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

	@Override
	public void update(Observable o, Object arg) {
		if (arg != null)
		if (username.equals((String) arg)) {
			pacientArrived.setVisible(true);
		}
	}
	
	public void setUsername(String user) {
		this.username = user;
		setTitle("Doctor name: " + username + " PAGE");
	}

	public void openWindow() {
		this.setVisible(true);
	}
}
