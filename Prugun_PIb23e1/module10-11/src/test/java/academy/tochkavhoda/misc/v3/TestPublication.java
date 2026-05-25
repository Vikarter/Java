package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPublication {

    @Test
    public void testPublicationWithColor() throws ColorException {
        Publication publication = new Publication("Java", "Gosling", Color.GREEN);
        assertAll(
                () -> assertEquals("Java", publication.getTitle()),
                () -> assertEquals("Gosling", publication.getAuthor()),
                () -> assertEquals(Color.GREEN, publication.getColor())
        );
    }

    @Test
    public void testPublicationWithString() throws ColorException {
        Publication publication = new Publication("Java", "Gosling", "BLUE");
        assertEquals(Color.BLUE, publication.getColor());
    }

    @Test
    public void testPublicationDefault() {
        Publication publication = new Publication();
        assertAll(
                () -> assertEquals("Publication", publication.getTitle()),
                () -> assertEquals("Author", publication.getAuthor()),
                () -> assertEquals(Color.RED, publication.getColor())
        );
    }

    @Test
    public void testSetColor() throws ColorException {
        Publication publication = new Publication("Java", "Gosling", Color.RED);
        publication.setColor(Color.BLUE);
        assertEquals(Color.BLUE, publication.getColor());

        publication.setColor("GREEN");
        assertEquals(Color.GREEN, publication.getColor());
    }

    @Test
    public void testNullColorThrows() throws ColorException {
        Publication publication = new Publication("Java", "Gosling", Color.RED);
        assertThrows(ColorException.class, () -> publication.setColor((Color) null));
        assertThrows(ColorException.class, () -> publication.setColor((String) null));
        assertThrows(ColorException.class, () -> new Publication("Java", "Gosling", (Color) null));
    }

    @Test
    public void testWrongColorStringThrows() {
        assertThrows(ColorException.class, () -> new Publication("Java", "Gosling", "YELLOW"));
    }

    @Test
    public void testPublicationSetters() throws ColorException {
        Publication publication = new Publication();
        publication.setTitle("Python");
        publication.setAuthor("Guido");
        assertEquals("Python", publication.getTitle());
        assertEquals("Guido", publication.getAuthor());
    }

    @Test
    public void testPublicationEquals() throws ColorException {
        Publication p1 = new Publication("Java", "Gosling", Color.RED);
        Publication p2 = new Publication("Java", "Gosling", Color.RED);
        Publication p3 = new Publication("Python", "Guido", Color.RED);
        Publication p4 = new Publication("Java", "Gosling", Color.BLUE);
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertNotEquals(p1, p4);
    }
}