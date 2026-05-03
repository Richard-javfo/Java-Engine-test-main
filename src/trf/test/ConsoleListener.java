/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trf.test;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import trf.api.RankedPlayer;
import trf.api.RankingUpdateListener;

/**
 *
 * @author DP
 */
public class ConsoleListener implements RankingUpdateListener {

    @Override
    public void onRankingUpdated(List<RankedPlayer> rankedPlayers) {
        
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        System.out.println("After Round " + rankedPlayers.getFirst().currentRound());
        for (int i = 0; i < rankedPlayers.size() ; i++) {
            RankedPlayer p = rankedPlayers.get(i);
            out.printf(Locale.US, " %4d %4d   %-33s %4.1f", i+1, p.getElo(), p.getName(), p.points());
            for (RankedPlayer.TiebreakEntry te : p.tiebreaks()) {
                
                out.printf(Locale.US, " %5s %4.1f ", te.label(), te.value());
            }
            
        }
    }
    
}
