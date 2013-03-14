package com.app.util;

import java.awt.EventQueue;

import com.app.main.MainFrame;

/**
 * 继承task，因为这里无法用taskengine控制程序的执行与否，这样来了
 * @author Administrator
 *
 */
public abstract class SwingTimerTask extends java.util.TimerTask {
    public abstract void doRun();

    public void run() {
    	if(MainFrame.getInstance().getAuto().isSelected()){
	        if (!EventQueue.isDispatchThread()) {
	            EventQueue.invokeLater(this);
	        }
	        else {
	            doRun();
	        }
        }
    }
}
