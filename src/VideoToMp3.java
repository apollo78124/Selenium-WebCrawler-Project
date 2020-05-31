import java.util.Scanner;

public class VideoToMp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int songNumber;
		String[] links;
		Scanner scn = new Scanner(System.in);
		boolean pageTurn = false;
		
		System.out.println("How many songs?");
		songNumber = scn.nextInt();
		links = new String[songNumber];
		
		for (int i = 0; i < songNumber; i++) {
			System.out.println("Paste the link");
			links[i] = scn.next();
		}
	}

}
