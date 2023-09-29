package animals;

abstract public class Animal {

    protected String name;
    protected int age;
    protected boolean isRunMethodImplemented = false;
    protected boolean isStayMethodImplemented = false;
    protected static int countOfAnimals;

    protected abstract void say();

    public void run() {
        if (isRunMethodImplemented) {
            System.out.println(this.name + " бежит");
        } else {
            throw new UnsupportedOperationException("Метод run не реализован");
        }
    }

    public void stay() {
        if (isRunMethodImplemented) {
            System.out.println(this.name + " стоит");
        } else {
            throw new UnsupportedOperationException("Метод run не реализован");
        }
    }

    public static void addToCountOfAnimals() {
        countOfAnimals++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRunMethodImplemented(boolean runMethodImplemented) {
        isRunMethodImplemented = runMethodImplemented;
    }

    public void setStayMethodImplemented(boolean stayMethodImplemented) {
        isStayMethodImplemented = stayMethodImplemented;
    }

    public boolean isRunMethodImplemented() {
        return isRunMethodImplemented;
    }

    public boolean isStayMethodImplemented() {
        return isStayMethodImplemented;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + this.getClass() + '\'' +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}
