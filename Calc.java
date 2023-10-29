import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        Calc method = new Calc();
        float[] values = new float[2];
        String operation;

        values[0] = method.values();
        do {
            operation = method.operations();

            // 無効な演算子の場合、エラーメッセージを表示
            if (!method.checkOperator(operation)) {
                System.out.println("無効な演算子です。再度入力してください。");
                continue;
            }
            else if(operation.equals("=")) break;

            values[1] = method.values();

            values[0] = method.calc(values, operation);
        } while (true);

        if(method.checkInt(values[0])){
            System.out.println("回答:" + (int)values[0]);
        }else{
            System.out.println("回答:" + values[0]);
        }
    }

    //値を標準入力をさせるメゾット
    private float values() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("値を入力してください:");
        return scanner.nextFloat();
    }

    //演算子を標準入力をさせるメゾット
    private String operations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("演算子[+-*/%, =]を入力してください:");
        return scanner.nextLine();
    }

    //計算をさせるメゾット
    private float calc(float[] v, String op) {
        float answer;
        switch (op) {
            case "+" -> answer = v[0] + v[1];
            case "-" -> answer = v[0] - v[1];
            case "*" -> answer = v[0] * v[1];
            case "%" -> answer = v[0] % v[1];
            case "/" -> {
                if (v[1] == 0) {
                    System.out.println("ゼロでの割り算は許可されていません。");
                    return Float.NaN; // エラーを示す特別な値を返す
                }
                answer = v[0] / v[1];
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
        return answer;
    }

    //演算子が正しいかチェックするメゾット
    private boolean checkOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%") || op.equals("=");
    }

    //float型の必要があるかチェックするメゾット
    private boolean checkInt(float number) {
        return (number * 10) % 1 == 0;
    }
}