public class LabExamQ3 {
	public static void main(String[] args) {
		
		ResourceDocument photo1 = new ResourceDocument("Photo1", 60);
		ResourceDocument photo2 = new ResourceDocument("Photo2", 130);
		ResourceDocument photo3 = new ResourceDocument("Photo3", 68);
		ResourceDocument program1 = new ResourceDocument("program1", 94);
		ResourceDocument program2 = new ResourceDocument("program2", 55);
		ResourceDocument program3 = new ResourceDocument("program3", 34);
		ResourceDocument cv = new ResourceDocument("myCV", 10);
		
		ResourceFolder photos = new ResourceFolder("My Photos");
			
		photos.add(photo1);
		photos.add(photo2);
		photos.add(photo3);
			
		ResourceFolder programs = new ResourceFolder("My Programs");
		programs.add(program1);
		programs.add(program2);
		programs.add(program3);
		programs.add(photos);
		
		ResourceFolder variousThings = new ResourceFolder("Various Things");
		photos.add(variousThings);
		variousThings.add(photo2);
		variousThings.add(photo3);
	
		//this prints the filing system in a hierarchical structure
		System.out.println(programs);
		
		//this demonstrates the working getSize() method
		System.out.println("Size of folder 'Various Things'   " + variousThings.getSize() + "  bytes");
		
		//this demonstrates 
		System.out.println("Size of folder 'photos'   " + photos.getNumDocuments() + "  docs");
		
	
	}


}
