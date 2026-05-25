package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPublication {

    @Test
    public void testPublicationConstructor() {
        Publication publication = new Publication("Java", "Gosling", 2);
        assertAll(
                () -> assertEquals("Java", publication.getTitle()),
                () -> assertEquals("Gosling", publication.getAuthor()),
                () -> assertEquals(2, publication.getColor())
        );
    }

    @Test
    public void testPublicationDefault() {
        Publication publication = new Publication();
        assertAll(
                () -> assertEquals("Publication", publication.getTitle()),
                () -> assertEquals("Author", publication.getAuthor()),
                () -> assertEquals(1, publication.getColor())
        );
    }

    @Test
    public void testPublicationSetColor() {
        Publication publication = new Publication("Java", "Gosling");
        publication.setColor(3);
        assertEquals(3, publication.getColor());
    }

    @Test
    public void testPublicationSetTitleAndAuthor() {
        Publication publication = new Publication();
        publication.setTitle("Python");
        publication.setAuthor("Guido");
        assertEquals("Python", publication.getTitle());
        assertEquals("Guido", publication.getAuthor());
    }

    @Test
    public void testPublicationEquals() {
        Publication publication1 = new Publication("Java", "Gosling", 1);
        Publication publication2 = new Publication("Java", "Gosling", 1);
        Publication publication3 = new Publication("Python", "Guido", 1);
        assertEquals(publication1, publication2);
        assertNotEquals(publication1, publication3);
    }
}