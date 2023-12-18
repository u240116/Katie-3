import java.util.Random;
import java.util.Scanner;

public class partB {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() {
        while (true) {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {
                return;
            }

            double a, b, r;

            switch (input) {
                case "square":
                    System.out.println("Enter the length of side a: ");
                    a = Double.parseDouble(scan.nextLine());
                    System.out.println("The circumference of the square is: " + a * 4);
                    System.out.println("The area of the square is: " + a * a);
                    break;

                case "rectangle":
                    System.out.println("Enter the length of side a: ");
                    a = Double.parseDouble(scan.nextLine());
                    System.out.println("Enter the length of side b: ");
                    b = Double.parseDouble(scan.nextLine());
                    System.out.println("The circumference of the rectangle is: " + (2 * a + 2 * b));
                    System.out.println("The area of the rectangle is: " + (a * b));
                    break;

                case "circle":
                    System.out.println("Enter the radius: ");
                    r = Double.parseDouble(scan.nextLine());
                    System.out.println("The circumference of the circle is: " + (Math.PI * r * 2));
                    System.out.println("The area of the circle is: " + (Math.PI * r * r));
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static void Q2() {
        System.out.println("Q2: Enter the current day (1-31): ");
        int num = scan.nextInt();
        System.out.println("Enter the current month: (1-12)");
        int num2 = scan.nextInt();
        String[]months={"Invalid month", "January","February","March","April","May", "June","July","August","September", "Ocober","November","December"};

        if (num == 1||num == 21||num == 31)
            System.out.print("You selected "+num+"st of ");
        else if (num == 2||num==22)
            System.out.print("You selected "+num+"nd of ");
        else if (num == 3||num==23)
            System.out.print("You selected "+num+"rd of ");
        else if (num >31)
            System.out.print("Invalid day ");
        else 
            System.out.print("You selected "+num+"th of ");
        

        if (num2 >= 1 && num2 <= 12) 
        {
            System.out.println(months[num2]);
        } 
        else 
        {
        System.out.println(months[0]);
        }
    }
    public static void Q3() {
        System.out.println("Q3: Enter how many numbers you want to check for primality: ");
        
        int n;
        try {
            n = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }
    
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (i < 2)
                continue;
    
            boolean check = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                counter++;
            }
        }
    
        System.out.println("There are: " + counter + " primes between 0 and " + n);
    }
    
    public static void Q4() {
        Random rng = new Random();
        System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
        System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int turns = 0;

        while (enemyHP > 0) {
            turns++;

            System.out.print("You rolled: ");
            int attackRoll = rng.nextInt(20) + 1;
            boolean buffActive = false;

            switch (scan.nextLine().toLowerCase()) {
                case "a":
                    break;
                case "b":
                    buffActive = true;
                    System.out.println("Buffing! +5 to your next attack roll and damage");
                    break;
                default:
                    System.out.println("Invalid input");
                    turns--;
                    continue;
            }

            attackRoll += buffActive ? 5 : 0;
            System.out.println(buffActive ? attackRoll + " + 5 (buff active)" : attackRoll);

            if (attackRoll >= 12) {
                int damage = (rng.nextInt(8) + 1) + (rng.nextInt(8) + 1) + (buffActive ? 5 : 0);
                if (attackRoll == 20 && buffActive) {
                    damage *= 2;
                    System.out.print("Critical hit! ");
                }
                System.out.println("You dealt " + damage + " damage" + (buffActive ? " (buffed attack)" : ""));
                enemyHP = Math.max(0, enemyHP - damage);
                System.out.println("Enemy HP: " + enemyHP);
            } else {
                System.out.println("Miss");
            }
        }

        System.out.println("Enemy died in " + turns + " turns");
        scan.close();
    }
}



