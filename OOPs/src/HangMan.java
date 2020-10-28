import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//give an option to guess the entire string
//handle invalid inputs


public class HangMan {
	private static int NUM_ATTEMPTS = 5;
	
	private void hangman() throws FileNotFoundException {
		ArrayList<String> al = new ArrayList<String>();
		String randomMovie = new String();
		String underscoredMovie = new String();
		// int c=0;
		try {
			File file = new File("/Users/njaglan/eclipse-workspace/OOPs/src/Movies");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				al.add(line);
				// c++;
			}
			randomMovie = generateRandomMovieName(al);
//			System.out.println("random movie=" + randomMovie);
			underscoredMovie = generateUnderscores(randomMovie);
			System.out.println("underscored=" + underscoredMovie);
			guess(randomMovie, underscoredMovie);
		} catch (FileNotFoundException exception) {
			System.out.println("File missing!");
		}

	}

	private void guess(String randomMovie, String underscoredMovie) {
		StringBuilder builder = new StringBuilder(underscoredMovie);
		Scanner scanner = new Scanner(System.in);
		int length = randomMovie.length();
		int noOfAttempts = NUM_ATTEMPTS, saveIndex = -1;
		while (noOfAttempts != 0) {
			System.out.println("Guess a letter..");
			char guessedCharacter = scanner.next().charAt(0);
			for (int i = 0; i < randomMovie.length(); i++) {
				if (guessedCharacter == randomMovie.charAt(i)) {
					saveIndex = i;
//					System.out.println("saved index=" + saveIndex);
					
					builder.setCharAt(saveIndex, randomMovie.charAt(saveIndex));
				}
				// System.out.println("underscoredMovie.charAt(saveIndex)"+underscoredMovie.charAt(saveIndex));
				// System.out.println("randomMovie.charAt(saveIndex)"+randomMovie.charAt(saveIndex));
			}
			noOfAttempts--;
			//System.out.println("under..." + builder.toString());
		}
		System.out.println("No of attempts exceeded!!!");
		System.out.println("The name of the movie was : " + randomMovie);
	}

	private String generateRandomMovieName(ArrayList<String> al) {
		Random random = new Random();
		int r = random.nextInt(al.size());
		String movie = al.get(r);
		return movie;
	}

	private String generateUnderscores(String randomMovie) {
		String hidden = new String(new char[randomMovie.length()]).replace('\0', '*');
		String hidden2 = randomMovie.replaceAll("[^ ]", "*");
		return hidden2;
	}

	public static void main(String[] args) throws FileNotFoundException {
		HangMan hm = new HangMan();
		hm.hangman();

	}

}
