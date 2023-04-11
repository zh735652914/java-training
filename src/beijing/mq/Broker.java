package beijing.mq;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhouhao
 * @date 2023/4/9 22:59
 */
public class Broker {
    private final static int MAX_SIZE = 3;
    private static final ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    public static void produce(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息中心投递消息： " + msg + "当前留存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息中心暂存的消息达到了最大负载，不能继续放入消息！");
        }
    }

    public static String consume() {
        String msg = messageQueue.poll();
        if (msg != null) {
            System.out.println("已经消费信息：" + msg + "， 当前暂存消息数量是：" + messageQueue.size());
        } else {
            System.out.println("已经没有消息可供消费！");
        }
        System.out.println("=============");
        return msg;
    }

    public static boolean flush() {
        messageQueue.clear();
        System.out.println("消息中心已经清空所有消息！");
        return true;
    }
}
