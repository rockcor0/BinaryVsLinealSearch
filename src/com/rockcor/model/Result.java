/**
 * 
 */
package com.rockcor.model;

/**
 * @author Rockoder
 *
 */
public class Result {
	
	private int elements;
	private long linealSearch;
	private long binarySearch;

	/**
	 * 
	 */
	public Result() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param elements
	 * @param linealSearch
	 * @param binarySearch
	 */
	public Result(int elements, long linealSearch, long binarySearch) {
		super();
		this.elements = elements;
		this.linealSearch = linealSearch;
		this.binarySearch = binarySearch;
	}

	/**
	 * @return the elements
	 */
	public int getElements() {
		return elements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(int elements) {
		this.elements = elements;
	}

	/**
	 * @return the linealSearch
	 */
	public long getLinealSearch() {
		return linealSearch;
	}

	/**
	 * @param linealSearch the linealSearch to set
	 */
	public void setLinealSearch(long linealSearch) {
		this.linealSearch = linealSearch;
	}

	/**
	 * @return the binarySearch
	 */
	public long getBinarySearch() {
		return binarySearch;
	}

	/**
	 * @param binarySearch the binarySearch to set
	 */
	public void setBinarySearch(long binarySearch) {
		this.binarySearch = binarySearch;
	}
	
	

}
