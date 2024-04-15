package Konami;

import java.util.Scanner;

public class Komami {

    public static void main(String[] args) {
    int [] konamiCode = {38, 38, 40, 40, 37, 39, 37, 39, 66, 65}; // Teclas: cima, cima, baixo, baixo, esquerda, direita, esquerda, direita, B, A

        int[] userInput = new int[konamiCode.length];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pressione as teclas seguindo o código Konami:");

        for (int i = 0; i < konamiCode.length; i++) {
                userInput[i] = scanner.nextInt();
            }

        if (checkKonamiCode(userInput, konamiCode)) {
                System.out.println("Código Konami ativado! Desbloqueou algo especial!");
            } else {
                System.out.println("Código Konami incorreto. Tente novamente.");
            }

            scanner.close();
        }

        public static boolean checkKonamiCode(int[] userInput, int[] konamiCode) {
            for (int i = 0; i < konamiCode.length; i++) {
                if (userInput[i] != konamiCode[i]) {
                    return false;
                }
            }
            return true;
        }
   }


