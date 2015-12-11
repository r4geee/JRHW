package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.message1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.message1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.message2);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.message2, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.message3);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.message3, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.message4);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.message4, cause);
        }
    }

    public static final class Constants
    {
        public static final String message1 = "Server is not accessible for now.";
        public static final String message2 = "User is not authorized.";
        public static final String message3 = "User is banned.";
        public static final String message4 = "Access is denied.";
    }
}
