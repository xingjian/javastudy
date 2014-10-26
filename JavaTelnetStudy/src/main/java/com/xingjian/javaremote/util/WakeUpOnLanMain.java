/** @文件名: WakeUpOnLanMain.java @创建人：邢健  @创建日期： 2012-10-31 下午3:14:39 */
package com.xingjian.javaremote.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @类名: WakeUpOnLanMain.java
 * @包名: com.xingjian.javaremote.util
 * @描述: java远程开机
 * @作者: xingjian xingjian@yeah.net
 * @日期:2012-10-31 下午3:14:39
 * @版本: V1.0
 */
public class WakeUpOnLanMain {

	public boolean wakeUpOnLan(String macAddress) throws IOException {
		int port = 10000;
		String destIP = "255.255.255.255";// 广播地址

		// 检测 mac 地址,并将其转换为二进制
		byte[] destMac = getMacBytes(macAddress);
		if (destMac == null)
			return false;

		InetAddress destHost = null;
		try {
			destHost = InetAddress.getByName(destIP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// construct packet data
		byte[] magicBytes = new byte[102];

		// 将数据包的前6位放入0xFF即 "FF"的二进制
		for (int i = 0; i < 6; i++)
			magicBytes[i] = (byte) 0xFF;

		// 从第7个位置开始把mac地址放入16次
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < destMac.length; j++) {
				magicBytes[6 + destMac.length * i + j] = destMac[j];
			}
		}
		// create packet
		DatagramPacket dp = null;
		dp = new DatagramPacket(magicBytes, magicBytes.length, destHost, port);
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
		return true;

	}

	// 将16进制的mac地址转换为二进制
	private static byte[] getMacBytes(String macStr)
			throws IllegalArgumentException {
		byte[] bytes = new byte[6];
		String[] hex = macStr.split("(\\:|\\-)");
		if (hex.length != 6) {
			throw new IllegalArgumentException("Invalid MAC address.");
		}
		try {
			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) Integer.parseInt(hex[i], 16);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"Invalid hex digit in MAC address.");
		}
		return bytes;
	}

	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	// 下面是通过ip获取网卡mac地址的代码
	private static String getMacAddressIP(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -A " + remotePcIP);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();

				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException ex) {
		}
		return macAddress;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WakeUpOnLanMain wum = new WakeUpOnLanMain();
		String s = wum.getMacAddressIP("10.10.142.135");
		System.out.println(s);
		try {
			boolean b = wum.wakeUpOnLan(s);
			System.out.println(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
