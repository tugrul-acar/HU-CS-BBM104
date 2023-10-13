import java.util.ArrayList;

public class Handball_league {
    public static ArrayList<Hteam> hteams = new ArrayList<Hteam>();


    public static ArrayList<String> takehteamnames(ArrayList<String> hmatch){
        ArrayList<String> teams = new ArrayList<>();
        for (String s : hmatch) {
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

    public static ArrayList<Hteam> addhteams(ArrayList<String> teamnames){

        for(int i= 0;i<4;i++){
            hteams.add(new Hteam(teamnames.get(i)));
        }
        return hteams;
    }

    public static String[] playhmathes(ArrayList<String> hmatch){
        ArrayList<String> hmatches = hmatch;
        for (String s : hmatches) {
            String[] match1 =s.split("\t");
            String[] score = match1[3].split(":");
            int firstteamscore=Integer.parseInt(score[0]);
            int secondteamscore=Integer.parseInt(score[1]);
            if(firstteamscore > secondteamscore){
                for (Hteam team : hteams) {
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
                for (Hteam team : hteams) {
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
                for (Hteam team : hteams) {
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
