package github.io.jameshiegel;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;

public class DirectoryManager {
	private File newPath = new File(".");

	public static void main(String[] args) {
		DirectoryManager main = new DirectoryManager();
		int menuOpt = 1;
		Scanner input = new Scanner(System.in);
		File fileToUse = new File(".");
		File fileToMake = new File(".");
		int fileLength = 0;
		byte data[] = new byte[16];
		char key[];

		while (menuOpt != 0) { // loops until "0 - Exit" selected
			main.displayMenu();
			menuOpt = input.nextInt();

			switch (menuOpt) {
			case 1: // change current directory
				System.out.printf("Enter absolute path to directory: ");
				main.newPath = new File(input.next());
				break;
			case 2: // list first level of directory
				main.displayDirectory(main.newPath, true);
				break;
			case 3: // list all levels of directory
				main.displayDirectory(main.newPath, false);
				break;
			case 4: // delete specified file
				System.out.printf("Enter file to delete: ");
				fileToUse = new File(main.newPath, input.next());
				if (fileToUse.delete()) {
					System.out.println("File deleted successfully");
				} else {
					System.out.println("Failed to delete the file");
				}
				break;
			case 5: // displays specified file in hexadecimal
				try {
					System.out.printf("Enter file to view: ");
					fileToUse = new File(main.newPath, input.next());
					FileInputStream fis = new FileInputStream(fileToUse);
					do {
						fileLength = fis.read(data);
						for (int j = 0; j < fileLength; j++)
							System.out.printf("%02X ", data[j]);
						System.out.println("");
					} while (fileLength != -1);
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6: // encrypts specified file with XOR
				System.out.printf("Enter file to encrypt: ");
				fileToUse = new File(main.newPath, input.next());
				System.out.printf("Enter encrypted file name: ");
				fileToMake = new File(main.newPath, input.next());
				System.out.printf("Enter password: ");
				key = input.next().toCharArray();
				main.encryptDecryptXOR(fileToUse, fileToMake, key);
				break;
			case 7: // decrypts specified file with XOR
				System.out.printf("Enter file to decrypt: ");
				fileToUse = new File(main.newPath, input.next());
				System.out.printf("Enter unencrypted file name: ");
				fileToMake = new File(main.newPath, input.next());
				System.out.printf("Enter password: ");
				key = input.next().toCharArray();
				main.encryptDecryptXOR(fileToUse, fileToMake, key);
				break;
			}
		}
		input.close();
	}

	public void displayMenu() {
		System.out.printf("\nCurrent path: " + newPath + "\nMain Menu\n" + "0 - Exit\n" + "1 - Select directory\n"
				+ "2 - List directory (first level)\n" + "3 - List directory (all levels)\n" + "4 - Delete file\n"
				+ "5 - Display file (hexadecimal view)\n" + "6 - Encrypt file (XOR with password)\n"
				+ "7 - Decrypt file (XOR with password)\n" + "Select option: ");
	}

	public void displayDirectory(File path, boolean firstOnly) {
		if (firstOnly) { // if true only lists current directory levels
			File[] files = path.listFiles();
			for (File f : files) {
				if (f.isDirectory())
					System.out.println(f.getAbsolutePath());
				if (f.isFile())
					System.out.println(f.getAbsolutePath());
			}
		} else { // if false lists all directory levels; recursive
			File[] files = path.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					displayDirectory(f, false);
				}
				if (f.isFile())
					System.out.println(f.getAbsolutePath());
			}
		}
	}

	public void encryptDecryptXOR(File fileToUse, File fileToMake, char[] key) {
		int read = -1;
		int totalRead = 0;
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileToUse), 2048);
			FileOutputStream fos = new FileOutputStream(fileToMake);
			do {
				read = bis.read();
				fos.write(read ^ key[totalRead % (key.length - 1)]);
				totalRead++;
			} while (read != -1);
			bis.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
