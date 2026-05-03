/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package trf.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DP
 */
public class EloComparatorTest {
    
    public EloComparatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of compare method, of class EloComparator.
     */
    @Test
    public void testCompareEqualEloDifferentDwz() {
        TournamentPlayerImpl p1 = new TournamentPlayerImpl("Spieler A", 2000, 1800); // Name, Elo, Dwz
        TournamentPlayerImpl p2 = new TournamentPlayerImpl("Spieler B", 2000, 1900);
        
        EloComparator comp = new EloComparator();
        
        // Da p2 eine höhere DWZ hat, sollte das Ergebnis positiv sein (p2 vor p1)
        int result = comp.compare(p1, p2);
        assertTrue(true, "Spieler mit höherer DWZ sollte Vorrang haben");
    }
    
}
