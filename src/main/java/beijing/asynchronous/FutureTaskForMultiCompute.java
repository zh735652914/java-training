package beijing.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhouhao
 * @date 2023/11/3 22:24
 * <p>
 * 面试闻到过这个：并行调用外部三个接口，三个接口都返回了才继续进行，应该怎么做？
 */
public class FutureTaskForMultiCompute {

    private class ComputeTask implements Callable<Integer> {

        private int result = 0;
        private String taskName = "";

        public ComputeTask(Integer iniResult, String taskName) {
            result = iniResult;
            this.taskName = taskName;
            System.out.println("生成子线程计算任务: " + taskName);
        }

        public String getTaskName() {
            return this.taskName;
        }

        @Override
        public Integer call() throws Exception {
//            for (int i = 0; i < 100; i++) {
//                result = i;
//            }
            result = 100;
            // 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取得FutureTask的结果是等待直至完成。
            Thread.sleep(5000);
            System.out.println("子线程计算任务: " + taskName + " 执行完成!" + " 结果为：" + result);
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        FutureTaskForMultiCompute inst = new FutureTaskForMultiCompute();
        // 创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<>();
        // 创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            // 传入Callable对象创建FutureTask对象
            FutureTask<Integer> ft = new FutureTask<>(inst.new ComputeTask(i, "子线程—" + i));
            taskList.add(ft);
            // 提交给线程池执行任务，也可以通过exec.invokeAll(taskList)一次性提交所有任务;
            exec.submit(ft);
        }

        System.out.println("所有计算任务提交完毕, 主线程接着干其他事情！");
        System.out.println("主线程休眠开始！");
        Thread.sleep(10000);
        System.out.println("主线程休眠完毕！");

        // 开始统计各计算线程计算结果
        int totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                //FutureTask的get方法会自动阻塞,直到获取计算结果为止
                totalResult = totalResult + ft.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=======");
        // 关闭线程池
        exec.shutdown();
        System.out.println("多任务计算后的总结果是:" + totalResult);

    }
}
