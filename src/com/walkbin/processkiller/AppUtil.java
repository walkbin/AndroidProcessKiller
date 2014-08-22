package com.walkbin.processkiller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;

public class AppUtil {

	public static List<RunningAppProcessInfo> getRunningProcesses(Context ctx) {
		ActivityManager am = (ActivityManager) ctx
				.getSystemService(Context.ACTIVITY_SERVICE);

		return am.getRunningAppProcesses();
	}

	public static void forceStopPackage(Context ctx, String packageName) {

		ActivityManager am = (ActivityManager) ctx
				.getSystemService(Context.ACTIVITY_SERVICE);

		Method method;
		try {
			method = Class.forName("android.app.ActivityManager").getMethod(
					"forceStopPackage", String.class);
			method.invoke(am, packageName);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isSystemApp(ApplicationInfo info) {  
        if ((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {  
            return true;  
        } else if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {  
            return true;  
        }  
        return false;  
    }  
	
	
}
