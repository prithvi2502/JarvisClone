package engineUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Search {
	
	public String simpleSearch(String input){
		String url = "http://en.wikipedia.org/wiki/" + input;
		String returnIntroTxt = null;
		Document document;
		try{
			document = Jsoup.connect(url).get();
			Elements paraEle = document.select("p");
			Element firstParagraph = paraEle.get(0);
			returnIntroTxt = firstParagraph.text();
			return returnIntroTxt;
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return returnIntroTxt;
	}
	public Elements complexGoogleSearchLinkRet(String input) throws UnsupportedEncodingException, IOException{
		//This method algorithm needs testing
		String google = "http://www.google.com/search?q=";
		String charset= "UTF-8";
		String agent = "ExampleBot 1.0 (+http://example.com/bot)"; 
		String[] urlStorage = new String[10];
		String[] titleStorage = new String[10];
		int i = 0 ;
		Elements links = Jsoup.connect(google + URLEncoder.encode(input, charset)).userAgent(agent).get().select("li.g>h3>a");
		for (Element link : links) {
			String title = link.text();
		    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
		    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

		    if (!url.startsWith("http")) {
		        continue; // Ads/news/etc.
		    }
		    
		    urlStorage[i] = url;
		    titleStorage[i] = title;
		    i++;
		}
		
		return process(urlStorage, titleStorage);
	}
	private Elements process(String urlStorage[], String titleStorage[]) throws IOException {
		// TODO Auto-generated method stsub
		String urlPrimary = urlStorage[0];
		String titlePrimary = titleStorage[0];
		Elements returnFunc = null;
		if(titlePrimary.substring(0, 4).equalsIgnoreCase("list")){
			returnFunc = complexWikiListExtractionSearch(urlPrimary);
		}else{
			//create a method to get the jist of whatever is in this page. like a paragraph extraction method
			otherParagraphExtractor(urlPrimary);
		}
		//needs to be finished after list and paragraph testing.
		return returnFunc;
	}
	private void otherParagraphExtractor(String urlPrimary) {
		// TODO this method will say only the first paragraph of all the content on this page but, it will display all the text on the app. This rule goes for everything being extracted for search. We then give the person the option to have jarvis speak the rest.
	}
	public Elements complexWikiListExtractionSearch(String input) throws IOException{
		
		Document document;
		document = Jsoup.connect(input).get();
        Elements lists = document.select("td");
        
		return lists;
	}
	public Elements complexWikiStringExtractionSearch(String input) throws IOException{
		String url = "http://en.wikipedia.org/wiki/" + input;
		
		Document document;
	
		document = Jsoup.connect(url).get();
		Elements paraEle = document.select("p");
			
	
		return paraEle;
	}
	@SuppressWarnings("null")
	public Elements complexWikiImageExtractionSearch(String input) throws IOException{
		String url ="http://en.wikipedia.org/wiki/" + input;

		Document document;
		document = Jsoup.connect(url).get();
		Elements paraEle = document.select("p");
			
		return paraEle;
	}
	public Elements complexWikiDataOrGraphSearch(String input) throws IOException{
		//filter the image extraction method to look for math formulas and graphs
		String url = "http://en.wikipedia.org/wiki/" + input;
		Document document;
		document = Jsoup.connect(url).get();
		Elements mathElements = document.select("img");
		//in math articles almost all equations are related to math stuffs so this is fine
		return mathElements;
	}
	public String[] fullFeatureUpload(String input){
		searchBuild $b = new searchBuild();
		String[] build = $b.getFullBuild(); //at this point this will just store all the images and texts, in this function with transport you to another  activity where all the information will be displayed. so it will be liek (psuedo code) goto activity ShowData. this source code for this will be everything that is in the "searchBuild" class.
		return build;
	}
}
