package test;

import org.h2.mvstore.MVMap;
import org.h2.mvstore.MVStore;

public class MVStoreWorkTool {

    public static void main(String[] args) {

        MVStore s = MVStore.open("C:\\temp\\test1.data");

        MVMap<Integer, String> map = s.openMap("data");

        System.out.println("start version=" + s.getCurrentVersion());
        map.put(1, "Hello1");
        System.out.println("put 1->hello1, ver=" + s.getCurrentVersion());
        map.put(2, "Hello2");
        System.out.println("put 2->hello2, ver=" + s.getCurrentVersion());
        map.put(1, "Hello3");
        System.out.println("put 1->hello3, ver=" + s.getCurrentVersion());

        s.close();
    }
}
