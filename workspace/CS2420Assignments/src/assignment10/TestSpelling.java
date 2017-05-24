package assignment10;

import java.io.File;
import java.util.ArrayList;

import junit.framework.TestCase;

public class TestSpelling extends TestCase{
	
	protected void setUp() throws Exception {
		super.setUp();	
		
		SpellingFunctions.populateDictionary(new File("WordStats.txt"));
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testDeletion(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Deletion("theyy");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testDeletion2(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Deletion("they");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testTransposition(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Transposition("theyy");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testTransposition2(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Transposition("thye");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testSubstitution(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Substitution("theyy");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testSubstitution2(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Substitution("thet");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testInsertion(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Insertion("theyy");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testInsertion2(){
		ArrayList<StringBuilder> testList = SpellingFunctions.Insertion("the");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testRATF(){
		ArrayList<StringBuilder> testList = SpellingFunctions.run_ALL_the_functions("theyo");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testdictionaryCatch(){
		SpellingFunctions.populateDictionary(new File("serendipidy.txt"));
		}
	
	public void testSetFr(){
		SpellingFunctions.setFr(true);
		assertEquals(true, SpellingFunctions.fr_isActive);
	}
	
	public void testBWSDeletion(){
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Deletion("theyy");
		for(int i=0; i<testList.size(); i++){
		}
	}
	
	public void testBWSTransposition(){
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Transposition("theyy");
		for(int i=0; i<testList.size(); i++){
		}
	}
		
	public void testBWSTransposition2() {
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Transposition("thye");
		for (int i = 0; i < testList.size(); i++) {
		}
	}
	
	public void testBWSSubstitution() {
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Transposition("theyy");
		for (int i = 0; i < testList.size(); i++) {
		}
	}
	
	public void testBWSSubstitution2() {
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Transposition("thet");
		for (int i = 0; i < testList.size(); i++) {
		}
	}
	
	public void testBWSInsertion() {
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Transposition("theyy");
		for (int i = 0; i < testList.size(); i++) {
		}
	}
	
	public void testBWSInsertion2() {
		BestWordSearch.populateDictionary(new File("WordStats.txt"));
		ArrayList<StringBuilder> testList = BestWordSearch.Transposition("thy");
		for (int i = 0; i < testList.size(); i++) {
		}
	}

}
