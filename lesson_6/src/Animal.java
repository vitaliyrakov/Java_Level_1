abstract public class Animal {
    Random rand = new Random();
    
    protected int dispersLimit = 20; //in percent
    protected double dispersLimitK = (1 - dispersLimit/100.0+rand.nextInt(dispersLimit*2)/100.0);

    protected abstract void run(int length);

    protected abstract void swim(int length);

    protected abstract void jampOver(double hight);
}
