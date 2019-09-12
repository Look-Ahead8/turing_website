package com.turing.website;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsiteApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("我们的爱".length());
    }

    @Test
    public void testUpload() {
        try {
            ClientGlobal.initByProperties("application.properties");
            System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
            System.out.println("charset=" + ClientGlobal.g_charset);
            TrackerClient tc = new TrackerClient();
            TrackerServer ts = tc.getConnection();
            if (ts == null) {
                System.out.println("getConnection return null");
                return;
            }
            StorageServer ss = tc.getStoreStorage(ts);
            if (ss == null) {
                System.out.println("getStoreStorage return null");
            }
            StorageClient1 sc1 = new StorageClient1(ts, ss);
            NameValuePair[] meta_list = null;
            String item = "C:\\Users\\Lenovo\\Desktop\\2019-09-10_213742.png";
            String fileid;
            fileid = sc1.upload_file1(item, "png", meta_list);
            System.out.println("Upload local file " + item + " ok, fileid=" + fileid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryFile() throws IOException, MyException {
        ClientGlobal.initByProperties("application.properties");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        FileInfo fileInfo = storageClient.query_file_info("group1",
                "M00/00/00/rBEkp113p1GABD4QAAIeGQ7IpZk030.png");
        System.out.println(fileInfo);
    }

    @Test
    public void upload() throws IOException {
        File file=new File("C:\\Users\\Lenovo\\Desktop\\timg.jpg");
        String fileName=file.getName();
        FileInputStream fileInputStream=new FileInputStream(file);
        byte[] bytes=new byte[10240];
        fileInputStream.read(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes.length);
    }

}
