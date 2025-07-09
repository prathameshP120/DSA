class Calculater {
    int a;

    public int add(int n1, int n2) {
        System.out.println("in add");
        int res = n1 + n2;

        return res;
    }
}

public class ClassAndObject {

    public static void main(String[] args) {
        int num1 = 8;
        int num2 = 9;
        Calculater calc = new Calculater(); // calc object is created
        int res = calc.add(num1, num2);
        System.out.println(res);
    }
}
