/**
 * Created by juny on 2017. 5. 20..
 */
public class File extends Directory {
    int size;
    String name, type;

    File(String n1, String n2, String t, int s) {
        super(n1);
        name = n2; type = t; size = s;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printFile() {
        System.out.println(type + "   " + name + "   " + size + "bytes");
    }
}
