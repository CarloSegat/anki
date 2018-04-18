package myPackage;

public class Extractor {
	
	private static final String beforeEnglishSentence = "<i>English Sentence:</i> <span style=\"\"\"\">";
	private static final String beforeGermanSentence = "<i>German Sentence:</i><br/> <span style=\"\"\"\">";
	private static final String beforeGermanAudio = "[sound";
	
	private static String buildingString = "";
	
	private static void resetBuildingString(){
		buildingString = "";
	}
	
	private static int getFirstIndexGermanSentence(String singleLineOfText) {
		return getFirstIndexSentence(singleLineOfText, beforeGermanSentence);
	}
	
	private static int getFirstIndexEnglishSentence(String singleLineOfText) {
		return getFirstIndexSentence(singleLineOfText, beforeEnglishSentence);
	}
	
	private static int getFirstIndexGermanRecording(String singleLineOfText) {
		return singleLineOfText.indexOf(beforeGermanAudio);
	}
	
	private static int getFirstIndexSentence(String singleLineOfText, String stringToMatch) {
		int index = singleLineOfText.indexOf(stringToMatch);
		index += stringToMatch.length();
		if(singleLineOfText.charAt(index) == '>') {
			index++;
		}
		return index;
	}
	
	private static String extractTextUntil(String sentenceYouAreInterested, int index, char stopWhenYouFindThis) {
		char c = sentenceYouAreInterested.charAt(index);
		while(c != stopWhenYouFindThis){
			buildingString += c;
			index++;
			c = sentenceYouAreInterested.charAt(index);
		}
		return buildingString;
	}
	
	public static String getEnglishSentence(String singleLineOfText) {
		resetBuildingString();
		int index = getFirstIndexEnglishSentence(singleLineOfText);
		char c = singleLineOfText.charAt(index);
		while(c != '<'){
			buildingString += c;
			index++;
			c = singleLineOfText.charAt(index);
		}
		return buildingString.trim();
	}
	
	public static String getGermanSentence(String singleLineOfText) {
		resetBuildingString();
		int index = getFirstIndexGermanSentence(singleLineOfText);
		extractTextUntil(singleLineOfText, index, '<');
		return buildingString.trim();
	}
	
	public static String getGermanAudioFromGermanSentence(String germanSentence) {
		resetBuildingString();
		int index = getFirstIndexGermanRecording(germanSentence);
		extractTextUntil(germanSentence, index, ']');
		buildingString += ']';
		return buildingString;
	}

}
