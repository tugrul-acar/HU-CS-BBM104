import java.util.ArrayList;
import java.util.Arrays;

public class Football_league {

    public static ArrayList<Fteam> teams1 = new ArrayList<Fteam>();
    public static ArrayList<String> taketeamnames(ArrayList<String> fmatch){
        ArrayList<String> teams = new ArrayList<>();
        for (String s : fmatch) {
            String[] a = s.split("\t");
            if (! teams.contains(a[1])){
                teams.add(a[1]);
            }
            if (! teams.contains(a[2])){
                teams.add(a[2]);
            }
        }

        return teams;
    }

    public static ArrayList<Fteam> addfteams(ArrayList<String> teamnames){

        for(int i= 0;i<4;i++){
            teams1.add(new Fteam(teamnames.get(i))) ;
        }
        return teams1;
    }


    public static String[] playfmathes(ArrayList<String> fmatch){
        ArrayList<String> fmatches = fmatch;
        for (String s : fmatches) {
            String[] match1 =s.split("\t");
            String[] score = match1[3].split(":");
            int firstteamscore=Integer.parseInt(score[0]);
            int secondteamscore=Integer.parseInt(score[1]);
            if(firstteamscore > secondteamscore){
                for (Fteam team : teams1) {
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.winal();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.loseal();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }

            if(firstteamscore < secondteamscore){
                for (Fteam team : teams1) {
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.winal();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.loseal();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }

            if(firstteamscore == secondteamscore){
                for (Fteam team : teams1) {
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.berabere();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.berabere();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }
        }
        return null;
    }







}
