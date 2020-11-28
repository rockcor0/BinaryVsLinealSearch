package com.rockcor.model;

public class Main {
	
	public static String ROW_SEPARATOR = "-------------------";

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main m = new Main();
				
		Result[] myResults = new Result[3];
		
		m.createCase(100000, myResults, 0);
		m.createCase(1000000, myResults, 1);
		m.createCase(10000000, myResults, 2);
		
		m.printInScreen(5, 8, myResults);

	}
	
	/**
	 * Create arrays and run linean search and binary search.
	 * @param growFactor
	 */
	private void createCase(int growFactor, Result[] myResults, int index) {
		int[] myArray1 = createArray(growFactor, growFactor-1);
		myResults[index] = new Result(growFactor, linealSearch(myArray1, growFactor-1), binarySearch(myArray1, growFactor-1));
	}
	
	/**
	 * Print the matriz in the console
	 * @param cols
	 * @param rows
	 * @param myResults 
	 * @return
	 */
	private void printInScreen(int cols, int rows, Result[] myResults) {
		//6*8
		
		String matrix[][] = new String[rows][cols];
		
		//Llenar matriz con espacios o guiones
		for(int i=0; i<rows; i++) {

			for(int j=0; j<cols; j++) {
				matrix[i][j] = "-";
			}
		}
		
		//Encabezados de la matrix
		int maxChars = 20;
		String charToFill = " ";

		System.out.println("");
		
		for(int j=0; j<cols; j++) {
			matrix[0][j] = getHeaders(j, cols);
			
			if((j%2) == 0)
				fillWithSpaces(matrix, 0, j, maxChars, charToFill);
		}

		//Add separator rows
		for(int i=1; i<rows; i+=2) {
			
			for(int j=0; j<cols; j+=2) {
				matrix[i][j] = ROW_SEPARATOR;
			}
		}
		
		//Add results
		int indexAux = 0;

		for(int i=2; i<rows; i+=2) {
			
			
			for(int j=0; j<cols; j++) {
				
				if(j==0) {
					matrix[i][j] = myResults[indexAux].getElements() + " elements";
					fillWithSpaces(matrix, i, j, maxChars, charToFill);
				}
				
				else if(j==2) {
					matrix[i][j] = myResults[indexAux].getLinealSearch() + " milliseconds";
					fillWithSpaces(matrix, i, j, maxChars, charToFill);

				}
				
				else if(j==4) {
					matrix[i][j] = myResults[indexAux].getBinarySearch() + " milliseconds";
					fillWithSpaces(matrix, i, j, maxChars, charToFill);
				}
				
				else {
					matrix[i][j] = " ";
				}
				
			}
			
			indexAux++;
		}
		
		//Draw the matriz
		for(int i=0; i<rows; i++) {

			for(int j=0; j<cols; j++) {
				System.out.print(matrix[i][j]);

			}
			System.out.println();
		}
	}

	/**
	 * Fill de array with spaces or other chars
	 * @param matrix
	 * @param x
	 * @param y
	 * @param maxChars
	 * @param charToFill
	 */
	private void fillWithSpaces(String[][] matrix, int x, int y, int maxChars, String charToFill) {
		
		if(matrix[x][y].length() < maxChars) {
			matrix[x][y] = matrix[x][y] + charToFill;
			fillWithSpaces(matrix, x, y, maxChars, charToFill);
		}
	}
	
	/**
	 * Create and sort an array with integers.
	 */
	private int[] createArray(int arrayLength, int searchedValue) {
		int[] myArray = new int[arrayLength];
		
		//Fill in the array
		fillInArray(myArray, searchedValue);
		
		//Sorting the array
		long endSorting = 0;
		long startSorting = System.currentTimeMillis();
		sortArray(myArray);
		endSorting = System.currentTimeMillis();
		System.out.println(">> Sorting time = " + (endSorting - startSorting));
		System.out.println();
		return myArray;
	}
	
	/**
	 * Secuential search method.
	 * @param arrayLength
	 * @return
	 */
	private long linealSearch(int[] myArray, int searchedValue) {
		
		long end = 0;
		long start = System.currentTimeMillis();
		
		for(int i=0; i<myArray.length; i++) {
			//System.out.print(" ");
			
			if(myArray[i] == searchedValue) {
				break;
			}
		}
		end = System.currentTimeMillis();
		
		return (end - start);
	}
	
	/**
	 * 
	 * @param myArray
	 * @param searchedValue
	 * @return
	 */
	private long binarySearch(int[] myArray, int searchedValue) {
		
		long end = 0;
		long start = System.currentTimeMillis();
		
		int startPosition = 0;
		int endPosition = myArray.length - 1;
		int middlePosition = 0;
		
		while( startPosition <= endPosition ) {
			
			//System.out.print(" ");
			
			middlePosition = (endPosition + startPosition)/2;

			if(myArray[middlePosition] == searchedValue) {
				break;
			}
			else if(searchedValue < myArray[middlePosition]) {
				endPosition = middlePosition - 1;
			}
			else {
				startPosition = middlePosition + 1;
			}
			
		}
		
		
		end = System.currentTimeMillis();
		
		return (end - start);
	}
	
	/**
	 * Sorting the array using Selection Sort
	 * @param myArray
	 */
	private void sortArray(int[] myArray) {
		// Selection sort
		int n = myArray.length;
		int temp = 0;
		
		for(int i=0; i<n-1; i++) {
			
			int min = i;
			
			for(int j=n-1; j>i; j--) {
				if( myArray[j] < myArray[min] ) {
					min = j;
				}
			}
			
			if( min != i ) {
				temp = myArray[i];
				myArray[i] = myArray[min];
				myArray[min] = temp;
			}
		}
	}

	/**
	 * Fill the array with random numbers.
	 * @param myArray
	 */
	private void fillInArray(int[] myArray, int searchedValue) {
		
		myArray[0] = searchedValue;
		
		for(int i=1; i<myArray.length; i++) {
			int valueTemp = (int) (Math.random() * myArray.length);
			
			myArray[i] = valueTemp;			
		}
	}
	
	/**
	 * Return a list of headers
	 * @param index
	 * @return
	 */
	private String getHeaders(int index, int myArrayLength) {
		
		String myHeaders[] = new String[myArrayLength];
		
		myHeaders[0] = "Elements";
		myHeaders[1] = " ";
		myHeaders[2] = "Lineal Search";
		myHeaders[3] = " ";
		myHeaders[4] = "Binary Search";
		
		return myHeaders[index];
		
	}

}
