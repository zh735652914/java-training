package beijing.designpattern.factory.simple;

/**
 * @author zhouhao
 * @date 2023/1/29 17:15
 */
public class SimpleRouJiaMoFactroy {
    public Roujiamo createRouJiaMo(String type) {
        Roujiamo rouJiaMo = null;
        if (type.equals("Suan")) {
            rouJiaMo = new SuanRouJiaMo();
        } else if (type.equals("Tian")) {
            rouJiaMo = new TianRouJiaMo();
        } else if (type.equals("La")) {
            rouJiaMo = new LaRouJiaMo();
        }
        return rouJiaMo;
    }
}
