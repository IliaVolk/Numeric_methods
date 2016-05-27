package Main;


import Main.other.InterfaceOfStaticGeneratedClass;
import Main.other.SafePatchyContainer;
import com.sun.javafx.image.impl.IntArgb;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static long evklid(long m, long n){
        while (true) {
            m = m%n;
            if (m == 0) return n;
            n = n%m;
            if (n == 0) return m;
        }
    }


    public static void main(String[] args) {
        System.out.println(evklid(2166, 6099));
    }
}

