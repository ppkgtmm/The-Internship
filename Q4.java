import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q4
{
    public static int[] getIndex(String[] converted,ArrayList<String> original)
    {
        int[] index = new int[converted.length];
        for(int i=0;i<converted.length;i++)
        {
            index[i] = original.indexOf(converted[i]);
        }
        return index;
    }
    public static void main(String[] arguments)
    {

        try {
            ArrayList<String> companyies = new ArrayList<>();
            ArrayList<String> description = new ArrayList<>();
            String content = null;
            URLConnection connection = null;
            connection = new URL("https://theinternship.io/").openConnection();
            Scanner scanner = null;
            scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            Document doc =  Jsoup.parse(content);
            Elements urls = doc.select("div.partner img[src]");
            for(Element company: urls)
            {
                companyies.add(company.attr("src"));
            }
            Elements descriptions = doc.select("span.list-company");
            for(Element des: descriptions)
            {
                description.add(des.text());
            }
            Object[] desArray = description.toArray();
            String[] descript = Arrays.copyOf(desArray, desArray.length, String[].class);
            Arrays.sort(descript, (x, y) -> Integer.compare(x.length(),y.length()));
            int[] index = Q4.getIndex(descript,description);
            for (int value : index) {
                System.out.println(companyies.get(value));
            }
            scanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
