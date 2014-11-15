package engineUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class s2 {

	public String stageTwo(boolean b, String[] split) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		
			if(split[1].equalsIgnoreCase("how")){
				
			}else if(split[1].equalsIgnoreCase("why")){ 
				whyClause();
			}else if(split[1].equalsIgnoreCase("what")){
				return whatClause(split);
			}else if(split[1].equalsIgnoreCase("can")){
				canClause();
			}else if(split[1].equalsIgnoreCase("when")){
				whenClause();
			}else if(split[1].equalsIgnoreCase("where")){
				whereClause();
			}else if(split[1].equalsIgnoreCase("who")){
				return whoClause(split);
			}else if(split[1].equalsIgnoreCase("which")){
				return whatClause(split);
			}else if(split[1].equalsIgnoreCase("give")){
				giveClause(split);
			}
		return null;
	}

	private String giveClause(String[] split){
		if(split[2].equalsIgnoreCase("me")){
			if(split[3].equalsIgnoreCase("the")){
				if(split[4].equalsIgnoreCase("time")){
					Calendar cal = Calendar.getInstance();
					cal.getTime();
					int swag;
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					return "The time is " + sdf.format(cal.getTime());
				}
			}
		}
		return null;
	}
	private void whichClause() {
		// TODO Auto-generated method stub
		
	}

	private String whoClause(String[] split) {
		// TODO Auto-generated method stub
		
	for(int i=0;i<split.length; i++){
		if(split[i].equalsIgnoreCase("is") || split[i].equalsIgnoreCase("are")){
			if(i+1 == split.length-1){
				//if only one word exists after is or are
				return conductSearch(split[i+1]);
			}else{
				String finalString = "";
				for(int j=i+1; j<split.length; j++){
					finalString += split[j] + " ";
				}
				return conductSearch(finalString);
			}
		}
	}
		
		return null;
	}
	private String conductSearch(String input){
		Search search = new Search();
		String result = search.simpleSearch(input);
		return result;
	}
	private void whereClause() {
		// TODO Auto-generated method stub
		//map section
		
		//normal googlecomplexsearch section
	}

	private void whenClause() {
		// TODO Auto-generated method stub
		
	}

	private void canClause() {
		// TODO Auto-generated method stub
		
	}

	private String whatClause(String[] split) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		/*if(split[2].equalsIgnoreCase("is") && split[].length < 6){
			if(split[3].equalsIgnoreCase("the")){
				if(split[4].equalsIgnoreCase("time")){
					Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			    	return "The time is " + sdf.format(cal.getTime());
			    	
				}
			}
		}else if(split[6].length > 5){
			if(split[3].equalsIgnoreCase("the")){
				if(split[4].equalsIgnoreCase("time")){
			    	if(split[5].equalsIgnoreCase("in")){
			    		return "The time in "+ split[6] + " is " + getTimeOtherCountry(split[6]);
			    	}	
				}
			}
		}*/

		for(int i=0; i < split.length; i++){
			if(split[i].equalsIgnoreCase("time") || split[i].equalsIgnoreCase("timezone")){
				if(i != split.length-1 && (split[i+1].equalsIgnoreCase("in") || split[i+1].equalsIgnoreCase("of"))){
					if(i+2 == split.length-1){
						return getTimeOtherCountry(split[i+2]);
					}else{
						
						return getTimeOtherCountry(split[i+2] + " " + split[i+3]);
					}
					
				}else{
					Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			    	return "The time is " + sdf.format(cal.getTime());
				}
			}else if(split[i].equalsIgnoreCase("name") || split[i].equalsIgnoreCase("call")){
				if(i == split.length-1 && (split[i-1].equals("your") || (split[i-1].equalsIgnoreCase("you're")))){
					return "Hello my name is Ember";
				}else if(split[i+1].equals("you")){
					return "You can call me Ember";
				}
			}else{
				Search $s = new Search();
				String input = null;
				for(int i1=0; i1<split.length; i1++){
					input += split[i1] + " ";
				}
				Elements elements = $s.complexGoogleSearchLinkRet(input);
				return elements.get(3).text();
				/*=String google = "http://www.google.com/search?q=";
				String charset= "UTF-8";
				String agent = "ExampleBot 1.0 (+http://example.com/bot)"; 
				String[] urlStorage = new String[10];
				String[] titleStorage = new String[10];
				int i1 = 0 ;
				Elements links = Jsoup.connect(google + URLEncoder.encode(input, charset)).userAgent(agent).get().select("li.g>h3>a");
				for (Element link : links) {
					String title = link.text();
				    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
				    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

				    if (!url.startsWith("http")) {
				        continue; // Ads/news/etc.
				    }
				    
				    urlStorage[i1] = url;
				    titleStorage[i1] = title;
				    i1++;
				}
				String urlPrimary = urlStorage[0];
				String titlePrimary = titleStorage[0];
				Elements returnFunc = null;
				if(titlePrimary.substring(0, 4).equalsIgnoreCase("list")){
					
					Document document;
					document = Jsoup.connect(urlStorage[0]).get();
			        Elements lists = document.select("td");
			        
					return lists.get(3).text();
				}else{
					//create a method to get the jist of whaterver is in this page. like a paragraph extraction method
					return "no";
				}*/
			}
		}
		
		return null;
	}

	private void whyClause() {
		// TODO Auto-generated method stub
		
	}

	public void stageTwo(String[] split) {
		// TODO Auto-generated method stub
		
	}

	public String getTimeOtherCountry(String input){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone(input));

		return "Date and time in " + input + ": " + df.format(date);
		
	}
}
