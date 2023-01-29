package beijing.designpattern.factory.simple;

/**
 * @author zhouhao
 * @date 2023/1/29 17:02
 */
public abstract class Roujiamo {
    protected String name;

    /*
    准备
     */
    public void prepare() {
        System.out.println("揉面-剁肉-完成准备工作");
    }

    /*
    包装
     */
    public void pack() {
        System.out.println("肉夹馍-专用袋-包装");
    }

    /*
    制作
     */
    public void fire() {
        System.out.println("肉夹馍-专用设备-烘烤");
    }
}
