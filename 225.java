
public class MyStack {
    //�Լ�����д���ԣ�����Ϊ�ο����ϴ����Լ��ҵ���⣬�Ҿ��������������ȥģ�⣬����û���õ�����Queue����
	// ά���������У���������һ������Ϊ�գ�Ϊpop��top����׼��
    private List<Integer> aList = new LinkedList<>();
	private List<Integer> bList = new LinkedList<>();
	// Push element x onto stack.
	public void push(int x) {
	// ���aList�ǿգ��ͽ�x��ӵ�aList�У���������ʱ�ǵ��ų�
		if (!aList.isEmpty()) {
			aList.add(x);
			}
	// ��������ӵ�bList��
		else {
			bList.add(x);
			}
	}
	// Removes the element on top of the stack.
	public void pop() {
	// ����������������һ��Ϊ�գ���aList���÷ǿգ���A�գ���ô��B��A���� ����֮��B����A����
	if (aList.isEmpty()) {
		List<Integer> tmp = bList;
		bList = aList;
		aList = tmp;
		}
	// �����һ��Ԫ���ⶼת�Ƶ�bList��
	while (aList.size() > 1) {
		bList.add(aList.remove(0));
		}
	// ɾ�����һ��Ԫ�أ���Ӧ������ջ��ջ��Ԫ�أ�����ΪջҪɾ��������ģ�����β����Ԫ��
	aList.clear();
	}
	// Get the top element.
	public int top() {
	// ����������������һ��Ϊ�գ���aList���÷ǿ�
	if (aList.isEmpty()) {
		List<Integer> tmp = bList;
		bList = aList;
		aList = tmp;
		}
	// �����һ��Ԫ���ⶼת�Ƶ�bList��
	while (aList.size() > 1) {
		bList.add(aList.remove(0));
	}
	bList.add(aList.get(0));
	return aList.remove(0);
	}
	// Return whether the stack is empty.
	public boolean empty() {
		return aList.isEmpty() && bList.isEmpty();
		}
	}