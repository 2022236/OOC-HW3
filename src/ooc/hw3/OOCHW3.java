package ooc.hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OOCHW3 {
    /**
     * Student number: 2022236 
     * I got inspiration from Sam and Ken to do few parts of the code.
     * I also had a problem because I still learning to commit, make a repository, so I did wrong the name 
     * could not find on Github. I figured it out but I do not have all the commits from when I was 
     * structuring the code. My apologies. 
     * Github link https://github.com/2022236/HW3OOC
     * @param args
     */
    public static void main(String[] args) {
        // Starting the code with Map, one of the Java Collections Framework. 
        // Choosing to start with `Map` seemed like a better idea since `Map` allows to put a key and value which would be 
        // a String to teams and a value representating the list of team members as Sam resquested
        Map<String, List<String>> teams = new HashMap<>();
        // try-catch also sounded a good idea if some error happens to open the file
        try (BufferedReader myBR = new BufferedReader(new FileReader("mock-data.csv"))) {
            String line;
            int teamNum = 1;
            // A array list to do the members
            List<String> members = new ArrayList<>();
           // A while to read all the lines an right after calling array list to add the lines  
            while ((line = myBR.readLine()) != null) { 
                members.add(line);
                // If statement to do a limit on the array, 5 persons per team and ++ to keep counting 
                if (members.size() == 5) {
                    teams.put("Team" + teamNum, new ArrayList<>(members));
                    // The members.clear() do not let repeat a person and make sure it is just 5  
                    members.clear();
                    teamNum++;
                }
            }
        } catch (IOException e) {
           System.out.println("File access error!");
        }
        // A for to go and print the teams starting from one getting the `Map` size 
        for (int i = 1; i <= teams.size(); i++) {
            String teamName = "Team" + i;
            System.out.println(teamName + ": " + teams.get(teamName));
        }
    }
}