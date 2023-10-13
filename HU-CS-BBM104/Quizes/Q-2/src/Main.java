import javax.swing.table.TableRowSorter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] lines = new String[100];
        String filename = args[0];
        File file = new File(filename);
        lines = Readfile.Readfromfile(filename);
        int lengthforlines = lines.length;
        ArrayList<String> fmatch = Readfile.addfmatches(lines, lengthforlines);
        ArrayList<String> bmatch = Readfile.addbmatches(lines, lengthforlines);
        ArrayList<String> hmatch = Readfile.addhmatches(lines, lengthforlines);
        ArrayList<String> vmatch = Readfile.addvmatches(lines, lengthforlines);
        ArrayList<String> teamnames = Football_league.taketeamnames(fmatch);
        ArrayList<String> hteamnames = Handball_league.takehteamnames(hmatch);
        ArrayList<String> bteamnames = Basketball_league.takebteamnames(bmatch);
        ArrayList<String> vteamnames = Volleyball_league.takevteamnames(vmatch);
        ArrayList<Fteam> fteams  = Football_league.addfteams(teamnames);
        ArrayList<Hteam> hteams = Handball_league.addhteams(hteamnames);
        ArrayList<Bteam> bteams = Basketball_league.addbteams(bteamnames);
        ArrayList<Vteam> vteams = Volleyball_league.addvteams(vteamnames);
        String a = fmatch.get(0);
        String[] B = a.split("\t");
        Football_league.playfmathes(fmatch);
        Handball_league.playhmathes(hmatch);
        Basketball_league.playbmathes(bmatch);
        Volleyball_league.playvmathes(vmatch);


        Collections.sort(fteams, new Comparator<Fteam>() {
            @Override
            public int compare(final Fteam team1, final Fteam team2) {
                int truee;
                truee = Integer.valueOf(team1.point).compareTo(Integer.valueOf(team2.point));
                if (truee == 0) {
                    truee = Integer.valueOf(team1.avg).compareTo(Integer.valueOf(team2.avg));
                }
                if(truee==0){
                    truee = team1.name.compareTo(team2.name);
                }
                return truee;
            }
        }
    );
        Collections.reverse(fteams);

        FileWriter yuWriter = new FileWriter("Football.txt",false);
        BufferedWriter buWriter = new BufferedWriter(yuWriter);
        buWriter.write("1.\t"+fteams.get(0).name+"\t"+fteams.get(0).match+"\t"+fteams.get(0).win+"\t"+fteams.get(0).draw+"\t"+fteams.get(0).lose+"\t"+fteams.get(0).ag+":"+ fteams.get(0).yg+"\t"+ fteams.get(0).point+"\n");

        for (int i = 1; i < 4; i++) {
            buWriter.write(i+1+".\t"+fteams.get(i).name+"\t"+fteams.get(i).match+"\t"+fteams.get(i).win+"\t"+fteams.get(i).draw+"\t"+fteams.get(i).lose+"\t"+fteams.get(i).ag+":"+ fteams.get(i).yg+"\t"+ fteams.get(i).point+"\n");
        }
        buWriter.close();

        Collections.sort(hteams, new Comparator<Hteam>() {
                    @Override
                    public int compare(final Hteam team1, final Hteam team2) {
                        int truee;
                        truee = Integer.valueOf(team1.point).compareTo(Integer.valueOf(team2.point));
                        if (truee == 0) {
                            truee = Integer.valueOf(team1.avg).compareTo(Integer.valueOf(team2.avg));
                        }
                        else if(truee==0){
                            truee = team1.name.compareTo(team2.name);
                        }
                        return truee;
                    }
                }
        );
        Collections.reverse(hteams);
        FileWriter xuWriter = new FileWriter("Handball.txt",false);
        BufferedWriter cuWriter = new BufferedWriter(xuWriter);
        cuWriter.write("1.\t"+hteams.get(0).name+"\t"+hteams.get(0).match+"\t"+hteams.get(0).win+"\t"+hteams.get(0).draw+"\t"+hteams.get(0).lose+"\t"+hteams.get(0).ag+":"+ hteams.get(0).yg+"\t"+ hteams.get(0).point+"\n");

        for (int i = 1; i < 4; i++) {
            cuWriter.write(i+1+".\t"+hteams.get(i).name+"\t"+hteams.get(i).match+"\t"+hteams.get(i).win+"\t"+hteams.get(i).draw+"\t"+hteams.get(i).lose+"\t"+hteams.get(i).ag+":"+ hteams.get(i).yg+"\t"+ hteams.get(i).point+"\n");
        }
        cuWriter.close();


        Collections.sort(bteams, new Comparator<Bteam>() {
                    @Override
                    public int compare(final Bteam team1, final Bteam team2) {
                        int truee;
                        truee = Integer.valueOf(team1.point).compareTo(Integer.valueOf(team2.point));
                        if (truee == 0) {
                            truee = Integer.valueOf(team1.avg).compareTo(Integer.valueOf(team2.avg));
                        }
                        else if(truee==0){
                            truee = team1.name.compareTo(team2.name);
                        }
                        return truee;
                    }
                }
        );
        Collections.reverse(bteams);
        FileWriter uuWriter = new FileWriter("Basketball.txt",false);
        BufferedWriter cuuWriter = new BufferedWriter(uuWriter);
        cuuWriter.write("1.\t"+bteams.get(0).name+"\t"+bteams.get(0).match+"\t"+bteams.get(0).win+"\t"+bteams.get(0).draw+"\t"+bteams.get(0).lose+"\t"+bteams.get(0).ag+":"+ bteams.get(0).yg+"\t"+ bteams.get(0).point+"\n");

        for (int i = 1; i < 4; i++) {
            cuuWriter.write(i+1+".\t"+bteams.get(i).name+"\t"+bteams.get(i).match+"\t"+bteams.get(i).win+"\t"+bteams.get(i).draw+"\t"+bteams.get(i).lose+"\t"+bteams.get(i).ag+":"+ bteams.get(i).yg+"\t"+ bteams.get(i).point+"\n");
        }
        cuuWriter.close();


        Collections.sort(vteams, new Comparator<Vteam>() {
                    @Override
                    public int compare(final Vteam team1, final Vteam team2) {
                        int truee;
                        truee = Integer.valueOf(team1.point).compareTo(Integer.valueOf(team2.point));
                        if (truee == 0) {
                            truee = Integer.valueOf(team1.avg).compareTo(Integer.valueOf(team2.avg));
                        }
                        else if(truee==0){
                            truee = team1.name.compareTo(team2.name);
                        }
                        return truee;
                    }
                }
        );
        Collections.reverse(vteams);
        FileWriter uoWriter = new FileWriter("Volleyball.txt",false);
        BufferedWriter uyWriter = new BufferedWriter(uoWriter);
        uyWriter.write("1.\t"+vteams.get(0).name+"\t"+vteams.get(0).match+"\t"+vteams.get(0).win+"\t"+vteams.get(0).draw+"\t"+vteams.get(0).lose+"\t"+vteams.get(0).ag+":"+ vteams.get(0).yg+"\t"+ vteams.get(0).point+"\n");

        for (int i = 1; i < 4; i++) {
            uyWriter.write(i+1+".\t"+vteams.get(i).name+"\t"+vteams.get(i).match+"\t"+vteams.get(i).win+"\t"+vteams.get(i).draw+"\t"+vteams.get(i).lose+"\t"+vteams.get(i).ag+":"+ vteams.get(i).yg+"\t"+ vteams.get(i).point+"\n");
        }
        uyWriter.close();

    }


}