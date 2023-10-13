import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        readtxt readfile = new readtxt();
        readfile.addcollections(args[0]);

        ArrayList<Contact> contactsarraylist = readfile.getContactsArrayList();
        HashSet<Contact> contactHashSet = readfile.getContactsHashset();
        TreeSet<Contact> contactTreeSet = readfile.getContactTreeSet();
        TreeSet<Contact> contactTreeSetsorted = readfile.getContactTreeSetsorted();
        HashMap<String,Contact> contactHashMap = readfile.getContactHashMap();


        readtxt.writetxt("contactsArrayList.txt",contactsarraylist);
        Collections.sort(contactsarraylist, new LastNameComparator());
        readtxt.writetxt("contactsArrayListOrderByLastName.txt",contactsarraylist);

        readtxt.writetxt("contactsHashSet.txt",contactHashSet);

        readtxt.writetxt("contactsTreeSet.txt",contactTreeSet);

        readtxt.writetxt("contactsTreeSetOrderByLastName.txt",contactTreeSetsorted);

        readtxt.writetxt("contactsHashMap.txt",contactHashMap);




    }
}
