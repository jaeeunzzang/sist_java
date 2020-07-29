package Test7;

import java.util.Scanner;
import java.util.Vector;

public class VectorMember {
	Scanner sc = new Scanner(System.in);
	Vector<Member> vec = new Vector<Member>();

	public boolean idCheck(String id) {
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).getId().equals(id))
				return true;
		}
		return false;
	}

	public int getIndex(String id) {
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).getId().equals(id))
				return i;
		}
		return -1;
	}

	public void memberAdd() {
		Member m = new Member();
		String id = null;
		do {
			System.out.print("ID:");
			id = sc.next();
			m.setId(id);
		} while (idCheck(id)); // id�� �ߺ��Ǹ� true->�ݺ�
		System.out.print("Name:");
		m.setName(sc.next());
		System.out.print("Hobby:");
		m.setHobby(sc.next());
		System.out.print("Age:");
		m.setAge(sc.nextInt());
		vec.add(m);
	}

	public void memberDelete() {
		System.out.print("������ ȸ���� ID �Է�>>");
		int index = getIndex(sc.next().trim());
		if (index == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		}
		System.out.println(vec.remove(index).getName().concat("�� ����"));
	}

	public void disp(int index) {
		System.out.println(vec.get(index).toString().substring(7));
	}

	public void memberSearch(int num) {
		if (num == 1) {
			System.out.print("�˻��� �̸� �Է� >>");
			String name = sc.next();
			for (int i = 0; i < vec.size(); i++) {
				if (vec.get(i).getName().equals(name)) {
					disp(i);
				}
			}
		}
		if (num == 2) {
			System.out.print("�˻��� ��� �Է� >>");
			String hobby = sc.next();
			for (int i = 0; i < vec.size(); i++) {
				if (vec.get(i).getHobby().equals(hobby)) {
					disp(i);
				}
			}
		}
		if (num == 3) {
			System.out.print("�˻��� ���� �Է� >>");
			int age = sc.nextInt();
			for (int i = 0; i < vec.size(); i++) {
				if (vec.get(i).getAge() == age) {
					disp(i);
				}
			}
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

	public void modify(int index) {
		System.out
				.println("���� �� " + vec.get(index).toString().substring(8, vec.get(index).toString().lastIndexOf("]")));
		System.out.println("MODIFY: 1.Name 2.Hobby 3.Age");
		switch (sc.nextInt()) {
		case 1:
			System.out.print("������ �̸� �Է�>>");
			vec.get(index).setName(sc.next());
			break;
		case 2:
			System.out.print("������ ��� �Է�>>");
			vec.get(index).setHobby(sc.next());
			break;
		case 3:
			System.out.print("������ ���� �Է�>>");
			vec.get(index).setAge(sc.nextInt());
			break;

		default:
			break;
		}
	}

	public void memberList() {
		System.out.println("����������������������������������������������������������������������������������������������������������������");
		for (Member m : vec) {
			System.out.println(String.format("��" + "%-54s��", m));
		}
		System.out.println("����������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}

	public void memberSearchMain() {
		System.out.print("SEARCH: 1.Name 2.Hobby 3.Age >>");
		switch (sc.nextInt()) {
		case 1:
			memberSearch(1);
			break;
		case 2:
			memberSearch(2);
			break;
		case 3:
			memberSearch(3);
			break;
		default:
			System.out.println("��Ȯ�� ��ȣ �Է�");
			break;
		}
	}

	public void mainMenu() {
		while (true) {
			System.out.print("1.ADD 2.DELETE 3.SEARCH 4.MODIFY 5.LIST 6.QUIT >>");
			switch (sc.nextInt()) {
			case 1:
				memberAdd();
				continue;
			case 2:
				memberDelete();
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
				System.out.println("��Ȯ�� ��ȣ �Է�");
				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		VectorMember v = new VectorMember();
		v.mainMenu();
	}
}
