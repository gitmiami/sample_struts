import java.util.*;

public class StackExample {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();
		
		stack.addLast("(1)");
		System.out.println("スタックの状態:" + stack);
		stack.addLast("(2)");
		System.out.println("スタックの状態:" + stack);
		stack.addLast("(3)");
		System.out.println("スタックの状態:" + stack);
		stack.addLast("(4)");
		System.out.println("スタックの状態:" + stack);
		
		while(!stack.isEmpty()) {
			System.out.println("要素の取り出し:" + stack.removeLast());
			System.out.println("スタックの状態" + stack);
		}
	}
}
