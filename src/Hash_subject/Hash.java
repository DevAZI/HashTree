package Hash_subject;

public class Hash {
	public class HashTable {
		private int n; //�ؽ����̺� �ִ� ������ ��
		private int m; //�ؽ����̺� ũ��
		private Object[] keys; //Ű �迭
		private Object[] values; //��� �迭
		//ũ�Ⱑ capacity�� �ؽ����̺� �ʱ�ȭ
		public int DH(int key)
		{
		   int HH = 7;
		   return HH - (key % HH);
		}
		public HashTable(int capacity) {
		m = capacity;
		n = 0;
		keys = new Object[m];
		values = new Object[m];
		}
		//�ؽð� ���ϱ�
		private int hashValue(Object key) {
		return (key.hashCode() & 0x7fffffff) % m;
		}
		//Ű�� ����� �ؽ����̺� ����
		public void put(Object key, Object val) {
		if (n >= m / 2) resize(2*m); //����(doubling)
		int i;
		//��������
		for(i = hashValue(key); keys[i] != null; i = (i+1) % m) {
		if(keys[i].equals(key)) { //�ش� Ű�� �����ϸ�
			{	i = (key.hashCode() & 0x7fffffff) % 7;
		values[i] = val; //��� ������Ʈ
			}
		
		return;
		}
		}
		keys[i] = key;
		values[i] = val;n++;
		}
		//�ؽ����̺� ��������(���ؽ�)
		private void resize(int new_capacity) {
		HashTable temp = new HashTable(new_capacity);
		for(int i=0;i<m;i++) {
		if (keys[i] != null) {
		temp.put(keys[i], values[i]); //�����̺�(temp)�� ����(���ؽ�)
		}
		}
		//temp�� �ؽ����̺��!!!
		keys = temp.keys;
		values = temp.values;
		m = temp.m;
		n = temp.n;
		}
		//�־��� Ű�� �˻��ϱ�
		public Object get(Object key) {
		for(int i = hashValue(key); keys[i] != null; i = (i+1) % m)
		if(keys[i].equals(key))
		return values[i];
		return null;
		}
		//�ؽ����̺� ���(������)
		public void printHT() {
		System.out.println("Hash Table with size " + m + " and " + n + " elements");
		for(int i=0;i<m;i++) {
		if(keys[i] == null)
		System.out.println("[" + i + "] ");
		else
		System.out.println("[" + i + "] " + keys[i]);
		}
		}}
}
