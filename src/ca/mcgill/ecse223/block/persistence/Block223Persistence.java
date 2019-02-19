package ca.mcgill.ecse223.block.persistence;

import ca.mcgill.ecse223.block.model.Block223;

public class Block223Persistence {

	public static String filename = "data.block223";
	
	public static void save(Block223 block223) {
		PersistenceObjectStream.serialize(block223);
	}
	
	public static Block223 load() {
		PersistenceObjectStream.setFilename(filename);
		Block223 block223 = (Block223) PersistenceObjectStream.deserialize();
		// if model can not be loaded, create an empty Block223
		if (block223 == null) {
			block223 = new Block223();
		}
		else {
			block223.reinitialize();
		}
		return block223;
	}
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}