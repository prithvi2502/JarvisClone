import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Random;



import engineUtil.s2;


public class DivRootTwo {

	/**
	 * @param args
	 */
	s2 $s2 = new s2();
	public String commonPhrs(String $cmdIn){
		String result = null;
		if($cmdIn.equalsIgnoreCase("Hello")){
			result = "Hello Prith";
		}else if($cmdIn.equalsIgnoreCase("ember tell me about yourself") || $cmdIn.equalsIgnoreCase("tell me something about you")){
			result = "I am a first gen Intelligent AI built to assist humans in thier work. I was built using the Maverick Engine and I am currently running of four core machine learing engine.";
		}else if($cmdIn.equalsIgnoreCase("how are you") || $cmdIn.equalsIgnoreCase("how are you doing")){
			int prob_1 = probalistic();
			switch(prob_1){
				case 0:
					result = "My systems are running fine";
					break;
				case 1:
					result = "I am doing great";
					break;
				case 2:
					result = "Just fine";
					break;
				case 3:
					result = "I am ready to answer your requests sir";
					break;
				case 4:
					result = "I am doing fine";
					break;
				case 5:
					result = "Good sir";
					break;
				case 6:
					result = "All systems are in check and running fine";
					break;
				case 7:
					result = "Great sir";
					break;
				default:
					result = "My systems are running fine";
			}
			
		}else if($cmdIn.equalsIgnoreCase("you are very smart") || $cmdIn.equalsIgnoreCase("you are quite smart") || $cmdIn.equalsIgnoreCase("ember you are very smart") || $cmdIn.equalsIgnoreCase("you are smart") ||$cmdIn.equalsIgnoreCase("ember you are smart") || $cmdIn.equalsIgnoreCase("ember you are quite smart")){
			result="you are quite smart yourself";
		}else if($cmdIn.equalsIgnoreCase("what is your name")){
			result="My name is Ember";
		}else if($cmdIn.equalsIgnoreCase("thank you")){
			result="Your Welcome";
		}else{
		
			//analyze further: AlgorithimTagNameSort
			return null;
		}
		return result;
	}
	public int probalistic(){
		Random randomGenerator = new Random();
		int prob = randomGenerator.nextInt(10);
		return prob;
	}
	public String[] splitsource(String $cmdIn){
		StringTokenizer st = new StringTokenizer($cmdIn, " ");  
		int length = st.countTokens();  
		String[] strArr = new String[length];  
		for(int i=0;i<length;i++){  
			strArr[i]=st.nextToken();  
		} 
		return strArr;
	}

	public String process(String[] $split) throws UnsupportedEncodingException, IOException{
		String $result = null;
		
		String $firstword = $split[0];
		
		if($firstword.equals("Ember") || $firstword.equals("ember")){
			$result = $s2.stageTwo(true,$split);
			return $result;
		}else{
			$s2.stageTwo($split);
		}
		
		
		return $result;
	}
	public String commonPhrs1(String swag){
		String result = "";
		
		StringTokenizer st = new StringTokenizer(swag, " ");  
		int length = st.countTokens();  
		String[] strArr = new String[length];  
		for(int i=0;i<length;i++){  
		strArr[i]=st.nextToken();  
		} 
		for(int i=0; i<strArr.length; i++){
			result = result + strArr[i];
		}
		return result;
	}
	public String TagNameSort(String input){
		String result = "";
		ArrayList<String> araryInput = null;
		String[] arrayVer = splitsource(input);
		for(String a: arrayVer){
			araryInput.add(a);
		}
		common.process(araryInput);
		return result;
	}

}
