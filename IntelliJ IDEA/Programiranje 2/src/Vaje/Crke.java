package Vaje;

/**
 *
 * @author Mitja
 */
public class Crke {
    public static void main(String[] args) {
        //izpisi(12341234);
        izpisi(71917410474557695l);
        izpisi(new long[] {
            4821103401091611672l, 0, 144680345680364600l, 1739555224076567106l, 
            -9114862049243683816l,1739555224076567106l, 0, 4821103401091611672l
        });
        long crkaO = getCrko(new int[] {60, 66, 129, 129, 129, 129, 66, 60});    
        System.out.println(crkaO);
        
        ime(new long[] {0, 0, -67536333235548144l, 144680345680364600l, 1739555224076567106l});
    }
    
    public static void izpisi(long crka){
        for (int i = 7; i >= 0; i--) {
            for (int j = 7; j >= 0; j--) {
                long maska = (long) 1 << (8*i+j);
                System.out.print((crka & maska) == maska ? "*" : " ");
            }
            System.out.println();
        }
    }
    
    public static void izpisi(long crke[]){
        for (int j = 7; j >= 0; j--) {
            for (int i = 0; i < crke.length; i++) {
                for (int k = 7; k >= 0; k--) {
                    long maska = (long) 1 << (8*j+k);
                    System.out.print((crke[i] & maska) == maska ? "*" : " ");
                }
            }
            System.out.println();
        }
    }
    
    public static long getCrko(int [] vrstice){
        long crka = ((long) vrstice[0] << 56) + ((long) vrstice[1] << 48) + 
                    ((long) vrstice[2] << 40) + ((long) vrstice[3] << 32) + 
                    ((long) vrstice[4] << 24) + ((long) vrstice[5] << 16) + 
                    ((long) vrstice[6] << 8) + (long) vrstice[7];
        return crka;
    }
    
    public static void ime(long crke[]){
        crke[0] = getCrko(new int[] {129, 195, 165, 137, 129, 129, 129, 129});
        crke[1] = getCrko(new int[] {16, 16, 16, 16, 16, 16, 16, 16});
        izpisi(crke);
    }
}
