package breaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GetAuthorArticles {
	
	
	public ArrayList<String> getMovieTitle(String contentString) {
		
		String response;
		int startPage=1;
		int total_pages=Integer.MAX_VALUE;
		List <String> movieTitles = new ArrayList<String>();
		while(startPage <=total_pages)
		{
			try
			{
				//System.out.println(startPage);
				URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search?Title="+contentString+"&page="+startPage);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while((response =in.readLine())!=null)
				{
					JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
					total_pages=convertedObject.get("total_pages").getAsInt();
					JsonArray data= convertedObject.getAsJsonArray("data");
					for(int i=0; i<data.size();i++)
					{
						String title = data.get(i).getAsJsonObject().get("Title").getAsString();
						movieTitles.add(title);
					}
				}
				in.close();
				startPage++;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("size of array ="+movieTitles.size());
		return (ArrayList<String>) movieTitles;
		
	}

	public static void main(String[] args) {
		
		GetAuthorArticles get = new GetAuthorArticles();
		System.out.println(get.getMovieTitle("road"));
		
		
	}

}
