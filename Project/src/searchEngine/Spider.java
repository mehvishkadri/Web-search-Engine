package searchEngine;
import java.io.IOException;

public class Spider {

	public Spider() {
		// TODO Auto-generated constructor stub
	}
	
	public static void GetData() throws IOException {
		
		String[] startURLs = new String[] {
				"https://www.uwindsor.ca/humanresources/", 
				"http://apps.uwindsor.ca/uwincpb/jsp/searchExpertWithSuggestion.jsp?key=I",
				"https://docs.oracle.com/javase/tutorial/",
				"https://blackboard.uwindsor.ca/?elqTrackId=b6d1d34789d946b09fe4ca005e1d198d&elq=00000000000000000000000000000000&elqaid=594&elqat=2&elqCampaignId=&elqcst=272&elqcsid=43",
				"http://ask.uwindsor.ca/app/ask",
				"https://twitter.com/intent/tweet/?&url=https%3A%2F%2Fwww.uwindsor.ca%2Fcontact"
		};
		
		String[] siteName = new String[] {"uwindsor", "apps", "Oracle", "blackboard", "ask", "twitter"};
		
		
		for(int i=0;i<startURLs.length;i++)
		{
			Web_crawler crawler = new Web_crawler(startURLs[i],siteName[i]);
			crawler.start();
		}
		
	}

}
