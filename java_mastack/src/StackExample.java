import java.util.*;

public class StackExample {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();
		
		stack.addLast("(1)");
		System.out.println("�X�^�b�N�̏��:" + stack);
		stack.addLast("(2)");
		System.out.println("�X�^�b�N�̏��:" + stack);
		stack.addLast("(3)");
		System.out.println("�X�^�b�N�̏��:" + stack);
		stack.addLast("(4)");
		System.out.println("�X�^�b�N�̏��:" + stack);
		
		while(!stack.isEmpty()) {
			System.out.println("�v�f�̎��o��:" + stack.removeLast());
			System.out.println("�X�^�b�N�̏��" + stack);
		}
	}
}
