import java.util.ArrayList;

public class Person {
    private final int personid;
    private final int weight;
    private final int height;
    private final int dateofbirth;
    private double calorieneed;
    private final String name;
    private final String gender;
    private int gainedcalorie,losedcalorie;
    public Person(int personid,String name,String gender,int weight,int height,int dateofbirth ){
        this.personid = personid;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.dateofbirth = dateofbirth;
        if (this.gender.equals("male")) {
            this.calorieneed = 66+ 13.75*weight+5*height-6.8*(2022-dateofbirth);
        }
        if (this.gender.equals("female")) {
            this.calorieneed = 665+ 9.6*weight+1.7*height-4.7*(2022-dateofbirth);
        }

    }
    public int getPersonid(){
        return this.personid;
    }
    public String getname(){
        return this.name;
    }
    public String getGender(){
        return this.gender;
    }
    public int getWeight(){
        return this.weight;
    }
    public int getHeight(){
        return this.height;
    }
    public int getDateofbirth(){
        return this.dateofbirth;
    }
    public long getCalorieneed(){ return Math.round(this.calorieneed);}
    public int getGainedcalorie(){ return this.gainedcalorie;}
    public int getLosedcalorie(){ return this.losedcalorie;}
    public void calculategained(int calorie,int porsion){this.gainedcalorie += porsion*calorie;}
    public void calculatelosed(int calorie,int duration){this.losedcalorie += duration*calorie/60;}
}
