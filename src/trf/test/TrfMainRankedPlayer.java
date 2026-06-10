package trf.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import trf.api.Pairing;
import trf.api.RankedPlayer;
import trf.api.RankedPlayer.TiebreakEntry;
import trf.api.TournamentState;
import trf.api.TRFJavafoPairingProvider;
import trf.tiebreak.Buchholz;
import trf.tiebreak.SonnebornBerger;
import trf.parser.TrfParser;
import trf.test.kotlin.MakeResults;

/**
 *
 * @author DP
 */
public class TrfMainRankedPlayer {

    static int count;
    private static TournamentState tournament;
    private static TRFJavafoPairingProvider pairingProvider;

    private static void viewNewTable() {
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        List<RankedPlayer> rankedPlayers;
        rankedPlayers = tournament.getLastRankedResults();
        
        for (int i = 0; i < rankedPlayers.size()-43 ; i++) {
            RankedPlayer p = rankedPlayers.get(i);
            out.printf(Locale.US, " %4d %4d   %-33s %4.1f", i+1, p.getElo(), p.getName(), p.points());
            for (TiebreakEntry te : p.tiebreaks()) {
                out.printf(Locale.US, " %5s %4.1f ", te.label(), te.value());
            }
            
        }
    }
    private static void testPairing() throws FileNotFoundException {

        File outputFileTrf = new File(".\\src\\testOutput" + (count) + ".trf");// Testfile
       OutputStream outputStreamTrf = new FileOutputStream(outputFileTrf);// Testfile
//        File inputFile = new File(".\\src\\testOutput"+count+".trf");
//        InputStream nputStreamTRF = new FileInputStream(inputFile);

                
        List<Pairing> pairList = pairingProvider.execPairing("1001aaa");
        MakeResults.pairEntries(pairList);
        pairingProvider.fill(pairList, tournament.getTournamentPlayers());
        
        tournament.updateRanking();
        pairingProvider.generateInitialTrf(outputStreamTrf);  // Testfile
        
        

        count++;

    }

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //         
//
            File inputFile1 = new File(".\\src\\funktioniert.trf");
            InputStream inputStreamTRF = new FileInputStream(inputFile1);
            tournament = TrfParser.parse(inputStreamTRF);
            //tournament.setRankingListener(new ConsoleListener());

            pairingProvider = new TRFJavafoPairingProvider(tournament.getInfo());

            tournament.getTournamentInfo().listTiebreaksStrategies().add(new Buchholz(0, 0));
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new Buchholz(1, 0));
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new Buchholz(1, 1));
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new SonnebornBerger(0, 0));
            
            tournament.updateRanking();
          

          
                testPairing();
                     
            
     

        } catch (Exception ex) {
            Logger.getLogger(TrfMainRankedPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
