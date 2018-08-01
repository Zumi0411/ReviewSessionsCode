package api.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CompareDataInTxtFiles {
	
	@Test
	public void findMissingKeys() throws IOException {
		
		List<String> usData = Files.readAllLines(Paths.get("Message_en_US.txt"));
		List<String> spData = Files.readAllLines(Paths.get("Message_es_SP.txt"));
		
		Map<String,String> usMap = new HashMap<>();
		Map<String,String> spMap = new HashMap<>();
		
		for (String pair : usData) {
			usMap.put(pair.split("=")[0].trim(), pair.split("=")[1].trim());
		}
		
		for (String pair : spData) {
			spMap.put(pair.split("=")[0].trim(), pair.split("=")[1].trim());
		}
		
		System.out.println(usMap);
		System.out.println(spMap);
		
		System.out.println("Keys missing in “Messages_en_US.txt”");
		
		for(String key : spMap.keySet()) {
			if(!usMap.containsKey(key)) {
				System.out.println("\"" + key + "\" missing with value \"" + spMap.get(key)+"\"");
			}
		}
		
		System.out.println("Keys missing in “Messages_en_SP.txt”");

		for(String key : usMap.keySet()) {
			if(!spMap.containsKey(key)) {
				System.out.println("\"" + key + "\" missing with value \"" + usMap.get(key)+"\"");
			}
		}
		

	}
	
}
