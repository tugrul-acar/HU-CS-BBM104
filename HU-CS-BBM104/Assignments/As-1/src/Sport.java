public class Sport {
    private final int sportid;
    private final int calorie;
    private final String name;
    public Sport(int sportid,String name,int calorie){
        this.sportid = sportid;
        this.name = name;
        this.calorie = calorie;
    }
    public String getname(){
        return this.name;
    }
    public int getSportidid(){
        return this.sportid;
    }
    public int getCalorie(){
        return this.calorie;
    }
}
