package ramkissoon_COMP228Lab3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GPA_Calculator extends JFrame{
	JButton calculateButton;
	JComboBox <String>numOfCoursesCombo;
	JComboBox <String>creditHoursCombo [] = new JComboBox [6];
	JComboBox <String>gradeCombo [] = new JComboBox [6];
	
	JLabel creditsLabel, currentGPA_Label, 
			numberOfCoursesLabel, 
			itemNumLabel, courseCodeLabel, creditHoursLabel, gradeLabel,
			finalGPA_Label;
	
	JLabel itemNum2_Label [] = new JLabel[6];
	
	JPanel topPanel, coursePanel, bottomPanel,
			topPanelUpper, topPanelLower;
	
	JTextField creditsTxtField, currentGPA_TxtField;
	
	JTextField courseCodeTxtField [] = new JTextField[6];

	public GPA_Calculator()
	{
		// Frame by default have this, just to be explicit
		// We will only be using North, Center, South , Collapsed will be East, West
		setLayout( new BorderLayout()); 
		
		// Top Panel +++++++++++++++++++++++++++++++++++++++++++++++++
		topPanel = new JPanel();		
		topPanelUpper = new JPanel();
		topPanelLower = new JPanel();
		
		// Top Panel Labels and Fields
		creditsLabel = new JLabel ("Credit Hours Earned:");
		creditsTxtField = new JTextField (4);
		currentGPA_Label = new JLabel ("Current GPA:");
		currentGPA_TxtField= new JTextField (4);
		numberOfCoursesLabel = new JLabel("Number of Courses:");
		String [] courses = {"0", "1", "2", "3", "4", "5", "6"};
		numOfCoursesCombo = new JComboBox <String>(courses);
		
		// Top Panel Layout
		topPanel.setLayout(new BorderLayout());
		topPanelUpper.add(creditsLabel);
		topPanelUpper.add(creditsTxtField);
		topPanelUpper.add(currentGPA_Label);
		topPanelUpper.add(currentGPA_TxtField);
		
		topPanel.add("North", topPanelUpper);
		
		topPanelLower.add(numberOfCoursesLabel);
		topPanelLower.add(numOfCoursesCombo);
		numOfCoursesCombo.addActionListener(new ComboHandler());	// listener for number of courses combo box
		
		topPanel.add("South", topPanelLower);
		
		
		//	Course Panel +++++++++++++++++++++++++++++++++++++++++++++++++
		coursePanel = new JPanel();
		
		// Course Panel Labels and Fields
		itemNumLabel = new JLabel("Nr");
		courseCodeLabel = new JLabel("Course code");
		creditHoursLabel = new JLabel("Credit hours");
		gradeLabel = new JLabel ("Grade");
		
		// Course Panel Layout
		coursePanel.setLayout(new GridLayout(0, 4));	// specify only Columns
		coursePanel.add(itemNumLabel);
		coursePanel.add(courseCodeLabel);
		coursePanel.add(creditHoursLabel);
		coursePanel.add(gradeLabel);
		
		// Push labels up with empty cells 24 is an arbitrary # 
		for(int i = 0; i < 24; i++){
			coursePanel.add(new JLabel());
		}
		
		// Bottom Panel +++++++++++++++++++++++++++++++++++++++++++++++++
		bottomPanel = new JPanel();
		
		
		// Bottom Panel Label and Button
		finalGPA_Label = new JLabel ("Final GPA");
		calculateButton = new JButton ("Calculate");
		
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
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(480,320);
		frame.setVisible(true);
	}
	
	private class ComboHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == numOfCoursesCombo){
				coursePanel.removeAll();
				coursePanel.add(itemNumLabel);
				coursePanel.add(courseCodeLabel);
				coursePanel.add(creditHoursLabel);
				coursePanel.add(gradeLabel);
				for (int i = 0; i < numOfCoursesCombo.getSelectedIndex(); i++){
					coursePanel.add(new JLabel(Integer.toString(i+1)));
					coursePanel.add(new JLabel("X"));
					coursePanel.add(new JLabel("X"));
					coursePanel.add(new JLabel("X"));
				} // end for
				
				coursePanel.revalidate();	// refresh layout, better than repaint()
			} //end if			
		} // end actionPerformed		
	}	
}


















