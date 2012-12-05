

public class Liste {
	Object value;
	Liste next;
	Liste previous;
	
	Object listType;
	
	public Liste(Object type) {
		this.listType = type;
	}
	
	public Liste(Object o, Object type) {
		this(o, type, null);
	}
	
	private Liste(Object o, Object type, Liste previous) {
		this.listType = type;
		if(o.getClass().isAssignableFrom(type.getClass())) {
			this.value = o;
		}
		this.previous = previous;
	}
	
	public void add(Object o) {
		if(value == null) {
			value = o;
		} else if (next == null && o.getClass().isAssignableFrom(listType.getClass())){
			next = new Liste(o, listType, this);
		} else if (next != null) {
			next.add(o);
		} else {
			System.out.println("INVALID TYPE");
		}
	}
	
}
