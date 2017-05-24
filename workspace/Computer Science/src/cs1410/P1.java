package cs1410;
import javax.swing.JOptionPane;

public class P1 {
					//Scott Glass: making a BMI calculator
	public static void main(String[] args) {
		//Insert person's first name
			String Firstname = JOptionPane.showInputDialog("Enter your first name:");
		//Insert person's last name
			String Lastname = JOptionPane.showInputDialog("Enter your last name:");
		//Insert person's height in inches
			String HeightinInches = JOptionPane.showInputDialog("Enter your height in inches:");
		//Insert person's weight in pounds
			String WeightinPounds = JOptionPane.showInputDialog("Enter your weight in pounds:");
		//Store number into variable "height"
			double height = Integer.parseInt(HeightinInches);
		//Find the height in meters
			double meters = height / 39.370079;
		//Store number into variable "weight"
			double weight = Integer.parseInt(WeightinPounds);
		//Find weight in kilograms
			double kilograms = weight / 2.2046228;
		//Calculate person's BMI and store number into variable "BMI"
			double BMI = kilograms / (meters*meters);
		//Store end message into String: "end"
			String end = Firstname + " " + Lastname + "\nBMI" + " " + BMI;
		//Display person's name and BMI
			JOptionPane.showMessageDialog(null, end);	
	}

}
