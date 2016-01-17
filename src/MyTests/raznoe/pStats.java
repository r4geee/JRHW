package MyTests.raznoe;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alexei on 06.08.2015.
 */
public class pStats {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
    static Map<String,Integer> map = new TreeMap<>();
    public static void main(String[] args) {
        File folder = new File("D:\\Documents\\q\\pics");
        countFiles(folder);
        int total = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            total += entry.getValue();
        }
        System.out.println("Total: " + total);
    }

    private static void countFiles(File folder) {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                String month = simpleDateFormat.format(file.lastModified());
                if (map.containsKey(month)) {
                    map.put(month, map.get(month) + 1);
                }
                else {
                    map.put(month, 1);
                }
            }
            else {
                countFiles(file);
            }
        }
    }
}
