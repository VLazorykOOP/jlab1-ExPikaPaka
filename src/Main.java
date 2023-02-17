import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static float my_max(List<Integer> arr)  {
        // Find max value in a given array;
        int max;
        max = arr.get(0);

        for (Integer aFloat : arr) {
            max = aFloat > max ? aFloat : max;
        }
        return max;
    }

    public static List<Integer> clear_repeatings_pairs(List<Integer> arr) {
        // Clears array of repeating's pairs
        // Ex. 1 2 3 4 4 3 => 1 2

        List<Integer> clear = new ArrayList<>();

        if(arr.size() > 0) {
            boolean same;

            for (int i = 0; i < arr.size(); i++) {
                same = false;
                for (int k = 0; k < arr.size(); k++) {
                    if (k == i) continue;

                    if (Objects.equals(arr.get(i), arr.get(k))) {
                        same = true;
                        break;
                    }
                }
                if (!same) {
                    clear.add(arr.get(i));
                }
            }
        }
        return clear;
    }


    public  static void task_1() {
        // Basic mathematical, IO operations

        System.out.println("Task 1 (basic operations). Input 2 float variables: \n");
        double a = Float.parseFloat(scanner.next());
        double b = Float.parseFloat(scanner.next());

        double res = (a * b - (a + b) * (a - b)) / (b * b * b * b + a * a * a) + 5.0 * b;

        System.out.println("Result (real - real):  " + res);
        System.out.println("Result (real - integer):  " + (int)res);



        a = (int)a;
        b = (int)b;

        double c = a;
        double d = b;

        res = (c == 0 && d == 0) ? 0 : (c * d - (c + d) * (c - d)) / (d * d * d * d + c * c * c) + 5.0 * d;
        System.out.println("Result (integer - real):  " + res);
    }

    public  static void task_2() {
        // Outputs max value in a non-repeating array
        // Can be used pre-defined array, or user-input array

        System.out.println("Task 2 (Finding max number in non-repeating array numbers.\n\n");
        System.out.println("Make choice :\n" + "a) Use pre-defined array of 20 variables\n" +
                "b) Input array, that terminates with 'e' symbol' \n");

        String choice = scanner.next();

        // If input 'a' - using pre-defined array
        if(Objects.equals(choice, "a")) {
            List<Integer> arr = new ArrayList<>(
                    Arrays.asList(1, 2, 3, 4, 5,
                            1, 2, 3, 4, 5,
                            1, 2, 3, 4, 5,
                            1, 2, 3, 4, 5,
                            6, 7, 8, 9, 0));

            // Output
            System.out.println("Original:\n" + arr);

            arr = clear_repeatings_pairs(arr);
            System.out.println("Repeating's are cleared:\n" + arr);

            System.out.println("Maximum:\n" + my_max(arr));
        }

        // If input 'b' - using user-input array
        if(Objects.equals(choice, "b")) {
            List<Integer> arr = new ArrayList<>();
            String buffer = "";
            int limit = 400;


            // Input
            System.out.println("Input array and 'e' symbol at the end of an array\n");
            while (!Objects.equals(buffer, "e")) {
                buffer = scanner.next();

                if(!Objects.equals(buffer, "e")) {
                    arr.add(Integer.valueOf(buffer));
                }
            }


            // Output
            System.out.println("Original:\n" + arr);

            arr = clear_repeatings_pairs(arr);
            System.out.println("Repeating's are cleared:\n" + arr);

            System.out.println("Maximum:\n" + my_max(arr));
        }

    }

    public  static void task_3() {
        // Rotates a given array so, that first row will be a row with a max number

        System.out.println("Make choice :\n" + "a) Use pre-defined 3x3 matrix\n" +
                "b) Input NxN matrix\n");

        String choice = scanner.next();

        // If input 'a' - using pre-defined 3x3 matrix
        int matrix[][] = new int[1][1];
        int maxNum = matrix[0][0];
        int maxRow = 0;
        int n = matrix[0].length;

        if(Objects.equals(choice, "a")) {
            matrix = new int[][]{{1, 2, 3}, {4, 5, 36}, {-1, -2, -3}};
            n = 3;
        }

        // If input 'b' - using user-input method
        if(Objects.equals(choice, "b")) {
            System.out.println("Input matrix size N: ");
            n = Integer.parseInt(scanner.next());
            matrix = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }



        // Finding row with a max number
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] > maxNum) {
                    maxNum = matrix[i][j];
                    maxRow = i;
                }
            }
        }

        // Rotating array so, that 1 row will be a row with a max number
        int out[][] = matrix;
        int ind = 0;

        if(maxRow != 0) {
            for (int i = maxRow; i < matrix[0].length; i++) {
                out[ind] = matrix[i];
                ind++;
            }

            for (int i = 0; i < maxRow; i++) {
                out[ind] = matrix[i];
                ind++;
            }

        }

        // Output
        System.out.println(Arrays.deepToString(out));
    }

    public  static void task_4() {
        // Creates a new array of words from another text with words that have pair of letters
        // Ex.
        //      'Some text, where must remain only words with pair of letters.' =>
        //       =>  [Some, text, must, remain, only, with, pair, of]

        String text = "Some text, where must remain only words with pair of letters.";
        text = text.replaceAll("[^a-zA-Z\\s]+", "");

        List<String> oddLengthWords = new ArrayList<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() % 2 == 0) {
                oddLengthWords.add(word);
            }
        }

        System.out.println(String.join(" ", oddLengthWords));
    }

    public static void main(String[] args) {

        System.out.println("Lab 1 Java\n");

        int choice;

        while (true) {
            System.out.println("Input task number 1, 2, 3, 4, (5 to exit): ");
            choice = scanner.nextInt();


            if(choice == 1) {
                task_1();
            }

            if(choice == 2) {
                task_2();
            }

            if(choice == 3) {
                task_3();
            }

            if(choice == 4) {
                task_4();
            }

            if(choice == 5) {
                break;
            }
        }
    }
}