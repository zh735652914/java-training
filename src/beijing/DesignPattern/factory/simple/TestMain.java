package beijing.designpattern.factory.simple;

/**
 * @author zhouhao
 * @date 2023/1/29 17:20
 */
public class TestMain {
    public static void main(String[] args) {
        SimpleRouJiaMoFactroy simpleRouJiaMoFactroy = new SimpleRouJiaMoFactroy();
        RoujiaMoStore roujiaMoStore = new RoujiaMoStore(simpleRouJiaMoFactroy);
        Roujiamo roujiamo = roujiaMoStore.sellRouJiaMo("Tian");
        System.out.println(roujiamo.name);
    }
}
