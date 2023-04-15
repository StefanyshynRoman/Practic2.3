package com.shpp.rstefanyshyn;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    static String fileNameProperties = "config.properties";



    static String min;
    static String max;
    static String inc;
    static String sysTurn;
    static ArrayList<BigDecimal> resultTableLong = new ArrayList<>();
    static ArrayList<BigDecimal> resultTableInt = new ArrayList<>();
    static ArrayList<BigDecimal> resultTableDouble = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    static Logger logger1 =LoggerFactory.getLogger("log1");
    private static BigDecimal mul;

    public static void main(String[] args) {
        GetProperty property = new GetProperty(fileNameProperties);

        max = property.getValueFromProperty("max");
        min = property.getValueFromProperty("min");
        inc = property.getValueFromProperty("inc");
        logger.warn(" Minimum=" + min + " Maximum=" + max + " Step=" + inc);
            sysTurn = System.getProperty("type","int").toLowerCase();

        try {
            switch (sysTurn) {
                case "int": {
                    int minimum = (Integer.parseInt((min)));
                    int maximum = (Integer.parseInt((max)));
                    int increment = (Integer.parseInt(inc));
                    multiplyInteger(maximum, minimum, increment);
                    break;
                }
                case "double": {
                    double minimum = (Double.parseDouble((min)));
                    double maximum = (Double.parseDouble((max)));
                    double increment = (Double.parseDouble(inc));
                    multiplyDouble(maximum, minimum, increment);

                    break;
                }
                case "long": {
                    long minimum = (Long.parseLong((min)));
                    long maximum = (Long.parseLong((max)));
                    long increment = (Long.parseLong(inc));
                    multiplyLong(maximum, minimum, increment);

                    break;
                }
                default:
                    logger.error("Type is wrong");
            }

        } catch (NumberFormatException e) {
            logger.error("One or more  value is wrong",e);
            System.exit(1);
        }
        logger.warn("______The_End____");
    }

    public static long multiplyLong(long maximum, long minimum, long increment) {
        logger.warn("________LONG________");
        for (long i = minimum; i < maximum; i += increment) {
            for (long j = minimum; j < maximum; j += increment) {
                mul = BigDecimal.valueOf(i * j);
                logger1.info(i + "x" + j + "= " + mul);
                resultTableLong.add(mul);
            }
        }
        return maximum*minimum;
    }

    public static double multiplyDouble(double maximum, double minimum, double increment) {
        logger.warn("________Double________");
        for (double i = minimum; i < maximum; i += increment) {
            for (double j = minimum; j < maximum; j += increment) {
                mul = BigDecimal.valueOf(i * j);
          String pattern="#.##";
                String iValue= new DecimalFormat(pattern).format(i);
                String jValue=new  DecimalFormat(pattern).format(j);
                String mulValue= new  DecimalFormat(pattern).format(mul);
                logger1.info(iValue+ "x" +jValue + "= " + mulValue);
                resultTableDouble.add(mul);
            }

        }
        return maximum*minimum;
    }

    public static int multiplyInteger(int maximum, int minimum, int increment) {
        logger.warn("________Integer________");
        for (int i = minimum; i < maximum; i += increment) {
            for (int j = minimum; j < maximum; j += increment) {
                mul = BigDecimal.valueOf((long) i * j);
                logger1.info(i + "x" + j + "= " + mul);
                resultTableInt.add(mul);
            }
        }
        return maximum * minimum;
    }


}
