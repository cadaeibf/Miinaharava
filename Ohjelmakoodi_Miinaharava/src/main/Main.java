
package main;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import src.Kentta;
import src.Nappi;

public class Main {

    public static void main(String[] args) {
        Kentta kentta = new Kentta(10,8, 0);
        
        kentta.lisaaMiinaViereen(1, 1);
        kentta.lisaaMiinaViereen(2, 3);
        kentta.lisaaMiinaViereen(3, 6);
        kentta.lisaaMiinaViereen(4, 5);
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                kentta.kaiva(i, j);
            }
        }
        System.out.println(kentta.toString());
        
//        for (Nappi nappi : kentta.ymparillaOlevat(5, 5)) {
//            nappi.teeNakyvaksi();
//        }
        
//        int x = 0;
//        int y = 0;
//        Scanner lukija = new Scanner(System.in);
//        System.out.println(kentta.toString());
//        
//        while(x>=0 & x<10 & y>=0 & y<8) {
//            System.out.print("X: ");
//            x = Integer.parseInt(lukija.nextLine());
//            System.out.print("Y: ");
//            y = Integer.parseInt(lukija.nextLine());
//            kentta.kaiva(x, y);
//            System.out.println(kentta.toString());
//        }
//        
//        System.out.println("Kiitos ja näkemiin");
    }
}
