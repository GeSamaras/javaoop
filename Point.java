interface Shape {
    public double area();
    public double circumference();
}

interface Moveable {
    public boolean isMoveable();
    public void moveAbsolute(Position pos);
    public void moveRelative(Position pos);
}


abstract class AbstractShape implements Shape, Moveable {
    // in UML the ▢ symbol is used for protected or private vars
    protected Position pos = new Position();
    private boolean moveable = false;

    public boolean isMoveable() {
        return moveable;
    }
    public void moveAbsolute(Position pos) {
        this.pos = pos;
    }
    public void moveRelative(Position pos) {
        this.pos.add(pos);
    }
    //abstract public double area();
    //abstract public double circumference();
}

class Position {
    public int x = 0;
    public int y = 0;
    public Position() {
        this.x = 0;
        this.y = 0;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position add(Position pos) {
        this.x += pos.x;
        this.y += pos.y;
        return pos; 
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

abstract class OneDimension extends AbstractShape {
    protected String name;

    public double area() {
        return Double.NaN;
    }
    public double circumference() {
        return Double.NaN;
    }
    public String toString() {
        return name + " " + pos;
    }

}

class Point extends OneDimension {
    Point() {
        name = "Point";
    }
}

class Line extends OneDimension {
    private Position pos2 = new Position();
    
    Line() {
        name = "Line";
    }

    public String toString() {
        return super.toString() + "-" + pos2;
    }
}
