package menu;

import data.Student;
import find.CourseFind;
import find.MNFind;
import find.PrenameFind;
import find.SurnameFind;
import main.Console;
import stack.Stackable;

import java.util.Scanner;

public class Factory {
    private static Console console = new Console();
    private static Scanner scan = new Scanner(System.in);

    public static void menu(Stackable<Student> stack) {
        menuView();
        int answer = 1;
        while (answer != 0) {
            answer = scan.nextInt();
            switch (answer) {
                case 1:
                    stack.push(student());
                    stack.printAll();
                    break;
                case 2:
                    stack.pop();
                    stack.printAll();
                    if(stack.empty()==true){
                        System.out.println("Stack is empty");
                    }
                    break;
                case 3:
                    System.out.println(stack.peek());
                    if(stack.empty()==true) {
                        System.out.println("Stack is empty");
                    }
                    break;
                case 4:
                    searching(stack);
                    break;
                case 5:
                    stack.clear();
                    System.out.println("Stack is empty");
                    break;
                case 6:
                    stack.printAll();
                    if(stack.empty()==true){
                        System.out.println("Stack is empty");
                    }
                    break;
                case 7:
                    System.out.println(stack.size());
                    break;
                case 0:
                    return;
            }
        }}

    private static void searching(Stackable<Student> stack) {
        int answer;
        do {
            answer = console.readInt("Choose searching by:" +
                    "1. Prename " +
                    "2. Surname " +
                    "3.MN " +
                    "4. Course "
                    + "5. Back to menu");
            switch (answer){
                case 1:
                    String prename = console.readString("Enter prename");
                    PrenameFind pf = new PrenameFind();
                    Stackable <Student> gefunden = pf.stack(prename, stack);
                    gefunden.printAll();
                    break;
                case 2:
                    String surname = console.readString("Enter surname");
                    SurnameFind sf = new SurnameFind();
                    Stackable <Student> detected = sf.stack(surname, stack);
                    detected.printAll();
                    break;
                case 3:
                    int mn = console.readInt("Enter matrikelnumer");
                    String line = String.valueOf(mn);
                    MNFind mnf = new MNFind();
                    Stackable <Student> found = mnf.stack(line, stack);
                    found.printAll();
                    break;
                case 4:
                    int course = console.readInt("Enter course");
                    String linee = String.valueOf(course);
                    CourseFind cf = new CourseFind();
                    Stackable <Student> find = cf.stack(linee, stack);
                    find.printAll();
                    break;
                case 5:
                case 0:
                    menuView(); return;
            }

        }while (answer!=0);
    }




    private static void menuView () {
        System.out.println();
            System.out.println("What would you like to change?");
            System.out.println("1.Push student to stack");
            System.out.println("2.Pop student from stack");
            System.out.println("3.Peek student");
            System.out.println("4.Check if students are on the stack");
            System.out.println("5.Clear stack");
            System.out.println("6.Print all students from stack");
            System.out.println("7.Get size of the stack");
            System.out.println("0.Exit");
        }

        private static Student student () {
            String prename = console.readString("Add prename");
            String surname = console.readString("Add surname");
            int course = console.readInt("Add course");
            int mn = console.readInt("Add matrikelnummer");
            Student student = new Student(surname, prename, course, mn);
            return student;
        }

    }
