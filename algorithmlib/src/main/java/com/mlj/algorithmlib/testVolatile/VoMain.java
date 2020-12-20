package testVolatile;

public class VoMain {
	//是否停止 变量
		private static volatile boolean stop = false;
		
		public static void main(String[] args) throws InterruptedException {
			//启动线程 1，当 stop 为 true，结束循环
			new Thread(() -> {
			    System.out.println("线程 1 正在运行...");
//			    while (!stop) ;
			    while (!stop) {
//			    	System.out.println("线程 1 yizhi");
				};
			    System.out.println("线程 1 终止");
			}).start();
			
			//休眠 10 毫秒
			Thread.sleep(10);
			
			//启动线程 2， 设置 stop = true
			new Thread(() -> {
			    System.out.println("线程 2 正在运行...");
			    stop = true;
			    System.out.println("设置 stop 变量为 true.");
			}).start();
		}

}
