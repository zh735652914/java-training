package Beijing.DesignPattern.Decorator;

import Beijing.DesignPattern.Decorator.Interface.IEquip;

/**
 * 武器
 *
 * @author zhouhao
 * @date 2023/1/16 21:47
 */
public class ArmEquip implements IEquip {
    @Override
    public int caculateAttack() {
        return 20;
    }

    @Override
    public String description() {
        return "帽子";
    }
}
