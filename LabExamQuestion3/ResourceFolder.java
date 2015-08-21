import java.util.*;

public class ResourceFolder implements ResourceComponent {

	// need an arrayList to store the resources(both files and folders so list
	// is of type component)
	private ArrayList<ResourceComponent> children;
	private String resourceName;

	// variable to produce String of all folder content
	public String folderContent = "";

	// variable to insert tabs to indent when outputting folder contents as hierarchy structure.
	int tabNum = 0;

	// constructor for a resource folder, has a name, and a list of components
	// (either files or further folders).
	public ResourceFolder(String name) {
		children = new ArrayList<ResourceComponent>();
		resourceName = name;
	}
	
	// method to make tabs to indent.
	public String makeTab(int counter) {
		String tabSpace = "";
		for (int i = 0; i < counter; i++) {
			tabSpace += "\t";
		}
		return tabSpace;
	}

	// Method to return the content of a folder. this method is called in the
	// toString() method below
	public String getContentOfFolder(int tab, ResourceFolder folder) {
		String contentString = "";
		// Folder tabs is always 1-contents tab
		contentString = makeTab(tab - 1) + "Folder: " + folder.resourceName
				+ " contains:\n\t";

		for (int i = 0; i < folder.children.size(); i++) {
			if (folder.children.get(i) instanceof ResourceFolder) {
				// increment tab number for the contents of new folder
				contentString += getContentOfFolder(tab + 1,
						(ResourceFolder) folder.children.get(i));
				//else do not indent
			} else
				contentString += makeTab(tab) + folder.children.get(i) + "\n\t";
		}
		return contentString;
	}

	// toString method to return the resource names and their contents in an
	// hierarchically indented way.
	public String toString() {

		//starts with no indent and first descriptor
		String totalString = makeTab(tabNum) + "Folder : " + resourceName
				+ " contains :\n";

		//totalString += "";
		//if its a folder, indent the contents of it by incrementing number of tabs
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i) instanceof ResourceFolder) {
				tabNum++;
				totalString += getContentOfFolder(tabNum,
						((ResourceFolder) children.get(i)));
			} else {
				totalString += makeTab(tabNum) + children.get(i) + "\n";
			}
		}
		return totalString;
	}

	// method to calculate number of documents in a resource
	public int getNumDocuments() {
		int numDocuments = 0;
		for (ResourceComponent a : children) {
			// if component a is a document, the number of documents will always
			// be 1
			if (a instanceof ResourceDocument) {
				numDocuments += 1;
			}

			// if it is a folder, must go into the folder and get the number of
			// docs in there and so on using recursion.
			else if (a instanceof ResourceFolder) {
				numDocuments += ((ResourceFolder) a).getNumDocuments();
			}
		}

		return numDocuments;
	}

	// method to add a component to the array list of components.
	public void add(ResourceComponent a) {
		children.add(a);
	}

	// method to get the size of a component. if a document,  cast the
	// component as a document and call get size method.
	public int getSize() {
		int folderSize = 0;
		for (ResourceComponent a : children) {
			if (a instanceof ResourceDocument) {
				folderSize += ((ResourceDocument) a).getSize();
			} else if (a instanceof ResourceFolder) {
				folderSize += ((ResourceFolder) a).getSize();
			}

		}
		return folderSize;
	}

}
