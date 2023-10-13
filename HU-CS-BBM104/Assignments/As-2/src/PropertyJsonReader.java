import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class PropertyJsonReader {
    private ArrayList<Land> land1 = new ArrayList<>();   //this command make land ,company and railroads arraylist
    private ArrayList<Railroads> railroads1 = new ArrayList<>();
    private ArrayList<Company> companie1 = new ArrayList<>();
    public PropertyJsonReader(){
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("property.json")){
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray Land = (JSONArray) jsonfile.get("1");

            for(Object i:Land){

                land1.add(new Land(Integer.parseInt((String)((JSONObject)i).get("id")),(String)((JSONObject)i).get("name"),Integer.parseInt((String)((JSONObject)i).get("cost"))));
            }
            JSONArray RailRoad = (JSONArray) jsonfile.get("2");
            for(Object i:RailRoad){
                railroads1.add(new Railroads(Integer.parseInt((String)((JSONObject)i).get("id")), (String)((JSONObject)i).get("name"), Integer.parseInt((String)((JSONObject)i).get("cost"))));

            }

            JSONArray Company = (JSONArray) jsonfile.get("3");
            for(Object i:Company){
                companie1.add(new Company(Integer.parseInt((String)((JSONObject)i).get("id")),(String)((JSONObject)i).get("name"),Integer.parseInt((String)((JSONObject)i).get("cost"))));

            }

        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Company> getCompanie1() {
        return companie1;
    }       //with these part ı take arraylists

    public ArrayList<Land> getLand1() {
        return land1;
    }

    public ArrayList<Railroads> getRailroads1() {
        return railroads1;
    }
}