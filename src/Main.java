import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("");System.out.println("Первая задача");
        System.out.println(solutions(1, 0, -1));
        System.out.println("");System.out.println("Вторая задача");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println("");System.out.println("Третья задача");
        System.out.println(checkPerfect(12));
        System.out.println("");System.out.println("Четвертая задача");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println("");System.out.println("Пятая задача");
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println("");System.out.println("Шестая задача");
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("");System.out.println("Седьмая задача");
        System.out.println(isKaprekar(297));
        System.out.println("");System.out.println("Восьмая задача");
        System.out.println(longestZero("111000011"));
        System.out.println("");System.out.println("Девятая задача");
        System.out.println(nextPrime(0));
        System.out.println("");System.out.println("Десятая задача");
        System.out.println(rightTriangle(6,8,10));
    }
    //1 задача Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных
    //решения для действительных значений x. учитывая a, b и c, вы должны вернуть число решений в уравнение.
    public static int solutions(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        int x = 0;
        if (D > 0) {
            x = 2;
        } else if (D == 0) {
            x = 1;
        } else {
            x = 0;
        }
        return x;
    }
    //2 задача Напишите функцию, которая возвращает позицию второго вхождения " zip " в строку
    //или -1, если оно не происходит по крайней мере дважды. Ваш код должен быть достаточно общим
    //чтобы передать все возможные случаи, когда "zip" может произойти в строке.
    public static int findZip(String line) {
        char[] strToArray = line.toCharArray();
        int i = 0;
        int sum = 0;
        int num = 0;
        while (i < strToArray.length - 1) {
            if (strToArray[i] == 'z') {
                i++;
                num = i - 1;
                if (strToArray[i] == 'i') {
                    i++;
                    if (strToArray[i] == 'p') {
                        sum++;
                    }
                }
            }
            i++;
        }
        if (sum == 0 || sum == 1) num = -1;
        return num;
    }
    //3 задача Создайте функцию, которая проверяет, является ли целое число совершенным числом или нет.
    //Совершенное число - это число, которое можно записать как сумму его множителей, исключая само число.
    //Например, 6-это идеальное число, так как 1 + 2 + 3 = 6, где 1, 2 и 3-Все коэффициенты 6.

    public static boolean checkPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        if (sum == num) return true;
        else return false;
    }
    //4 задача Создайте функцию, которая принимает строку и возвращает новую строку с заменой ее первого и
    //последнего символов, за исключением трех условий: – Если длина строки меньше двух, верните "несовместимо".".
    //– Если первый и последний символы совпадают, верните "два-это пара.".
    public static String flipEndChars(String line) {
        char[] strToArray = line.toCharArray();
        char start;
        char end;
        String str;
        if (strToArray[0] == strToArray[strToArray.length - 1]) {
            str = "Два - это пара";
        } else if (strToArray.length < 2) {
            str = "Несовместимо";
        } else {
            start = strToArray[0];
            end = strToArray[strToArray.length - 1];
            strToArray[0] = end;
            strToArray[strToArray.length - 1] = start;
            str = String.valueOf(strToArray);
        }
        return str;
    }
    //5 задача Создайте функцию, которая определяет, является ли строка допустимым шестнадцатеричным кодом.
    //Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6 символов.
    //Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F.
    //Все буквенные символы могут быть прописными или строчными
    public static boolean isValidHexCode(String line) {
        char[] strToArray = line.toCharArray();
        int num = 0;
        int i = 0;
        if (strToArray[i] == '#') {
            num++;
            for (; i < strToArray.length; i++) {
                if ((((strToArray[i] >= 'a') && (strToArray[i] <= 'f')) || ((strToArray[i] >= 'A') && (strToArray[i] <= 'F')) || (strToArray[i] >= '0' && strToArray[i] <= '9')) && strToArray.length == 7) {
                    num++;
                }
            }
        }
        return num == strToArray.length;
    }
    //6 задача Напишите функцию, которая возвращает true, если два массива имеют одинаковое
    //количество уникальных элементов, и false в противном случае.
    //Для примера:arr1 = [1, 3, 4, 4, 4] arr2 = [2, 5, 7]
    //В arr1 число 4 появляется трижды, что означает, что оно содержит три уникальных
    //элемента: [1, 3, 4]. Поскольку arr1 и arr2 содержат одинаковое количество уникальных элементов
    //этот пример вернет значение true.
    public static boolean same(int[] arr1, int[] arr2) {
        int sum=0;int sum2=0;
        for(int i =0;i<arr1.length;i++)
        {
            boolean test=false;
            for(int j=0;j<i;j++)
            {
                if(arr1[j]==arr1[i])
                {
                    test=true;
                    break;
                }
            }
            if(!test)
            {
                sum++;
            }
        }
        for(int i =0;i<arr2.length;i++)
        {
            boolean test=false;
            for(int j=0;j<i;j++)
            {
                if(arr2[j]==arr2[i])
                {
                    test=true;
                    break;
                }
            }
            if(!test)
            {
                sum2++;
            }
        }
        return sum==sum2;
    }
    //7 задача
    public static boolean isKaprekar(int a){
        int pow=a*a; String sq1=Integer.toString(pow);
        int middle=(Integer.toString(pow).length())/2;
        int mod=pow%((int)Math.pow(10,sq1.length()-middle));
        int div=pow/((int)Math.pow(10,sq1.length()-middle));
        int sum=mod+div;
        return sum==a;
    }
    //8 задача Напишите функцию, которая возвращает самую длинную последовательность
    //последовательных нулей в двоичной строке.
    public static String longestZero(String line){
        char[] strToArray = line.toCharArray();
        String g="";
        int res=0;int fin=0;
        for(int i=0;i<strToArray.length;i++){
            if(strToArray[i]=='0'){
                res++;
                if(fin<res){
                    fin=res;
                }
            }
            else{res=0;}
        }
        for(int f=0;f<fin;f++){
            g = g + "0";
        }
        return g;
    }
    // 9 задача Если задано целое число, создайте функцию, которая возвращает следующее простое число.
    //Если число простое, верните само число.
    public static int nextPrime(int a){
        boolean probablePrime;
        if(a==0){a=2;}
        else{
            do{
                BigInteger bigInteger = BigInteger.valueOf(a);
                probablePrime = bigInteger.isProbablePrime((int) Math.log(a));
                a++;
            }
            while (!probablePrime);}
        return --a;
    }
    //10 задача Учитывая три числа, x, y и z, определите, являются ли они ребрами прямоугольного треугольника.
    public static boolean rightTriangle(int x,int y,int z){
        boolean res=false;
        if(Math.pow(x,2)+Math.pow(y,2)==Math.pow(z,2)||Math.pow(x,2)==Math.pow(y,2)+Math.pow(z,2)||Math.pow(x,2)+Math.pow(z,2)==Math.pow(y,2)){
            res=true;

        }
        return res;
    }
}