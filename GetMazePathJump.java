import java.util.*;
import java.io.*;

public class GetMazePathJump {
    public static void main(String[] args) throws Exception
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        ArrayList<String> mypath = gmpj(1, 1, n, m);
        System.out.println(mypath);
    }

    public static ArrayList<String>gmpj(int sr,int sc,int dr,int dc) {
        //base case
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> mypath = new ArrayList<>(); //this is result
        //horizontal move
        for (int movesize = 1; movesize <=dc - sc; movesize++) {
            ArrayList<String> hpath = gmpj(sr, sc + movesize, dr, dc);
            for (String path : hpath) {
                mypath.add("h" + movesize + path);
            }
        }
        //vertical move
        for (int movesize = 1; movesize <= dr - sr; movesize++) {
            ArrayList<String> vpath = gmpj(sr + movesize, sc, dr, dc);
            for (String path : vpath) {
                mypath.add("v" + movesize + path);
            }
        }
        //diagonal move
        for (int movesize = 1; movesize <= dr - sr && movesize <= dc - sc; movesize++) {
            ArrayList<String> dpath = gmpj(sr + movesize, sc + movesize, dr, dc);
            for (String path : dpath) {
                mypath.add("d" + movesize + path);
            }
        }

        return mypath;
    }
}
