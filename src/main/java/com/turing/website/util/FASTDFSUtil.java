package com.turing.website.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**fastdfs工具类
 * @author Meng
 * @date 2019/9/11
 */
public class FASTDFSUtil {

    private static TrackerServer trackerServer;
    private static TrackerClient trackerClient;
    private static StorageClient1 storageClient1;

    /**
     * 获取文件扩展名
     * @param fileName  文件名
     * @return
     */
    public static String getFileExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }

    /**
     * 上传文件
     * @param data  文件字节数组
     * @param fileName 文件名
     * @return 文件路径
     */
    public static  String uploadFile(String configuration,byte[] data, String fileName) throws IOException, MyException {
        ClientGlobal.initByProperties(configuration);
        trackerClient=new TrackerClient();
        trackerServer=trackerClient.getConnection();
        storageClient1=new StorageClient1(trackerServer,null);
        return storageClient1.upload_file1(data,getFileExtension(fileName),null);
    }
}
