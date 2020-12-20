package binarytreetest;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class TestMainFun {
	private static Node cuNode;

	public static void main(String[] args) {
		Node headNode = new Node(0);
		Node leftNode = new Node(1);
		Node leftleftNode = new Node(3);
		Node leftRightNode = new Node(4);
		Node rightNode = new Node(2);
		Node rightLeftNode = new Node(5);
		Node rightRightNode = new Node(6);

		headNode.leftNode = leftNode;
		headNode.rightNode = rightNode;

		leftNode.leftNode = leftleftNode;
		leftNode.rightNode = leftRightNode;

		rightNode.leftNode = rightLeftNode;
		rightNode.rightNode = rightRightNode;

		////// 先序遍历///////
		// preOrderTraverse(headNode);

		////// 中序遍历////
//		inOrderTraverse(headNode);

		// 层次遍历
//		levelOrderTraverse(headNode);

		// 是否有环
		ifHasCircle(headNode);
	}

	// 使用快慢指针，查找链表上是否有环
	private static boolean ifHasCircle(Node headNode) {
		Node slowNode = headNode;
		Node fastNode = headNode;
		// 比较的是 走一步和 走两步的比较，需要保证[走一步可]走，走[第二步可]走
		while (slowNode != null && fastNode.nextNode != null) {
			// 也是提前走一步
			slowNode = slowNode.nextNode;
			fastNode = fastNode.nextNode.nextNode;
			if (slowNode == fastNode) {
				return true;
			}
		}
		return false;
	}

	// 层次遍历 使用队列进行访问
	private static void levelOrderTraverse(Node headNode) {
		ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<Node>(16);
		Node cuNode = headNode;
		queue.add(cuNode);
		while (!queue.isEmpty()) {
			cuNode = queue.poll();
			System.out.println(cuNode.data);// 访问出队列的结点
			if (cuNode.leftNode != null) {
				queue.add(cuNode.leftNode);
			}
			if (cuNode.rightNode != null) {
				queue.add(cuNode.rightNode);
			}
		}

	}

	// 中序遍历和先序遍历是一样的 只是需要访问的顺序和位置 是不一样的
	private static void inOrderTraverse(Node headNode) {
		Stack<Node> stack = new Stack<Node>();
		Node cuNode = headNode;
		while (cuNode != null || !stack.isEmpty()) {
			while (cuNode != null) {
				stack.push(cuNode);
				cuNode = cuNode.leftNode;
			}
			if (!stack.isEmpty()) {
				cuNode = stack.pop(); // 这里拿到 会有一些用处
				System.out.println(cuNode.data);
				cuNode = cuNode.rightNode;
			}
		}
	}

	// 中左右 中左中的转换
	private static void preOrderTraverse(Node headNode) {
		Stack<Node> stack = new Stack<Node>();
		Node cuNode = headNode;
		while (cuNode != null || !stack.isEmpty()) {
			// 这里是while找到底
			while (cuNode != null) {
				// 先序遍历
				System.out.println(cuNode.data);
				stack.push(cuNode);
				cuNode = cuNode.leftNode;
			}
			// 这里是if 进行一次其他树的判断 不要用while
			if (!stack.isEmpty()) {
				cuNode = stack.pop(); // 这里拿出来的没有用，因为已经访问过了！！！！！
				cuNode = cuNode.rightNode;
			}
		}
	}
}

class Node {
	int data;
	Node leftNode;
	Node rightNode;

	public Node(int data) {
		this.data = data;
	}
}