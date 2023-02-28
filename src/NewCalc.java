import java.util.Scanner;

public class NewCalc {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        }else{
            throw new Exception("Некорректный знак действия");
        }
        if (data[0].length()>10) throw new Exception("Количество букв должно быть меньше 11");
        if (data[1].length()>10) throw new Exception("Количество букв должно быть меньше 11");
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
            else if (action == '*' || action == '/') {
                int multiplier1 = Integer.parseInt(data[1]);
                if (multiplier1>10 || multiplier1<1) throw new Exception("число должно быть от 1 до 10");

            }
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){
        if (text.length()>40){
            System.out.println("\""+text+"..."+"\"");
        }
        else
        System.out.println("\""+text+"\"");
    }
}