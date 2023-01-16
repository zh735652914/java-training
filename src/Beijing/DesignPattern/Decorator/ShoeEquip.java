package Beijing.DesignPattern.Decorator;

import Beijing.DesignPattern.Decorator.Interface.IEquip;

/**
 * 鞋子
 *
 * @author zhouhao
 * @date 2023/1/16 21:50
 */
public class ShoeEquip implements IEquip {
    @Override
    public int caculateAttack() {
        return 10;
    }

    @Override
    public String description() {
        return "鞋子";
    }
}
