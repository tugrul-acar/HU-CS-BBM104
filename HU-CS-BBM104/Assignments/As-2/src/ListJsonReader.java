import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class ListJsonReader{
    private final ArrayList<String> chanceListarray = new ArrayList<>();
    private final ArrayList<String> communityChestListarray = new ArrayList<>();
    public ListJsonReader(){
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("list.json")){
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray chanceList = (JSONArray) jsonfile.get("chanceList");


            for(Object i:chanceList){
                chanceListarray.add(((String)((JSONObject)i).get("item")));
            }
            JSONArray communityChestList = (JSONArray) jsonfile.get("communityChestList");

            for(Object i:communityChestList){
                communityChestListarray.add(((String)((JSONObject)i).get("item")));
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getChanceListarray() {
        return chanceListarray;
    }

    public ArrayList<String> getCommunityChestListarray() {
        return communityChestListarray;
    }
}

