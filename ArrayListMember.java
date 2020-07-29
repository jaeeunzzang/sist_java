package Test7;

import java.util.ArrayList;
import java.util.Scanner;

//�߰� ���� ��ȸ ����
public class ArrayListMember {
	Scanner sc = new Scanner(System.in);
	ArrayList<Member> list = new ArrayList<Member>();

	public ArrayListMember() {
		list.add(new Member("jenny", "jenny", "hihi", 25));
	}

	public int getIndex(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id))
				return i;
		}
		return -1;
	}

	public Member getData(int index) {
		return list.get(index);
	}

	public boolean idCheck(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id))
				return true;
		}
		return false;
	}

	public void memberAdd() {
		Member member = new Member();
		String id = null;
		do {
			System.out.print("ID:");
			id = sc.next();
			member.setId(id);
		} while (idCheck(id)); // id�� �ߺ��Ǹ� true->�ݺ�
		System.out.print("Name:");
		member.setName(sc.next());
		System.out.print("Hobby:");
		member.setHobby(sc.next());
		System.out.print("Age:");
		member.setAge(sc.nextInt());
		list.add(member);
	}

	public void memberDelete2() {
		System.out.println("delete");
		System.out.print("������ ID �Է� >>");
		int index = getIndex(sc.next().trim());
		if (index == -1) {
			System.out.println("������ �����Ͱ� �����ϴ�.");
			return;
		}
		System.out.println(list.remove(index).getName().concat("�� ����"));
	}

	public void memberDelete() {
		System.out.println("delete");
		System.out.print("������ ID �Է� >>");
		String id = sc.next();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getId().equals(id)) {
				System.out.println(list.get(j).getId() + "����");
				list.remove(j);
			}
		}
	}

	public void disp(int index) {
		System.out.println(list.get(index).toString());
	}

	public void memberSearchName() {
		System.out.print("�˻��� �̸� �Է� >>");
		String name = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				disp(i);
			}
		}
	}

	public void memberSearchHobby() {
		System.out.print("�˻��� ��� �Է� >>");
		String hobby = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getHobby().equals(hobby)) {
				disp(i);
			}
		}
	}

	public void memberSearchAge() {
		System.out.print("�˻��� ���� �Է� >>");
		int age = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAge() == age) {
				disp(i);
			}
		}
	}

	public void memberSearchMain() {
		System.out.print("SEARCH: 1.Name 2.Hobby 3.Age >>");
		switch (sc.nextInt()) {
		case 1:
			memberSearchName();
			break;
		case 2:
			memberSearchHobby();
			break;
		case 3:
			memberSearchAge();
			break;
		default:
			System.out.println("��Ȯ�� ��ȣ �Է�");
			break;
		}
	}

	public void modify(int index) {
		System.out.println(
				"���� �� " + list.get(index).toString().substring(8, list.get(index).toString().lastIndexOf("]")));
		System.out.println("MODIFY: 1.Name 2.Hobby 3.Age");
		switch (sc.nextInt()) {
		case 1:
			System.out.print("������ �̸� �Է�>>");
			list.get(index).setName(sc.next());
			break;
		case 2:
			System.out.print("������ ��� �Է�>>");
			list.get(index).setHobby(sc.next());
			break;
		case 3:
			System.out.print("������ ���� �Է�>>");
			list.get(index).setAge(sc.nextInt());
			break;

		default:
			break;
		}
	}

	public void modifyMain() {
		System.out.println("Modify");
		System.out.print("������ ȸ���� ID �Է� >>");
		int index = getIndex(sc.next().trim());
		if (index == -1) {
			System.out.println("ȸ�� �����Ͱ� �����ϴ�.");
			return;
		}
		modify(index);
	}

	public void memberList() {
		System.out.println("����������������������������������������������������������������������������������������������������������������");
		for (Member m : list) {
			System.out.println(String.format("��" + "%-54s��", m));
		}
		System.out.println("����������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}

	public void print() {
		while (true) {
			System.out.print("1.JOIN 2.DELETE 3.SEARCH 4.MODIFY 5.LIST 6.QUIT>>");
			switch (sc.nextInt()) {
			case 1:
				memberAdd();
				continue;
			case 2:
				memberDelete2();
				continue;
			case 3:
				memberSearchMain();
				continue;
			case 4:
				modifyMain();
				continue;
			case 5:
				memberList();
				continue;
			case 6:
				System.out.println("����");
				break;
			default:
				continue;
			}
			break;

		}

	}

	public static void main(String[] args) {
		ArrayListMember a = new ArrayListMember();
		a.print();
	}
}
