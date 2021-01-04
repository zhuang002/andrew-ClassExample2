
public class ClassExample2 {
	
	public static void main(String[] args) throws Exception {
		MyList list=new MyList();
		
		list.add(1);
		list.add("a");
		list.add(true);
		
		System.out.println(list);
		System.out.println("value at index 2: "+list.get(2));
		
		list.add(1,"b");
		System.out.println("after insert 'b' at index 1: "+list);
		list.remove(2);
		System.out.println("after remove value at index 2:"+list);
		
		System.out.println("length:"+list.length());
		list.remove("b");
		System.out.println("after remove 'b':"+list);
		
		System.out.println("if list contains value 'b':"+list.contains("b"));
	}
	
}

class MyList    {
	final int MAX_SIZE=100;
	Object[] ar=new Object[MAX_SIZE];
	int size=0;
	
	public void add(Object o) throws Exception {
		if (size>=MAX_SIZE) {
			throw new Exception("List is full");
		}
		
		ar[size]=o;
		size++;
	}
	
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for (int i=0;i<size;i++) {
			if (ar[i].equals(o))
				return true;
		}
		return false;
	}

	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

	public Object get(int idx) throws Exception  {
		// TODO Auto-generated method stub
		if (size==0 || idx>=size) throw new Exception("out of boundry");
		return ar[idx];
	}

	public void remove(int idx) throws Exception {
		// TODO Auto-generated method stub
		if (size==0 || idx>=size) throw new Exception("out of boundry");
		
		for (int i=idx;i<size-1;i++) {
			ar[i]=ar[i+1];
		}
		size--;
		
	}
	
	public void remove(Object o) throws Exception {
		for (int i=0;i<size;i++) {
			if (o.equals(ar[i])) {
				remove(i);
			}
		}
	}

	public void add(int idx,Object o) throws Exception {
		if (size>=MAX_SIZE) {
			throw new Exception("List is full");
		}
		
		if (idx>size) {
			throw new Exception("Out of boundry");
		}
		
		for (int i=size-1;i>=idx;i--) {
			ar[i+1]=ar[i];
		}
		ar[idx]=o;
		size++;
	}
	
	@Override 
	public String toString() {
		String s="[";
		for (int i=0;i<size-1;i++) {
			s+=ar[i]+",";
		}
		s+=ar[size-1]+"]";
		return s;
	}
}