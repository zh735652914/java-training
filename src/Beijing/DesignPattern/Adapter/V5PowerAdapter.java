package Beijing.DesignPattern.Adapter;

import Beijing.DesignPattern.Adapter.Interface.V5Power;

/**
 * 适配器
 *
 * @author zhouhao
 * @date 2023/1/29 16:10
 */
public class V5PowerAdapter implements V5Power {
    private final V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
        int power = v220Power.provideV220Power();
        System.out.println("适配器改变了电压");
        return 5;
    }
}
