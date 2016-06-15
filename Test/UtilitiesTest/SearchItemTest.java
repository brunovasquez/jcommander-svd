/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitiesTest;

import Utilities.SearchItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * @version 1.0
 * @since   2016-06-08
 * @author vania huayta
 */
public class SearchItemTest {
    @Test
    public void testSearchFileInDirectoryUsingAsteric() {
        List<String> items = new ArrayList<>();
        List<String> result = SearchItem.searchUsingWilcards("*.java", new File("."), items);
        
        assertFalse(result.isEmpty());
    }
    
    @Test
    public void testSearchFileInDirectoryUsingQuestionMark() {
        List<String> items = new ArrayList<>();
        List<String> result = SearchItem.searchUsingWilcards("*.?ava", new File("."), items);
        
        assertFalse(result.isEmpty());
    }
}
