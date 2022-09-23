package pro.sky.java.course1.hw1;

public class Main {
    public static void main(String[] args) {
        // Task 1.1
        System.out.println("Task 1.1");
        var dog = 8;
        var cat = 3.6;
        var paper = 763789;
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(paper);
        System.out.println("--");

        // Task 1.2
        System.out.println("Task 1.2");
        dog += 4;
        cat += 4;
        paper += 4;
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(paper);
        System.out.println("--");

        // Task 1.3
        System.out.println("Task 1.3");
        dog -= 3.5;
        cat -= 1.6;
        paper -= 7639;
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(paper);
        System.out.println("--");

        // Task 2.1
        System.out.println("Task 2.1");
        var friend = 19;
        System.out.println(friend);
        friend += 2;
        System.out.println(friend);
        friend /= 7;
        System.out.println(friend);
        System.out.println("--");

        // Task 2.2
        System.out.println("Task 2.2");
        var frog = 3.5;
        System.out.println(frog);
        frog *= 10;
        System.out.println(frog);
        frog /= 3.5;
        System.out.println(frog);
        frog += 4;
        System.out.println(frog);
        System.out.println("--");

        // Task 3.1
        System.out.println("Task 3.1");
        var firstBoxerWeight = 78.2;
        System.out.println("First boxer's weight: " + firstBoxerWeight);
        var secondBoxerWeight = 82.7;
        System.out.println("Second boxer's weight: " + secondBoxerWeight);
        var totalWeight = firstBoxerWeight + secondBoxerWeight;
        System.out.println("Total weight of both boxers: " + totalWeight);
        var weightDifference = firstBoxerWeight - secondBoxerWeight;
        //var weightDifference = java.lang.Math.abs(firstBoxerWeight - secondBoxerWeight);
        System.out.println("Weight difference between two boxers: " + weightDifference);
        System.out.println("--");

        // Task 3.2
        System.out.println("Task 3.2");
        var weightDifference_subtraction = secondBoxerWeight - firstBoxerWeight;
        System.out.println("Weight difference between two boxers calculated with subtraction: " + weightDifference_subtraction);
        var weightDifference_division = secondBoxerWeight % firstBoxerWeight;
        System.out.println("Weight difference between two boxers calculated with remainder of the division: " + weightDifference_division);
        System.out.println("--");

        // Task 3.3
        System.out.println("Task 3.3");
        var totalHours = 640;
        var hoursPerEmployee = 8;
        var employeesNumber = totalHours / hoursPerEmployee;
        System.out.println("Всего работников в компании – " + employeesNumber + " человек");
        employeesNumber += 94;
        totalHours = employeesNumber * hoursPerEmployee;
        System.out.println("Если в компании работает " + employeesNumber + " человек, то всего "
                + totalHours + " часов работы может быть поделено между сотрудниками");
    }
}
