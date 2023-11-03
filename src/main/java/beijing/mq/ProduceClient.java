package beijing.mq;

/**
 * @author zhouhao
 * @date 2023/4/11 21:08
 */
public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
//        client.produce("Hello World");
        for (int i = 0; i < 4; i++) {
            MqClient.produce("Hello World " + i);
        }
//        client.produce("FLUSH");
    }
}
