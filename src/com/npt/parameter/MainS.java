package com.npt.parameter;

import java.io.IOException;

/**
 * example:
 * schtasks  /create
 * 			 /tn "RsyncSchedule"
 * 			 /tr "rsync -av rsync://192.168.0.118:873/doc /cygdrive/c/users/matrix/desktop/sync"
 * 			 /sc daily
 * 			 /st 15:45
 * 			 /ru matrix
 * 			 /rp 121550
  * @author matrix
 *
 */
public class MainS {
	public static void main(String args[]) throws IOException{
			
			//get the input parameter
			String tn =  "RsyncSchedule";
			String tr = "rsync -av rsync://192.168.0.118:873/doc /cygdrive/c/users/matrix/desktop/sync";
			String sc =  "daily";
			String st =  "09:20";
			String ru =  "matrix";
			String rp =  "121550";

			SchTask schTask = new SchTask(tn,tr,sc,st,ru,rp);
			String schCmd = schTask.createSch();
			schTask.display(schCmd);
			
			//get the cmd string
			String cmdStr = "cmd /k "+schCmd;
			schTask.display(schCmd);
			
			//run the command to create a schedule task
			Runtime.getRuntime().exec(schCmd);
			
	}

}
