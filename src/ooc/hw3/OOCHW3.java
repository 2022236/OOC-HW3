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
     * 
     */
    public static void main(String[] args) {
        Map<String, List<String>> teams = new HashMap<>();

        try (BufferedReader myBR = new BufferedReader(new FileReader("mock-data.csv"))) {
            String line;
            int teamNum = 1;
            List<String> members = new ArrayList<>();

            while ((line = myBR.readLine()) != null) { 
                members.add(line);

                if (members.size() == 5) {
                    teams.put("Team" + teamNum, new ArrayList<>(members));
                    members.clear();
                    teamNum++;
                }
            }
        } catch (IOException e) {
           System.out.println("File access error!");
        }

        // Print the teams and their members
        for (int i = 1; i <= teams.size(); i++) {
            String teamName = "Team" + i;
            System.out.println(teamName + ": " + teams.get(teamName));
        }
    }
}
