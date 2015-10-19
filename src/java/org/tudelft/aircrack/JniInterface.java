package org.tudelft.aircrack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JniInterface
{

	static
	{
		try {
			System.loadLibrary("aircrack-ng-jni");
		} catch (UnsatisfiedLinkError ex) {
			try {
				// get the class object for this class, and get the location of it
				final Class c = JniInterface.class;
				final URL location = c.getProtectionDomain().getCodeSource().getLocation();

				// jars are just zip files, get the input stream for the lib
				ZipFile zf = new ZipFile(location.getPath());
				final Enumeration<? extends ZipEntry> entries = zf.entries();
				InputStream in = null;

				while (entries.hasMoreElements()) {
					final ZipEntry entry = entries.nextElement();
					final String entryName = entry.getName();

					if (entryName != null && entryName.endsWith("libaircrack-ng-jni.so")) {
						in = zf.getInputStream(entry);
						break;
					}
				}

				if (in == null) {
					throw new UnsatisfiedLinkError("libaircrack-ng-jni.so has not been found");
				}

				// create a temp file and an input stream for it
				File f = File.createTempFile("JARLIB-", "-libaircrack-ng-jni.so");
				FileOutputStream out = new FileOutputStream(f);

				// copy the lib to the temp file
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0)
					out.write(buf, 0, len);
				in.close();
				out.close();

				// load the lib specified by it’s absolute path and delete it
				System.load(f.getAbsolutePath());
				f.delete();

			} catch (Exception e) {
				e.printStackTrace();
				throw new UnsatisfiedLinkError("loading libaircrack-ng-jni.so failed");
			}
		}
	}
	
	// Interface name, i.e. 'mon0'.
	private final String name;
	
	// Pointer to the wif struct that describes the interface once opened.
	private long wif = 0;
	
	public JniInterface(String name)
	{
		this.name = name;
	}

	native static private long _open(String interfaceName);
	native static private void _close(long wif);
	
	native static private int _setChannel(long wif, int channel);
	native static private int _getChannel(long wif);

	native static private int _setFrequency(long wif, int freq);
	native static private int _getFrequency(long wif);

	native static private int _setMac(long wif, byte[] mac);
	native static private int _getMac(long wif, byte[] mac);

	native static private int _setRate(long wif, int rate);
	native static private int _getRate(long wif);
	
	native static private int _getMonitor(long wif);
	
	native static private int _setMtu(long wif, int mtu);
	native static private int _getMtu(long wif);
	
	public void open()
	{
		this.wif = _open(name);
		
		if (this.wif==0)
			throw new RuntimeException("Unable to open interface: " + name);
		
	}
}
