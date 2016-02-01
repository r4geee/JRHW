package MyTests;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexei on 13.12.2015.
 */
public class GenTttt {
    public static void main(String[] args) throws ClassNotFoundException {
        BigDecimal a = new BigDecimal("2762161261262161261");
        BigDecimal c = new BigDecimal("5.9213");
        BigDecimal b = new BigDecimal(13421412);
        //System.out.println(a.divide(b));
        System.out.println(a.divide(c, 10, BigDecimal.ROUND_HALF_EVEN));
    }
}
