package MyTests;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class lvl83juroklastzadanie
{
    public static void main (String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Пупкин", "Вася");
        map.put("Зайцев", "Петя");
        map.put("Ануфриев", "Илья");
        map.put("Лютер", "Юра");
        map.put("Куценко", "Гоша");
        map.put("Воронов", "Гоша");
        map.put("Зайцев2", "Вася");
        map.put("Цой", "Виктор");
        map.put("Бут", "Виктор");
        map.put("Путин", "Владимир");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>();
        boolean toBeAdded;

        for (Map.Entry<String, String> pair: map.entrySet())
        {
            toBeAdded = true;
            for (Map.Entry<String, String> innerPair: map.entrySet())
            {
                if (pair.getValue().equals(innerPair.getValue())&& !pair.getKey().equals(innerPair.getKey()))
                {
                    toBeAdded = false;
                }
            }
            if (toBeAdded)
                copy.put(pair.getKey(), pair.getValue());
        }
        //map = copy;
        /*
        for (Map.Entry<String, String> pair: map.entrySet())
        {
            map.remove(pair.getKey());
        }
        */
        map.clear();
        map.putAll(copy);

        for (Map.Entry<String, String> pair: map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
