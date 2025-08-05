package com.acton.module3.d4Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<PlayerBattingStats> players;

    /**
     * Takes in a comma sperated values file and parses the data.  It takes the data and
     * creates a PlayerBattingStats object and adds it to the players list.  The CSV file
     * must be in the format of:
     * Name,Team,Gamesplayed,At bats, runs, hits, doubles, triples, home runs, rbi's
     * @param file containg the data
     */
    public static void parseCSVData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            String name = splitter[0];
            String team = splitter[1];
            int gamesPlayed = Integer.parseInt(splitter[2]);
            int atBats = Integer.parseInt(splitter[3]);
            int runs = Integer.parseInt(splitter[4]);
            int hits = Integer.parseInt(splitter[5]);
            int doubles = Integer.parseInt(splitter[6]);
            int triples = Integer.parseInt(splitter[7]);
            int homeRunes = Integer.parseInt(splitter[8]);
            int rbis = Integer.parseInt(splitter[9]);
            players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRunes, rbis));
        }

    }

    public static void main(String[] args) {
        players = new ArrayList<>();
        try {
            parseCSVData(new File("Unit 3\\src\\com\\acton\\module3\\d4Sorting\\PlayerData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (PlayerBattingStats player : players) {
            System.out.println(player);
        }

        try {
            PrintWriter writer = new PrintWriter(new File("Unit 3\\src\\com\\acton\\module3\\d4Sorting\\PlayerDataSorted.txt"));
            int[] sortTypes = {PlayerSorter.GAMESPLAYED, PlayerSorter.ATBATS, PlayerSorter.RUNS, PlayerSorter.PERCENTRUNS, PlayerSorter.PERCENTONBASE};
            String[] labels = {"Games Played", "At Bats", "Runs", "Percent Runs (runs/atBats)", "Percent On Base ((hits + doubles + triples)/atBats)"};

            for (int i = 0; i < sortTypes.length; i++) {
                writer.println("==== Sorted by " + labels[i] + " ====");
                ArrayList<PlayerBattingStats> sorted = PlayerSorter.sort(players, sortTypes[i]);
                for (PlayerBattingStats player : sorted) {
                    String string = "";
                    switch(sortTypes[i]) {
                        case PlayerSorter.GAMESPLAYED:
                            string += player.getGames();
                            break;
                        case PlayerSorter.ATBATS:
                            string += player.getAtBats();
                            break;
                        case PlayerSorter.RUNS:
                            string += player.getRuns();
                            break;
                        case PlayerSorter.PERCENTRUNS:
                            string += Math.round((player.getAtBats() > 0 ? (double) player.getRuns() / player.getAtBats() : 0.0) * 100) / 100.0 + "%";
                            break;
                        case PlayerSorter.PERCENTONBASE:
                            string += Math.round((player.getAtBats() > 0 ? (double) (player.getHits() + player.getDoubles() + player.getTriples()) / player.getAtBats() : 0.0) * 100) / 100.0 + "%";
                            break;
                    }
                    writer.printf("%-25s\t%6s\n", player.getName(), string);
                }
                writer.println();
            }

            writer.close();
            System.out.println("Successfully wrote to file.");
        } catch (FileNotFoundException err) {
            System.out.println("Unable to write to file due to error: " + err.getMessage());
        }
    }
}