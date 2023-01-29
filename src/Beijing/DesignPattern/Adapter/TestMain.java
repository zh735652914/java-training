package Beijing.DesignPattern.Adapter;

import Beijing.DesignPattern.Adapter.Interface.V5Power;

/**
 * @author zhouhao
 * @date 2023/1/29 16:12
 */
public class TestMain {
    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        V5Power v5Power = new V5PowerAdapter(new V220Power());
        mobile.inputPower(v5Power);
    }
}
