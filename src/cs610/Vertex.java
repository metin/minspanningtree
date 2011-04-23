package cs610;

public class Vertex {
  public String name;
  public int x;
  public int y;
  public Vertex head, tail, next;

  public Vertex(String pName) {
    this.name = pName;
    x = 0;
    y = 0;
    next = null;
    head = tail = this;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Vertex) {
      Vertex n = (Vertex) o;
      if (this.name.equals(n.name))
        return true;
    }
    return false;
  }
}
