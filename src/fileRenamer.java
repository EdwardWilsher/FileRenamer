import java.awt.Frame;
import java.io.File;

import javax.swing.JFileChooser;

public class fileRenamer
{

	public static void main(String[] args)
	{
		// Open a file chooser and only allow directories to be chosen
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(new Frame());
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			// Gets the folder selected
			File folder = fileChooser.getSelectedFile();
			
			// Gets all the folders inside the folder selected
			File[] innerFolders = folder.listFiles();
			for (int i = 0; i < innerFolders.length; i++) 
			{
				// Checks that it is a folder and is not the Other folder
				if (innerFolders[i].isDirectory() && innerFolders[i].getName() != "Other") 
				{
					// Gets the files inside the inner folder
					File[] innerFiles = innerFolders[i].listFiles();
					for (int j = 0; j < innerFiles.length; j++) 
					{
						File newName = new File(innerFolders[i].getAbsolutePath() + "/" + innerFolders[i].getName() + " Pt." + (j+1) + "." + innerFiles[j].getAbsolutePath().substring(innerFiles[j].getAbsolutePath().lastIndexOf(".") + 1));
						innerFiles[j].renameTo(newName);
					}
				}
			}
		}
	}

}
