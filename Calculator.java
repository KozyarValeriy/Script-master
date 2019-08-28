/**
Напишите программу на языке java, которая может складывать, 
вычитать, умножать и делить
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    /** Class to calculate expression */
    public static void main (String[] args) {
        System.out.println("Enter an expression like: X operator Y, " +
                           "where operator in [+, -, /, *]");
        Scanner in = new Scanner(System.in);
        // reading input
        String equation = in.nextLine();
        equation = equation.replaceAll(" ", ""); 
        // set template
        String target = "\\d[)]?([*/+-])[(]?[-]?\\d";
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(equation);
        if (matcher.find()) {
            String operator = matcher.group(1);
            int index = matcher.start(1);
            // selecting first variable
            String var_x = equation.substring(0, index);
            // selecting second variable
            String var_y = equation.substring(index + 1, 
                                        equation.length());
            // converting variable to Float
            Float x = to_float(var_x);
            Float y = to_float(var_y);
            Float answer = new Float("0");
            // choosing action
            switch (operator) {
                case "+":
                    answer = sum(x, y);
                    break;
                case "-":
                    answer = difference(x, y);
                    break;
                case "*":
                    answer = multiplication(x, y);
                    break;
                case "/":
                    answer = div(x, y);
                    break;
            }
            System.out.println(var_x + " " + operator + " " + var_y + 
                               " = " + Float.toString(answer));
        } else {
            System.out.println("Could not find equation");
        }
    }
    
    private static Float to_float(String par) {
        /** Method to convert variable to Float */
        par = par.replaceAll("\\)", ""); 
        par = par.replaceAll("\\(", ""); 
        try {
            Float val = new Float(par);
            return val;
        } catch (NumberFormatException e) {
            System.err.println("Error converting to number");
            return new Float("0");
        }
    }
    
    public static Float sum(Float x, Float y) {
        /** Method to calculate sum of two numbers */
        return x + y;
    }
    
    public static Float difference(Float x, Float y) {
        /** Method to calculate difference of two numbers */
        return x - y;
    }
    
    public static Float multiplication(Float x, Float y) {
        /** Method to calculate multiplication of two numbers */        
        return x * y;
    }

    public static Float div(Float x, Float y) {
        /** Method to calculate division of two numbers */      
        Float division;
        try {
            division = x / y;
        } catch (ArithmeticException e) {
            System.err.println("Cannot be divided by zero");
            division = new Float("0");
        }
        return division;
    }
}