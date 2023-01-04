package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User el : users) {
            if (el.getUsername().equals(login)) {
                result = el;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("This login is not found in users");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("This user is not valid");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("User name length is less 3");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Rustam Suleymanov", true)
        };
        try {
            User user = findUser(users, "Rustam Suleymanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}