package suanfa;

public class zhebanchazhao {
	public static void main(String[] args) {
			int[] array = new int[] {0,1,2,3,4,5,6,7};
			int binarySearchFun = binarySearchFun(array, 6);
			System.out.println(binarySearchFun);
	}

	// 查找返回一个位置
	public static int binarySearchFun(int[] num, int target) {
		int start = 0;
		int end = num.length - 1;
		while (start <= end) { //
//			>> 优先级比较低
			int middle = start + ((end - start) >> 1);
			if (num[middle] == target) {
				System.out.println("1111111");
				return middle;
			} else if (num[middle] > target) {
				System.out.println("22222222");
				end = middle - 1;
			} else {
				System.out.println("3333333");
				start = middle + 1;
			}
		}
		return -1;
	}
}
