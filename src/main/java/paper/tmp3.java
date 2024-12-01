package paper;

import jodd.util.StringUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 岗位在8大区的分布
 *
 * @author zhouhao
 * @date 2024/12/1 20:44
 */
public class tmp3 {

    private static Map<String, Integer> mapData;

    public static void main(String[] args) {

        String[] data = getData().split("\n");
        Map<String, Set<String>> map = new HashMap<>();
        String cap = "";
        for (String str : data) {
            if (StringUtil.isEmpty(str) || (str.contains("，") && str.contains("联邦管区"))) {
                continue;
            }

            if (!str.contains("（")) {
                cap = str;
//                System.out.println("cap : " + cap);
                Set<String> set = new HashSet<>();
                map.put(cap, set);
                continue;
            }
            if (str.contains("，")) {
                str = str.split("，")[0];
            }

            int tail = str.indexOf("（");
            str = str.substring(0, tail);
//            System.out.println(str);

            map.get(cap).add(str);
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().toString());
        }

        System.out.println("--------------------------------------");
        initData(map);


        String[] data1 = getData1().split("\n");
        int sum = 0;
        int diff = 0;
        for (String str : data1) {
            String[] tmp = str.split("\t");
            String city = tmp[0];
            int num = Integer.parseInt(tmp[1]);
            sum += num;
            if (!isInCap(map, city, num)) {
                System.out.println("不包含在内的城市为：" + city + "，岗位数：" + num);
                diff += num;
            }
        }
        System.out.println();
        System.out.println("以地区计算，岗位总数为：" + sum);
        int calSum = cal();
        System.out.println("差异岗位总数：" + diff);
        System.out.println("------八大区具体统计数据如下------");
        float sumProportion = 0;
        for (Map.Entry<String, Integer> entry : mapData.entrySet()) {
            float count = entry.getValue();
            float sumF = (float) calSum; // 分母为只有八大区的岗位数
            float proportion = count / sumF;
            sumProportion += proportion;
            System.out.println(entry.getKey() + ": " + entry.getValue() + "，占比为：" + proportion);
        }
        System.out.println("八大区占比总和为：" + sumProportion);
    }

    private static int cal() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : mapData.entrySet()) {
            sum += entry.getValue();
        }
        System.out.println("八大区岗位总和：" + sum);
        return sum;
    }

    private static boolean isInCap(Map<String, Set<String>> map, String city, int count) {
        if (city.contains("莫斯科")) {
            mapData.put("中央联邦管区", mapData.get("中央联邦管区") + count);
            return true;
        }
        if (city.contains("萨哈共和国")) {
//            mapData.put("远东联邦管区", mapData.get("远东联邦管区") + count);
            city = "萨哈";
        }
        if (city.contains("北奥塞梯-阿拉尼亚共和国")) {
            mapData.put("北高加索联邦管区", mapData.get("北高加索联邦管区") + count);
            return true;
        }
        if (city.contains("圣彼得")) {
            mapData.put("西北部联邦管区", mapData.get("西北部联邦管区") + count);
            return true;
        }
        if (city.contains("汉特-曼西自治区-尤格拉")) {
            mapData.put("乌拉尔联邦管区", mapData.get("乌拉尔联邦管区") + count);
            return true;
        }
        String name1 = city.replace("地区", "边疆区");
        String name2 = city.replace("地区", "州");
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(name1) || entry.getValue().contains(name2)) {
                mapData.put(entry.getKey(), mapData.get(entry.getKey()) + count);
                return true;
            }
        }
        return false;
    }

    private static void initData(Map<String, Set<String>> map) {
        mapData = new HashMap<>(8);
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            mapData.put(entry.getKey(), 0);
        }
    }


    private static String getData1() {
        return "阿尔泰地区\t71\n" +
                "阿穆尔州\t64\n" +
                "阿尔汉格尔斯克州\t1\n" +
                "阿斯特拉罕地区\t15\n" +
                "别尔哥罗德地区\t10\n" +
                "布良斯克州\t5\n" +
                "弗拉基米尔地区\t6\n" +
                "伏尔加格勒地区\t24\n" +
                "沃洛格达地区\t2\n" +
                "沃罗涅日州\t24\n" +
                "顿涅茨克人民共和国\t1\n" +
                "犹太自治区\t2\n" +
                "外贝加尔地区\t30\n" +
                "伊尔库茨克地区\t68\n" +
                "加里宁格勒地区\t6\n" +
                "卡卢加地区\t19\n" +
                "堪察加地区\t1\n" +
                "克麦罗沃州\t42\n" +
                "基洛夫地区\t7\n" +
                "克拉斯诺达尔地区\t63\n" +
                "克拉斯诺亚尔斯克地区\t72\n" +
                "库尔干地区\t2\n" +
                "库尔斯克地区\t7\n" +
                "列宁格勒地区\t48\n" +
                "利佩茨克州\t10\n" +
                "卢甘斯克人民共和国\t1\n" +
                "莫斯科\t1417\n" +
                "莫斯科地区\t254\n" +
                "摩尔曼斯克州\t2\n" +
                "下诺夫哥罗德州\t51\n" +
                "诺夫哥罗德地区\t1\n" +
                "新西伯利亚地区\t145\n" +
                "鄂木斯克地区\t49\n" +
                "奥伦堡地区\t30\n" +
                "奥廖尔地区\t5\n" +
                "奔萨地区\t7\n" +
                "彼尔姆地区\t50\n" +
                "滨海边疆区\t143\n" +
                "普斯科夫州\t11\n" +
                "巴什科尔托斯坦共和国\t53\n" +
                "布里亚特共和国\t18\n" +
                "达吉斯坦共和国\t2\n" +
                "印古什共和国\t1\n" +
                "卡累利阿共和国\t1\n" +
                "科米共和国\t1\n" +
                "克里米亚共和国\t7\n" +
                "马里埃尔共和国\t1\n" +
                "莫尔多瓦共和国\t1\n" +
                "萨哈共和国（雅库特）\t3\n" +
                "北奥塞梯-阿拉尼亚共和国\t1\n" +
                "鞑靼斯坦共和国\t91\n" +
                "哈卡斯共和国\t1\n" +
                "罗斯托夫地区\t59\n" +
                "梁赞地区\t11\n" +
                "萨马拉地区\t45\n" +
                "圣彼得堡\t404\n" +
                "萨拉托夫地区\t13\n" +
                "萨哈林地区\t1\n" +
                "斯维尔德洛夫斯克州\t133\n" +
                "斯摩棱斯克地区\t3\n" +
                "斯塔夫罗波尔地区\t19\n" +
                "坦波夫地区\t3\n" +
                "特维尔地区\t6\n" +
                "托木斯克州\t24\n" +
                "图拉地区\t24\n" +
                "秋明地区\t40\n" +
                "乌德穆尔特共和国\t60\n" +
                "乌里扬诺夫斯克州\t8\n" +
                "哈巴罗夫斯克地区\t77\n" +
                "汉特-曼西自治区-尤格拉\t30\n" +
                "车里雅宾斯克州\t49\n" +
                "楚瓦什共和国\t7\n" +
                "亚马尔-涅涅茨自治区\t5\n" +
                "雅罗斯拉夫尔地区\t14";
    }

    private static String getData() {
        return "中央联邦管区\n" +
                "中央联邦管区（Центральный федеральный округ），首府莫斯科\n" +
                "\n" +
                "别尔哥罗德州（Белгородская Область）\n" +
                "布良斯克州（Брянская Область）\n" +
                "伊万诺沃州（Ивановская область）\n" +
                "卡卢加州（Калужская Область）\n" +
                "科斯特罗马州（Костромская Область）\n" +
                "库尔斯克州（Курскская Область）\n" +
                "利佩茨克州（Липецская Область）\n" +
                "莫斯科自治市（Москва）\n" +
                "莫斯科州（Московская Область）\n" +
                "奥廖尔州（Орёл / Орловская область）\n" +
                "梁赞州（Рязанская Область）\n" +
                "斯莫棱斯克州（Смоленская Область）\n" +
                "坦波夫州（Тамбовская Область）\n" +
                "特维尔州（Тверская область）\n" +
                "图拉州（Тульская область）\n" +
                "弗拉基米尔州（Владимирская область）\n" +
                "沃罗涅日州（Воронежская область）\n" +
                "雅罗斯拉夫尔州（Ярославская Область）\n" +
                "西北部联邦管区\n" +
                "西北部联邦管区（Северо-западный федеральный округ），首府圣彼得堡\n" +
                "\n" +
                "阿尔汉格尔斯克州（Архангельская Область）\n" +
                "涅涅茨自治区（Ненецкий автономный Округ）\n" +
                "加里宁格勒州（Калининградская Область）\n" +
                "卡累利阿共和国（Республика Карелия）\n" +
                "科米共和国（Республика Коми）\n" +
                "摩尔曼斯克州（Мурманская Область）\n" +
                "诺夫哥罗德州（Новгородская Область）\n" +
                "普斯科夫州（Псковская Область）\n" +
                "圣彼得堡自治市（Санкт-Петербург）\n" +
                "列宁格勒州（Ленинградская Область）\n" +
                "沃洛格达州（Вологодская Область）\n" +
                "伏尔加联邦管区\n" +
                "伏尔加联邦管区（Приволжский федеральный округ），首府下诺夫哥罗德\n" +
                "\n" +
                "巴什科尔托斯坦共和国（Республика Башкортостан （Башкирия)）\n" +
                "楚瓦什共和国（Республика Чувашия）\n" +
                "基洛夫州（Кировская Область）\n" +
                "马里埃尔共和国（Республика Марий Эл）\n" +
                "莫尔多瓦共和国（Республика Мордовия）\n" +
                "下诺夫哥罗德州（Нижний Новгород Область）\n" +
                "奥伦堡州（Оренбургская Область）\n" +
                "奔萨州（Пензенская область）\n" +
                "彼尔姆边疆区（Пермская Край）\n" +
                "萨马拉州（Самара）\n" +
                "萨拉托夫州（Саратовская Область）\n" +
                "鞑靼斯坦共和国（Республика Татарстан）\n" +
                "乌德穆尔特共和国（Республика Удмуртия）\n" +
                "乌里扬诺夫斯克州（Ульяновская Область）\n" +
                "南部联邦管区\n" +
                "南部联邦管区（Южный федеральный округ），首府顿河畔罗斯托夫\n" +
                "\n" +
                "阿迪格共和国（Республика Адыгея）\n" +
                "阿斯特拉罕州（Астраханская Область）\n" +
                "卡尔梅克共和国（Калмыкия-Кхалмтангч Республика）\n" +
                "克拉斯诺达尔边疆区（Краснодарский край）\n" +
                "罗斯托夫州（Ростовская Область）\n" +
                "伏尔加格勒州（Волгоградская Область）\n" +
                "克里米亚共和国（Республика Крым）**\n" +
                "塞瓦斯托波尔（Севасто́поль）**\n" +
                "\n" +
                "北高加索联邦管区\n" +
                "北高加索联邦管区（Се́веро-Кавка́зский федера́льный о́круг），首府皮亚季戈尔斯克\n" +
                "\n" +
                "车臣共和国（Чеченская республика）\n" +
                "达吉斯坦共和国（Республика Дагестан）\n" +
                "印古什共和国（Республика Ингушетия）\n" +
                "卡拉恰伊-切尔克斯共和国（Карачаево-Черкесская республика）\n" +
                "北奥塞梯-阿兰共和国（Республика Северная Осетия–Алания）\n" +
                "斯塔夫罗波尔边疆区（Ставропольский край）\n" +
                "卡巴尔达-巴尔卡尔共和国（Кабардино-Балкарская республика）\n" +
                "乌拉尔联邦管区\n" +
                "乌拉尔联邦管区（Уральский федеральный округ)，首府叶卡捷琳堡\n" +
                "\n" +
                "库尔干州（Курганская Область）\n" +
                "斯维尔德洛夫斯克州（Свердловская Область）\n" +
                "秋明州（Тюменская Область）\n" +
                "汉特-曼西自治区（Ханты-Мансийский автономный округ）\n" +
                "亚马尔-涅涅茨自治区（Ямало-Ненецкий автономный округ）\n" +
                "车里雅宾斯克州（Челябинская Область）\n" +
                "西伯利亚联邦管区\n" +
                "西伯利亚联邦管区（Сибирский федеральный округ）\n" +
                "\n" +
                "阿尔泰共和国（Республика Алтай）\n" +
                "阿尔泰边疆区（Алтайский Край）\n" +
                "伊尔库茨克州（Иркутская область）\n" +
                "科麦罗沃州（Кемеровская область）\n" +
                "克拉斯诺亚斯克边疆区（Красноярский Край）\n" +
                "新西伯利亚州（Новосибирская область）\n" +
                "鄂木斯克州（Омская область）\n" +
                "托木斯克州（Томская область）\n" +
                "图瓦共和国（Республика Тыва）\n" +
                "哈卡斯共和国（Республика Хакасия）\n" +
                "远东联邦管区\n" +
                "远东联邦管区（Дальневосточный федеральный округ），首府海参崴\n" +
                "\n" +
                "阿穆尔州（Амурская Область）\n" +
                "犹太自治州（Еврейская автономная Область）\n" +
                "堪察加边疆区（Камчатская Край）\n" +
                "哈巴罗夫斯克边疆区（Хабаровский Край）\n" +
                "马加丹州（Магаданская Область）\n" +
                "楚科奇自治区（Чукотский автономный округ）\n" +
                "滨海边疆区（Приморский Край）\n" +
                "萨哈（雅库特）共和国（Республика Саха (Якутия)）\n" +
                "萨哈林州（Сахалинская Область）\n" +
                "布里亚特共和国（Республика Бурятия）\n" +
                "外贝加尔边疆区（Забайкальский край）";
    }
}
