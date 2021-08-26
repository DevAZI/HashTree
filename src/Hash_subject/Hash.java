package Hash_subject;

public class Hash {
	public class HashTable {
		private int n; //해시테이블에 있는 아이템 수
		private int m; //해시테이블 크기
		private Object[] keys; //키 배열
		private Object[] values; //밸류 배열
		//크기가 capacity인 해시테이블 초기화
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
		//해시값 구하기
		private int hashValue(Object key) {
		return (key.hashCode() & 0x7fffffff) % m;
		}
		//키와 밸류를 해시테이블에 삽입
		public void put(Object key, Object val) {
		if (n >= m / 2) resize(2*m); //더블링(doubling)
		int i;
		//선형조사
		for(i = hashValue(key); keys[i] != null; i = (i+1) % m) {
		if(keys[i].equals(key)) { //해당 키가 존재하면
			{	i = (key.hashCode() & 0x7fffffff) % 7;
		values[i] = val; //밸류 업데이트
			}
		
		return;
		}
		}
		keys[i] = key;
		values[i] = val;n++;
		}
		//해시테이블 리사이즈(리해싱)
		private void resize(int new_capacity) {
		HashTable temp = new HashTable(new_capacity);
		for(int i=0;i<m;i++) {
		if (keys[i] != null) {
		temp.put(keys[i], values[i]); //새테이블(temp)에 삽입(리해싱)
		}
		}
		//temp를 해시테이블로!!!
		keys = temp.keys;
		values = temp.values;
		m = temp.m;
		n = temp.n;
		}
		//주어진 키로 검색하기
		public Object get(Object key) {
		for(int i = hashValue(key); keys[i] != null; i = (i+1) % m)
		if(keys[i].equals(key))
		return values[i];
		return null;
		}
		//해시테이블 출력(교육용)
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
