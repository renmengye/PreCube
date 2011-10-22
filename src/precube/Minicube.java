/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precube;

/**
 *
 * @author MengYe
 */
public class Minicube {

    private int type;
    private int color[] = {-1, -1, -1, -1, -1, -1};
    //int d[] = new int[3];
    private int x, y, z;
    private int loc;

    public Minicube(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
        switch (x) {
            case 0:
                color[C.SIDE_U] = C.SIDE_U;
                break;
            case 2:
                color[C.SIDE_D] = C.SIDE_D;
                break;
        }
        switch (y) {
            case 0:
                color[C.SIDE_L] = C.SIDE_L;
                break;
            case 2:
                color[C.SIDE_R] = C.SIDE_R;
                break;
        }
        switch (z) {
            case 0:
                color[C.SIDE_F] = C.SIDE_F;
                break;
            case 2:
                color[C.SIDE_B] = C.SIDE_B;
                break;
        }
        if ((x == 0 || x == 2) && (y == 0 || y == 2) && (z == 0 || z == 2)) {
            type = C.LOC_CORNER;
        } else if (x == 1 || y == 1 || z == 1 && (x * y != 1 || y * z != 1 || x * z != 1)) {
            type = C.LOC_SIDE;
        } else if (x * y * z == 1) {
            type = C.LOC_FACE;
        }
    }

    public Minicube(int x, int y, int z, int type, int[] color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
        this.color = color.clone();
    }

    public Minicube clone(Minicube input) {
        Minicube output = new Minicube(input.x, input.y, input.z, input.type, input.color);
        return output;
    }

    protected void switch_color(int a, int b) {
        int c = color[a];
        color[a] = color[b];
        color[b] = c;
    }

    public int get_color(int side) {
        return color[side];
    }

    protected void set_color(int side, int color) {
        this.color[side]=color;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public int getZ(){
        return z;
    }
}
