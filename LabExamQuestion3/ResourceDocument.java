
public class ResourceDocument implements ResourceComponent {

	private String fileName;
	private int numBytes;
	
	//constructor for the document
	public ResourceDocument(String name, int bytes){
		fileName = name ;
		numBytes = bytes;
	}

	@Override
	public int getSize() {
		return numBytes;
	}
	
	//method to return the name
	public String toString() {
		return fileName;
	}
	
	
	
}
