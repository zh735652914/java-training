package Beijing.DesignPattern.Decorator;

import Beijing.DesignPattern.Decorator.Interface.IEquip;
import Beijing.DesignPattern.Decorator.Interface.IEquipDecorator;

/**
 * 红宝石装饰品
 *
 * @author zhouhao
 * @date 2023/1/16 21:55
 */
public class RedGemDecorator implements IEquipDecorator {
    // 每个装饰品维护一个装备
    private final IEquip equip;

    public RedGemDecorator(IEquip equip) {
        this.equip = equip;
    }

    @Override
    public int caculateAttack() {
        return 15 + equip.caculateAttack();
    }

    @Override
    public String description() {
        return equip.description() + "红宝石";
    }
}
