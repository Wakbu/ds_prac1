package hw;

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
	
	// 리스트의 맨 뒤에 data를 삽입
	public void add(int data) {
		Node temp = head;
		Node newNode = new Node();
		newNode.data = data;
		
		// head가 null인 경우 head에 새로 만든 노드를 연결함
		if(head == null) {
			head = newNode;
		} else {
			// node가 null이 아닌경우 temp를 통해 node list를 마지막 node의 위치로 이동 시킴
			while(temp.link != null) {
				temp = temp.link;
			}
			
			// 마지막 node의 링크에 새로운 node를 참조
			temp.link = newNode;
		}
		
		// 새로운 노드가 추가 되었기 때문에 list size 변수 값 증가
		size++;
	}
	
	public void remove(int data) {
		Node temp = head;
		Node pre = head;
		
		// temp가 null일 경우 리스트에 아무 값도 없는 것이기 때문에 구분해야 함
		if(temp == null) {
			System.out.println("-1");
		} else {
			// temp가 null이 아닐 경우
			while(temp.link != null) {
				// 현재 temp의 data와 삭제하고자 하는 데이터가 같은지 비교
				if(temp.data == data) {
					/* 
					 * temp의 data가 비교하고자 하는 데이터와 같은 경우
					 * 삭제하고자 하는 노드가 제일 첫 번째 node이면, 즉, head이면 head를 temp의 링크(원래 head에 연결된 node의 다음 node)로 연결해준다.
					 * 그렇지 않을 경우 전의 node의 링크에 삭제하고자 하는 node의 link를 연결해줌
					 * 즉, 삭제해야하는 node의 다음 node를 연결해 삭제 node를 garbage로 만듬
					*/
					if(temp == head) {
						head = temp.link;
					} else {
						pre.link = temp.link;
					}
					
					// list 사이즈 변수 값 감소 후 break
					size--;
					break;
				}
				
				// pre는 항상 다음 비교하고자 하는 node의 전 node를 가지고 있어야한다.
				// 때문에 temp를 다음 node로 옮기기 전에 pre에 현재 temp 값을 저장한다.
				pre = temp;
				temp = temp.link;
			}
		}
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
		System.out.println("lab6_1:홍길동");

		// (1) MyLinkedList형 리스트 객체 list를 생성
		MyLinkedList list = new MyLinkedList();

		// (2) List 뒤쪽부터 데이터 추가
		list.add(10);
		list.add(30);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println(list);
		
		list.remove(30);
		list.remove(20);
		list.remove(50);
		list.remove(40);
		list.remove(10);
		list.remove(30);
		list.remove(60);
		System.out.println(list);
	}

}
