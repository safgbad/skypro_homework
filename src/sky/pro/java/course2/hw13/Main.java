package sky.pro.java.course2.hw13;

public class Main {
    public static void main(String[] args) {
        Gryffindor[] gryffindor = new Gryffindor[3];
        gryffindor[0] = new Gryffindor("Гарри Поттер", random(), random(), random(), random(), random());
        gryffindor[1] = new Gryffindor("Гермиона Грейнджер", random(), random(), random(), random(), random());
        gryffindor[2] = new Gryffindor("Рон Уизли", random(), random(), random(), random(), random());

        Hufflepuff[] hufflepuff = new Hufflepuff[3];
        hufflepuff[0] = new Hufflepuff("Захария Смит", random(), random(), random(), random(), random());
        hufflepuff[1] = new Hufflepuff("Седрик Диггори", random(), random(), random(), random(), random());
        hufflepuff[2] = new Hufflepuff("Джастин Финч-Флетчли", random(), random(), random(), random(), random());

        Ravenclaw[] ravenclaw = new Ravenclaw[3];
        ravenclaw[0] = new Ravenclaw("Чжоу Чанг", random(), random(), random(), random(), random(), random());
        ravenclaw[1] = new Ravenclaw("Падма Патил", random(), random(), random(), random(), random(), random());
        ravenclaw[2] = new Ravenclaw("Маркус Белби", random(), random(), random(), random(), random(), random());

        Slytherin[] slytherin = new Slytherin[3];
        slytherin[0] = new Slytherin("Драко Малфой", random(), random(), random(), random(), random(), random(), random());
        slytherin[1] = new Slytherin("Грэхэм Монтегю", random(), random(), random(), random(), random(), random(), random());
        slytherin[2] = new Slytherin("Грегори Гойл", random(), random(), random(), random(), random(), random(), random());

        System.out.println(slytherin[0]);
        System.out.println(ravenclaw[1]);
        System.out.println(hufflepuff[2]);
        System.out.println(gryffindor[0]);

        Hogwarts.compareBasicQualities(ravenclaw[1], hufflepuff[2]);
        Hogwarts.compareLocalQualities(gryffindor[0], gryffindor[1]);
        Hogwarts.compareLocalQualities(gryffindor[0], hufflepuff[1]);
    }

    public static int random() {
        return (int) (100 * Math.random());
    }
}
