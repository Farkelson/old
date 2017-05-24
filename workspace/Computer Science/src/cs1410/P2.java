package cs1410;
import javax.swing.JOptionPane;
public class P2 {

	// Scott Glass doing Methods and While Loops
	public static void main(String[] args) {
		drawIndentedLine( 0, "+", 20, "-", "+");
		drawParallelogram(4, 7);
		drawDiamond(20);
		drawX(50);
		drawShapes();
	}
	//drawIndentedLine should print  a single line, terminated with a newline, that begins with the 
	//specified number of spaces, followed by the begin string, followed by n copies of the middle string, followed by the end string
	public static void drawIndentedLine (int spaces, String begin, int n, String middle, String end){
		int i = 0;
				while (i < spaces){
					System.out.print(" ");
					i = i + 1;
				}
		System.out.print(begin);
		int j = 0;
				while (j < n){
					System.out.print(middle);
					j = j + 1;
					}
		System.out.print(end);
		System.out.println();

	}
	//drawParallelogram should print a parallelogram shape with the specified height and width
	public static void drawParallelogram (int height, int width){
		String endpoint = "\\";
		System.out.print(endpoint);
		parallelwidth(width);
		System.out.println(endpoint);
		parallelheight(height, width);
		System.out.print(endpoint);
		parallelwidth(width);
		System.out.println(endpoint);
	}
	//Print the top and bottom lines with the desired length of 
	//the Parallelogram with "-".
	public static void parallelwidth(int width){
		int i = 0;
		while (i < width){
			System.out.print("-");
			i = i + 1;
		}
		}
	//Print the middle of the Parallelogram with the desired height.
	public static void parallelheight(int height, int width){
		System.out.print(" ");
		int j = 0;
		while (j < height){
			System.out.print("\\");
			int k = 0;
			while (k < width){
				System.out.print(" ");
				k = k + 1;}
			System.out.println("\\");
			System.out.print(" ");
			int h = -1;
			while (h < j){
				System.out.print(" ");
				h = h + 1;
			}
			j = j + 1;}
		}
	//drawDiamond should print a diamond shape with the specified size
	public static void drawDiamond (int size){
		int k = 0;
		int l = 0;
		int m = 0;
		while (k<size){
			while (m<size){
				System.out.print(" ");
				m = m + 1;
			}
			drawIndentedLine(0, "/", l, "**", "\\");
			l = l+1;
			k = k+1;
			m = k;
		}
		k = size;
		l = size-1;
		m = size;
		while (k>0){
			while (m<size + 1){
				System.out.print(" ");
				m = m + 1;
			}
			drawIndentedLine(0, "\\", l, "**", "/");
			l = l-1;
			k = k-1;
			m = k;
		}
		}
	//drawX should print an X shape with the specified size.
	public static void drawX(int size){
		int k = size;
		int l = size-1;
		int m = size;
		while (k>0){
			while (m<size + 1){
				System.out.print(" ");
				m = m + 1;
			}
			drawIndentedLine(0, "\\", l, "  ", "/");
			l = l-1;
			k = k-1;
			m = k;
		}
		k = 0;
		l = 0;
		m = 0;
		while (k<size){
			while (m<size){
				System.out.print(" ");
				m = m + 1;
			}
			drawIndentedLine(0, "/", l, "  ", "\\");
			l = l+1;
			k = k+1;
			m = k;
		}

	}
	//drawShapes should obtain a size from the user via an input dialog and 
	//then draw a parallelogram, a diamond, and an X of the specified size.
	//(For the parallelogram, both the height and width should be of 
	//the specified size.)
	
	public static void drawShapes () {
		String big = JOptionPane.showInputDialog("Enter the size you want your shapes to be:");
		int small = Integer.parseInt(big);
		drawParallelogram(small, small);
		drawDiamond(small);
		drawX(small);
	}
}		
	

	


