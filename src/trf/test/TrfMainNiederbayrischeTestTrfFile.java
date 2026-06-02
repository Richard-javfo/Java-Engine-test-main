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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import trf.api.Pairing;
import trf.api.RankedPlayer;
import trf.api.RankedPlayer.TiebreakEntry;
import trf.api.TournamentPlayer;
import trf.api.TournamentState;
import trf.impl.TRFJavafoPairingProvider;
import trf.tiebreak.Buchholz;
import trf.tiebreak.SonnebornBerger;
import trf.parser.TrfParser;
import trf.test.kotlin.MakeResults;

/**
 *
 * @author DP
 */
public class TrfMainNiederbayrischeTestTrfFile {

    
    private static TournamentState tournament;
    private static TRFJavafoPairingProvider pairingProvider;


    private static  void testGenerateTrfFile() throws FileNotFoundException {

        File outputFileTrf = new File(".\\src\\Niederbayrische-2026-Runde1-regenerated.trf");// Testfile
       OutputStream outputStreamTrf = new FileOutputStream(outputFileTrf);// Testfile
//        File inputFile = new File(".\\src\\testOutput"+count+".trf");
//        InputStream nputStreamTRF = new FileInputStream(inputFile);

        
        
       
        pairingProvider.generateInitialTrf(outputStreamTrf);  // Testfile
        
        

      
        
        

    }

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //         
//
            File inputFile1 = new File(".\\src\\Niederbayrische-2026-Runde1.trf");
            InputStream inputStreamTRF = new FileInputStream(inputFile1);
            tournament = TrfParser.parse(inputStreamTRF);
            
            pairingProvider = new TRFJavafoPairingProvider(tournament.getInfo());

           
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new Buchholz(1, 0));
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new SonnebornBerger(1, 0));
            //tournament.updateRanking();
            
           testGenerateTrfFile();
           
    


        } catch (Exception ex) {
            Logger.getLogger(TrfMainNiederbayrischeTestTrfFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
