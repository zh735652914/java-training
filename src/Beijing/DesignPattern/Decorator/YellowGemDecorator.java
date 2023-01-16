package Beijing.DesignPattern.Decorator;

import Beijing.DesignPattern.Decorator.Interface.IEquip;
import Beijing.DesignPattern.Decorator.Interface.IEquipDecorator;

/**
 * 黄宝石装饰品
 *
 * @author zhouhao
 * @date 2023/1/16 21:53
 */
public class YellowGemDecorator implements IEquipDecorator {
    // 每个装饰品维护一个装备
    private final IEquip equip;

    public YellowGemDecorator(IEquip equip) {
        this.equip = equip;
    }

    @Override
    public int caculateAttack() {
        return 10 + equip.caculateAttack();
    }

    @Override
    public String description() {
        return equip.description() + "黄宝石";
    }
}
