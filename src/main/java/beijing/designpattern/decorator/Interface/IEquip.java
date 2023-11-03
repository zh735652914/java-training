package beijing.designpattern.decorator.Interface;

/**
 * 装备接口
 *
 * @author zhouhao
 * @date 2023/1/16 21:46
 */
public interface IEquip {
    /**
     * 计算攻击力
     *
     * @return
     */
    int caculateAttack();

    /**
     * 装备的描述
     *
     * @return
     */
    String description();
}
