import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class readtxt {

    private final ArrayList<Contact> contactsArrayList = new ArrayList<>();
    private final HashSet<Contact> contactsHashset = new HashSet<>();
    private final TreeSet<Contact> contactTreeSet = new TreeSet<>();
    private final TreeSet<Contact> contactTreeSetsorted = new TreeSet<>(new LastNameComparator());
    private final HashMap<String,Contact> contactHashMap = new HashMap<>();

    private ArrayList<String> addtoarray(String path) throws IOException {
        ArrayList<String> ArrayList1 = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        return ArrayList1;
    }
    public void addcollections(String path) throws IOException {
        ArrayList<String> ArrayList1 = addtoarray(path);
        for (String s : ArrayList1) {
            String[] contacts = s.split(" ");
            Contact contact = new Contact(contacts[0],contacts[1],contacts[2],contacts[3]);
            contactsArrayList.add(contact);
            contactsHashset.add(contact);
            contactTreeSet.add(contact);
            contactTreeSetsorted.add(contact);
            contactHashMap.put(contact.getPhoneNumber(),contact);
        }
    }

    public ArrayList<Contact> getContactsArrayList() {
        return contactsArrayList;
    }

    public HashMap<String, Contact> getContactHashMap() {
        return contactHashMap;
    }

    public HashSet<Contact> getContactsHashset() {
        return contactsHashset;
    }

    public TreeSet<Contact> getContactTreeSet() {
        return contactTreeSet;
    }

    public TreeSet<Contact> getContactTreeSetsorted() {
        return contactTreeSetsorted;
    }

    public static void writetxt(String name, ArrayList<Contact> contacts) throws IOException {
        Iterator<Contact> iter = contacts.iterator();
        FileWriter writer = new FileWriter(name);
        while (iter.hasNext()) {
            Contact contact = iter.next();
            writer.write(contact.getPhoneNumber()+" "+contact.getFirstName()+ " "+contact.getLastName()+ " "+contact.getSocialSecurityNumber()+"\n");
        }
        writer.close();

    }

    public static void writetxt(String name, HashSet<Contact> contacts) throws IOException {
        Iterator<Contact> iter = contacts.iterator();
        FileWriter writer = new FileWriter(name);
        while (iter.hasNext()) {
            Contact contact = iter.next();
            writer.write(contact.getPhoneNumber()+" "+contact.getFirstName()+ " "+contact.getLastName()+ " "+contact.getSocialSecurityNumber()+"\n");
        }
        writer.close();
    }
    public static void writetxt(String name, TreeSet<Contact> contacts) throws IOException {
        Iterator<Contact> iter = contacts.iterator();
        FileWriter writer = new FileWriter(name);
        while (iter.hasNext()) {
            Contact contact = iter.next();
            writer.write(contact.getPhoneNumber()+" "+contact.getFirstName()+ " "+contact.getLastName()+ " "+contact.getSocialSecurityNumber()+"\n");
        }
        writer.close();
    }
    public static void writetxt(String name, HashMap<String,Contact> contacts) throws IOException {
        FileWriter writer = new FileWriter(name);
        for (Map.Entry<String, Contact> map : contacts.entrySet()) {
            writer.write(map.getValue().getPhoneNumber()+" "+map.getValue().getFirstName()+ " "+map.getValue().getLastName()+ " "+map.getValue().getSocialSecurityNumber()+"\n");
        }
        writer.close();
    }



}
