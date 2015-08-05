package com.npt.parameter;

import java.io.IOException;

/**
 * example:
 *        rsync  -av rsync://192.168.0.124:873/doc  /cygdrive/c/sync
 * 
 * @author matrix
 *
 */
public class MainR {
	public static void main(String args[]) throws IOException{
		//get the input parameter
		String ip = "192.168.0.126";
		String port = "873";
		String moduleName = "doc";
		String dstPath = "c/sync";
		
		//get the rsync string
	    Rsync rsync = new Rsync(ip,port,moduleName,dstPath);
	    String cmdRsync = rsync.getCmd();
		rsync.display(cmdRsync);
		
		//get the cmd string
		String cmdStr = "cmd /k "+cmdRsync;
		rsync.display(cmdStr);
		Runtime.getRuntime().exec(cmdStr);
}
}
