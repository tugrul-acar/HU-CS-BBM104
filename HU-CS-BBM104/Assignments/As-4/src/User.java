import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class User {
    public static boolean loguserban = false;
    public static String logusername;
    public static boolean isadmin = false;
    private boolean admin;
    private boolean clubmember;
    private String password;
    private String name;
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<User> users2 = new ArrayList<>();
    public static ArrayList<String> usersname = new ArrayList<>();
    public static ArrayList<Boolean> adminlist = new ArrayList<>();
    public static ArrayList<Boolean> memberlist = new ArrayList<>();

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setClubmember(boolean clubmember) {
        this.clubmember = clubmember;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, boolean admin, boolean clubmember, String password){
        this(name,admin,clubmember);
        this.admin = admin;
        this.clubmember = clubmember;
        this.name = name;
        this.password = password;
        users.add(this);
        usersname.add(name);
        adminlist.add(admin);
        memberlist.add(clubmember);

    }
    public User(String name,boolean admin,boolean clubmember){
        this.admin = admin;
        this.clubmember = clubmember;
        this.name = name;
        users2.add(this);
    }


    public static boolean isIsadmin() {
        return isadmin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isClubmember() {
        return clubmember;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<User> getUsers2() {
        return users2;
    }

    public static ArrayList<String> getUsersname() {
        return usersname;
    }

    public static ArrayList<Boolean> getAdminlist() {
        return adminlist;
    }

    public static ArrayList<Boolean> getMemberlist() {
        return memberlist;
    }

    public static String hashpass(String password){
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] md5Digest = new byte[0];
        try {
            md5Digest = MessageDigest.getInstance("MD5").digest(bytes);
        }
         catch (NoSuchAlgorithmException e) {
            return null;
        }
        return Base64.getEncoder().encodeToString(md5Digest);
    }
}
