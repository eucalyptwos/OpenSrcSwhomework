package ku.opensrcsw._midterm;


import org.json.simple.*;
import org.json.simple.parser.*;
import midterm.problem2.RegularExpression;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App 
{
	public static void main(String[] args) {
		RegularExpression re = new RegularExpression();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the keyword you are looking for: ");
		String search = s.nextLine();
		JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;
		try {
			jsonObject = (JSONObject)jsonParser.parse(new FileReader("d:\\midterm.json"));
		
        JSONArray infoArray = (JSONArray) jsonObject.get("poem");
        for(int i=0;i<infoArray.size();i++)
        {
        	JSONObject itemObject =(JSONObject)infoArray.get(i);
        	if (re.check((String) itemObject.get("item"), search))	
        		System.out.println("item "+i+": "+itemObject.get("item"));
        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
        }		
	}
