package beijing.designpattern.factory.simple;

/**
 * @author zhouhao
 * @date 2023/1/29 17:13
 */
public class RoujiaMoStore {
    private final SimpleRouJiaMoFactroy factroy;

    public RoujiaMoStore(SimpleRouJiaMoFactroy factroy) {
        this.factroy = factroy;
    }

    /**
     * 根据传入类型卖不同的肉夹馍
     */
    public Roujiamo sellRouJiaMo(String type) {
        Roujiamo rouJiaMo = factroy.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
