package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import java.util.Objects;

public class Publication implements Colored {
    private String title;
    private String author;
    private Color color;

    public Publication(String title, String author, Color color) throws ColorException {
        this.title = title;
        this.author = author;
        setColor(color);
    }

    public Publication(String title, String author, String colorString) throws ColorException {
        this(title, author, Color.colorFromString(colorString));
    }

    public Publication() {
        this.title = "Publication";
        this.author = "Author";
        this.color = Color.RED;
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
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
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