package sky.pro.java.course1.hw2;

import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        int intVariable = Integer.MAX_VALUE;
        System.out.println("Значение переменной intVariable с типом int равно " + intVariable);
        byte byteVariable = Byte.MIN_VALUE;
        System.out.println("Значение переменной byteVariable с типом byte равно " + byteVariable);
        short shortVariable = Float.MAX_EXPONENT;
        System.out.println("Значение переменной shortVariable с типом short равно " + shortVariable);
        long longVariable = Long.MAX_VALUE;
        System.out.println("Значение переменной longVariable с типом long равно " + longVariable);
        float floatVariable = Float.NEGATIVE_INFINITY;
        System.out.println("Значение переменной floatVariable с типом float равно " + floatVariable);
        double doubleVariable = Double.NaN;
        System.out.println("Значение переменной doubleVariable с типом double равно " + doubleVariable);
        System.out.println("--");

        // Task 2
        float firstValue = 27.12f;
        long secondValue = 987678965549L;
        double thirdValue = 2.786;
        boolean fourthValue = false;
        short fifthValue = 569;
        int sixthValue = -159;
        char seventhValue = 27897;
        byte eighthValue = 67;

        // Task 3
        System.out.println("Task 3");
        int sheetsTotalNumber = 480;
        int pupilsNumber_LP = 23;
        int pupilsNumber_AS = 27;
        int pupilsNumber_EA = 30;
        int pupilsNumber_total = pupilsNumber_LP + pupilsNumber_AS + pupilsNumber_EA;
        int sheetsPerPupil = sheetsTotalNumber / pupilsNumber_total; // хочется верить, что в этой школе ученикам достаются целые листы бумаги
        System.out.println("На каждого ученика рассчитано " + sheetsPerPupil + " листов бумаги");
        System.out.println("--");

        // Task 4
        System.out.println("Task 4");
        int minutesInHour = 60;
        int minutesInDay = minutesInHour * 24;
        int minutesInMonth = minutesInDay * 30;
        double bottlesPerMinute = 16d / 2; // производительность может быть рациональным числом
        System.out.println("За 20 минут машина произвела " + 20 * bottlesPerMinute + " бутылок");
        System.out.println("За сутки машина произвела " + minutesInDay * bottlesPerMinute + " бутылок");
        System.out.println("За 3 дня машина произвела " + 3 * minutesInDay * bottlesPerMinute + " бутылок");
        System.out.println("За месяц (30 дней) машина произвела " + minutesInMonth * bottlesPerMinute + " бутылок");
        System.out.println("--");

        // Task 5
        System.out.println("Task 5");
        int cansTotalNumber = 120;
        int cansOfWhitePaintPerClass = 2;
        int cansOfBrownPaintPerClass = 4;
        int cansOfPaintPerClass = cansOfWhitePaintPerClass + cansOfBrownPaintPerClass;
        int numberOfClasses = cansTotalNumber / cansOfPaintPerClass; // классов не может быть нецелое число
        int cansOfWhitePaintTotal = numberOfClasses * cansOfWhitePaintPerClass;
        int cansOfBrownPaintTotal = numberOfClasses * cansOfBrownPaintPerClass;
        System.out.println("В школе, где " + numberOfClasses + " классов нужно " + cansOfWhitePaintTotal + " банок " +
                "белой краски и " + cansOfBrownPaintTotal + " банок коричневой краски");
        System.out.println("--");

        // Task 6
        System.out.println("Task 6");
        int gPerKg = 1000;
        int bananasNumber = 5;
        int bananaWeight = 80;
        int milkAmountML = 200;
        double milkWeightPerML = 105d / 100;
        int iceCreamNumber = 2;
        int iceCreamWeight = 100;
        int eggNumber = 4;
        int eggWeight = 70;
        double totalWeightG = bananasNumber * bananaWeight + milkAmountML * milkWeightPerML + iceCreamNumber
                * iceCreamWeight + eggNumber * eggWeight;
        double totalWeightKg = totalWeightG / gPerKg;
        System.out.println("Протеиновый коктейль весит " + totalWeightKg + " кг");
        System.out.println("--");

        // Task 7
        System.out.println("Task 7");
        int leastLossPerDay = 250;
        int greatestLossPerDay = 500;
        double averageLossPerDay = (double) (leastLossPerDay + greatestLossPerDay) / 2;
        double lossGoal = 7 * gPerKg;
        System.out.println("Если спортсмен каждый день будет сбрасывать по " + leastLossPerDay + " г, " +
                "то он добьется цели за " + (int) Math.ceil(lossGoal / leastLossPerDay) + " дней");
        System.out.println("Если спортсмен каждый день будет сбрасывать по " + greatestLossPerDay + " г, " +
                "то он добьется цели за " + (int) Math.ceil(lossGoal / greatestLossPerDay) + " дней");
        System.out.println("Если спортсмен каждый день будет сбрасывать по " + averageLossPerDay + " г, " +
                "то он добьется цели за " + (int) Math.ceil(lossGoal / averageLossPerDay) + " дней");
        System.out.println("--");

        // Task 8
        System.out.println("Task 8");
        int salary_masha = 67760;
        long salary_denis = 83690;
        int salary_kristina = 76230;
        double increasePercentage = 0.1;
        // если брать коэффициент 1.1 и просто умножать на текущую зп, то джава (да и не только) плохо считает
        // (появляются лишние знаки после запятой в каком-то далеком разряде из-за погрешности представления чисел
        // с плавающей запятой)
        double increasedSalary_masha = salary_masha + increasePercentage * salary_masha;
        double increasedSalary_denis = salary_denis + increasePercentage * salary_denis;
        double increasedSalary_kristina = salary_kristina + increasePercentage * salary_kristina;
        double incomeDifference_masha = 12 * (increasedSalary_masha - salary_masha);
        double incomeDifference_denis = 12 * (increasedSalary_denis - salary_denis);
        double incomeDifference_kristina = 12 * (increasedSalary_kristina - salary_kristina);
        System.out.printf("Маша теперь получает %.2f рублей. Годовой доход вырос на %.2f рублей.%n",
                increasedSalary_masha, incomeDifference_masha);
        System.out.printf("Денис теперь получает %.2f рублей. Годовой доход вырос на %.2f рублей.%n",
                increasedSalary_denis, incomeDifference_denis);
        System.out.printf("Кристина теперь получает %.2f рублей. Годовой доход вырос на %.2f рублей.%n",
                increasedSalary_kristina, incomeDifference_kristina);
    }
}