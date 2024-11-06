import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("InputOneTwo.txt"));
        System.out.println(challengeTwo("InputOneTwo.txt"));
        System.out.println(challengeThree("InputThreeFour.txt"));
        System.out.println(challengeFour("InputThreeFour.txt"));
    }

    /** TODO 1
     *
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] nums = readFile(fileName);
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] > 0) {
                counter++;
            }
        }
        return counter;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] nums = readFile(fileName);
        int[] nums1 = new int[nums.length];
        int counter = 0;
        for (int i = 2; i < nums.length; i++) {
            nums1[i-2] = nums[i-2] + nums[i-1] + nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums1[i] - nums1[i-1] > 0) {
                counter++;
            }
        }
        return counter;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] strings = readFile2(fileName);
        int x = 0;
        int y = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].split(" ")[0].equals("forward")) {
                x += Integer.parseInt(strings[i].split(" ")[1]);
            }
            if (strings[i].split(" ")[0].equals("up")) {
                y += -Integer.parseInt(strings[i].split(" ")[1]);
            }
            if (strings[i].split(" ")[0].equals("down")) {
                y += Integer.parseInt(strings[i].split(" ")[1]);
            }
        }
        return (x*y);
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] strings = readFile2(filename);
        int x = 0;
        int y = 0;
        int aim = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].split(" ")[0].equals("forward")) {
                x += Integer.parseInt(strings[i].split(" ")[1]);
                y += Integer.parseInt(strings[i].split(" ")[1]) * aim;
            }
            if (strings[i].split(" ")[0].equals("up")) {
                aim += -Integer.parseInt(strings[i].split(" ")[1]);
            }
            if (strings[i].split(" ")[0].equals("down")) {
                aim += Integer.parseInt(strings[i].split(" ")[1]);
            }
        }
        return (x*y);
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}