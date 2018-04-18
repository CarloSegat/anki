package tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.ComparisonFailure;
import myPackage.Extractor;
public class TestExtractor {
	
	String example_01;
	String germanSentence;
	String germanRecording;
	String englishSentence;
	
	@Before
	public void setup()
	{
		example_01 = "<span style=\"\"\"\">auf[sound:rec1408044612.mp3]</span><br><br/> <i>German Sentence:</i><br/> <span style=\"\"\"\">Die Tasse steht auf dem Tisch.[sound:rec1408044618.mp3]</span><br><br/> <i>Rank:</i> <span style=\"\"\"\">17</span>\"	\"<span style=\"\"\"\">on, at, in</span><br><i>(other meanings:</i> <span style=\"\"\"\"></span>)<br><br/> <i>English Sentence:</i> <span style=\"\"\"\">The cup is on the table.</span><br><br/>";	
		germanSentence = "Die Tasse steht auf dem Tisch.";
		germanRecording = "[sound:rec1408044618.mp3]";
		englishSentence = "The cup is on the table.";
	}
	
	@Test
	public void testEnglishSentence()
	{
		assert(Extractor.getEnglishSentence(example_01).equals(englishSentence));
	}
	
	@Test
	public void testGermanSentence()
	{
		assert(Extractor.getGermanSentence(example_01).equals(germanSentence + germanRecording));
	}
	
	@Test
	public void testGermanRecordings()
	{
		assert(Extractor.getGermanAudioFromGermanSentence(Extractor.getGermanSentence(example_01)).equals(germanRecording));
	}


}