public class Hteam {
    public int point = 0,ag= 0,yg= 0,avg= 0,match= 0,win= 0,lose= 0,draw= 0;

    public String name = null;
    public Hteam(String name){
        this.name = name;
    }
    public void golat(int gol){
        this.ag += gol;
    }
    public void golye(int gol){
        this.yg += gol;
    }
    public void macoyna(){
        this.match += 1;
    }
    public void winal(){
        this.win += 1;
    }
    public void berabere(){
        this.draw += 1;
    }
    public void loseal(){
        this.lose += 1;
    }
    public void pointcal(){this.point = win*2 + draw;}
    public void avgcal(){this.avg = ag - yg;}

}
