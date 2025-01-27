package library.enums;

public enum Genre {
    COMEDY,
    DETECTIVE,
    DRAMA,
    FANTASY;

    public static void printAllGenres() {
        for (Genre genre : Genre.values()) {
            int genreNumber = genre.ordinal() + 1;
            System.out.println(genreNumber + ". " + genre);
        }
    }

    public static Genre chooseGenreByNumber(int genreNumber) {
        int index = genreNumber - 1;
        for (Genre genre : Genre.values()) {
           if (index == genre.ordinal()) {
               return genre;
           }
        }
        return null;
    }
}
