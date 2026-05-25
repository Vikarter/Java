package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private Color color;

    // ── конструкторы с Color ──────────────────────────────
    public ColoredRectangle(Point topLeft, Point bottomRight, Color color) throws ColorException {
        super(topLeft, bottomRight);
        setColor(color);
    }
    public ColoredRectangle(int x1, int y1, int x2, int y2, Color color) throws ColorException {
        super(x1, y1, x2, y2);
        setColor(color);
    }
    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        super(length, width);
        setColor(color);
    }
    public ColoredRectangle(Color color) throws ColorException {
        super(1, 1);
        setColor(color);
    }

    // ── конструкторы со String ────────────────────────────
    public ColoredRectangle(Point topLeft, Point bottomRight, String colorString) throws ColorException {
        this(topLeft, bottomRight, Color.colorFromString(colorString));
    }
    public ColoredRectangle(int x1, int y1, int x2, int y2, String colorString) throws ColorException {
        this(x1, y1, x2, y2, Color.colorFromString(colorString));
    }
    public ColoredRectangle(int length, int width, String colorString) throws ColorException {
        this(length, width, Color.colorFromString(colorString));
    }
    public ColoredRectangle(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    // ── по умолчанию ─────────────────────────────────────
    public ColoredRectangle() {
        super(1, 1);
        this.color = Color.RED;
    }

    // ── геттер/сеттер ─────────────────────────────────────
    @Override public Color getColor() { return color; }

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
        if (!super.equals(o)) return false;
        if (!(o instanceof ColoredRectangle)) return false;
        return color == ((ColoredRectangle) o).color;
    }
    @Override public int hashCode() { return Objects.hash(super.hashCode(), color); }
}