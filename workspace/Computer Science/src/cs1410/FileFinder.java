package cs1410;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FileFinder {

	/**
	 * Scott Glass Creating a program that will 
	 * @param args 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		File f = fileChooser();
		String searchword  = StringSearch();
		String fileFound = FileWithWord(searchword, f, 0).toString();
		long bytes = bytesInFile(f);
		JOptionPane.showMessageDialog(null, fileFound + "\n" + bytes);
		continueorend();
		
		
		
		
		/** Create and set up a file chooser
		
			// If the file is actually a folder, count and display the number
			// of files it contains
			if (f.isDirectory()) {
				JOptionPane.showMessageDialog(null, depth(f));
				int count = countFilesInFolder(f);
				JOptionPane.showMessageDialog(null, "File count = " + count);
				count = countNestedFilesInFolder(f);
				JOptionPane.showMessageDialog(null, "File count = " + count);
		}
		*/
}
		
/**
 * Returns the number of files in the folder.
 */
/**public static int countFilesInFolder (File folder) {
	
	// Get an array of all the files/folders inside folder
	File[] files = folder.listFiles();
	
	// Count the files
	int c = 0;
	for (int j = 0; j < files.length; j++) {
		if (files[j].isFile()) {
			c++;
		}
	}
	
	// All done
	return c;
}
*/

/**
 * Returns the number files that are contained, directly or
 * indirectly, by the folder.
 */
/**public static int countNestedFilesInFolder (File folder) {
	
	// Get an array of all the files/folders inside folder
	File[] files = folder.listFiles();
	
	// Count the files
	int c = 0;
	for (int j = 0; j < files.length; j++) {
		if (files[j].isFile()) {
			c++;
		}
		else {
			c = c + countNestedFilesInFolder(files[j]);
		}
	}
	
	// All done
	return c;
}
*/

/**
 * Returns the total number of bytes in the file
 */
public static long bytesInFile (File folder) {
	return folder.getTotalSpace();
}


/**
 * Returns the total number of bytes in all the files that are
 * contained, directly or indirectly, by the folder.
 */
/**public static long totalNestedBytes (File folder) {
	
	// Get an array of all the files/folders inside folder
	File[] files = folder.listFiles();
	
	// Add up the bytes
	long total = 0;		
	for (int i = 0; i < files.length; i++) {
		if (files[i].isFile()) {
			total = total + files[i].length();
		}
		else {
			total = total + totalNestedBytes(files[i]);
		}
	}
	
	// All done
	return total;
}
*/


/**
 * Returns the number of folder levels in the piece of the
 * file system rooted at folder.
 * The depth of a folder that contains no folders is 1.
 */
/**public static int depth (File folder) {
			
	// Get an array of all the files/folders inside folder
	File[] files = folder.listFiles();
	
	int maxDepthSoFar = 0;
	for (int i = 0; i < files.length; i++) {
		if (files[i].isDirectory()) {
			maxDepthSoFar = Math.max(maxDepthSoFar,
					                 depth(files[i]));
		}
	}
	
	return maxDepthSoFar + 1;
				
			}
			*/

/** Allows the user to select a file and if they cancel it runs
 * areYouSure
 */
public static File fileChooser(){
	JFileChooser chooser = new JFileChooser();
	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	
	int outcome = chooser.showOpenDialog(null);
	
	if (outcome == JFileChooser.APPROVE_OPTION) {
		File f = chooser.getSelectedFile();
		return f;
	}
	else{
		areYouSure();
		return fileChooser();
				}
	
	
}
/**Asks the user if they want to continue the program or exit
 * out of the program
 */
public static void areYouSure(){
	int outcome = JOptionPane.showConfirmDialog(null, "Do you wish to continue?");
	if (outcome == JOptionPane.NO_OPTION){
		System.exit(0);		
	}	
}
/** Gets a String and stores it into searchString
 * if the user does not input anything it runs areYouSure
 */
public static String StringSearch(){
	String searchString = JOptionPane.showInputDialog("Enter part of the name of " +
			"the file you are looking for:");
	if (searchString != null){
		return searchString;
	}
	else{
		areYouSure();
		return StringSearch();
	}	
}
/**
 * Searches for a file with searchword being part of its
 * name in the selected file or folder
 * @param searchword
 * @param f
 * @return
 */
public static File FileWithWord(String searchword, File f, int j){
	File[] files = f.listFiles();
		while( j < files.length) {
			if (files [j].isDirectory()){
				FileWithWord (searchword, files [j], 0);
			}
			else{
				String t = files [j].getName();
				CharSequence sw = searchword;
				if (t.contains(sw)){
					return f;
				}
				j++;
			}
	}
		return f;
}
public static void continueorend(){
	int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue searching?");
	if (choice == JOptionPane.CANCEL_OPTION){
		System.exit(0);
	}
	if (choice == JOptionPane.NO_OPTION){
		System.exit(0);
	}
}
}

