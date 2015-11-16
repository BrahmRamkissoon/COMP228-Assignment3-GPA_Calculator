package ramkissoon_COMP228Lab3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GPA_Calculator extends JFrame {
	JButton calculateButton;
	JComboBox<String> numOfCoursesCombo;
	//ArrayList<JTextField> courseCodeTextField;
	JComboBox<String> creditHoursCombo[] = new JComboBox[6]; // ComboBox to hold credit hours
	JComboBox<String> gradeCombo[] = new JComboBox[6]; 	// ComboBox to hold Letter Grades
	
	private static final String[] courses = { "0", "1", "2", "3", "4", "5", "6" };
	private static final String[] creditHours = {"3", "4", "5"};
	private static final String[] letterGrade = { "A+ 90-100%", "A 80-89%", "B+ 75-79%", "B 70-74%",
													"C+ 65-69%", "C 60-64%", "D+ 55-59", "D 50-54%", "F 0-49%"};
	
	JLabel creditsLabel, currentGPA_Label, numberOfCoursesLabel, itemNumLabel, courseCodeLabel, creditHoursLabel,
			gradeLabel, finalGPA_Label;

	JLabel itemNum2_Label[] = new JLabel[6];

	JPanel topPanel, coursePanel, bottomPanel, topPanelUpper, topPanelLower;

	JTextField creditsTxtField, currentGPA_TxtField;

	JTextField courseCodeTxtField[] = new JTextField[6];

	public GPA_Calculator() {
		// Frame by default have this, just to be explicit
		// Only using North, Center, South 
		setLayout(new BorderLayout());

		// Top Panel +++++++++++++++++++++++++++++++++++++++++++++++++
		topPanel = new JPanel();
		topPanelUpper = new JPanel();
		topPanelLower = new JPanel();

		// Top Panel Labels and Fields
		creditsLabel = new JLabel("Credit Hours Earned:");
		creditsTxtField = new JTextField(4);
		currentGPA_Label = new JLabel("Current GPA:");
		currentGPA_TxtField = new JTextField(4);
		numberOfCoursesLabel = new JLabel("Number of Courses:");		
		numOfCoursesCombo = new JComboBox<String>(courses);

		// Top Panel Layout
		topPanel.setLayout(new BorderLayout());
		topPanelUpper.add(creditsLabel);
		topPanelUpper.add(creditsTxtField);
		topPanelUpper.add(currentGPA_Label);
		topPanelUpper.add(currentGPA_TxtField);

		topPanel.add("North", topPanelUpper);

		topPanelLower.add(numberOfCoursesLabel);
		topPanelLower.add(numOfCoursesCombo);
		// listener for courses combo box
		numOfCoursesCombo.addActionListener(new ComboHandler()); 

		topPanel.add("South", topPanelLower);
		

		// Course Panel +++++++++++++++++++++++++++++++++++++++++++++++++n  n  
		coursePanel = new JPanel();

		// Course Panel Labels and Fields
		itemNumLabel = new JLabel("Nr");
		courseCodeLabel = new JLabel("Course code");
		creditHoursLabel = new JLabel("Credit hours");
		gradeLabel = new JLabel("Grade");

		// Course Panel Layout
		coursePanel.setLayout(new GridLayout(0, 4)); // specify only Columns
		coursePanel.add(itemNumLabel);
		coursePanel.add(courseCodeLabel);
		coursePanel.add(creditHoursLabel);
		coursePanel.add(gradeLabel);

		// Push labels up with 24 empty cells (arbitrary #)
		for (int i = 0; i < 24; i++) {
			coursePanel.add(new JLabel());
		}

		// Bottom Panel +++++++++++++++++++++++++++++++++++++++++++++++++
		bottomPanel = new JPanel();

		// Bottom Panel Label and Button
		finalGPA_Label = new JLabel("Final GPA");
		calculateButton = new JButton("Calculate");

		// Bottom Panel Layout
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.add(finalGPA_Label);
		bottomPanel.add(calculateButton);

		// Add Top, Course, Bottom Panels to Frame
		add("North", topPanel);
		add("Center", coursePanel);
		add("South", bottomPanel);
	}

	public static void main(String[] args) {
		GPA_Calculator frame = new GPA_Calculator();
		frame.setTitle("GPA Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 320);
		frame.setVisible(true);
		
		ArrayList<JTextField> courseCodeTextField = new ArrayList<JTextField>();
	}

	private class ComboHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numOfCoursesCombo) {
				coursePanel.removeAll();
				coursePanel.add(itemNumLabel);
				coursePanel.add(courseCodeLabel);
				coursePanel.add(creditHoursLabel);
				coursePanel.add(gradeLabel);
				
				for (int i = 0; i < numOfCoursesCombo.getSelectedIndex(); i++) {
					//Course Number Column
					coursePanel.add(new JLabel(Integer.toString(i + 1)));
					
					// Course Code Column					
					coursePanel.add(new JTextField("X"));
					// Credit Hours Column
					coursePanel.add(new JComboBox<String>(creditHours));
					// Grade Column
					coursePanel.add(new JComboBox<String>(letterGrade));
				} // end for

				coursePanel.revalidate(); // refresh layout, better than
											// repaint()
			} // end if
		} // end actionPerformed
	}
}
