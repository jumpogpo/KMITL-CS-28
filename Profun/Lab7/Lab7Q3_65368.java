public class Lab7Q3_65368 {
    public static void main(String[] args) {
        numDaysFormDate(3, 5, 2004, 5);
    }

    static void numDaysFormDate(int date, int month, int year, int myBD) {
        int daysBornTil31Dec2021 = 0;
        int[] daysArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year % 4 == 0) daysArray[1] = 29;
        daysBornTil31Dec2021 += daysArray[month - 1] - date;

        for (int i = month; i < daysArray.length; i++) {
            daysBornTil31Dec2021 += daysArray[i];
        }

        for (int j = year + 1; j < 2022; j++) {
            if (j % 4 == 0) {
                daysBornTil31Dec2021 += 366;
            } else {
                daysBornTil31Dec2021 += 365;
            }
        }

        int daysBornTil2Jan2022 = daysBornTil31Dec2021 + 2;
        String str = showResult(date, month, year, myBD, daysBornTil2Jan2022);
        System.out.println(str);
    }

    static String showResult(int date, int month, int year, int myBD, int fromNumDaysFromDate) {
        String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int dayFromSun = 0;
        int modResult = fromNumDaysFromDate % 7;

        if (modResult != 0) {
            dayFromSun = 7 - modResult;
        }

        String str = String.format("You were born on %s and have been born for %d days (2 Jan 2022). Your program says %s", dayName[myBD], fromNumDaysFromDate, dayName[dayFromSun]);
        return str;
    }
}