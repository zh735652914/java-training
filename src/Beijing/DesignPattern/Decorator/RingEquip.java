package Beijing.DesignPattern.Decorator;

import Beijing.DesignPattern.Decorator.Interface.IEquip;

/**
 * 戒指
 *
 * @author zhouhao
 * @date 2023/1/16 21:48
 */
public class RingEquip implements IEquip {
    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "戒指";
    }
}
