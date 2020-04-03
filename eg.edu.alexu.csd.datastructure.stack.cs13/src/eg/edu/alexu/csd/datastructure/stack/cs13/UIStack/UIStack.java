package eg.edu.alexu.csd.datastructure.stack.cs13;

import java.util.Scanner;


public class UIStack {

    static int choice;
    static boolean checkValid() {
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        if ((choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5))
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        String data = new String();
        Scanner scanner = new Scanner(System.in);
        Stack s = new Stack();
        boolean exit = true;


        do {
            System.out.println("Stack operations");
            System.out.println("-----------------------------------");
            System.out.println("1-Push:");
            System.out.println("2-Pop:");
            System.out.println("3-Get peek:");
            System.out.println("4-isEmpty:");
            System.out.println("5-Get size:");
            System.out.println("6-Exit:");
            System.out.println("-----------------------------------");
            System.out.println("Choose operation:");
            if (!checkValid()) {
                System.out.println("Choose a valid operation");
                continue;
            }



            switch (choice) {


                case 1:
                    System.out.println("Enter a value to be pushed: ");
                    data = scanner.next();
                    s.push(data);
                    break;

                case 2:

                    try {
                        data = (String) s.pop();
                    } catch (RuntimeException e) {
                        System.out.println("Stack is empty");
                    }
                    System.out.println("value popped is " + data);
                    break;
                case 3:
                    try {
                        System.out.println(s.peek());

                    } catch (RuntimeException e) {
                        System.out.println("Stack is empty");
                    }
                    break;

                case 4:
                    System.out.println(s.isEmpty() ? true : false);
                    break;
                case 5:
                    System.out.println(s.size());
                    break;
                case 6:
                    exit = false;
                    System.exit(0);

            }

        } while (exit);


    }
}	
	
	
		

	
	


