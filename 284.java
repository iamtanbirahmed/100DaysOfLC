// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> itr;
    private Integer peek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
        this.peek = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(this.peek == null){
            this.peek = this.itr.next();    
        }        
        return this.peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(this.peek!=null){
            Integer returnItem = this.peek;
            this.peek = null;
            return returnItem;
        }
        return this.itr.next();
	}
	
	@Override
	public boolean hasNext() {
	    return (this.peek !=null || this.itr.hasNext());
	}
}