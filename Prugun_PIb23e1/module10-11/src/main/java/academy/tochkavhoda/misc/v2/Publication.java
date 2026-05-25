package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import java.util.Objects;

public class Publication implements Colored {
    private String title;
    private String author;
    private int color;

    public Publication(String title, String author, int color) {
        this.title = title;
        this.author = author;
        this.color = color;
    }

    public Publication(String title, String author) {
        this(title, author, 1);
    }

    public Publication() {
        this("Publication", "Author", 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication p = (Publication) o;
        return color == p.color
                && Objects.equals(title, p.title)
                && Objects.equals(author, p.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, color);
    }
}