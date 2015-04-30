package ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmpID;
	private JTextField txtEmpName;
	private JTextField txtPosition;
	private JList empList;
	private DefaultListModel empListModel;
	private JComboBox deptComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(10, 185, 78, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(10, 210, 89, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(10, 235, 78, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 260, 46, 14);
		contentPane.add(lblPosition);
		
		txtEmpID = new JTextField();
		txtEmpID.setText("101");
		lblEmployeeId.setLabelFor(txtEmpID);
		txtEmpID.setBounds(110, 182, 86, 20);
		contentPane.add(txtEmpID);
		txtEmpID.setColumns(10);
		
		txtEmpName = new JTextField();
		txtEmpName.setText("Robert Rathman");
		lblEmployeeName.setLabelFor(txtEmpName);
		txtEmpName.setBounds(110, 207, 131, 20);
		contentPane.add(txtEmpName);
		txtEmpName.setColumns(10);
		
		JButton btnNoArg = new JButton("No Arg");
		btnNoArg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNoArg_actionPerformed(e);
			}
		});
		btnNoArg.setBounds(52, 285, 89, 23);
		contentPane.add(btnNoArg);
		
		JButton btnTwoArg = new JButton("2 Arg");
		btnTwoArg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTwoArg_actionPerformed(e);
			}
		});
		btnTwoArg.setBounds(153, 285, 89, 23);
		contentPane.add(btnTwoArg);
		
		JButton btnFourArg = new JButton("4 Arg");
		btnFourArg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFourArg_actionPerformed(e);
			}
		});
		btnFourArg.setBounds(252, 285, 89, 23);
		contentPane.add(btnFourArg);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maintenance"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(110, 232, 153, 20);
		contentPane.add(deptComboBox);
		
		txtPosition = new JTextField();
		txtPosition.setText("Software Designer");
		lblPosition.setLabelFor(txtPosition);
		txtPosition.setBounds(110, 257, 131, 20);
		contentPane.add(txtPosition);
		txtPosition.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 368, 166);
		contentPane.add(scrollPane);
		
		empListModel = new DefaultListModel();  //added manually
		//empList = new JList();
		empList = new JList(empListModel);
		//empList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(empList);
		
	}
	protected void do_btnNoArg_actionPerformed(ActionEvent e) {
		//Call appropriate constructor
		Employee Employee = new Employee(); 
		empListModel.addElement(Employee);
	}
	
	protected void do_btnTwoArg_actionPerformed(ActionEvent e) {
		String empName = txtEmpName.getText();
		int empID = Integer.parseInt(txtEmpID.getText());
		//Call appropriate constructor
		Employee Employee = new Employee(
				empName,
				empID);
				empListModel.addElement(Employee);
	}
	
	protected void do_btnFourArg_actionPerformed(ActionEvent e) {
		String empName = txtEmpName.getText();
		int empID = Integer.parseInt(txtEmpID.getText());
		String dept = (String) deptComboBox.getSelectedItem();
		String position = txtPosition.getText();
		//Call appropriate constructor
		Employee Employee = new Employee(
				empName,
				empID,
				dept,
				position);
				empListModel.addElement(Employee);
	}
	
}
