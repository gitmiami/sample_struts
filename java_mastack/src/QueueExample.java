import java.util.*;

public class QueueExample {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("(1)");
		System.out.println("�L���[�̏��:" + queue);
		queue.offer("(2)");
		System.out.println("�L���[�̏��:" + queue);
		queue.offer("(3)");
		System.out.println("�L���[�̏��:" + queue);
		queue.offer("(4)");
		System.out.println("�L���[�̏��:" + queue);
		
		while(!queue.isEmpty()) {
			System.out.println("�v�f�̎��o��:" + queue.poll());
			System.out.println("�L���[�̏��" + queue);
		}
	}
}
