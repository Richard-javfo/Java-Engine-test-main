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
import java.util.logging.Level;
import java.util.logging.Logger;
import trf.impl.TournamentState;
import trf.api.TRFJavafoPairingProvider;
import trf.tiebreak.Buchholz;
import trf.tiebreak.SonnebornBerger;
import trf.parser.TrfParser;

/**
 *
 * @author DP
 */
public class MainFromTrfFile2TrfFile {

    
    private static TournamentState tournament;
    private static TRFJavafoPairingProvider pairingProvider;
    static File inputFile1 = new File(".\\src\\AcceleratedTRFXSample2.txt");
    static     File outputFileTrf = new File(".\\src\\AcceleratedTRFXSample2-regenerated.trf");// Testfile

    private static  void testGenerateTrfFile() throws FileNotFoundException {

      
       OutputStream outputStreamTrf = new FileOutputStream(outputFileTrf);// Testfile
        pairingProvider.generateInitialTrf(outputStreamTrf);  // Testfile
    

    }

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //         
//
            
            InputStream inputStreamTRF = new FileInputStream(inputFile1);
            tournament = TrfParser.parse(inputStreamTRF);
            
            pairingProvider = new TRFJavafoPairingProvider(tournament.getInfo());

           
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new Buchholz(1, 0));
            tournament.getTournamentInfo().listTiebreaksStrategies().add(new SonnebornBerger(1, 0));
            //tournament.updateRanking();
            
           testGenerateTrfFile();
           
    


        } catch (Exception ex) {
            Logger.getLogger(MainFromTrfFile2TrfFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
