public class Vteam {
    public int point = 0,ag= 0,yg= 0,avg= 0,match= 0,win= 0,lose= 0,draw= 0;
    public int uc=0,iki=0,bir =0,sifir =0;
    public String name = null;
    public Vteam(String name){
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
    public void loseal(){
        this.lose += 1;
    }
    public void pointcal(){this.point = 3*uc + iki*2 +bir;}
    public void adduc(){
        this.uc += 1;
    }
    public void addiki(){
        this.iki += 1;
    }
    public void addbir(){
        this.bir += 1;
    }
    public void addsifir(){
        this.sifir += 1;
    }

    public void avgcal(){this.avg = ag - yg;}
}
