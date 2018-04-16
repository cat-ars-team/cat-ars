/**
 * 
 */
package com.cat.utils;

import java.io.File;

import org.apache.struts2.ServletActionContext;


/**
 * <p>zhucz</p>
 * 文件操作工具类
 */
public class FileUtil {
	
	/**
	 * 获取文件后缀名
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName){
		int postion = fileName.lastIndexOf(".");
		return fileName.substring(postion);
	}
	
	/**
	 * 给文件重命名
	 * @param path
	 */
	public static void reFileName(String path, String reName) {
	    File file = new File(path);
	    file.renameTo(new File(reName));
	}
	
	/**
	 * 获取文件夹下的文件
	 * @return
	 */
	public static File getEncryFile(){
		String path = ServletActionContext.getServletContext().getRealPath("/fileFolder");
		File file = new File(path + "//project.key");
		return file;
	}
	
	/**
	 * 获取文件夹下的文件
	 * @return
	 */
	public static File getSrcFile(){
		String path = ServletActionContext.getServletContext().getRealPath("/fileFolder/srcFile");
		File file = new File(path + "//project.properties");
		return file;
	}
	
	/**
	 * 删除文件夹,及该文件夹下所有文件
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除所有文件
	 * @param path
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

}
