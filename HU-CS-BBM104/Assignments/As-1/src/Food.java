public class Food {
    private final int foodid;
    private final int calorie;
    private final String name;
    public Food(int foodid,String name,int calorie){
        this.foodid = foodid;
        this.name = name;
        this.calorie = calorie;
    }
    public String getname(){
        return this.name;
    }
    public int getFoodid(){
        return this.foodid;
    }
    public int getCalorie(){
        return this.calorie;
    }

}
