package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {
    private Color color;

    // ── конструкторы с Color ──────────────────────────────
    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        setColor(color);
    }
    public ColoredCircle(int x, int y, int radius, Color color) throws ColorException {
        super(x, y, radius);
        setColor(color);
    }
    public ColoredCircle(int radius, Color color) throws ColorException {
        super(radius);
        setColor(color);
    }
    public ColoredCircle(Color color) throws ColorException {
        super(1);
        setColor(color);
    }

    // ── конструкторы со String ────────────────────────────
    public ColoredCircle(Point center, int radius, String colorString) throws ColorException {
        this(center, radius, Color.colorFromString(colorString));
    }
    public ColoredCircle(int x, int y, int radius, String colorString) throws ColorException {
        this(x, y, radius, Color.colorFromString(colorString));
    }
    public ColoredCircle(int radius, String colorString) throws ColorException {
        this(radius, Color.colorFromString(colorString));
    }
    public ColoredCircle(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    // ── по умолчанию ─────────────────────────────────────
    public ColoredCircle() {
        super(1);
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
        if (!(o instanceof ColoredCircle)) return false;
        return color == ((ColoredCircle) o).color;
    }
    @Override public int hashCode() { return Objects.hash(super.hashCode(), color); }
}