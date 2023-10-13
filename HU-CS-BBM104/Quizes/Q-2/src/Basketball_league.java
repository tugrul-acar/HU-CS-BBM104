import java.util.ArrayList;
public class Basketball_league {
    public static ArrayList<Bteam> bteams = new ArrayList<Bteam>();
    public static ArrayList<String> takebteamnames(ArrayList<String> bmatch){
        ArrayList<String> teams = new ArrayList<>();
        for (String s : bmatch) {
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
    public static ArrayList<Bteam> addbteams(ArrayList<String> teamnames){

        for(int i= 0;i<4;i++){
            bteams.add(new Bteam(teamnames.get(i)));
        }
        return bteams;
    }


    public static String[] playbmathes(ArrayList<String> bmatch){
        ArrayList<String> bmatches = bmatch;
        for (String s : bmatches) {
            String[] match1 =s.split("\t");
            String[] score = match1[3].split(":");
            int firstteamscore=Integer.parseInt(score[0]);
            int secondteamscore=Integer.parseInt(score[1]);
            if(firstteamscore > secondteamscore){
                for (Bteam team : bteams) {
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
                for (Bteam team : bteams) {
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
                for (Bteam team : bteams) {
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
