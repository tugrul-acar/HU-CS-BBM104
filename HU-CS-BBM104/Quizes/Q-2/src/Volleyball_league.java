import java.util.ArrayList;

public class Volleyball_league {
    public static ArrayList<Vteam> vteams = new ArrayList<Vteam>();
    public static ArrayList<String> takevteamnames(ArrayList<String> vmatch){
        ArrayList<String> teams = new ArrayList<>();
        for (String s : vmatch) {
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

    public static ArrayList<Vteam> addvteams(ArrayList<String> teamnames){

        for(int i= 0;i<4;i++){
            vteams.add(new Vteam(teamnames.get(i)));
        }
        return vteams;
    }



    public static String[] playvmathes(ArrayList<String> vmatch){
        ArrayList<String> vmatches = vmatch;
        for (String s : vmatches) {
            String[] match1 =s.split("\t");
            String[] score = match1[3].split(":");
            int firstteamscore=Integer.parseInt(score[0]);
            int secondteamscore=Integer.parseInt(score[1]);
            if(match1[3].equals("3:0")){
                for (Vteam team : vteams) {
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.winal();
                        team.adduc();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.loseal();
                        team.addsifir();
                        team.pointcal();
                        team.avgcal();
                    }
                }

            }
            if(match1[3].equals("3:1")){
                for (Vteam team : vteams) {
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.winal();
                        team.adduc();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.loseal();
                        team.addsifir();
                        team.pointcal();
                        team.avgcal();
                    }
                }

            }

            if(match1[3].equals("3:2")){
                for (Vteam team : vteams) {
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.winal();
                        team.addiki();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.loseal();
                        team.addbir();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }
            if(match1[3].equals("1:3")){
                for (Vteam team : vteams) {
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.winal();
                        team.adduc();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.loseal();

                        team.addsifir();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }
            if(match1[3].equals("0:3")){
                for (Vteam team : vteams) {
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.winal();

                        team.adduc();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.loseal();

                        team.addsifir();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }
            if(match1[3].equals("2:3")){
                for (Vteam team : vteams) {
                    if(team.name.equals(match1[2])){
                        team.golat(secondteamscore);
                        team.golye(firstteamscore);
                        team.macoyna();
                        team.winal();

                        team.addiki();
                        team.pointcal();
                        team.avgcal();
                    }
                    if(team.name.equals(match1[1])){
                        team.golat(firstteamscore);
                        team.golye(secondteamscore);
                        team.macoyna();
                        team.loseal();

                        team.addbir();
                        team.pointcal();
                        team.avgcal();
                    }
                }
            }





        }
        return null;
    }
}
