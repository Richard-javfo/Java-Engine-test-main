/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trf.test.kotlin;

import trf.api.PairingListener;

/**
 *
 * @author DP
 */
public class PairingListenerImpl implements PairingListener {

    @Override
    public void onStatusUpdate(String message) {
        
    }

    @Override
    public void onError(String error, String technicalDump) {
        System.out.println(error + " " + technicalDump);
    }

    @Override
    public void onPairingCompleted(int count) {
        
    }
    
}
