package main.arrays_and_hashing;

import main.util.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku implements Medium {
    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }


    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                //row
                Set<Character> rowSet = rows.getOrDefault(i, new HashSet<>());
                if (!rowSet.add(c)) {
                    return false;
                }
                rows.put(i, rowSet);

                //column
                Set<Character> columnSet = columns.getOrDefault(j, new HashSet<>());
                if (!columnSet.add(c)) {
                    return false;
                }
                columns.put(j, columnSet);

                //square
                String squareIndex = i / 3 + String.valueOf(j / 3);
                Set<Character> squareSet = squares.getOrDefault(squareIndex, new HashSet<>());
                if (!squareSet.add(c)) {
                    return false;
                }
                squares.put(squareIndex, squareSet);
            }
        }

        return true;
    }


    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-sudoku/";
    }

    @Override
    public String mySolution() {
        return """
                    public boolean isValidSudoku(char[][] board) {
                                
                        Map<Integer, Set<Character>> rows = new HashMap<>();
                        Map<Integer, Set<Character>> columns = new HashMap<>();
                        Map<Integer, Set<Character>> squares = new HashMap<>();
                                
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                
                                char c = board[i][j];
                                if (Character.getNumericValue(c) == 46) {
                                    continue;
                                }
                                
                                //row
                                Set<Character> rowSet = rows.getOrDefault(i, new HashSet<>());
                                if (Character.isDigit(c) && !rowSet.add(c)) {
                                    return false;
                                }
                                rows.put(i, rowSet);
                                
                                //column
                                Set<Character> columnSet = columns.getOrDefault(j, new HashSet<>());
                                if (Character.isDigit(c) && !columnSet.add(c)) {
                                    return false;
                                }
                                columns.put(j, columnSet);
                                
                                //square
                                int squareIndex = -1;
                                
                                if (squareIndex == -1 && i < 3 && j < 3) {
                                    squareIndex = 0;
                                }
                                if (squareIndex == -1 && i < 3 && j < 6) {
                                    squareIndex = 1;
                                }
                                if (squareIndex == -1 && i < 3 && j < 9) {
                                    squareIndex = 2;
                                }
                                if (squareIndex == -1 && i < 6 && j < 3) {
                                    squareIndex = 3;
                                }
                                if (squareIndex == -1 && i < 6 && j < 6) {
                                    squareIndex = 4;
                                }
                                if (squareIndex == -1 && i < 6 && j < 9) {
                                    squareIndex = 5;
                                }
                                if (squareIndex == -1 && i < 9 && j < 3) {
                                    squareIndex = 6;
                                }
                                if (squareIndex == -1 && i < 9 && j < 6) {
                                    squareIndex = 7;
                                }
                                if (squareIndex == -1 && i < 9 && j < 9) {
                                    squareIndex = 8;
                                }
                                Set<Character> squareSet = squares.getOrDefault(squareIndex, new HashSet<>());
                                if (Character.isDigit(c) && !squareSet.add(c)) {
                                    return false;
                                }
                                squares.put(squareIndex, squareSet);
                            }
                        }
                                
                        return true;
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                    public boolean isValidSudoku(char[][] board) {
                                
                        Map<Integer, Set<Character>> rows = new HashMap<>();
                        Map<Integer, Set<Character>> columns = new HashMap<>();
                        Map<String, Set<Character>> squares = new HashMap<>();
                                
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                
                                char c = board[i][j];
                                if (c == '.') {
                                    continue;
                                }
                                
                                //row
                                Set<Character> rowSet = rows.getOrDefault(i, new HashSet<>());
                                if (!rowSet.add(c)) {
                                    return false;
                                }
                                rows.put(i, rowSet);
                                
                                //column
                                Set<Character> columnSet = columns.getOrDefault(j, new HashSet<>());
                                if (!columnSet.add(c)) {
                                    return false;
                                }
                                columns.put(j, columnSet);
                                
                                //square
                                String squareIndex = i / 3 + String.valueOf(j / 3);
                                Set<Character> squareSet = squares.getOrDefault(squareIndex, new HashSet<>());
                                if (!squareSet.add(c)) {
                                    return false;
                                }
                                squares.put(squareIndex, squareSet);
                            }
                        }
                                
                        return true;
                    }
                """;
    }
}
