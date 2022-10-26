package sky.pro.java.course1.hw11;

public class Main {
    public static void main(String[] args) {
        Author dostoevsky = new Author("Фёдор", "Достоевский");
        Book crimeAndPunishment = new Book("Преступление и наказание", dostoevsky, 1865);
        Author pushkin = new Author("Александр", "Пушкин");
        Book eugeneOnegin = new Book("Евгений Онегин", pushkin, 1833);
        crimeAndPunishment.setYear(1866);
        Author tolstoy = new Author("Лев", "Толстой");
        Book warAndPeace = new Book("Война и мир", tolstoy, 1865);
        Author lermontov = new Author("Михаил", "Лермонтов");
        Book heroOfOurTime = new Book("Герой нашего времени", lermontov, 1839);
        Author griboedov = new Author("Александр", "Грибоедов");
        Book griefFromTheMind = new Book("Горе от ума", griboedov, 1825);
        Author gogol = new Author("Николай", "Гоголь");
        Book deadSouls = new Book("Мертвые души", gogol, 1842);

        Library library = new Library(10);
        library.addBook(crimeAndPunishment);
        library.addBook(eugeneOnegin);
        library.addBook(warAndPeace);
        library.addBook(heroOfOurTime);
        library.addBook(griefFromTheMind);
        library.addBook(deadSouls);

        library.printBookInformationByName("ВОЙна и МиР");
        library.setYear("Герой нашего времени", 1840);
        library.printBooks();

    }
}
