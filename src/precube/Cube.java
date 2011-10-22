/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precube;

import java.util.*;

/**
 *
 * @author MengYe
 */
public class Cube {

    public Minicube cube[][][] = new Minicube[3][3][3];  //Little components
    private Minicube cubeclone[][][] = new Minicube[3][3][3];
    public ArrayList method = new ArrayList();

    public Cube() {
        initArray();
    }

    public Cube(Minicube[][][] cube) {
        this.cube = cube;
    }

    private void initArray() {

        for (int i = 0; i <= 2; i++) { //Initialize all the Arrays.
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 2; k++) {
                    cube[i][j][k] = new Minicube(i, j, k);
                }
            }
        }
    }

    private int flip_side(int side, int hvp, int dir) {
        int fside = 0;
        switch (hvp) {
            case C.TURN_H: {
                if (side != 2 && side != 5) {
                    switch (dir) {
                        case C.TURN_CW: {
                            switch (side) {
                                case 0:
                                    fside = 4;
                                    break;
                                case 1:
                                    fside = 0;
                                    break;
                                case 3:
                                    fside = 1;
                                    break;
                                case 4:
                                    fside = 3;
                                    break;
                            }
                            break;
                        }
                        case C.TURN_CCW: {
                            switch (side) {
                                case 0:
                                    fside = 1;
                                    break;
                                case 1:
                                    fside = 3;
                                    break;
                                case 3:
                                    fside = 4;
                                    break;
                                case 4:
                                    fside = 0;
                                    break;
                            }
                            break;
                        }
                    }
                } else {
                    fside = side;
                }
                break;
            }
            case C.TURN_V: {
                if (side != 1 && side != 4) {
                    switch (dir) {
                        case C.TURN_CW: {
                            switch (side) {
                                case 0:
                                    fside = 2;
                                    break;
                                case 2:
                                    fside = 3;
                                    break;
                                case 3:
                                    fside = 5;
                                    break;
                                case 5:
                                    fside = 0;
                                    break;
                            }
                            break;
                        }
                        case C.TURN_CCW: {
                            switch (side) {
                                case 0:
                                    fside = 5;
                                    break;
                                case 2:
                                    fside = 0;
                                    break;
                                case 3:
                                    fside = 2;
                                    break;
                                case 5:
                                    fside = 3;
                                    break;
                            }
                            break;
                        }
                    }

                } else {
                    fside = side;
                }
                break;
            }
            case C.TURN_P: {
                if (side != 0 && side != 3) {
                    switch (dir) {
                        case C.TURN_CW: {
                            switch (side) {
                                case 1:
                                    fside = 5;
                                    break;
                                case 2:
                                    fside = 1;
                                    break;
                                case 4:
                                    fside = 2;
                                    break;
                                case 5:
                                    fside = 4;
                                    break;
                            }
                            break;
                        }
                        case C.TURN_CCW: {
                            switch (side) {
                                case 1:
                                    fside = 2;
                                    break;
                                case 2:
                                    fside = 4;
                                    break;
                                case 4:
                                    fside = 5;
                                    break;
                                case 5:
                                    fside = 1;
                                    break;
                            }
                            break;
                        }
                    }
                } else {
                    fside = side;
                }
                break;
            }
        }

        return fside;
    }

    private int[] flip_grid(int dir, int x, int y) {

        int[] d = {0, 0};
        switch (dir) {
            case C.TURN_CCW: {
                if (x == 0 && y == 0) {
                    d[0] = 0;
                    d[1] = 2;
                } else if (x == 0 && y == 1) {
                    d[0] = 1;
                    d[1] = 2;
                } else if (x == 0 && y == 2) {
                    d[0] = 2;
                    d[1] = 2;
                } else if (x == 1 && y == 0) {
                    d[0] = 0;
                    d[1] = 1;
                } else if (x == 1 && y == 2) {
                    d[0] = 2;
                    d[1] = 1;
                } else if (x == 2 && y == 0) {
                    d[0] = 0;
                    d[1] = 0;
                } else if (x == 2 && y == 1) {
                    d[0] = 1;
                    d[1] = 0;
                } else if (x == 2 && y == 2) {
                    d[0] = 2;
                    d[1] = 0;
                }
                break;
            }
            case C.TURN_CW: {
                if (x == 0 && y == 0) {
                    d[0] = 2;
                    d[1] = 0;
                } else if (x == 0 && y == 1) {
                    d[0] = 1;
                    d[1] = 0;
                } else if (x == 0 && y == 2) {
                    d[0] = 0;
                    d[1] = 0;
                } else if (x == 1 && y == 0) {
                    d[0] = 2;
                    d[1] = 1;
                } else if (x == 1 && y == 2) {
                    d[0] = 0;
                    d[1] = 1;
                } else if (x == 2 && y == 0) {
                    d[0] = 2;
                    d[1] = 2;
                } else if (x == 2 && y == 1) {
                    d[0] = 1;
                    d[1] = 2;
                } else if (x == 2 && y == 2) {
                    d[0] = 0;
                    d[1] = 2;
                }
                break;
            }
        }

        return d;
    }

    public Minicube[][][] clone_map() {
        Minicube[][][] output = new Minicube[3][3][3];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 2; k++) {
                    output[i][j][k] = cube[i][j][k].clone(cube[i][j][k]);
                }
            }
        }
        return output;
    }

    public void turn(int hvp, int row, int dir) throws NumberFormatException {

        int r = row - 1;
        cubeclone = clone_map();
        for (int move = 0; move <= 7; move++) {
            int xi = C.TURN_ARRAY[dir][hvp][r][move][0][0];
            int yi = C.TURN_ARRAY[dir][hvp][r][move][0][1];
            int zi = C.TURN_ARRAY[dir][hvp][r][move][0][2];
            int xf = C.TURN_ARRAY[dir][hvp][r][move][1][0];
            int yf = C.TURN_ARRAY[dir][hvp][r][move][1][1];
            int zf = C.TURN_ARRAY[dir][hvp][r][move][1][2];
            Minicube cubei = cubeclone[xi][yi][zi];
            Minicube cubef = cube[xf][yf][zf];
            for (int i = 0; i <= 5; i++) {
                int i2 = flip_side(i, hvp, dir);
                int ci = cubei.get_color(i);
                int ci2 = cubef.get_color(i2);
                //System.out.printf("tried i %d to i2 %d\n",i,i2);
                if (cubei.get_color(i) != -1 && cubef.get_color(i2) != -1) {
                    cubef.set_color(i2, cubei.get_color(i));
                    //System.out.printf("%d %d %d color %d %d copy to %d %d %d color %d %d\n", xi, yi, zi, i,ci,xf, yf, zf, i2, ci2);
                }
            }
        }
    }

    public void display() {
        System.out.println("");
        for (int i = 0; i <= 2; i++) {
            if (i == 0) {
                System.out.println("          U       B");
            } else if (i == 1) {
                System.out.println("  L       F       R");
            } else if (i == 2) {
                System.out.println("          D         ");
            }

            for (int j = 0; j <= 2; j++) {
                for (int u = 0; u <= 2; u++) {
                    int faceNum = -1;
                    switch (i * 3 + u) {
                        case 1:
                            faceNum = C.SIDE_U;
                            break;
                        case 2:
                            faceNum = C.SIDE_B;
                            break;
                        case 3:
                            faceNum = C.SIDE_L;
                            break;
                        case 4:
                            faceNum = C.SIDE_F;
                            break;
                        case 5:
                            faceNum = C.SIDE_R;
                            break;
                        case 7:
                            faceNum = C.SIDE_D;
                    }
                    for (int v = 0; v <= 2; v++) {

                        if (faceNum >= 0) {
                            int[] co = new int[3];
                            co[0] = C.FACE_ARRAY[faceNum][j][v][0];
                            co[1] = C.FACE_ARRAY[faceNum][j][v][1];
                            co[2] = C.FACE_ARRAY[faceNum][j][v][2];
                            System.out.print(cube[co[0]][co[1]][co[2]].get_color(faceNum) + " ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    //Minicube[][] display=get_face_cube(faceNum);
                    /*for (int v = 0; v <= 2; v++) {
                    if (faceNum == 0 || faceNum == 1 || faceNum == 5 || faceNum == 3) {
                    System.out.print(face[faceNum].get_color(j, v) + " ");
                    } else if (faceNum == 2) {
                    System.out.print(face[faceNum].get_color(j, v) + " ");
                    } else if (faceNum == 4) {
                    System.out.print(face[faceNum].get_color(j, v) + " ");
                    } else if (faceNum < 0) {
                    System.out.print("  ");
                    }
                    }*/


                    System.out.print("  ");

                }

                System.out.println();
            }

            //System.out.println();
        }
        System.out.println("");
        System.out.println("");
    }

    public void random(int time) {
        int place, roll, direction;
        Random rand = new Random();
        for (int i2 = 0; i2 <= time - 1; i2++) {
            place = rand.nextInt(3);
            roll = rand.nextInt(3) + 1;
            direction = rand.nextInt(2);
            turn(place, roll, direction);
            System.out.printf("Step %d: %s %d %s\n", i2 + 1, conv_hvp(place), roll, conv_dir(direction));
        }
    }

    public ArrayList solve() {
        boolean check = false;
        int depth = 0, width = 0;
        ArrayList everything = new ArrayList();
        ArrayList this_level = new ArrayList();
        ArrayList next_level = new ArrayList();
        this_level.add(clone_me());
        everything.add(this_level);
        Cube mytry = new Cube();
        Cube mytry2 = new Cube();
        ArrayList upper = new ArrayList();
        outer:
        do {
            //System.out.printf("I am now on depth %d, width %d\n", depth, width);
            if (depth == 0 || width == 0) {
                next_level = new ArrayList();
            } else {
                next_level = (ArrayList) everything.get(depth + 1);
            }
            this_level = (ArrayList) everything.get(depth);
            mytry = (Cube) this_level.get(width);
            //mytry.display();
            for (int hvp = 0; hvp <= 2; hvp++) {
                for (int row = 1; row <= 3; row++) {
                    //for (int dir = 0; dir <= 1; dir++) {
                    mytry2 = mytry.clone_me();
                    mytry2.turn(hvp, row, 0);
                    mytry2.method.add(depth, new int[]{hvp, row, 0});
                    //System.out.printf("I am now on depth %d, width %d try %d doing %d %d\n", depth, width, hvp * 2 + (row - 1) * 2 + 1, hvp, row - 1);
                    //mytry2.display();
                    check = check(mytry2.cube);
                    next_level.add(mytry2);
                    if (check) {
                        System.out.println("success!");
                        //print_method(mytry2.method);
                        return mytry2.method;
                    }
                    //}
                }
            }
            if (!check) {
                if (width == this_level.size() - 1) {
                    System.out.printf("finished depth %d\n", depth);
                    everything.add(depth + 1, next_level);
                    depth++;
                    width = 0;
                } else {
                    if (width == 0) {
                        everything.add(depth + 1, next_level);
                    } else {
                        everything.remove(depth + 1);
                        everything.add(depth + 1, next_level);
                    }
                    width++;
                }
            }
        } while (!check);
        return new ArrayList();
    }

    public ArrayList solve2() {
        //ArrayList todo = new ArrayList();
        ArrayList meth = new ArrayList();
        meth.add(method);
        outer:
        while (!meth.isEmpty()) {
            //Cube now = new Cube((Minicube[][][]) todo.get(0));
            ArrayList now_meth = (ArrayList) meth.get(0);
            //todo.remove(0);
            meth.remove(0);
            for (int hvp = 0; hvp <= 2; hvp++) {
                for (int row = 1; row <= 3; row++) {
                    for (int dir = 0; dir <= 1; dir++) {
                        ArrayList now_meth_copy = (ArrayList) now_meth.clone();
                        now_meth_copy.add(new int[]{hvp, row, dir});
                        if (!redund(now_meth_copy)) {
                            Cube now_copy = clone_me();
                            for (int i = 0; i < now_meth_copy.size(); i++) {
                                int[] acmeth = (int[]) now_meth_copy.get(i);
                                now_copy.turn(acmeth[0], acmeth[1], acmeth[2]);
                            }
                            if (check(now_copy.cube)) {
                                return now_meth_copy;
                            } else {
                                meth.add(now_meth_copy);
                            }
                        }
                    }
                }
            }
            if (meth.size() % 100 == 0) {
                long free_space = Runtime.getRuntime().freeMemory() / 1024 / 1024;
                System.out.println(free_space);
                //if(free_space<200){break outer;}
                System.out.println(meth.size());
            }
        }
        return new ArrayList();
    }

    public boolean check(Minicube[][][] cube) {
        boolean check = true;
        outer:
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 2; k++) {
                    for (int count = 0; count <= 5; count++) {
                        if (cube[i][j][k].get_color(count) != -1) {
                            if (cube[i][j][k].get_color(count) != count) {
                                check = false;
                                break outer;
                            }
                        }
                    }
                }
            }
        }
        return check;
    }

    public Cube clone_me() {
        Cube me = new Cube();
        me.cube = this.clone_map();
        me.method = (ArrayList) this.method.clone();
        return me;
    }

    public void print_method(ArrayList m) {
        for (int i = 0; i < m.size(); i++) {
            int[] m1 = (int[]) m.get(i);
            System.out.printf("Step %d: %s %d %s\n", i + 1, conv_hvp(m1[0]), m1[1], conv_dir(m1[2]));
        }
    }

    public static char conv_hvp(int hvp) {
        if (hvp == C.TURN_H) {
            return 'h';
        } else if (hvp == C.TURN_V) {
            return 'v';
        } else if (hvp == C.TURN_P) {
            return 'p';
        } else {
            return ' ';
        }
    }

    public static char conv_dir(int dir) {
        if (dir == C.TURN_CW) {
            return '+';
        } else if (dir == C.TURN_CCW) {
            return '-';
        } else {
            return ' ';
        }
    }

    public boolean redund(ArrayList method) {
        if (method.size() >= 2) {
            int[] last1 = (int[]) method.get(method.size() - 1);
            int[] last2 = (int[]) method.get(method.size() - 2);
            if (last1[0] == last2[0]) {
                if (last1[1] == last2[1] && last1[2] != last2[2]) {
                    return true;
                } else if (last1[1] == last2[1] && last1[2] == last2[2]) {
                    if (method.size() >= 3) {
                        int[] last3 = (int[]) method.get(method.size() - 3);
                        if (last1[0] == last3[0] && last1[1] == last3[1] && last1[2] == last3[2]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}