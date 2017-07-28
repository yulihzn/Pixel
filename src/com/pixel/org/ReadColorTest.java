package com.pixel.org;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSON;

public class ReadColorTest {
	private PixelModel model = new PixelModel();
	private List<BufferedImage> images = new ArrayList<>();
	public static final int W = 32;
	public static final int H = 32;
	private ColorMap colorMap;
	
	public ReadColorTest() {
		super();
		colorMap = new ColorMap();
	}
	/**
	 * 读取一张图片的RGB值
	 * 
	 * @throws Exception
	 */
	public void getImagePixel(String image) throws Exception {
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		model.getList().clear();
		for (int i = 0; i < width/W; i++) {
			images.add(bi.getSubimage(i*W, 0, W, H));
			
		}
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");
		
		for(int i = 0;i < images.size();i++){
			PixelInfo pixelInfo = new PixelInfo();
			pixelInfo.setIndex(i);
			BufferedImage temp = images.get(i);
			pixelInfo.setList(getFramePixels(temp));
			model.getList().add(pixelInfo);
			
		}

		String content = JSON.toJSONString(model);
		System.out.println(content);
		saveAsFileWriter(image.substring(0,image.indexOf("."))+".json", content);
	}
	private List<Pixel> getFramePixels(BufferedImage bi){
		List<Pixel> list  = new ArrayList<>();
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		int[] rgb = new int[3];
		int index = 0;
		StringBuilder sb = new StringBuilder();
		//左上角横排开始读
		for (int j = miny; j < height; j++) {
			for (int i = minx; i < width; i++) {
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if(pixel != -1&&pixel != 0){
					index++;
					list.add(new Pixel(i,j,colorMap.getColorIndex(pixel)));
//					System.out.println("i=" + i + ",j=" + j + ",index="+index+":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");
//					System.out.println("map.put("+pixel+","+index+");");
					
					if(index < 10){
						sb.append("0");
					}
					sb.append(index+" ");
				}else{
					sb.append("0"+"  ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return list;
	}
	private void saveAsFileWriter(String filename,String content) {

		 FileWriter fwriter = null;
		 try {
		  fwriter = new FileWriter(filename);
		  fwriter.write(content);
		 } catch (IOException ex) {
		  ex.printStackTrace();
		 } finally {
		  try {
		   fwriter.flush();
		   fwriter.close();
		  } catch (IOException ex) {
		   ex.printStackTrace();
		  }
		 }
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ReadColorTest rc = new ReadColorTest();
		rc.getImagePixel("D:\\aaaaa\\anim\\base_anim_face.png");
	}

}
