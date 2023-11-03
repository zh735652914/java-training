package beijing.designpattern.decorator;

import beijing.designpattern.decorator.Interface.IEquip;
import beijing.designpattern.decorator.Interface.IEquipDecorator;

/**
 * 蓝宝石装饰品
 *
 * @author zhouhao
 * @date 2023/1/16 21:51
 */
public class BlueGemDecorator implements IEquipDecorator {
    // 每个装饰品维护一个装备
    private final IEquip equip;

    public BlueGemDecorator(IEquip equip) {
        this.equip = equip;
    }

    @Override
    public int caculateAttack() {
        return 5 + equip.caculateAttack();
    }

    @Override
    public String description() {
        return equip.description() + "蓝宝石";
    }
}
