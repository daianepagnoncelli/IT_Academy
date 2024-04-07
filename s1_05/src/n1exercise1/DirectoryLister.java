package n1exercise1;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Uso: java com.example.DirectoryLister <diretório>");
			return;
		}

		// Obtenha o caminho do diretório a partir do argumento da linha de comando
		String directoryPath = args[0];

		// Crie um objeto File representando o diretório
		File directory = new File(directoryPath);

		// Verifique se o diretório existe
		if (!directory.exists() || !directory.isDirectory()) {
			System.out.println("O diretório especificado não existe.");
			return;
		}

		// Obtenha a lista de arquivos e diretórios no diretório especificado
		String[] fileList = directory.list();

		// Ordene a lista em ordem alfabética
		Arrays.sort(fileList);

		// Imprima a lista ordenada
		System.out.println("Conteúdo do diretório '" + directoryPath + "':");
		for (String file : fileList) {
			System.out.println(file);
		}
	}

}
