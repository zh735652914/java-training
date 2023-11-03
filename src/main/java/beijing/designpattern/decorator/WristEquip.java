package beijing.designpattern.decorator;

import beijing.designpattern.decorator.Interface.IEquip;

/**
 * 护腕
 *
 * @author zhouhao
 * @date 2023/1/16 21:49
 */
public class WristEquip implements IEquip {
    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "护腕";
    }
}
