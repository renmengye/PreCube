/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precube;

import java.io.PrintStream;

/**
 *
 * @author MengYe
 */
public class Face {

    //public int cube[][][] = new int[3][3][3];
    private int side;
    private int i, j, k;
    private Minicube[][] cube = new Minicube[C.SIZE][C.SIZE];
    private int color[][] = new int[3][3];

    protected void add(int x, int y, Minicube mini) {
    }

    protected void fix(String c) { //type=line, face
    }

    public Face(int side, Minicube[][] cube) {
        this.side = side;
        this.cube = cube;
    }

    public int get_color(int y, int x) {
        return cube[y][x].get_color(side);
    }

    protected void refresh_color() {
        for (j = 0; j < C.SIZE; j++) {
            for (i = 0; i < C.SIZE; i++) {
                color[j][i] = cube[j][i].get_color(side);
            }
        }
    }

    public int get_side() {
        return side;
    }

    /*private void init(int side) {//Determine the Components.
    
    switch (side) {
    case C.SIDE_F:
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    cube[i][j][0] = i;
    cube[i][j][1] = j;
    cube[i][j][2] = 0;
    }
    }
    break;
    case C.SIDE_R:
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    cube[i][j][0] = i;
    cube[i][j][1] = 2;
    cube[i][j][2] = j;
    }
    }
    break;
    case C.SIDE_U:
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    cube[i][j][0] = 0;
    cube[i][j][1] = j;
    cube[i][j][2] = i;
    }
    }
    break;
    case C.SIDE_B:
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    cube[i][j][0] = i;
    cube[i][j][1] = j;
    cube[i][j][2] = 2;
    }
    }
    break;
    case C.SIDE_L:
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    cube[i][j][0] = i;
    cube[i][j][1] = 0;
    cube[i][j][2] = j;
    }
    }
    case C.SIDE_D:
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    cube[i][j][0] = 2;
    cube[i][j][1] = j;
    cube[i][j][2] = i;
    }
    }
    break;
    }
    }
    
    private void initArray() {//Initialize, maybe not.
    
    for (i = 0; i <= 2; i++) {
    for (j = 0; j <= 2; j++) {
    for (k = 0; k <= 2; k++) {
    cube[i][j][k] = 0;
    }
    //color[i][j] = 0;
    }
    }
    }
    
    public int getColor(int x, int y){
    return cube
    }*/
}