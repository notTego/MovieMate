package misc;

import java.util.Hashtable;

public final class Database {

    private static volatile Database instance;

    private static Hashtable<String, Page> myDict = new Hashtable<String, Page>();

    private Database(final Hashtable<String, Page> myDict) {
        this.myDict = myDict;
    }

    public Hashtable<String, Page> getMyDict() {
        return myDict;
    }

    /***/
    public static Database getInstance(final Hashtable<String, Page> newDict) {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database(newDict);
                }
            }
        }
        return instance;
    }

}
