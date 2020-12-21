abstract public class Animal {
    protected int dispersLimit = 20; //in percent

    protected abstract void run(int length);

    protected abstract void swim(int length);

    protected abstract void jampOver(double hight);
}
