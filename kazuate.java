import java.util.Scanner;

public class kazuate {
    public static void main(String[] args) {
        int answerNumber = 78;
        System.out.println("数当てゲームへようこそ！");
        System.out.println("私が設定した2桁の正の整数を当ててください。");
        System.out.println("チャンスは5回です。");
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5;
        boolean hasGuessedCorrectly = false;
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.println("\n----- " + i + "回目の挑戦 -----");
            System.out.print("数を入力してください: ");
            int userGuess = scanner.nextInt();
            if (userGuess == answerNumber) {
                System.out.println("🎉 当たり！おめでとうございます！");
                hasGuessedCorrectly = true;
                break;
            } else {
                if (userGuess > answerNumber) {
                    if (userGuess - answerNumber >= 20) {
                        System.out.println("残念！20以上大きいです。");
                    } else {
                        System.out.println("残念！大きいです。");
                    }
                } else {
                    if (answerNumber - userGuess >= 20) {
                        System.out.println("残念！20以上小さいです。");
                    } else {
                        System.out.println("残念！小さいです。");
                    }
                }
            }
        }
        if (!hasGuessedCorrectly) {
            System.out.println("\nゲームオーバー。");
            System.out.println("正解は " + answerNumber + " でした。");
        }
        scanner.close();
    }
}