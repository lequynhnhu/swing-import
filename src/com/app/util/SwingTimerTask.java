package com.app.util;

import java.awt.EventQueue;

import com.app.main.MainFrame;

/**
 * �̳�task����Ϊ�����޷���taskengine���Ƴ����ִ�������������
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
