// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> itr;
    private Integer peeker = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(this.peeker == null){
            this.peeker = this.itr.next();
        }
        return this.peeker;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(this.peeker !=null){
            Integer tmp = this.peeker;
            this.peeker = null;
            return tmp;
        }
        return this.itr.next();
	}
	
	@Override
	public boolean hasNext() {
	    if(this.itr.hasNext() || this.peeker!=null) return true;
        
        return false;
	}
}