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
        int attempt = 1;

        while (attempt <= maxAttempts) {
            System.out.println("\n----- " + attempt + "回目の挑戦 -----");
            System.out.print("数を入力してください（2桁の正の整数）: ");

            if (!scanner.hasNextInt()) {
                System.out.println("⚠ 数字を入力してください。");
                scanner.next(); // 無効な入力を読み飛ばす
                continue;
            }

            int userGuess = scanner.nextInt();

            if (userGuess < 10 || userGuess > 99) {
                System.out.println("⚠ 入力は2桁の正の整数のみです。もう一度入力してください。");
                continue; // チャンス消費なし
            }

            // 判定処理
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
            attempt++;
        }

        if (!hasGuessedCorrectly) {
            System.out.println("\nゲームオーバー。");
            System.out.println("正解は " + answerNumber + " でした。");
        }

        scanner.close();
    }
}
