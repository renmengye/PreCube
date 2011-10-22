/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precube;

import java.io.*;

/**
 *This program enables user to play and solve a rubic cube in command line.
 * @author MengYe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, NumberFormatException {
        // TODO code application logic here
        listen();
    }

    private static void listen() throws IOException, NumberFormatException {

        Cube cube = new Cube();
        DataInputStream cinput = new DataInputStream(System.in);
        String[] command = new String[3];
        welcome();
        cube.display();
        wait_command();

        while (true) {

            String bind = cinput.readLine();
            command = bind.split(" ");
            boolean is3 = (command.length == 3);

            if (is3) {
                boolean isHVP = (command[0].equals("h") || command[0].equals("v") || command[0].equals("p"));
                boolean isRoll = (command[1].equals("1") || command[1].equals("2") || command[1].equals("3"));
                boolean isDir = (command[2].equals("+") || command[2].equals("-"));

                if (isHVP && isRoll && isDir) {
                    cube.turn(command(command[0]), command(command[1]), command(command[2]));
                    cube.display();
                } else {
                    System.out.println("Incorrect order!");
                }
                wait_command();

            } else if (bind.equals("end")) {
                System.out.println("Program closed!");
                break;

            } else if (bind.equals("solve")) {
                cube.print_method(cube.solve2());
                cube.display();
                wait_command();

            } else if (command[0].equals("random") && command.length == 2) {
                if (Integer.parseInt(command[1]) <= 50) {
                    cube.random(Integer.parseInt(command[1]));
                    cube.display();
                    wait_command();
                } else {
                    System.out.println("Too big number!");
                    wait_command();
                }

            } else if (bind.equals("new")) {
                cube = new Cube();
                welcome();
                cube.display();
                wait_command();

            } else {
                System.out.println("incorrect order!");
                wait_command();
            }
        }
        cinput.close();
    }

    private static int command(String c) {
        if (c.equals("h")) {
            return C.TURN_H;
        } else if (c.equals("v")) {
            return C.TURN_V;
        } else if (c.equals("p")) {
            return C.TURN_P;
        } else if (c.equals("+")) {
            return C.TURN_CW;
        } else if (c.equals("-")) {
            return C.TURN_CCW;
        } else if (c.equals("1")) {
            return 1;
        } else if (c.equals("2")) {
            return 2;
        } else if (c.equals("3")) {
            return 3;
        } else {
            return -1;
        }
    }
    

    private static void wait_command() {
        System.out.print("Input your command here: ");
    }

    private static void welcome() {
        System.out.println("Welcome to a new cube!");
    }
}
