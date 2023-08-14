// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Exception;



public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        Scanner scan = new Scanner(System.in);

        String sum = "";

        while(true) {
            try {

                System.out.println("Input");
                String input = scan.nextLine();
                sum = calc(input);

                System.out.println("Output = " + sum);

            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                break;
            } catch (Exception e) {

                System.out.println(e.toString());
                if(e.toString().equals("java.lang.Exception: negative number")) continue;
                break;
            }

        }


    }


    private static String calc(String input) throws Exception
    {
        String str = "";

        char [] signs = {'+', '-', '*', '/'};
        char sign = ' ';
        int x=-1, y=-1, index = -1, result = 0;
        boolean state = false;

        for(char ch : signs)
        {
            index = input.indexOf(ch);
            if(index != -1)
            {
                sign = ch;
                break;
            }
        }

        if(index == -1) throw new Exception("Not correct sign");


        String begin = new String(input.toCharArray(), 0, index);
        String end = new String(input.toCharArray(), ++index, input.length()-index);


        begin = begin.trim();
        end = end.trim();


        Roman [] arr = Roman.values();
        for(Roman r : arr)
        {
            if(begin.equals(r.toString())) x = r.n;
            if(end.equals(r.toString())) y = r.n;
        }


        if((x != -1 && y == -1) || (x == -1 && y != -1))
            throw new Exception("Not correct Roma number");

        else if(x == -1 && y == -1)
        {
            x = Integer.parseInt(begin);
            y = Integer.parseInt(end);
            state = true;
        }

        if(x < 1 || x > 10)  throw new Exception("Out bounds");
        if(y < 1 || y > 10)  throw new Exception("Out bounds");


        switch (sign)
        {
            case '/':
                result = x/y;
                break;
            case '*':
                result = x*y;
                break;
            case '+':
                result = x+y;
                break;
            case '-':
                result = x-y;
                if (!state &&  result <=0 ) throw new Exception("negative number");
                break;
        }


        str += state ? result : arr[result-1];


        return str;

    }

    enum Roman
    {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20),
        XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26), XXVII(27), XXVIII(28), XXIX(29), XXX(30),
        XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45), XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
        LI(51), LII(52), LIII(53), LIV(54), LV(55), LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
        LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65), LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
        LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75), LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
        LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85), LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
        XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95), XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100)  ;
        int n;
        Roman(int i){n = i;}

    }
}