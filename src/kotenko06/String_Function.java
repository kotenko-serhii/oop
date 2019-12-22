package ua.khpi.oop.kotenko06;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import ua.khpi.oop.kotenko06.String_Function;

public class String_Function implements Iterable<String>, Serializable {
	//static String_Function list = new String_Function();

	private static final long serialVersionUID = 1L;
	private String[] elements;
    private int size;
    
    public String_Function(String[] tmp){
        this.elements = tmp;
        this.size = tmp.length;
    }
    public String_Function() {
        this.elements = null;
    }
    
    public String getByIndex(int index) {
    	return elements[index];
    }
    
    public String toString() {
    	String result = " ";
    	for (int i = 0; i < size; i++) {
    		result += (elements[i] + " ");
    	}
    	return result;
    }
    
    public void add(String string) {
		if (elements != null){
			String[] newArray = new String[elements.length + 1];
	        System.arraycopy(elements, 0, newArray, 0, size);
	        elements = newArray;
        } else {
        	String[] newArray = new String[1];
        	elements = newArray;
        }
        elements[size] = string;
        size++;
	}
	
	public void clear() {
        for(int i = 0; i < size; i++) {
        	elements[i] = null; 
        }
		size = 0;
	}
	
	public boolean remove(String str) {    
	      for (int index = 0; index < size; index++) {
	        if(str.equals(elements[index])) {
	        	fast_remove(index);
	          return true;
	        }
	      }
	      return false;
	    }
	
	public void fast_remove(int index) {
	      if(index < 0 || index >= size) {
	        return;
	      }
	      
	      String[] newArray = new String[size - 1];
	      System.arraycopy(elements, 0, newArray, 0, index);
	      System.arraycopy(elements, index + 1, newArray, index, size - index - 1);
	      elements = newArray;
	      size --;
	    }
	
	public String[] toArray() {
		return this.elements;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean contains(String tmp) {
		return indexOf(tmp) >= 0;
	}
	
	public boolean containsAll(String_Function container) {
		for(int i = 0; i < size; i++) {
			if(!container.contains(elements[i])) {
				return false;
			}
		}
		return true;
	}
	
	public int indexOf(String tmp) {
        if (tmp == null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (tmp.equals(elements[i]))
                    return i;
        }
        return -1;
    }

	public void sortArray() {
		Arrays.sort(elements);
	}
	
	@Override
	public Iterator<String> iterator() {
		Iterator<String> it = new Iterator<String>() {
			
		   private int currentIndex = 0;

           @Override
           public boolean hasNext() {
               return currentIndex < size && elements[currentIndex] != null;
           }

           @Override
           public String next() {
               return elements[currentIndex++];
           }

           @Override
           public void remove() {
               throw new UnsupportedOperationException();
           }
	    };
	    return it;
	}
}