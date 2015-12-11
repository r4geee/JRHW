package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    //public static SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("your_file_name");
            InputStream inputStream = new FileInputStream("your_file_name");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush = initJavaRush(javaRush);
            javaRush.save(outputStream);

            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
/*            for(User user : loadedObject.users)
            {
                System.out.println(user.getFirstName()+user.getLastName()+user.getBirthDate()+user.isMale()+user.getCountry());
            }*/

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users)
            {
                if(user == null)
                {
                    printWriter.println("nullUser");
                    continue;
                }
                printWriter.print(user.getFirstName() != null ? user.getFirstName() + ", " : "noFirstName, " );
                printWriter.print(user.getLastName() != null ? user.getLastName() + ", " : "noLastName, " );
                printWriter.print(user.getBirthDate() != null ? ft.format(user.getBirthDate()) + ", " : "noBirthDayDate, ");
                printWriter.print(user.isMale() + ", " );
                printWriter.println(user.getCountry() != null ? user.getCountry().getDisplayedName() : "countryUnknown" );
            }
            printWriter.println("@");
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready())
            {
                String s = reader.readLine();
                if (s.equals("@"))
                {
                    break;
                }
                else if (s.equals("nullUser"))
                {
                    User newUser = null;
                    users.add(newUser);
                    continue;
                }
                String data[] = s.split(", ");
                User newUser = new User();
                String firstName = data[0];
                if (!firstName.equals("noFirstName"))
                    newUser.setFirstName(firstName);
                String lastName = data[1];
                if (!lastName.equals("noLastName"))
                    newUser.setLastName(lastName);
                String date = data[2];
                if(!date.equals("noBirthDayDate"))
                    newUser.setBirthDate(ft.parse(date));
                newUser.setMale(Boolean.parseBoolean(data[3]));
                String country = data[4];
                if (!country.equals("countryUnknown"))
                    newUser.setCountry(User.Country.valueOf(country.toUpperCase()));
                users.add(newUser);
            }
        }
    }

    public static JavaRush initJavaRush(JavaRush javaRush) throws ParseException
    {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        User newUser1 = new User();
        newUser1.setFirstName("Mikola");
        newUser1.setLastName("Saloedov");
        newUser1.setBirthDate(ft.parse("13.12.1988"));
        newUser1.setMale(true);
        newUser1.setCountry(User.Country.UKRAINE);
        javaRush.users.add(newUser1);

        User newUser2 = new User();
        newUser2.setFirstName("Vanjka");
        newUser2.setLastName("Vstanjka");
        newUser2.setBirthDate(ft.parse("19.05.1984"));
        newUser2.setMale(true);
        newUser2.setCountry(User.Country.RUSSIA);
        javaRush.users.add(newUser2);

        User newUser3 = new User();
        newUser3.setFirstName("Devaha");
        newUser3.setMale(false);
        newUser3.setCountry(User.Country.OTHER);
        javaRush.users.add(newUser3);
        User newUser4 = null;
        javaRush.users.add(new User());
        javaRush.users.add(newUser4);

        return javaRush;
    }
}
