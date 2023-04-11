package beijing.mq;

/**
 * @author zhouhao
 * @date 2023/4/11 21:20
 */
public class ConsumeClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
//        String message = client.consume();
//        System.out.println("消费的消息是：" + message);

        for (int i = 0; i < 5; i++) {
            System.out.println("消费的消息是：" + MqClient.consume());
        }
    }
}
