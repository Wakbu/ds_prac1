package lab;

class MyLinkedList {
	private Node head; // 리스트의 첫번째 노드를 가리키는 변수
	private int size; // 리스트 길이(원소 수)

	// 연결 리스트 노드 구조
	private class Node {
		int data;
		Node link;
	}

	// 공백 리스트를 생성
	public MyLinkedList() {
		head = null;
		size = 0;
	}

	// 리스트의 맨 앞에 data를 삽입
	public void addFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.link = head;
		head = newNode;
		size++;
	}

	public boolean contains(int index) {
		Node temp = head;

		while (temp != null) {

			if (temp.data == index) {
				return true;
			}
			temp = temp.link;
		}

		return false;
	}

	// 리스트 원소들을 하나의 문자열로 만들어 리턴
	@Override
	public String toString() { // LinkedList와 구분하기 위해 [] 대신에 ()를 사용할 것
		StringBuffer result = new StringBuffer("(");
		Node temp = head;
		if (size > 0) {
			for (int i = 0; i < size - 1; i++) {
				result.append(temp.data + ", ");
				temp = temp.link;
			}
			result.append(temp.data);
		}
		result.append(")");
		return result.toString();
	}
}

public class Main_202214148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab6_1:최준용");

		// (1) MyLinkedList형 리스트 객체 list를 생성
		MyLinkedList list = new MyLinkedList();
		
		//

		// (2) list에 10이 존재하는지 여부를 알아내어 출력
		System.out.println(list.contains(10) + " ");

		// (3) list의 맨 앞에 10, 20, 30, 40을 차례대로 모두 삽입한 후, list 내용을 출력
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		System.out.println(list);

		// (4) list에 50, 20, 40, 10, 30이 존재하는지 여부를 차례대로 알아내어 출력
		System.out.print(list.contains(50) + " ");
		System.out.print(list.contains(20) + " ");
		System.out.print(list.contains(40) + " ");
		System.out.print(list.contains(10) + " ");
		System.out.print(list.contains(30) + " ");
	}

}
