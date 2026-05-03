/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trf.test.kotlin;

import java.util.List;
import trf.api.Pairing;

/**
 *
 * @author DP
 */
public class MakeResults {
    
    public  static void pairEntries(List<Pairing> pairList){
        
        for(Pairing pair:pairList){
            if(pair.whiteRound().opponentStartRank!=0)
                pair.whiteRound().result='1';
            
            if(pair.blackRound()!=null)
                pair.blackRound().result='0';
            
        }
    }
    
}
