package beijing.designpattern.adapter;

import beijing.designpattern.adapter.Interface.V5Power;

/**
 * @author zhouhao
 * @date 2023/1/29 16:09
 */
public class Mobile {
    /*
    充电
     */
    public void inputPower(V5Power power) {
        int provideV5Power = power.provideV5Power();
        System.out.println("手机（客户端）：我需要5V电压充电，现在是-->" + provideV5Power + "V");
    }
}
