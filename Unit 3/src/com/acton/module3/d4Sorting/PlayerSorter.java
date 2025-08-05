package com.acton.module3.d4Sorting;

import java.util.ArrayList;

/**
 * Class that takes in an ArrayList and sorts the players by various criteria
 * using a mergesort.
 */

public class PlayerSorter {
    //The following fields are the different sort types:
    public static final int GAMESPLAYED = 0;
    public static final int ATBATS = 1;
    public static final int RUNS = 2;
    public static final int PERCENTRUNS = 3; // Calculated by: runs/atBats
    public static final int PERCENTONBASE = 4; // Calculated by (hits + doubles + triples) / atBats

    /**
     * This method is an interface that allows the sorting of a player given based on
     * certain criteria.  There are 5 options to sort a player which are by Games played,
     * at bats, runs, percent runs, percent on base.
     * The sort is in descending order (Largest to smallest)
     * This method calls one of 5 private methods that will do the sort based on the chosen criteria.
     * @param list List of players containing the statistics
     * @param sortType How the user wants the players sorted.  The value should be chosed from one of
     *                 the 5 static fields from the class.
     * @return An ArrayList that is sorted according to the users specification.
     */
    public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> list, int sortType) {
        return mergeSort(list, sortType);
    }

    private static ArrayList<PlayerBattingStats> mergeSort(ArrayList<PlayerBattingStats> list, int sortType) {
        if (list.size() <= 1) return list;
        int middle = list.size() / 2;
        ArrayList<PlayerBattingStats> left = new ArrayList<>(list.subList(0, middle));
        ArrayList<PlayerBattingStats> right = new ArrayList<>(list.subList(middle, list.size()));
        left = mergeSort(left, sortType);
        right = mergeSort(right, sortType);
        return merge(left, right, sortType);
    }

    private static ArrayList<PlayerBattingStats> merge(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right, int sortType) {
        ArrayList<PlayerBattingStats> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            PlayerBattingStats player1 = left.get(i);
            PlayerBattingStats player2 = right.get(j);
            if (compare(player1, player2, sortType)) {
                merged.add(player1);
                i++;
            }
            else {
                merged.add(player2);
                j++;
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }

    private static boolean compare(PlayerBattingStats player1, PlayerBattingStats player2, int sortType) {
        switch (sortType) {
            case GAMESPLAYED:
                return player1.getGames() >= player2.getGames();
            case ATBATS:
                return player1.getAtBats() >= player2.getAtBats();
            case RUNS:
                return player1.getRuns() >= player2.getRuns();
            case PERCENTRUNS:
                return (player1.getAtBats() > 0 ? (double) player1.getRuns() / player1.getAtBats() : 0.0) >= (player2.getAtBats() > 0 ? (double) player2.getRuns() / player2.getAtBats() : 0.0);
            case PERCENTONBASE:
                return (player1.getAtBats() > 0 ? (double) (player1.getHits() + player1.getDoubles() + player1.getTriples()) / player1.getAtBats() : 0.0) >= (player2.getAtBats() > 0 ? (double) (player2.getHits() + player2.getDoubles() + player2.getTriples()) / player2.getAtBats() : 0.0);
            default:
                throw new IllegalArgumentException("Invalid sort type");
        }
    }


}