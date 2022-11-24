package qa.demo.tests;

import static qa.demo.utils.RandomUtils.*;

public class TestData {
    static String[] names = {"Egor", "Alex", "Oleg", "Petr"};
    public static String firstName = randomListItem(names),
    lastName = randomString(12),
    userEmail = randomEmail(12),
    userNumber = randomPhone("7", 10000000, 999999999);
}
