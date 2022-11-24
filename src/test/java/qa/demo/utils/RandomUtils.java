package qa.demo.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker();
    static Random random = new Random();

    /*
    public static void main(String[] args) {

        System.out.println(randomString(15));
        System.out.println(randomEmail(7));
        System.out.println(randomNumber(10000000L, 99999999999L));
        System.out.println(randomPhone("7", 10000000, 999999999));

        System.out.println(RandomStringUtils.random(20, true, true));
        System.out.println(RandomStringUtils.random(20, false, false));
        System.out.println(RandomStringUtils.random(20, true, false));
        System.out.println(RandomStringUtils.random(20, false, true));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String[] birthDay = dateFormat.format(faker.date().birthday()).split(" ");
    }
*/
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }

    public static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String randomEmail(int len) {
        return randomString(len) + "@qa.guru";
    }

    static Long randomNumber(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String randomPhone(String prefix, int min, int max) {
        return prefix + ThreadLocalRandom.current().nextInt(min, max);
    }

    public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        System.out.println(generatedString);
    }


    public static String randomListItem(String[] values) {
        int index = randInt(0, values.length);
        return values[index];
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


    public static String getSubject() {
        String[] subjects = {"English", "Math", "Arts", "Physics", "Chemistry", "Economics", "Biology"};
        int index = random.nextInt(subjects.length);
        return subjects[index];
    }

    public static String getMonth() {
        String[] arrMonth = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        int index = random.nextInt(arrMonth.length);
        return arrMonth[index];
    }

    public static String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[random.nextInt(hobbies.length)];
    }
}
