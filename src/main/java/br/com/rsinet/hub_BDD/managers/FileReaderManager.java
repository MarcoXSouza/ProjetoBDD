package br.com.rsinet.hub_BDD.managers;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigFileReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}
}
