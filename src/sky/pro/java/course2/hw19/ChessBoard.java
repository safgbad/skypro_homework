package sky.pro.java.course2.hw19;

import java.util.ArrayList;

public class ChessBoard {
    public static void main(String[] args) {
        printChessBoard();
    }

    public static void printChessBoard() {
        ArrayList<ArrayList<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, (i + j) % 2 == 0 ? "◯" : "●");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + (j < 7 ? " " : ""));
            }
            System.out.println();
        }
    }
}
