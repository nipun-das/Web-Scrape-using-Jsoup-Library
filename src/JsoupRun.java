import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupRun {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.imdb.com/india/top-rated-indian-movies/").timeout(6000).get();
            Elements body = doc.select("tbody.lister-list");

            for (Element e : body.select("tr")) {

                String title = e.select("td.posterColumn img").attr("alt");
                String rating = e.select("td.ratingColumn.imdbRating").text().trim();

                System.out.println("Movie : " + title + "\n" + "Rating : " + rating);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

