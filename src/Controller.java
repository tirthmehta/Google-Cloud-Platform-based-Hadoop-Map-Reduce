import java.util.*;



import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
public class Controller {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 String crawlStorageFolder = "data/crawl";
		 int numberOfCrawlers = 7;
		 CrawlConfig config = new CrawlConfig();
		 config.setCrawlStorageFolder(crawlStorageFolder);
		 
		 //SETTING THE INNER CONFIGURATIONS
		 config.setMaxDepthOfCrawling(16);
		 config.setMaxPagesToFetch(30);
		 
		 
		 PageFetcher pageFetcher = new PageFetcher(config);
		 RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		 RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		 CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
		
		 String givenurl="http://www.latimes.com/";
		 controller.addSeed(givenurl);
		 controller.start(MyCrawler.class,numberOfCrawlers);
		 
	}

}

